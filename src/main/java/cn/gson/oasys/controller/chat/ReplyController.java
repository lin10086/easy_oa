package cn.gson.oasys.controller.chat;

import cn.gson.oasys.ServiceV2.UserServiceV2;
import cn.gson.oasys.ServiceV2.discussV2.*;
import cn.gson.oasys.model.po.*;
import cn.gson.oasys.vo.UserVO;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttribute;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;
import java.util.Date;
import java.util.Objects;
import java.util.Set;

@Controller
@RequestMapping("/")
public class ReplyController {

    //点赞处理
    @RequestMapping("likethis")
    public void likeThis(HttpServletRequest req, HttpServletResponse resp, @SessionAttribute("userId") Long userId) {
        resp.setCharacterEncoding("utf-8");
        PrintWriter out = null;
        likeThisFun(req, userId);
//		try {
//			out = resp.getWriter();
//			if(number==1){
//				out.println("已赞("+(likenum+1)+")");
//			}else{
//				out.println("赞("+(likenum-1)+")");
//			}
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
        out.flush();
        out.close();
    }

    //=======================================
    @Resource
    private UserServiceV2 userServiceV2;
    @Resource
    private DiscussListPOServiceV2 discussListPOServiceV2;
    @Resource
    private DiscussUserPOServiceV2 discussUserPOServiceV2;
    @Resource
    private DiscussServiceV2 discussServiceV2;
    @Resource
    private ReplyListPOServiceV2 replyListPOServiceV2;
    @Resource
    private ReplyListUserPOServiceV2 replyListUserPOServiceV2;
    @Resource
    private CommentListPOServiceV2 commentListPOServiceV2;
    @Resource
    private VoteTitlesPOServiceV2 voteTitlesPOServiceV2;
    @Resource
    private VoteListPOServiceV2 voteListPOServiceV2;
    @Resource
    private VoteTitleUserPOServiceV2 voteTitleUserPOServiceV2;
    @Resource
    private VoteServiceV2 voteServiceV2;

    /*  */

    /**
     * 回复处理
     *
     * @param req
     * @return
     */
    @RequestMapping("replyhandle")
    public String reply(HttpServletRequest req,
                        @RequestParam(value = "page", defaultValue = "1") int page,
                        @RequestParam(value = "size", defaultValue = "5") int size,
                        @SessionAttribute("userId") Long userId, Model model) {
        UserPO userPO = userServiceV2.getUserPOByUserId(userId);//登录用户信息
        Long num = null;
        Long discussPOId = Long.parseLong(req.getParameter("replyId"));
        String module = req.getParameter("module");    //用来判断是保存在哪个表
        DiscussListPO discussListPO = null;
        if ("discuss".equals(module)) {
            discussListPO = discussListPOServiceV2.getDiscussListPOSByDiscussPOId(discussPOId);
            num = discussListPO.getDiscussId();
        } else {//是回复
            ReplyListPO replyListPO = replyListPOServiceV2.getReplyListPOByReplyListPOId(discussPOId);
            discussListPO = discussListPOServiceV2.getDiscussListPOSByDiscussPOId(replyListPO.getDiscussId());
            num = discussListPO.getDiscussId();
        }
        if (!StringUtils.isEmpty(req.getParameter("comment"))) {
            String comment = req.getParameter("comment");
            if ("discuss".equals(module)) {
                //说明是回复-楼主
                DiscussListPO discussListPO1 = discussListPOServiceV2.getDiscussListPOSByDiscussPOId(discussPOId);
                num = discussListPO1.getDiscussId();
                ReplyListPO insertReplyListPO = new ReplyListPO();
                insertReplyListPO.setReplayTime(new Date());
                insertReplyListPO.setContent(comment);
                insertReplyListPO.setReplyUserId(userId);
                insertReplyListPO.setDiscussId(discussListPO1.getDiscussId());
                replyListPOServiceV2.insertReplyListPOByReplyListPO(insertReplyListPO);
            } else { //说明是回复-评论
                ReplyListPO replyListPO1 = replyListPOServiceV2.getReplyListPOByReplyListPOId(discussPOId);
                num = replyListPO1.getDiscussId();
                CommentListPO commentListPO = new CommentListPO();
                commentListPO.setTime(new Date());
                commentListPO.setComment(comment);
                commentListPO.setCommentUserId(userId);
                commentListPO.setReplyId(replyListPO1.getReplyId());
                commentListPOServiceV2.insertCommentListPOByCommentListPO(commentListPO);
            }
            DiscussListPO discussListPONum = discussListPOServiceV2.getDiscussListPOSByDiscussPOId(num);
            Boolean superMan = userPO.getSuperman() == 0 ? false : true;
            if (superMan) {
                model.addAttribute("manage", "具有管理权限");
            } else {
                if (Objects.equals(userPO.getUserId(), discussListPONum.getDiscussUserId())) {
                    model.addAttribute("manage", "具有管理权限");
                }
            }
        }
        discussServiceV2.setDiscussMess(model, num, userId, page, size);
        return "chat/replytable";
    }


