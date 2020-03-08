package cn.gson.oasys.serviceV2.discussV2;

import cn.gson.oasys.serviceV2.typeV2.TypePOServiceV2;
import cn.gson.oasys.serviceV2.userV2.UserPOServiceV2;
import cn.gson.oasys.modelV2.bo.PageBO;
import cn.gson.oasys.modelV2.po.*;
import cn.gson.oasys.voandfactory.userVO2.UserVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;

import javax.annotation.Resource;
import java.sql.Timestamp;
import java.util.*;

@Service
@Slf4j
public class DiscussServiceV2 {
    @Resource
    private DiscussListPOServiceV2 discussListServiceV2;
    @Resource
    private UserPOServiceV2 userPOServiceV2;
    @Resource
    private TypePOServiceV2 typePOServiceV2;
    @Resource
    private ReplyListPOServiceV2 replyListPOServiceV2;
    @Resource
    private ReplyListUserPOServiceV2 replyListUserPOServiceV2;
    @Resource
    private CommentListPOServiceV2 commentListPOServiceV2;
    @Resource
    private DiscussUserPOServiceV2 discussUserPOServiceV2;

    /**
     * 讨论列表的方法
     *
     * @param baseKey
     * @param userId
     * @param type
     * @param time
     * @param visitNum
     * @return
     */
    public List<DiscussListPO> paging(String baseKey, Long userId, String type, String time, String visitNum) {
        if (StringUtils.isEmpty(userId)) {//userId为null
            if (!StringUtils.isEmpty(baseKey)) {//查找字存在
                List<DiscussListPO> discussListPOS = discussListServiceV2.getDiscussListPOSByTitleLike(baseKey, type, time, visitNum);
                return discussListPOS;
            }
            //userId不存在，baseKey不存在
            List<DiscussListPO> discussListPOS = discussListServiceV2.getDiscussListPOSAll(type, time, visitNum);
            return discussListPOS;
        } else {
            UserPO userPO = userPOServiceV2.getUserPOByUserId(userId);
            Boolean superMan = userPO.getSuperman() == 0 ? false : true;//是否是超级管理员0不是，1是
            if (superMan) {
                if (!StringUtils.isEmpty(baseKey)) {//查找字存在
                    List<DiscussListPO> discussListPOS = discussListServiceV2.getDiscussListPOSByTitleLike(baseKey, type, time, visitNum);
                    return discussListPOS;
                }
                List<DiscussListPO> discussListPOS = discussListServiceV2.getDiscussListPOSAll(type, time, visitNum);//是超级管理员
                return discussListPOS;
            } else {
                if (!StringUtils.isEmpty(baseKey)) {
//                    根据讨论归属人和标题模糊字找
                    List<DiscussListPO> discussListPOS = discussListServiceV2.getDiscussListPOSByDiscussUserIdAndTitleLike(userId, baseKey, type, time, visitNum);
                    return discussListPOS;
                }
                //只能看自己的
                List<DiscussListPO> discussListPOS = discussListServiceV2.getDiscussListPOSByDiscussUserId(userId, type, time, visitNum);
                return discussListPOS;
            }
        }
    }


    /**
     * 封装讨论列表信息
     *
     * @param discussListPOS
     * @return
     */
    public List<Map<String, Object>> packaging(List<DiscussListPO> discussListPOS) {
        List<Map<String, Object>> mapList = new ArrayList<>();
        for (DiscussListPO discussListPO : discussListPOS) {
            Map<String, Object> result = new HashMap<>();
            result.put("id", discussListPO.getDiscussId());//讨论表ID
            String typeName = typePOServiceV2.getTypePOByTypeId(discussListPO.getTypeId()).getTypeName();//讨论表类型名
            result.put("typeName", typeName);
            String userName = userPOServiceV2.getUserPOByUserId(discussListPO.getDiscussUserId()).getUserName();//讨论的归属用户名
            result.put("userName", userName);
            Set<UserPO> userPOSet = discussUserPOServiceV2.getUserVOSetByDiscussListPO(discussListPO);//在讨论中间表根据讨论ID找此讨论的用户
            if (userPOSet.size() == 0) {
                result.put("likeNum", 0);
            } else {
                result.put("likeNum", userPOSet.size());
            }
            result.put("commentsNum", getComments(discussListPO));//讨论区的评论数

            result.put("title", discussListPO.getTitle());//讨论标题
            result.put("createTime", discussListPO.getCreateTime());// 讨论时间
            result.put("visitNum", discussListPO.getVisitNum());//此讨论的访问量
            String typeColor = typePOServiceV2.getTypePOByTypeId(discussListPO.getTypeId()).getTypeColor();
            result.put("typecolor", typeColor);
            mapList.add(result);
        }
        return mapList;
    }

