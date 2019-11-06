package cn.gson.oasys.ServiceV2;

import cn.gson.oasys.ServiceV2.mailV2.MailServiceV2;
import cn.gson.oasys.ServiceV2.processServiceV2.AttachmentServiceV2;
import cn.gson.oasys.ServiceV2.processServiceV2.ByProcessPOIdServiceV2;
import cn.gson.oasys.ServiceV2.processServiceV2.ProcessAuditVOServiceV2;
import cn.gson.oasys.mappers.*;
import cn.gson.oasys.model.po.*;
import cn.gson.oasys.vo.*;
import cn.gson.oasys.vo.factoryvo.*;
import cn.gson.oasys.vo.processV2.*;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.github.pagehelper.util.StringUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.io.IOException;
import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.*;

@Slf4j
@Service
public class ProcessServiceV2 {

    @Resource
    private SubjectPOMapper subjectPOMapper;
    @Resource
    private UserServiceV2 userServiceV2;
    @Resource
    private TypeServiceV2 typeServiceV2;
    @Resource
    private DeptServiceV2 deptServiceV2;
    @Resource
    private PositionServiceV2 positionServiceV2;
    @Resource
    private BursementPOMapper bursementPOMapper;
    @Resource
    private MailServiceV2 mailServiceV2;
    @Resource
    private AttachmentServiceV2 attachmentServiceV2;
    @Resource
    private ProcessListPOMapper processListPOMapper;
    @Resource
    private StatusServiceV2 statusServiceV2;
    @Resource
    private ProcessAuditVOServiceV2 processAuditVOServiceV2;
    @Resource
    private ReviewedPOMapper reviewedPOMapper;
    @Resource
    private EvectionPOMapper evectionPOMapper;
    @Resource
    private OvertimePOMapper overtimePOMapper;
    @Resource
    private RegularPOMapper regularPOMapper;
    @Resource
    private HolidayPOMapper holidayPOMapper;
    @Resource
    private ResignPOMapper resignPOMapper;
    @Resource
    private DetailsbursePOMapper detailsbursePOMapper;
    @Resource
    private ByProcessPOIdServiceV2 byProcessPOIdServiceV2;
    @Resource
    private AttendanceServiceV2 attendanceServiceV2;

    /**
     * 汉语中数字大写
     */
    private static final String[] CN_UPPER_NUMBER = {"零", "壹", "贰", "叁", "肆",
            "伍", "陆", "柒", "捌", "玖"};
    /**
     * 汉语中货币单位大写，这样的设计类似于占位符
     */
    private static final String[] CN_UPPER_MONETRAY_UNIT = {"分", "角", "元",
            "拾", "佰", "仟", "万", "拾", "佰", "仟", "亿", "拾", "佰", "仟", "兆", "拾",
            "佰", "仟"};
    /**
     * 特殊字符：整
     */
    private static final String CN_FULL = "整";
    /**
     * 特殊字符：负
     */
    private static final String CN_NEGATIVE = "负";
    /**
     * 金额的精度，默认值为2
     */
    private static final int MONEY_PRECISION = 2;
    /**
     * 特殊字符：零元整
     */
    private static final String CN_ZERO_FULL = "零元" + CN_FULL;

    //根据parent_id查找费用科目列表
    public List<SubjectPO> getSubjectByParentId(Long parentId) {
        SubjectPOExample subjectPOExample = new SubjectPOExample();
        subjectPOExample.createCriteria().andParentIdEqualTo(parentId);
        List<SubjectPO> subjectPOList = subjectPOMapper.selectByExample(subjectPOExample);
        return subjectPOList;
    }

    //根据parent_id查找费用科目列表
    public List<SubjectPO> getSubjectByParentIdNot(Long parentId) {
        SubjectPOExample subjectPOExample = new SubjectPOExample();
        subjectPOExample.createCriteria().andParentIdNotEqualTo(parentId);
        List<SubjectPO> subjectPOList = subjectPOMapper.selectByExample(subjectPOExample);
        return subjectPOList;
    }


