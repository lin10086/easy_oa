package cn.gson.oasys.voandfactory.processVO2;

import cn.gson.oasys.modelV2.po.ProcessListPO;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

public class ProcessListVOFactory {
    public static ProcessListVO createProcessListVOByProcessListPO(ProcessListPO processListPO) {
        ProcessListVO processListVO = new ProcessListVO();
        processListVO.setProcessId(processListPO.getProcessId());
        processListVO.setApplyTime(new Timestamp(processListPO.getApplyTime().getTime()));
        processListVO.setDeeplyId(processListPO.getDeeplyId());
        processListVO.setEndTime(processListPO.getEndTime());
        processListVO.setIsChecked(processListPO.getIsChecked() == 0 ? false : true);
        processListVO.setProcessDays(processListPO.getProcseeDays());
        processListVO.setProcessDescribe(processListPO.getProcessDes());
        processListVO.setProcessName(processListPO.getProcessName());
        processListVO.setAuditUsername(processListPO.getShenuser());
        processListVO.setStartTime(processListPO.getStartTime());
        processListVO.setStatusId(processListPO.getStatusId());
        processListVO.setTypeName(processListPO.getTypeName());
        return processListVO;
    }

    public static List<ProcessListVO> createProcessListVOSByProcessListPOS(List<ProcessListPO> processListPOList) {
        List<ProcessListVO> processListVOList = new ArrayList<>();
        for (ProcessListPO processListPO : processListPOList) {
            processListVOList.add(ProcessListVOFactory.createProcessListVOByProcessListPO(processListPO));
        }
        return processListVOList;
    }

    public static ProcessListPO createProcessListPOByProcessListVO(ProcessListVO processListVO) {
        ProcessListPO processListPO = new ProcessListPO();
        processListPO.setProcessId(processListVO.getProcessId());
        processListPO.setApplyTime(new Timestamp(processListVO.getApplyTime().getTime()));
        processListPO.setDeeplyId(processListVO.getDeeplyId());
        processListPO.setProcessName(processListVO.getProcessName());
        processListPO.setEndTime(processListVO.getEndTime());
        processListPO.setIsChecked(processListVO.getIsChecked() == false ? 0 : 1);
        processListPO.setProcessDes(processListVO.getProcessDescribe());
//        processListPO.setProcessUserId(processListVO.getUserVO().getUserId());
        processListPO.setProcseeDays(processListVO.getProcessDays());
//        processListPO.setProFileId(processListVO.getAttachmentVO().getAttachmentId());
        processListPO.setStartTime(processListVO.getStartTime());
        processListPO.setTypeName(processListVO.getTypeName());
        processListPO.setStatusId(processListVO.getStatusId());
        return processListPO;
    }
}