    //根据讨论区获取到它的评论数
    private Integer getComments(DiscussListPO discussListPO) {
        int chatNum = 0;
        List<ReplyListPO> replyListPOS = replyListPOServiceV2.getReplyListPOSByDiscussId(discussListPO.getDiscussId());
        if (replyListPOS.size() > 0) {
            //目的是把回复列表的ID放在集合内
            List<Long> replyIds = new ArrayList<>();//用户存放回复id
            replyListPOS.forEach(replyListPO -> replyIds.add(replyListPO.getReplyId()));
            log.info("replyIds={}", replyIds);
            List<CommentListPO> commentListPOS = commentListPOServiceV2.getCommentListPOSByReplyIdIn(replyIds);//in 查找所有回复id的所有评论

            chatNum = commentListPOS.size() + replyListPOS.size();
        }
        return chatNum;
    }


    /**
     * 查看，并将访问量+1
     *
     * @param discussListPOId 讨论ID
     * @return
     */
    public DiscussListPO addOneDiscuss(Long discussListPOId) {
        DiscussListPO discussListPO = discussListServiceV2.getDiscussListPOSByDiscussPOId(discussListPOId);
        discussListPO.setVisitNum(discussListPO.getVisitNum() + 1);
        DiscussListPO updateDiscussListPO = discussListServiceV2.updateDiscussListPOByVisitNum(discussListPO);
        return updateDiscussListPO;
    }


    /**
     * 用来显示信息
     *
     * @param model
     * @param discussPOId
     * @param userId
     * @param page
     * @param size
     */
    public void setDiscussMess(Model model, Long discussPOId, Long userId, int page, int size) {
        discussHandle(model, discussPOId, userId, page, size, null, null);
    }


    /**
     * 处理讨论区信息
     *
     * @param model
     * @param discussPOId 讨论表ID
     * @param userId
     * @param page
     * @param size
     * @param selectType
     * @param selectSort
     */
    public void discussHandle(Model model, Long discussPOId, Long userId, int page, int size, Long selectType, Long selectSort) {
        List<ReplyListPO> replyListPOS = null;
        DiscussListPO discussListPO = discussListServiceV2.getDiscussListPOSByDiscussPOId(discussPOId);//讨论信息
        UserPO userPO = userPOServiceV2.getUserPOByUserId(userId);//用户信息
        Set<UserPO> userPOSet = discussUserPOServiceV2.getUserVOSetByDiscussListPO(discussListPO);//此条讨论的所有用户
        //根据讨论表ID在中间表找讨论的用户(去重），看是否包含此登陆用户
        Boolean discussContain = userPOSet.contains(userPO);
        int discussLikeNum = userPOSet.size();//用户数
        model.addAttribute("discussContain", discussContain);//是否包含用户
        model.addAttribute("discussLikeNum", discussLikeNum);//此条评论用户数
        List<UserPO> userPOList = new ArrayList<>(userPOSet);
        List<UserVO> userVOList = new ArrayList<>();
        for (UserPO userPO1 : userPOList) {
            UserVO userVO = userPOServiceV2.setUserVOByUserId(userPO1.getUserId());
            userVOList.add(userVO);
        }
        model.addAttribute("setUsers", userVOList);
        //这句是关键代码，从数据库拿到所有数据，也进行排序，只要在这进行判断
        if (!StringUtils.isEmpty(selectType)) {
            UserPO userPO2 = userPOServiceV2.getUserPOByUserId(selectType);
            replyListPOS = replyListPOServiceV2.getReplyListPOSByDiscussIdAndUserId(discussListPO.getDiscussId(), userPO2.getUserId(), selectSort);//根据讨论id和用户ID找到此用户所有的回复表
        } else {
            replyListPOS = replyListPOServiceV2.getReplyListPOSByDiscussIdAndCreateTimeSort(discussListPO.getDiscussId(), selectSort);//根据讨论id找到所有的回复表
        }
        List<Map<String, Object>> replys = this.replyPackaging(replyListPOS, userId);//回复信息的封装
        getPageMapList(page, size, replys, model);
        //对回复表字段进行封装，主要是为了获取到评论数
        List<ReplyListPO> replyListPOCols = replyListPOServiceV2.getReplyListPOSByDiscussIdAndCreateTimeSort(discussListPO.getDiscussId(), selectSort);
        if (replyListPOCols.size() > 0) {
            List<Long> replyIds = new ArrayList<>();//用户存放回复id
            replyListPOS.forEach(replyListPO -> replyIds.add(replyListPO.getReplyId()));
            List<CommentListPO> commentListPOS = commentListPOServiceV2.getCommentListPOSByReplyIdIn(replyIds);//in 查找所有回复id的所有评论
            List<Map<String, Object>> commentMap = this.commentPackaging(commentListPOS);    //对评论字段进行封装
            model.addAttribute("commentList", commentMap);
            int chatNum = commentListPOS.size() + replyListPOCols.size();
            model.addAttribute("chatNum", chatNum);//总数
        }

        discussListPO.setCreateTime(new Timestamp(discussListPO.getCreateTime().getTime()));
        model.addAttribute("discuss", discussListPO);//讨论信息
        model.addAttribute("user", userPOServiceV2.getUserPOByUserId(discussListPO.getDiscussUserId()));//讨论归属用户
    }