    /**
     * 设置model信息(index6)
     *
     * @param model
     * @param userId
     * @param page
     * @param size
     */
    public void setModel(Model model, Long userId, int page, int size) {
        //根据申请人userId获取申请人的用户信息
        UserPO applyUserPO = userServiceV2.getUserPOByUserId(userId);
        UserVO applyUserVO = UserFactoryVO.createUserVO(applyUserPO);

        PageHelper.startPage(page, size);
        List<UserPO> userPOList = userServiceV2.getUserAll();
        List<UserVO> userVOList = UserFactoryVO.createUserVOList(userPOList);
        PageInfo pageInfo = new PageInfo(userVOList);

        Map<Long, DeptPO> longDeptPOMap = userServiceV2.userIdAndDeptPO(userPOList);
        Map<Long, PositionPO> longPositionPOMap = userServiceV2.userIdAndPositionPO(userPOList);
        Map<Long, RolePO> longRolePOMap = userServiceV2.userIdAndRolePO(userPOList);
        for (UserVO userVO : userVOList) {
            userVO.setDeptVO(DeptFactoryVO.createDeptVO(longDeptPOMap.get(userVO.getUserId())));
            userVO.setPositionVO(PositionFactoryVO.createPositionVO(longPositionPOMap.get(userVO.getUserId())));
            userVO.setRoleVO(RoleFactoryVO.createRoleVO(longRolePOMap.get(userVO.getUserId())));
        }

        List<TypePO> exigenceTypePOList = typeServiceV2.getTypePOByTypeModel("aoa_process_list");
        List<TypeVO> exigenceTypeVOList = TypeFactoryVO.createTypeVOList(exigenceTypePOList);

        List<DeptPO> deptPOList = deptServiceV2.getDeptPOList();
        List<DeptVO> deptVOList = DeptFactoryVO.createDeptVOList(deptPOList);

        List<PositionPO> positionPOList = positionServiceV2.getPositionList();
        List<PositionVO> positionVOList = PositionFactoryVO.createPositionVOList(positionPOList);

        model.addAttribute("username", applyUserVO.getUserName());//申请人的用户名
        model.addAttribute("page", pageInfo);//可以获取第几页之类的
        model.addAttribute("userVOList", userVOList);//分页后的用户列表
        model.addAttribute("exigenceTypeVOList", exigenceTypeVOList);//紧急程度列表
        model.addAttribute("deptVOList", deptVOList);//部门列表
        model.addAttribute("positionVOList", positionVOList);//职位列表
        model.addAttribute("url", "names");//
    }


    /**
     * 存审核表
     */
    public void insertReviewedPO(UserPO userPO, ProcessListPO processListPO) {

        ReviewedPO reviewedPO = new ReviewedPO();
        reviewedPO.setUserId(userPO.getUserId());
        reviewedPO.setStatusId(23L);
        reviewedPO.setDel(0);
        reviewedPO.setReviewedTime(new Date());
        reviewedPO.setProId(processListPO.getProcessId());
        reviewedPOMapper.insert(reviewedPO);
    }


    /**
     * 插入费用报销表
     *
     * @param reimbursementVO
     */
    public BursementPO insertBursementPO(ReimbursementVO reimbursementVO, ProcessListPO processListPO, Long userId, Long auditUserId) {
        BursementPO bursementPO = new BursementPO();
        bursementPO.setProId(processListPO.getProcessId());
        bursementPO.setAllinvoices(reimbursementVO.getAllinvoices());
        bursementPO.setAllMoney(reimbursementVO.getAllMoney());
        bursementPO.setProId(processListPO.getProcessId());
        bursementPO.setBurseTime(reimbursementVO.getReimbursementTime());
        bursementPO.setName(reimbursementVO.getName());
        bursementPO.setTypeId(reimbursementVO.getTypeId());
        bursementPO.setOperationName(userId);
        bursementPO.setUserName(auditUserId);
        bursementPO.setBurseTime(new Date());
        bursementPOMapper.insertSelective(bursementPO);
        return bursementPO;
    }