    //异步刷新点赞的人数，详细显示点赞的人出来；
    //接收两个值，一个模块名，另一个主键id；
    @RequestMapping("likeuserload")
    public String likeUserLoad(HttpServletRequest req, Model model, @SessionAttribute("userId") Long userId) {
        Long replyId = Long.parseLong(req.getParameter("replyId"));
        String module = req.getParameter("module");
        Integer size = Integer.parseInt(req.getParameter("size"));
        UserPO userPO = userServiceV2.getUserPOByUserId(userId);
        if ("discuss".equals(module)) {
            //处理讨论表的点赞，刷新
            likeThisFun(req, userId);
            discussServiceV2.setDiscussMess(model, replyId, userId, 1, size);
            DiscussListPO discussListPO = discussListPOServiceV2.getDiscussListPOSByDiscussPOId(replyId);
            Set<UserPO> userPOSet = discussUserPOServiceV2.getUserVOSetByDiscussListPO(discussListPO);
            int discussLikeNum = userPOSet.size();
            model.addAttribute("discuss", discussListPO);
            model.addAttribute("discussLikeNum", discussLikeNum);
            Set<UserVO> userVOSet = userServiceV2.getUserVOSetByUserPOSet(userPOSet);
            model.addAttribute("setUsers", userVOSet);
            return "chat/discusslike";
        } else if ("reply".equals(module)) {
            //处理回复表的点赞，刷新
            String rightNum = req.getParameter("rightNum");
            likeThisFun(req, userId);
            ReplyListPO replyListPO = replyListPOServiceV2.getReplyListPOByReplyListPOId(replyId);
            Set<UserPO> userPOSet = replyListUserPOServiceV2.getUserVOSetByReplyListPO(replyListPO);
            int likeNum = userPOSet.size();
            model.addAttribute("rightNum", rightNum);//?????
            int comments = commentListPOServiceV2.getCommentListPOSByReplyPO(replyListPO.getReplyId()).size();
            model.addAttribute("comments", comments);    //评论的人数
            model.addAttribute("reply", replyListPO);                        //设置返回到前台的回复对象
            model.addAttribute("contain", userPOSet.contains(userPO));    //是否包含
            model.addAttribute("likeNum", likeNum);                    //点赞的人数
            Set<UserVO> userVOSet = userServiceV2.getUserVOSetByUserPOSet(userPOSet);
            model.addAttribute("users", userVOSet);                        //点赞的所有用户
            return "chat/replylike";
        } else {
            //什么鬼？  传参数错误，有问题
            return "参数异常";
        }
    }

    private void likeThisFun(HttpServletRequest req, Long userId) {
        Long replyId = Long.parseLong(req.getParameter("replyId"));//讨论或回复的ID
        String module = req.getParameter("module");//属于哪个模块
        UserPO userPO = userServiceV2.getUserPOByUserId(userId);
        if ("discuss".equals(module)) {
            DiscussListPO discussListPO = discussListPOServiceV2.getDiscussListPOSByDiscussPOId(replyId);//讨论表信息
            Set<UserPO> userPOSet = discussUserPOServiceV2.getUserVOSetByDiscussListPO(discussListPO);//此讨论的用户
            if (!userPOSet.contains(userPO)) {//保存一个讨论点赞记录
                discussUserPOServiceV2.insertLoveDiscussUserPOByUserIdAndDiscussListPOId(userId, discussListPO.getDiscussId());
            } else {//删除掉一个讨论点赞记录
                discussUserPOServiceV2.deleteLoveDiscussUserPOByUserIdAndDiscussListPOId(userId, discussListPO.getDiscussId());
            }
        } else if ("reply".equals(module)) {
            ReplyListPO replyListPO = replyListPOServiceV2.getReplyListPOByReplyListPOId(replyId);
            Set<UserPO> userPOSet = replyListUserPOServiceV2.getUserVOSetByReplyListPO(replyListPO);
            if (!userPOSet.contains(userPO)) {//保存一个回复点赞记录
                replyListUserPOServiceV2.insertLoveReplyUserPOByUserIdAndReplyPOId(userId, replyListPO.getReplyId());
            } else {//删除掉一个回复点赞记录
                replyListUserPOServiceV2.deleteLoveReplyUserPOByUserIdAndReplyPOId(userId, replyListPO.getReplyId());
            }
        }
    }


