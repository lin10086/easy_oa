package cn.gson.oasys.vo.factoryvo;

import cn.gson.oasys.model.po.ProcessListPO;
import cn.gson.oasys.vo.ProcessListVO;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ProcessListFactoryVO {
    public static ProcessListVO createProcessListVO(ProcessListPO processListPO) {
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

    public static List<ProcessListVO> createProcessListVOList(List<ProcessListPO> processListPOList) {
        List<ProcessListVO> processListVOList = new ArrayList<>();
        for (ProcessListPO processListPO : processListPOList) {
            processListVOList.add(ProcessListFactoryVO.createProcessListVO(processListPO));
        }
        return processListVOList;
    }
}