    /**
     * 插入报销明细表（目前只能插入一个）
     *
     * @param reimbursementVO
     */
    public void insertDetailsReimbursePO(ReimbursementVO reimbursementVO, Long bursementPOId) {
        for (int i = 0; i < reimbursementVO.getDetailsReimburseVOList().size(); i++) {
            DetailsbursePO detailsbursePO = new DetailsbursePO();
            detailsbursePO.setBursmentId(bursementPOId);
            detailsbursePO.setDescript(reimbursementVO.getDetailsReimburseVOList().get(i).getDescript());
            detailsbursePO.setDetailmoney(reimbursementVO.getDetailsReimburseVOList().get(i).getDetailMoney());
            detailsbursePO.setInvoices(reimbursementVO.getDetailsReimburseVOList().get(i).getInvoices());
            detailsbursePO.setProduceTime(reimbursementVO.getDetailsReimburseVOList().get(i).getProduceTime());
            detailsbursePO.setSubject(reimbursementVO.getDetailsReimburseVOList().get(i).getSubject());
            detailsbursePOMapper.insertSelective(detailsbursePO);
        }
    }

    /**
     * 插入出差申请表
     *
     * @param typeId
     * @param processListPO
     */
    public void insertEvectionPO(Long typeId, ProcessListPO processListPO) {
        EvectionPO evectionPO = new EvectionPO();
        evectionPO.setTypeId(typeId);
        evectionPO.setProId(processListPO.getProcessId());
        evectionPOMapper.insertSelective(evectionPO);

    }

    /**
     * 插入加班申请表
     *
     * @param typeId
     * @param processListPO
     */
    public void insertOverTimePO(Long typeId, ProcessListPO processListPO) {
        OvertimePO overtimePO = new OvertimePO();
        overtimePO.setTypeId(typeId);
        overtimePO.setProId(processListPO.getProcessId());
        overtimePOMapper.insertSelective(overtimePO);
    }

    /**
     * 插入转正申请表
     *
     * @param regularVO
     * @param processListPO
     */
    public void insertRegularPO(RegularVO regularVO, ProcessListPO processListPO) {
        RegularPO regularPO = new RegularPO();
        regularPO.setExperience(regularVO.getExperience());
        regularPO.setUnderstand(regularVO.getUnderstand());
        regularPO.setPullulate(regularVO.getPullulate());
        regularPO.setDeficiency(regularVO.getDeficiency());
        regularPO.setDobetter(regularVO.getDobetter());
        regularPO.setAdvice(regularVO.getAdvice());
        regularPO.setDays(regularVO.getDays());
        regularPO.setPersonnelAdvice(regularVO.getPersonnelAdvice());
        regularPO.setManagerAdvice(regularVO.getManagerAdvice());
        regularPO.setProId(processListPO.getProcessId());
        regularPOMapper.insertSelective(regularPO);
    }

    /**
     * 插入请假表
     *
     * @param holidayVO
     * @param processListPO
     */
    public void insertHolidayPO(HolidayVO holidayVO, ProcessListPO processListPO) {
        HolidayPO holidayPO = new HolidayPO();
        holidayPO.setLeaveDays(holidayVO.getLeaveDays());
        holidayPO.setProId(processListPO.getProcessId());
        holidayPO.setTypeId(holidayVO.getTypeId());
        holidayPOMapper.insertSelective(holidayPO);
    }

    /**
     * 插入离职申请表
     *
     * @param resignVO
     * @param processListPO
     */
    public void insertResignPO(ResignVO resignVO, ProcessListPO processListPO, Long correlationUserPOId) {
        ResignPO resignPO = new ResignPO();
        resignPO.setFinancialAdvice(resignVO.getFinancialAdvice());
        resignPO.setHandUser(correlationUserPOId);
        resignPO.setIsFinish(resignVO.getFinish());
        resignPO.setManagerAdvice(resignVO.getManagerAdvice());
        resignPO.setNofinish(resignVO.getNoFinish());
        resignPO.setPersonnelAdvice(resignVO.getPersonnelAdvice());
        resignPO.setProId(processListPO.getProcessId());
        resignPO.setSuggest(resignVO.getSuggest());
        resignPOMapper.insertSelective(resignPO);
    }

