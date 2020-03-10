package cn.gson.oasys.service;

import cn.gson.oasys.mappers.NoticeListPOMapper;
import cn.gson.oasys.model.entity.notice.NoticesList;
import cn.gson.oasys.modelV2.po.NoticeListPO;
import cn.gson.oasys.modelV2.po.NoticeListPOExample;
import cn.gson.oasys.modelV2.po.NoticeUserRelationPOExample;
import cn.gson.oasys.serviceV2.notice2.NoticePOServiceV2;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runner.Runner;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.util.StringUtils;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@Slf4j
@RunWith(SpringRunner.class)
@SpringBootTest
public class NoticePOListTest {

    @Resource
    private NoticeListPOMapper noticeListPOMapper;
    @Resource
    private NoticePOServiceV2 noticePOServiceV2;

    @Test
    public void pageThis() {
        String type = "1", status = "1", time = "1", baseKey = "公告";
        StringBuilder str = new StringBuilder();
        NoticeListPOExample noticeListPOExample = new NoticeListPOExample();
//        if ("1".equals(type)) {
//            str.append("type_id DESC");
//        }
//        if ("1".equals(status)) {
//            str.append(",status_id DESC");
//        }
        noticeListPOExample.setOrderByClause("type_id DESC,status_id DESC");
//        noticeListPOExample.setOrderByClause("status_id DESC");
//        noticeListPOExample.setOrderByClause(str.toString());
        noticeListPOExample.createCriteria().andUserIdEqualTo(3L);
        List<NoticeListPO> noticeListPOS = noticeListPOMapper.selectByExample(noticeListPOExample);
        log.info("noticeListPOS={}", noticeListPOS);
        //根据类型排序
//        if (!StringUtils.isEmpty(type)) {
//            if ("1".equals(type)) {
//                noticeListPOExample.setOrderByClause("type_id DESC");
//            } else {
//                noticeListPOExample.setOrderByClause("type_id ASC");
//            }
//        } else if (!StringUtils.isEmpty(status)) { //根据状态排序
//            if ("1".equals(status)) {
//                noticeListPOExample.setOrderByClause("status_id DESC");
//            } else {
//                noticeListPOExample.setOrderByClause("status_id ASC");
//            }
//        } else if (!StringUtils.isEmpty(time)) { //根据时间排序
//            if ("1".equals(time)) {
//                noticeListPOExample.setOrderByClause("modify_time DESC");
//            } else {
//                noticeListPOExample.setOrderByClause("modify_time ASC");
//            }
//        } else if (!StringUtils.isEmpty(baseKey)) {
//            String key = "%" + baseKey + "%";
//
//            return noticePOServiceV2.noticeListPOSByUserIdAndTitleLikeOrderIsTopDESCAndModifyTimeDESC();
//        }
//        System.out.println("orders:" + orders);
//        if (orders.size() > 0) {
//            Sort sort = new Sort(orders);
//            pa = new PageRequest(page, size, sort);
//        } else {
//            pa = new PageRequest(page, size);
//        }
//        return informDao.findByUserId(userId, pa);
//    }
    }

    @Test
    public void update() {
        NoticeListPOExample noticeListPOExample = new NoticeListPOExample();
        NoticeListPO noticeListPO = new NoticeListPO();
        noticeListPO.setUrl("https://www.baidu.com/");
        noticeListPOMapper.updateByExampleSelective(noticeListPO, noticeListPOExample);
    }

    @Test
    public void getNoticeLstPOS() {
        String baseKey = "p";
        NoticeListPOExample noticeListPOExample = new NoticeListPOExample();
        noticeListPOExample.createCriteria().andNoticeIdEqualTo(3L);
        if (baseKey != null) {
            NoticeListPOExample.Criteria criteria2 = noticeListPOExample.createCriteria().andTitleLike("%" + baseKey + "%");
        }
        List<NoticeListPO> noticeListPOS = noticeListPOMapper.selectByExample(noticeListPOExample);
        log.info("noticeListPOS={}", noticeListPOS);
    }
}


