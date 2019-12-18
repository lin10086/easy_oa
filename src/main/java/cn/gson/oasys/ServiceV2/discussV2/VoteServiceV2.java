package cn.gson.oasys.ServiceV2.discussV2;

import cn.gson.oasys.model.entity.discuss.Discuss;
import cn.gson.oasys.model.entity.discuss.VoteList;
import cn.gson.oasys.model.entity.discuss.VoteTitles;
import cn.gson.oasys.model.entity.user.User;
import cn.gson.oasys.model.po.DiscussListPO;
import cn.gson.oasys.model.po.UserPO;
import cn.gson.oasys.model.po.VoteListPO;
import cn.gson.oasys.model.po.VoteTitlesPO;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import javax.annotation.Resource;
import java.util.*;

@Service
public class VoteServiceV2 {
    @Resource
    private VoteListPOServiceV2 voteListPOServiceV2;
    @Resource
    private VoteTitlesPOServiceV2 voteTitlesPOServiceV2;
    @Resource
    private VoteTitleUserPOServiceV2 voteTitleUserPOServiceV2;

    public void voteServiceHandle(Model model, UserPO userPO, DiscussListPO discussListPO) {

        if (!Objects.isNull(discussListPO.getVoteId())) {
            List<VoteTitlesPO> voteTitlesPOS = voteTitlesPOServiceV2.getVoteTitlesPOByVoteId(discussListPO.getVoteId());//根据投票表ID找投票标题集合
            List<Map<String, Object>> voteTitlesList = new ArrayList<>();
            for (VoteTitlesPO voteTitlesPO : voteTitlesPOS) {
                Map<String, Object> result = new HashMap<>();
                result.put("titleId", voteTitlesPO.getTitleId());//投票标题ID
                result.put("title", voteTitlesPO.getTitle());//投票标题
                result.put("users", voteTitleUserPOServiceV2.getVoteTitleUserPOSByVoteTitleId(voteTitlesPO.getTitleId()));//在用户投票的标题表中查找所有的同一标题的集合
                result.put("count", voteTitleUserPOServiceV2.getVoteTitleUserPOSByVoteTitleId(voteTitlesPO.getTitleId()).size());//在用户投票的标题表中查找所有的同一标题的集合的大小
                result.put("color", voteTitlesPO.getColor());//投票标题进度颜色
                result.put("countNum", voteTitleUserPOServiceV2.getVoteTitleUserPOSByVoteId(voteTitlesPO.getVoteId()).size());//在用户投票的标题表中查找所有的同一投票的集合的到校
//                在用户投票的标题表中查找所有的同一标题和同一用户的（即投票标题相同）
                result.put("contain", !Objects.isNull(voteTitleUserPOServiceV2.getVoteTitleUserPOByVoteTitleIdAndUserId(voteTitlesPO.getTitleId(), userPO.getUserId())));
                voteTitlesList.add(result);
            }
            VoteListPO voteListPO = voteListPOServiceV2.getVoteListPOByVoteListPOId(discussListPO.getVoteId());//根据投票表ID找投票信息
            Date date = new Date();
            if (date.getTime() < voteListPO.getStartTime().getTime()) {
                model.addAttribute("dateType", 1);
            } else if (date.getTime() > voteListPO.getEndTime().getTime()) {
                model.addAttribute("dateType", 2);
            } else {
                model.addAttribute("dateType", 3);
            }
            model.addAttribute("voteTitles", voteTitlesList);//投票表题封装
            model.addAttribute("voteList", voteListPO);//投票信息
        }
    }

}