    /**
     * 插入附件表
     *
     * @param applyUserPO 申请人
     * @param filePath
     * @return
     * @throws IllegalStateException
     * @throws IOException
     */
    public AttachmentListPO insertAttachment(UserPO applyUserPO, MultipartFile filePath) throws IllegalStateException, IOException {
        AttachmentVO attachmentVO = null;//附件
        //file.getOriginalFilename()是得到上传时的文件名。
        if (!StringUtil.isEmpty(filePath.getOriginalFilename())) {
            //上传附件
            AttachmentListPO attachmentListPO = mailServiceV2.uploadAttachmentListPO(filePath, applyUserPO);
            attachmentServiceV2.insertAttachmentListPO(attachmentListPO);
            return attachmentListPO;
        }
        return null;
    }

    /**
     * 插入主表
     *
     * @param processListVO
     * @param val           主表类型名
     * @return
     */
    public ProcessListPO insertProcessListPO(ProcessListVO processListVO, String val, Long userId, UserPO auditUserPO, Long attachmentListPOId) {
        ProcessListPO processListPO = new ProcessListPO();
        processListPO.setStatusId(23L);//流程审核状态，23L未处理
        processListPO.setTypeName(val);//流程申请类型
        processListPO.setProcessUserId(userId);//流程申请人
        processListPO.setProcessDes(processListVO.getProcessDescribe());
        processListPO.setIsChecked(0);
        processListPO.setProcessName(processListVO.getProcessName());
        processListPO.setDeeplyId(processListVO.getDeeplyId());
        processListPO.setApplyTime(new Date());//流程申请时间
        processListPO.setShenuser(auditUserPO.getUserName());
        processListPO.setProFileId(attachmentListPOId);
        processListPOMapper.insertSelective(processListPO);
        return processListPO;
    }

    /**
     * 根据申请人ID查询主表信息(主表里面有申请人ID，根据申请人ID，process_user_id)
     *
     * @param userId   申请用户ID
     * @param pageNum  第几页
     * @param pageSize 每页几条
     * @return 分页后的流程主表列表
     */
    public List<ProcessListPO> getProcessListPOListByUserId(Long userId, int pageNum, int pageSize) {

        PageHelper.startPage(pageNum, pageSize);
        ProcessListPOExample processListPOExample = new ProcessListPOExample();
        processListPOExample.createCriteria().andProcessUserIdEqualTo(userId);

        List<ProcessListPO> processListPOList = processListPOMapper.selectByExample(processListPOExample);
        return processListPOList;
    }

    /**
     * 根据流程主表ID查询流程主表信息
     *
     * @param processListPOId 流程主表ID
     * @return 流程主表
     */
    public ProcessListPO getProcessListPOByProcessListPOId(Long processListPOId) {
        ProcessListPO processListPO = processListPOMapper.selectByPrimaryKey(processListPOId);
        return processListPO;
    }

