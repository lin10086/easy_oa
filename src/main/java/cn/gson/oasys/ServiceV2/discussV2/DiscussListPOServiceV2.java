package cn.gson.oasys.ServiceV2.discussV2;

import cn.gson.oasys.mappers.DiscussListPOMapper;
import cn.gson.oasys.model.po.CommentListPO;
import cn.gson.oasys.model.po.DiscussListPO;
import cn.gson.oasys.model.po.DiscussListPOExample;
import cn.gson.oasys.model.po.ReplyListPO;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import javax.annotation.Resource;
import java.util.List;

@Service
public class DiscussListPOServiceV2 {
    @Resource
    private DiscussListPOMapper discussListPOMapper;
    @Resource
    private ReplyListPOServiceV2 replyListPOServiceV2;
    @Resource
    private CommentListPOServiceV2 commentListPOServiceV2;
    @Resource
    private DiscussUserPOServiceV2 discussUserPOServiceV2;

    /**
     * 插入一条讨论信息
     *
     * @param discussListPO 讨论信息
     * @return
     */
    public DiscussListPO insertDiscussListPOByDiscussListPO(DiscussListPO discussListPO) {
        discussListPOMapper.insertSelective(discussListPO);
        return discussListPO;
    }

    /**
     * 根据讨论表ID删除讨论表信息
     *
     * @param discussListPOId 讨论表信息
     */
    public void deleteDiscussListPOByDiscussListPOId(Long discussListPOId) {

        List<ReplyListPO> replyListPOS = replyListPOServiceV2.getReplyListPOSByDiscussId(discussListPOId);
        for (ReplyListPO replyListPO : replyListPOS) {
            replyListPOServiceV2.deleteReplyListPOByReplyListPOId(replyListPO.getReplyId());
        }
        //还应该删除此讨论的点赞
        discussUserPOServiceV2.deleteLoveDiscussUserPOByiscussListPOId(discussListPOId);
        discussListPOMapper.deleteByPrimaryKey(discussListPOId);
    }

    /**
     * 更新访问量
     *
     * @param discussListPO
     * @return
     */
    public DiscussListPO updateDiscussListPOByVisitNum(DiscussListPO discussListPO) {
        discussListPOMapper.updateByPrimaryKeySelective(discussListPO);
        return discussListPO;
    }

    /**
     * 根据讨论表信息
     *
     * @param discussListPO
     * @return
     */
    public DiscussListPO updateDiscussListPOByDiscussListPO(DiscussListPO discussListPO) {
        discussListPOMapper.updateByPrimaryKeySelective(discussListPO);
        return discussListPO;
    }

    /**
     * 根据标题模糊查询
     *
     * @param title 模糊标题
     * @return
     */
    public List<DiscussListPO> getDiscussListPOSByTitleLike(String title, String type, String time, String visitNum) {
        DiscussListPOExample discussListPOExample = setSort(type, time, visitNum);
        discussListPOExample.createCriteria().andTitleLike("%" + title + "%");
        List<DiscussListPO> discussListPOS = discussListPOMapper.selectByExample(discussListPOExample);
        return discussListPOS;
    }

    /**
     * 查找所有讨论列表
     *
     * @return
     */
    public List<DiscussListPO> getDiscussListPOSAll(String type, String time, String visitNum) {
        DiscussListPOExample discussListPOExample = setSort(type, time, visitNum);
        List<DiscussListPO> discussListPOS = discussListPOMapper.selectByExample(discussListPOExample);
        return discussListPOS;
    }

    /**
     * 根据讨论归属人和标题模糊字找
     *
     * @param userId
     * @param title
     * @return
     */
    public List<DiscussListPO> getDiscussListPOSByDiscussUserIdAndTitleLike(Long userId, String title, String type, String time, String visitNum) {
        DiscussListPOExample discussListPOExample = setSort(type, time, visitNum);
        discussListPOExample.createCriteria().andDiscussUserIdEqualTo(userId).andTitleLike("%" + title + "%");
        List<DiscussListPO> discussListPOS = discussListPOMapper.selectByExample(discussListPOExample);
        return discussListPOS;
    }

    /**
     * 根据讨论归属人查找
     *
     * @param userId 讨论归属人ID
     * @return
     */
    public List<DiscussListPO> getDiscussListPOSByDiscussUserId(Long userId, String type, String time, String visitNum) {
        DiscussListPOExample discussListPOExample = setSort(type, time, visitNum);
        discussListPOExample.createCriteria().andDiscussUserIdEqualTo(userId);
        List<DiscussListPO> discussListPOS = discussListPOMapper.selectByExample(discussListPOExample);
        return discussListPOS;
    }

