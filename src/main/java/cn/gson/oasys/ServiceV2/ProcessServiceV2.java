package cn.gson.oasys.ServiceV2;

import cn.gson.oasys.ServiceV2.mailV2.MailServiceV2;
import cn.gson.oasys.ServiceV2.processV2.AttachmentServiceV2;
import cn.gson.oasys.mappers.BursementPOMapper;
import cn.gson.oasys.mappers.ProcessListPOMapper;
import cn.gson.oasys.mappers.SubjectPOMapper;
import cn.gson.oasys.model.entity.process.ProcessList;
import cn.gson.oasys.model.entity.user.User;
import cn.gson.oasys.model.po.*;
import cn.gson.oasys.vo.*;
import cn.gson.oasys.vo.factoryvo.*;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.github.pagehelper.util.StringUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.io.IOException;
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
    public Map<String, Object> resultMap(String name, User user, String typename, ProcessListPO processListPO) {
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
            resultMap.put("username", user.getUserName());
            resultMap.put("deptname", deptName);
        }
        resultMap.put("applytime", processListPO.getApplyTime());

        if (!Objects.isNull(processListPO.getProFileId())) {
            AttachmentListPO attachmentListPO = attachmentServiceV2.getAttachmentListPOByAttachmentListPOId(processListPO.getProFileId());
            resultMap.put("file", attachmentListPO);
        } else {
            resultMap.put("file", "file");//？？？
        }
        resultMap.put("name", name);
        resultMap.put("typename", processListPO.getTypeName());
        resultMap.put("startime", processListPO.getStartTime());
        resultMap.put("endtime", processListPO.getEndTime());
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

}
