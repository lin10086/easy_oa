package cn.gson.oasys.ServiceV2;

import cn.gson.oasys.ServiceV2.mailV2.MailServiceV2;
import cn.gson.oasys.ServiceV2.processV2.AttachmentServiceV2;
import cn.gson.oasys.mappers.BursementPOMapper;
import cn.gson.oasys.mappers.ProcessListPOMapper;
import cn.gson.oasys.mappers.SubjectPOMapper;
import cn.gson.oasys.model.entity.process.AubUser;
import cn.gson.oasys.model.entity.process.ProcessList;
import cn.gson.oasys.model.entity.system.SystemStatusList;
import cn.gson.oasys.model.entity.user.User;
import cn.gson.oasys.model.po.*;
import cn.gson.oasys.vo.*;
import cn.gson.oasys.vo.factoryvo.*;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.github.pagehelper.util.StringUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
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
    private ReviewedServiceV2 reviewedServiceV2;
    @Resource
    private BursementPOMapper bursementPOMapper;

    @Resource
    private MailServiceV2 mailServiceV2;
    @Resource
    private AttachmentServiceV2 attachmentServiceV2;
    @Resource
    private ProcessListPOMapper processListPOMapper;

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
     * 存表
     *
     * @throws IOException
     * @throws IllegalStateException
     */
    //主表，费用报销，申请人，上传的票据路径，审核人的用户名(pro,val,lu,filePath,reuser.getUserName())
    public void publicX5(ProcessListVO pro, String val, UserVO lu, MultipartFile filePath, String name) throws IllegalStateException, IOException {

        pro.setTypeName(val);//流程申请类型
        pro.setApplyTime(new Date());//流程申请时间
        pro.setUserVO(lu);//流程申请人
        pro.setStatusId(23L);//流程审核状态，23L未处理
        pro.setShenuser(name);//审核人用户名
        AttachmentVO attachmentVO = null;//附件
        //file.getOriginalFilename()是得到上传时的文件名。
        if (!StringUtil.isEmpty(filePath.getOriginalFilename())) {
            //上传附件
            attachmentVO = mailServiceV2.uploadAttachmentVO(filePath, lu);

            attachmentServiceV2.insertAttachmentListPO();
            pro.setAttachmentVO(attachmentVO);
        }
    }

    //    	 公用
    public void publicX6(Model model, Long userId, int page, int size) {
        //根据userId获取用户信息
        UserPO userPO = userServiceV2.getUserPOByUserId(userId);
//        UserVO userVO = UserFactoryVO.createUserVO(userPO);
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
        List<TypePO> typePOList = typeServiceV2.getTypePOByTypeModel("aoa_process_list");
        List<TypeVO> typeVOList = TypeFactoryVO.createTypeVOList(typePOList);

        List<DeptPO> deptPOList = deptServiceV2.getDeptPOList();
        List<DeptVO> deptVOList = DeptFactoryVO.createDeptVOList(deptPOList);

        List<PositionPO> positionPOList = positionServiceV2.getPositionList();
        List<PositionVO> positionVOList = PositionFactoryVO.createPositionVOList(positionPOList);

        model.addAttribute("page", pageInfo);
        model.addAttribute("userVOList", userVOList);
        model.addAttribute("deptVOList", deptVOList);
        model.addAttribute("positionVOList", positionVOList);
        model.addAttribute("url", "names");
        model.addAttribute("username", userPO.getUserName());
        model.addAttribute("typeVOList", typeVOList);
    }


    /**
     * 存审核表
     *
     * @param user          审核人
     * @param processListVO 主表
     */
    public void insertReviewedVO(UserVO user, ProcessListVO processListVO) {


        reviewedServiceV2.insertReviewedVO(user, processListVO);

    }

    //更新费用报销表
//    票据总数,总计金额

    /**
     * 插入费用报销表
     *
     * @param zhuti       证明人
     * @param bursementVO 前端费用报销表数据
     * @param allInvoice  票据总数
     * @param allMoney    报销金额
     * @param reUser      审核人
     */
    public void insertBursementVO(ProcessListVO processListVO, UserVO zhuti, BursementVO bursementVO, Integer allInvoice, Double allMoney, UserVO reUser) {
        BursementPO bursementPO = new BursementPO();
        bursementPO.setProId(processListVO.getProcessId());
        bursementPO.setAllinvoices(allInvoice);
        bursementPO.setAllMoney(allMoney);
        bursementPO.setUserName(zhuti.getUserId());
        bursementPOMapper.insertSelective(bursementPO);
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
     * @param name          "审核"或者"申请"
     * @param user          申请用户信息
     * @param typename      主表里面的类型名称
     * @param processListPO 主表信息
     * @return
     */
    public Map<String, Object> resultMap(String name, UserPO userPO, ProcessListPO processListPO) {
        ProcessListVO processListVO = ProcessListFactoryVO.createProcessListVO(processListPO);
        Map<String, Object> resultMap = new HashMap<>();
        String typeName = typeServiceV2.getTypeNameByTypeId(processListPO.getDeeplyId());
//        String harryname = tydao.findname(process.getDeeply());

        resultMap.put("proId", processListPO.getProcessId());
        resultMap.put("harryname", typeName);
        resultMap.put("processName", processListPO.getProcessName());
        resultMap.put("processDescribe", processListPO.getProcessDes());

        String deptName = deptServiceV2.getDeptNameByUserId(processListPO.getProcessUserId());
        if (("审核").equals(name)) {
            String userName = userServiceV2.getUsernameByUserId(processListPO.getProcessUserId());
            resultMap.put("username", userName);//提单人员(申请人名）
            resultMap.put("deptname", deptName);//部门
        } else if (("申请").equals(name)) {
            resultMap.put("username", userPO.getUserName());
            resultMap.put("deptname", deptName);
        }
        resultMap.put("applytime", new Timestamp(processListPO.getApplyTime().getTime()));

        if (!Objects.isNull(processListPO.getProFileId())) {
            AttachmentListPO attachmentListPO = attachmentServiceV2.getAttachmentListPOByAttachmentListPOId(processListPO.getProFileId());
            resultMap.put("file", attachmentListPO);
        } else {
            resultMap.put("file", "file");//？？？
        }
        resultMap.put("name", name);
        resultMap.put("typename", processListPO.getTypeName());
        resultMap.put("startime", new Timestamp(processListPO.getStartTime().getTime()));
        resultMap.put("endtime", new Timestamp(processListPO.getEndTime().getTime()));
        resultMap.put("tianshu", processListPO.getProcseeDays());
        resultMap.put("statusid", processListPO.getStatusId());
        if (processListPO.getProFileId() != null) {
            String filePath = attachmentServiceV2.getAttachmentPathByAttachmentListPOId(processListPO.getProFileId());
            resultMap.put("filepath", filePath);
            Boolean flage = attachmentServiceV2.getAttachmentListPOByAttachmentListPOId(processListPO.getProFileId()).getAttachmentType().startsWith("image");
            if (flage) {
                resultMap.put("filetype", "img");
            } else {
                resultMap.put("filetype", "appli");
            }
        }
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



}