    /**
     * 对回复表进行封装
     *
     * @param replyListPOS 回复列表
     * @param userId       用户ID
     * @return
     */
    public List<Map<String, Object>> replyPackaging(List<ReplyListPO> replyListPOS, Long userId) {
        UserPO userPO = userPOServiceV2.getUserPOByUserId(userId);
        List<Map<String, Object>> replyMap = new ArrayList<>();
        for (ReplyListPO replyListPO : replyListPOS) {
            Map<String, Object> result = new HashMap<>();
            if (replyListPOS.size() == 0 || replyListUserPOServiceV2.getUserVOSetByReplyListPO(replyListPO).size() == 0) {
                result.put("contain", false);
                result.put("likenum", 0);
            } else {
                result.put("contain", replyListUserPOServiceV2.getUserVOSetByReplyListPO(replyListPO).contains(userPO));//此回复的用户是否包含此用户
                result.put("likenum", replyListUserPOServiceV2.getUserVOSetByReplyListPO(replyListPO).size());//此回复的用户数（点赞数）
            }
            result.put("count", commentListPOServiceV2.getCommentListPOSByReplyPO(replyListPO.getReplyId()).size());//根据回复表找所有的有关评论数
            Set<UserPO> userPOSet = replyListUserPOServiceV2.getUserVOSetByReplyListPO(replyListPO);
            Set<UserVO> userVOSet = userPOServiceV2.getUserVOSetByUserPOSet(userPOSet);
            result.put("replyLikeUsers", userVOSet);//回复的所有用户
            result.put("replyId", replyListPO.getReplyId());//回复ID
            result.put("replayTime", new Timestamp(replyListPO.getReplayTime().getTime()));//回复时间
            result.put("content", replyListPO.getContent());//回复内容
            result.put("user", userPOServiceV2.getUserPOByUserId(replyListPO.getReplyUserId()));//回复归属人

            DiscussListPO discussListPO = discussListServiceV2.getDiscussListPOSByDiscussPOId(replyListPO.getDiscussId());
            discussListPO.setCreateTime(new Timestamp(discussListPO.getCreateTime().getTime()));
            result.put("discuss", discussListPO);//讨论表信息
            replyMap.add(result);
        }
        return replyMap;
    }

    /**
     * 回复封装的分页信息
     *
     * @param page
     * @param size
     * @param mapList
     * @param model
     */
    public void getPageMapList(int page, int size, List<Map<String, Object>> mapList, Model model) {
        PageBO pageBO = new PageBO(page, size);
        pageBO.setTotalCount(mapList.size());
        int start = (pageBO.getPageNo() - 1) * pageBO.getPageSize();
        int end = pageBO.getPageNo() * pageBO.getPageSize();
        if (end > mapList.size()) {
            end = mapList.size();
        }
        List<Map<String, Object>> subMapList = mapList.subList(start, end);

        model.addAttribute("replyList", subMapList);// 回复的封装的信息
        model.addAttribute("page", pageBO);
    }

    /**
     * 对评论表进行封装
     *
     * @param commentListPOS 评论列表
     * @return
     */
    public List<Map<String, Object>> commentPackaging(List<CommentListPO> commentListPOS) {
        List<Map<String, Object>> commentMap = new ArrayList<>();
        for (CommentListPO commentListPO : commentListPOS) {
            Map<String, Object> map = new HashMap<>();
            map.put("commentId", commentListPO.getCommentId());//评论ID
            map.put("comment", commentListPO.getComment());//评论内容
            map.put("time", new Timestamp(commentListPO.getTime().getTime()));//评论时间
            map.put("user", userPOServiceV2.getUserPOByUserId(commentListPO.getCommentUserId()));//此评论归属人
            map.put("reply", commentListPO.getReplyId());//回复ID
            commentMap.add(map);
        }
        return commentMap;
    }

}