    /**
     * 回复分页处理
     *
     * @param req
     * @param selectType
     * @param selectSort
     * @param page
     * @param size
     * @param userId
     * @param model
     * @return
     */
    @RequestMapping("/replypaging")
    public String replyPaging(HttpServletRequest req,
                              @RequestParam(value = "selecttype") Long selectType,
                              @RequestParam(value = "selectsort") Long selectSort,
                              @RequestParam(value = "page", defaultValue = "1") int page,
                              @RequestParam(value = "size", defaultValue = "5") int size,
                              @SessionAttribute("userId") Long userId, Model model) {
        Long num = Long.parseLong(req.getParameter("num"));
        discussServiceV2.discussHandle(model, num, userId, page, size, selectType, selectSort);
        return "chat/replytable";
    }

    //回复删除
    @RequestMapping("/replydelete")
    public String replyDelete(HttpServletRequest req,
                              @RequestParam(value = "page", defaultValue = "1") int page,
                              @RequestParam(value = "size", defaultValue = "5") int size,
                              @SessionAttribute("userId") Long userId, Model model) {
        UserPO userPO = userServiceV2.getUserPOByUserId(userId);
        Long discussPOId = Long.parseLong(req.getParameter("num"));
        DiscussListPO discussListPO = discussListPOServiceV2.getDiscussListPOSByDiscussPOId(discussPOId);//讨论信息
        String module = req.getParameter("module");    //用来判断是保存在哪个表
        Long replyIdOrCommentPOId = Long.parseLong(req.getParameter("replyId"));//回复ID或评论ID
        Boolean superMan = userPO.getSuperman() == 0 ? false : true;
        if (superMan) {
            //超级管理员
        } else {
            if (Objects.equals(userPO.getUserId(), discussListPO.getDiscussUserId())) {
                //是登录人自己发布的讨论
            } else {
                System.out.println("权限不匹配，不能删除");
                return "redirect:/notlimit";
            }
        }
        if ("reply".equals(module)) {
            replyListPOServiceV2.deleteReplyListPOByReplyListPOId(replyIdOrCommentPOId);
        } else if ("comment".equals(module)) {
            commentListPOServiceV2.deleteCommentListPOByCommentListPOId(replyIdOrCommentPOId);
        }
        discussServiceV2.setDiscussMess(model, discussPOId, userId, page, size);
        model.addAttribute("manage", "manage");
        return "chat/replytable";
    }



    /**
     * 投票处理
     * @param req
     * @param userId
     * @param model
     * @return
     */
    @RequestMapping("votehandle")
    public String voteHandle(HttpServletRequest req, @SessionAttribute("userId") Long userId, Model model) {
        Long discussId = Long.parseLong(req.getParameter("discussId"));//讨论ID
        Long titleId = Long.parseLong(req.getParameter("titleId"));//投票标题ID
        Integer selectOne = Integer.parseInt(req.getParameter("selectType"));//单选多选
        DiscussListPO discussListPO = discussListPOServiceV2.getDiscussListPOSByDiscussPOId(discussId);//根据讨论ID获取讨论信息
        UserPO userPO = userServiceV2.getUserPOByUserId(userId);
        VoteListPO voteListPO = voteListPOServiceV2.getVoteListPOByVoteListPOId(discussListPO.getVoteId());//根据讨论表中的投票ID获取投票信息
        VoteTitleUserPO voteTitleUserPO = new VoteTitleUserPO();
        voteTitleUserPO.setTitleId(titleId);
        voteTitleUserPO.setUserId(userId);
        voteTitleUserPO.setVoteId(voteListPO.getVoteId());
        Date date = new Date();
        if (date.getTime() < voteListPO.getStartTime().getTime()) {
            return "状态为未开始";
        } else if (date.getTime() > voteListPO.getEndTime().getTime()) {
            return "状态为已结束";
        } else {
            model.addAttribute("dateType", 3);
        }
        VoteTitleUserPO voteTitleUserPO1 = voteTitleUserPOServiceV2.getVoteTitleUserPOByVoteTitleIdAndUserId(titleId,userId);
        if (Objects.isNull(voteTitleUserPO1)) {
            voteTitleUserPOServiceV2.insertVoteTitleUserPOByVoteTitleUserPO(voteTitleUserPO);
        } else {
            return "你已经投过票了";
        }
        voteServiceV2.voteServiceHandle(model,userPO,discussListPO);
        model.addAttribute("discuss", discussListPO);
        return "chat/votetable";
    }


}
