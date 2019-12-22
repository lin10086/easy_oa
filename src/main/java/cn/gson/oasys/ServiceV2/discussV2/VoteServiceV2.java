package cn.gson.oasys.ServiceV2.discussV2;

import cn.gson.oasys.ServiceV2.UserPOServiceV2;
import cn.gson.oasys.model.po.*;
import cn.gson.oasys.vo.UserVO;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import javax.annotation.Resource;
import java.sql.Timestamp;
import java.util.*;

@Service
public class VoteServiceV2 {
    @Resource
    private VoteListPOServiceV2 voteListPOServiceV2;
    @Resource
    private VoteTitlesPOServiceV2 voteTitlesPOServiceV2;
    @Resource
    private VoteTitleUserPOServiceV2 voteTitleUserPOServiceV2;
    @Resource
    private UserPOServiceV2 userServiceV2;

    public void voteServiceHandle(Model model, UserPO userPO, DiscussListPO discussListPO) {
        if (!Objects.isNull(discussListPO.getVoteId())) {
            List<VoteTitlesPO> voteTitlesPOS = voteTitlesPOServiceV2.getVoteTitlesPOByVoteId(discussListPO.getVoteId());//根据投票表ID找投票标题集合
            List<Map<String, Object>> voteTitlesList = new ArrayList<>();
            for (VoteTitlesPO voteTitlesPO : voteTitlesPOS) {
                Map<String, Object> result = new HashMap<>();
                result.put("titleId", voteTitlesPO.getTitleId());//投票标题ID
                result.put("title", voteTitlesPO.getTitle());//投票标题
                List<VoteTitleUserPO> voteTitleUserPOS = voteTitleUserPOServiceV2.getVoteTitleUserPOSByVoteTitleId(voteTitlesPO.getTitleId());//在用户投票的标题表中查找所有的同一标题的集合
                result.put("voteTitleUserPOS", voteTitleUserPOS);
                List<UserVO> userVOList = new ArrayList<>();
                for (VoteTitleUserPO voteTitleUserPO : voteTitleUserPOS) {
                    UserVO userVO = userServiceV2.setUserVOByUserId(voteTitleUserPO.getUserId());
                    userVOList.add(userVO);
                }
                result.put("userVOList", userVOList);
                result.put("count", voteTitleUserPOServiceV2.getVoteTitleUserPOSByVoteTitleId(voteTitlesPO.getTitleId()).size());//在用户投票的标题表中查找所有的同一标题的集合的大小
                result.put("color", voteTitlesPO.getColor());//投票标题进度颜色
                result.put("countNum", voteTitleUserPOServiceV2.getVoteTitleUserPOSByVoteId(voteTitlesPO.getVoteId()).size());//在用户投票的标题表中查找所有的同一投票的集合的大小
//                在用户投票的标题表中查找所有的同一标题和同一用户的（投过票是true）
                result.put("contain", !Objects.isNull(voteTitleUserPOServiceV2.getVoteTitleUserPOByVoteTitleIdAndUserId(voteTitlesPO.getTitleId(), userPO.getUserId())));
                voteTitlesList.add(result);
            }
            VoteListPO voteListPO = voteListPOServiceV2.getVoteListPOByVoteListPOId(discussListPO.getVoteId());//根据投票表ID找投票信息
            Date date = new Date();
            if (date.getTime() < voteListPO.getStartTime().getTime()) {
                model.addAttribute("dateType", 1);//未开始
            } else if (date.getTime() > voteListPO.getEndTime().getTime()) {
                model.addAttribute("dateType", 2);//已结束
            } else {
                model.addAttribute("dateType", 3);//进行中
            }
            model.addAttribute("voteTitles", voteTitlesList);//投票表题封装
            voteListPO.setStartTime(new Timestamp(voteListPO.getStartTime().getTime()));
            voteListPO.setEndTime(new Timestamp(voteListPO.getEndTime().getTime()));
            model.addAttribute("voteList", voteListPO);//投票信息
        }
    }

}