    /**
     * 封装process
     *
     * @param name          "审核"或者"申请"
     * @param userPO        申请用户信息
     * @param processListPO 主表信息
     * @return
     */
    public Map<String, Object> resultMap(String name, UserPO userPO, ProcessListPO processListPO) {
        Map<String, Object> resultMap = new HashMap<>();
        //根据主表里面的紧急ID在类型表获取紧急名称
        String exigencyName = typeServiceV2.getTypeNameByTypeId(processListPO.getDeeplyId());

        resultMap.put("proId", processListPO.getProcessId());//流程主表ID
        resultMap.put("exigencyName", exigencyName);//类型名（紧急程度）
        resultMap.put("processName", processListPO.getProcessName());//标题
        resultMap.put("processDescribe", processListPO.getProcessDes());//原因内容

        //根据流程主表的申请人ID找申请人部门
        String applyDeptName = deptServiceV2.getDeptNameByUserId(processListPO.getProcessUserId());
        if (("审核").equals(name)) {
            String userName = userServiceV2.getUsernameByUserId(processListPO.getProcessUserId());//根据申请人ID找申请人的名字
            resultMap.put("username", userName);//提单人员(申请人名）
        } else if (("申请").equals(name)) {
            resultMap.put("username", userPO.getUserName());
        }
        resultMap.put("deptName", applyDeptName);//申请人部门
        resultMap.put("applyTime", new Timestamp(processListPO.getApplyTime().getTime()));//提单日期
        // 流程表的附件ID不为null返回false
        if (!Objects.isNull(processListPO.getProFileId())) {
            //根据流程表附件ID找附件
            AttachmentListPO attachmentListPO = attachmentServiceV2.getAttachmentListPOByAttachmentListPOId(processListPO.getProFileId());
            resultMap.put("file", attachmentListPO);//流程附件

            String filePath = attachmentListPO.getAttachmentPath();//根据附件ID找附件存储路径
            resultMap.put("filepath", filePath);
            if (attachmentListPO.getAttachmentType().startsWith("image")) {
                resultMap.put("filetype", "img");
            } else {
                resultMap.put("filetype", "appli");
            }

        } else {
            resultMap.put("file", "file");
        }
        resultMap.put("name", name);// 审核或者申请
        resultMap.put("typeName", processListPO.getTypeName());// 主表的类型名
//        resultMap.put("startime", new Timestamp(processListPO.getStartTime().getTime()));//开始时间(要注意为空值）
//        resultMap.put("endtime", new Timestamp(processListPO.getEndTime().getTime()));// 结束时间
        resultMap.put("startime", new Timestamp(new Date().getTime()));//开始时间
        resultMap.put("endtime", new Timestamp(new Date().getTime()));// 结束时间
        resultMap.put("numberOfDays", processListPO.getProcseeDays());//天数
        resultMap.put("statusId", processListPO.getStatusId());//主表的状态ID
        return resultMap;
    }

    /**
     * 把输入的金额转换为汉语中人民币的大写
     *
     * @param numberOfMoney 输入的金额
     * @return 对应的汉语大写
     */
    public static String number2CNMontrayUnit(BigDecimal numberOfMoney) {
        StringBuffer sb = new StringBuffer();
        // -1, 0, or 1 as the value of this BigDecimal is negative, zero, or
        // positive.
        int signum = numberOfMoney.signum();
        // 零元整的情况
        if (signum == 0) {
            return CN_ZERO_FULL;
        }
        //这里会进行金额的四舍五入
        long number = numberOfMoney.movePointRight(MONEY_PRECISION)
                .setScale(0, 4).abs().longValue();
        // 得到小数点后两位值
        long scale = number % 100;
        int numUnit = 0;
        int numIndex = 0;
        boolean getZero = false;
        // 判断最后两位数，一共有四中情况：00 = 0, 01 = 1, 10, 11
        if (!(scale > 0)) {
            numIndex = 2;
            number = number / 100;
            getZero = true;
        }
        if ((scale > 0) && (!(scale % 10 > 0))) {
            numIndex = 1;
            number = number / 10;
            getZero = true;
        }
        int zeroSize = 0;
        while (true) {
            if (number <= 0) {
                break;
            }
            // 每次获取到最后一个数
            numUnit = (int) (number % 10);
            if (numUnit > 0) {
                if ((numIndex == 9) && (zeroSize >= 3)) {
                    sb.insert(0, CN_UPPER_MONETRAY_UNIT[6]);
                }
                if ((numIndex == 13) && (zeroSize >= 3)) {
                    sb.insert(0, CN_UPPER_MONETRAY_UNIT[10]);
                }
                sb.insert(0, CN_UPPER_MONETRAY_UNIT[numIndex]);
                sb.insert(0, CN_UPPER_NUMBER[numUnit]);
                getZero = false;
                zeroSize = 0;
            } else {
                ++zeroSize;
                if (!(getZero)) {
                    sb.insert(0, CN_UPPER_NUMBER[numUnit]);
                }
                if (numIndex == 2) {
                    if (number > 0) {
                        sb.insert(0, CN_UPPER_MONETRAY_UNIT[numIndex]);
                    }
                } else if (((numIndex - 2) % 4 == 0) && (number % 1000 > 0)) {
                    sb.insert(0, CN_UPPER_MONETRAY_UNIT[numIndex]);
                }
                getZero = true;
            }
            // 让number每次都去掉最后一个数
            number = number / 10;
            ++numIndex;
        }
        // 如果signum == -1，则说明输入的数字为负数，就在最前面追加特殊字符：负
        if (signum == -1) {
            sb.insert(0, CN_NEGATIVE);
        }
        // 输入的数字小数点后两位为"00"的情况，则要在最后追加特殊字符：整
        if (!(scale > 0)) {
            sb.append(CN_FULL);
        }
        return sb.toString();
    }