    /**
     * 根据讨论ID找讨论表信息
     *
     * @param discussPOId 讨论表ID
     * @return
     */
    public DiscussListPO getDiscussListPOSByDiscussPOId(Long discussPOId) {
        DiscussListPO discussListPO = discussListPOMapper.selectByPrimaryKey(discussPOId);
        return discussListPO;
    }

    //排序

    /**
     * 根据类型升序
     *
     * @return
     */
    public List<DiscussListPO> getDiscussListPOSByTypeIdASC() {
        DiscussListPOExample discussListPOExample = new DiscussListPOExample();
        discussListPOExample.setOrderByClause("type_id ASC");
        List<DiscussListPO> discussListPOS = discussListPOMapper.selectByExample(discussListPOExample);
        return discussListPOS;
    }

    /**
     * 根据类型降序
     *
     * @return
     */
    public List<DiscussListPO> getDiscussListPOSByTypeIdDESC() {
        DiscussListPOExample discussListPOExample = new DiscussListPOExample();
        discussListPOExample.setOrderByClause("type_id DESC");
        List<DiscussListPO> discussListPOS = discussListPOMapper.selectByExample(discussListPOExample);
        return discussListPOS;
    }

    /**
     * 根据时间升序
     *
     * @return
     */
    public List<DiscussListPO> getDiscussListPOSByCreateTimeASC() {
        DiscussListPOExample discussListPOExample = new DiscussListPOExample();
        discussListPOExample.setOrderByClause("create_time ASC");
        List<DiscussListPO> discussListPOS = discussListPOMapper.selectByExample(discussListPOExample);
        return discussListPOS;
    }

    /**
     * 根据时间降序
     *
     * @return
     */
    public List<DiscussListPO> getDiscussListPOSByCreateTimeDESC() {
        DiscussListPOExample discussListPOExample = new DiscussListPOExample();
        discussListPOExample.setOrderByClause("create_time DESC");
        List<DiscussListPO> discussListPOS = discussListPOMapper.selectByExample(discussListPOExample);
        return discussListPOS;
    }


    /**
     * 根据访问量升序
     *
     * @return
     */
    public List<DiscussListPO> getDiscussListPOSByVisitNumASC() {
        DiscussListPOExample discussListPOExample = new DiscussListPOExample();
        discussListPOExample.setOrderByClause("visit_num ASC");
        List<DiscussListPO> discussListPOS = discussListPOMapper.selectByExample(discussListPOExample);
        return discussListPOS;
    }

    /**
     * 根据访问量降序
     *
     * @return
     */
    public List<DiscussListPO> getDiscussListPOSByVisitNumDESC() {
        DiscussListPOExample discussListPOExample = new DiscussListPOExample();
        discussListPOExample.setOrderByClause("visit_num DESC");
        List<DiscussListPO> discussListPOS = discussListPOMapper.selectByExample(discussListPOExample);
        return discussListPOS;
    }

    /**
     * 根据类型升序和时间降序
     *
     * @return
     */
    public List<DiscussListPO> getDiscussListPOSByTypeIdASCAndCreateTimeDESC() {
        DiscussListPOExample discussListPOExample = new DiscussListPOExample();
        discussListPOExample.setOrderByClause("type_id ASC,create_time DESC");
        List<DiscussListPO> discussListPOS = discussListPOMapper.selectByExample(discussListPOExample);
        return discussListPOS;
    }


    /**
     * 设置排序
     *
     * @param type
     * @param time
     * @param visitNum
     * @return
     */
    private DiscussListPOExample setSort(String type, String time, String visitNum) {
        DiscussListPOExample discussListPOExample = new DiscussListPOExample();
        if (!StringUtils.isEmpty(type)) {
            if ("1".equals(type)) {
                discussListPOExample.setOrderByClause("type_id ASC");
            } else {
                discussListPOExample.setOrderByClause("type_id DESC");
            }
        } else if (!StringUtils.isEmpty(time)) {
            if ("1".equals(time)) {
                discussListPOExample.setOrderByClause("create_time DESC");
            } else {
                discussListPOExample.setOrderByClause("create_time ASC");
            }
        } else if (!StringUtils.isEmpty(visitNum)) {
            if ("1".equals(visitNum)) {
                discussListPOExample.setOrderByClause("visit_num DESC");
            } else {
                discussListPOExample.setOrderByClause("visit_num ASC");
            }
        } else {
            discussListPOExample.setOrderByClause("type_id ASC,create_time DESC");
        }
        return discussListPOExample;
    }


}