    public static String numbertocn(Double money) {
        BigDecimal numberOfMoney = new BigDecimal(money);
        String s = number2CNMontrayUnit(numberOfMoney);
        System.out.println("你输入的金额为：【" + money + "】   #--# [" + s.toString() + "]");
        return s.toString();
    }


    /**
     * 获取流程审核页面的信息
     *
     * @param userPO
     * @param page
     * @param size
     * @param val
     * @param model
     * @return
     */
    public List<ProcessAuditVO> getProcessAuditVOList(UserPO userPO, int page, int size, String val, Model model) {
        PageHelper.startPage(page, size);
        List<ProcessAuditVO> processAuditVOList = null;
        if (StringUtil.isEmpty(val)) {
            processAuditVOList = processAuditVOServiceV2.getProcessAuditVOByProcessPOAndReviewedPO(userPO, false);
        }
        return processAuditVOList;
    }

    /**
     * 封装审核页面信息
     *
     * @param processAuditVOList
     * @return
     */
    public List<Map<String, Object>> mapList(List<ProcessAuditVO> processAuditVOList) {
        //创建list集合
        List<Map<String, Object>> list = new ArrayList<>();

        for (int i = 0; i < processAuditVOList.size(); i++) {

            String exigenceName = typeServiceV2.getTypeNameByTypeId(processAuditVOList.get(i).getExigenceName());
//                    tydao.findname(prolist.get(i).getDeeply());
            StatusPO statusPO = statusServiceV2.getStatusPOByStatusId(processAuditVOList.get(i).getStatusId());
//            SystemStatusList status = sdao.findOne(prolist.get(i).getStatusId());
            // 创建map集合用于用于存放前端的
            Map<String, Object> result = new HashMap<>();

            result.put("typeName", processAuditVOList.get(i).getTypeName());//主表的类型名
            result.put("processName", processAuditVOList.get(i).getProcessName());//主表的标题
            result.put("auditUsername", processAuditVOList.get(i).getUserName());//申请人姓名
            result.put("applyTime", new Timestamp(processAuditVOList.get(i).getApplyTime().getTime()));//申请时间
            result.put("exigence", exigenceName);//紧急程度
            result.put("statusName", statusPO.getStatusName());//状态名
            result.put("statusColor", statusPO.getStatusColor());//状态颜色
            result.put("processId", processAuditVOList.get(i).getProcessId());//主表ID
            list.add(result);

        }
        return list;
    }

    /**
     * 用户封装
     *
     * @param page
     * @param size
     * @return
     */
    public void getUser(int page, int size, Model model) {
        PageHelper.startPage(page, size);
        List<UserPO> userPOList = userServiceV2.getUserAll();//获取所有用户信息
        PageInfo pageInfo = new PageInfo(userPOList);// 可以获取分页信息
        List<DeptPO> deptPOList = deptServiceV2.getDeptPOList();//获取所有的部门信息
        List<PositionPO> positionPOList = positionServiceV2.getPositionList();//获取所有的职位信息
        model.addAttribute("page", pageInfo);//可以用户的一些分页信息
        model.addAttribute("emplist", userPOList);//所有用户信息
        model.addAttribute("deptlist", deptPOList);//所有的部门信息
        model.addAttribute("poslist", positionPOList);//所有的部门信息
        model.addAttribute("url", "names");
    }

    /**
     * 审核人封装
     */
    public List<Map<String, Object>> getAuditUser(ProcessListPO processListPO) {
        List<Map<String, Object>> auditMapList = new ArrayList<>();
        //根据审核时间非空和主表ID找审核表
        List<ReviewedPO> reviewedPOList = byProcessPOIdServiceV2.getReviewedPOListByReviewedTimeNotNullAndProcessId(processListPO.getProcessId());
        for (int i = 0; i < reviewedPOList.size(); i++) {
            Map<String, Object> result = new HashMap<>();
            //根据审核人ID获取审核人信息
            UserPO auditUserPO = userServiceV2.getUserPOByUserId(reviewedPOList.get(i).getUserId());
            //根据审核人的职位ID获取审核人的职位信息
            PositionPO positionPO = positionServiceV2.getPositionByPositionId(auditUserPO.getPositionId());
            //根据审核人的状态ID获取审核人的状态信息
            StatusPO statusPO = statusServiceV2.getStatusPOByStatusId(reviewedPOList.get(i).getStatusId());
            result.put("poname", positionPO.getName());//获取审核人的职位名
            result.put("username", auditUserPO.getUserName());//获取审核人的用户名
            result.put("img", auditUserPO.getImgPath());//获取审核人图像路径
            result.put("positionid", auditUserPO.getPositionId());//获取申请人的职位ID
            result.put("retime", new Timestamp(reviewedPOList.get(i).getReviewedTime().getTime()));//获取审核时间
            result.put("des", reviewedPOList.get(i).getAdvice());//获取审核人意见
            result.put("restatus", statusPO.getStatusName());//从审核人状态信息中获取审核人的状态名
            result.put("statuscolor", statusPO.getStatusColor());//从审核人状态信息中获取审核人的状态颜色
            auditMapList.add(result);//将map集合添加斤进list集合
        }
        return auditMapList;
    }

    /**
     * 更新主表信息
     *
     * @param processId  主表ID
     * @param u          登录人信息
     * @param reviewedVO 审核表
     * @param pro        主表
     * @param u2         下一个审核人
     */
    public void save(Long processId, UserPO u, ReviewedVO reviewedVO, ProcessListPO pro, UserPO u2) {
        ReviewedPO reviewedPO = byProcessPOIdServiceV2.getReviewedPOByProcessPOIdAndUserId(processId, u.getUserId());
        reviewedPO.setStatusId(reviewedVO.getStatusId());
        reviewedPO.setAdvice(reviewedVO.getAdvice());
        reviewedPO.setReviewedTime(new Date());
        reviewedPOMapper.updateByPrimaryKeySelective(reviewedPO);

        ReviewedPO reviewedPO2 = new ReviewedPO();
        reviewedPO2.setProId(pro.getProcessId());
        reviewedPO2.setUserId(u2.getUserId());
        reviewedPO2.setStatusId(23L);
        reviewedPOMapper.insertSelective(reviewedPO2);

        pro.getShenuser();
        pro.setShenuser(pro.getShenuser() + ";" + u2.getUserName());
        pro.setStatusId(24L);//改变主表的状态
        processListPOMapper.updateByPrimaryKeySelective(pro);

    }

    /**
     * 更新审核表信息
     *
     * @param re
     * @param reviewed
     */
    public void updateReviewedPO(ReviewedPO re, ReviewedVO reviewed) {
        re.setAdvice(reviewed.getAdvice());
        re.setStatusId(reviewed.getStatusId());
        re.setReviewedTime(new Date());
        reviewedPOMapper.updateByPrimaryKeySelective(re);

    }

    /**
     * 更新主表状态ID
     *
     * @param processListPO
     * @param reviewedVO
     */
    public void updateProcessPOStatus(ProcessListPO processListPO, ReviewedVO reviewedVO) {
        processListPO.setStatusId(reviewedVO.getStatusId());
        processListPOMapper.updateByPrimaryKeySelective(processListPO);
    }


}
