package cn.gson.oasys.serviceV2.directormanageV2;

import cn.gson.oasys.serviceV2.attachmentV2.AttachmentServiceV2;
import cn.gson.oasys.model.po.DirectorPO;
import cn.gson.oasys.model.po.DirectorUsersPO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.util.ResourceUtils;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import java.io.IOException;
import java.util.*;

@Slf4j
@Service
public class DirectorManageServiceAllV2 {
    @Resource
    private DirectorPOServiceV2 directorPOServiceV2;
    @Resource
    private DirectorUserPOServiceV2 directorUserPOServiceV2;
    @Resource
    private AttachmentServiceV2 attachmentServiceV2;

    private String rootPath;

    @PostConstruct
    public void UserpanelController() {
        try {
            rootPath = ResourceUtils.getURL("classpath:").getPath().replace("/target/classes/", "/src/main/resources/attachment");
        } catch (IOException e) {
            System.out.println("获取项目路径异常");
        }
    }

    public List<Map<String, Object>> getDirectorPOAndDirectorUserPOPackage(Long userId, String alphabet, String outType, String baseKey) {
        List<Map<String, Object>> mapList = new ArrayList<>();
        List<DirectorUsersPO> directorUsersPOListAll = new ArrayList<>();
        List<DirectorPO> directorPOListAll = new ArrayList<>();
        //根据用户ID和目录ID非空和是外部通讯录找通讯录用户信息
        List<DirectorUsersPO> directorUsersPOList1 = directorUserPOServiceV2.getDirectorUsersPOListByUserIdAndDirectorIdIsNotNullAndIsHandle(userId);
        directorUsersPOListAll.addAll(directorUsersPOList1);
        List<DirectorPO> directorPOList1 = null;
        if (!"ALL".equals(alphabet)) {
            directorPOList1 = directorPOServiceV2.getDirectorPOListByPinyinLike(alphabet);
            directorPOListAll.addAll(directorPOList1);
        } else {
            directorPOList1 = directorPOServiceV2.getDirectorPOListByALL();
            directorPOListAll.addAll(directorPOList1);
            log.info("directorPOListAll={},directorPOListAll.size()={}", directorPOListAll, directorPOListAll.size());
        }
        List<DirectorUsersPO> directorUsersPOList2 = null;
        if (outType != null && outType != "") {//目录名
            directorUsersPOList2 = directorUserPOServiceV2.getDirectorUsersPOListByCatelogNameEqualToAndCatelogNameAsc(outType);
            for (DirectorPO directorPO1 : directorPOList1) {
                for (DirectorUsersPO directorUsersPO2 : directorUsersPOList2) {
                    if (directorPO1.getDirectorId().equals(directorUsersPO2.getDirectorId())) {
                        directorPOListAll.add(directorPO1);
                        log.info("directorPOListAll={},directorPOListAll.size()={}", directorPOListAll, directorPOListAll.size());
                    }
                }
            }
            for (DirectorPO directorPO : directorPOList1) {
                directorPOListAll.remove(directorPO);
            }
            log.info("directorPOListAll={},directorPOListAll.size()={}", directorPOListAll, directorPOListAll.size());
        }
        List<DirectorUsersPO> directorUsersPOList3 = null;
        List<DirectorPO> directorPOListBySet = new ArrayList<>();//Or条件的结果
        if (baseKey != null && baseKey != "") {//模糊字
            directorUsersPOList3 = directorUserPOServiceV2.getDirectorUsersPOListByCatelogNameLike(baseKey);//目录名模糊查找通讯录用户表信息
            directorUsersPOListAll.addAll(directorUsersPOList3);

            List<DirectorPO> directorPOList2 = directorPOServiceV2.geDirectorPOListByCompanyNameLike(baseKey);//公司名模糊查找外部通讯录人信息
            List<DirectorPO> directorPOList3 = directorPOServiceV2.geDirectorPOListByPhoneNumberLike(baseKey);//手机号模糊查找外部通讯录人信息
            List<DirectorPO> directorPOList4 = directorPOServiceV2.getDirectorPOListByUserNameLike(baseKey);//用户名模糊查找外部通讯录人信息
            List<DirectorPO> directorPOList5 = directorPOServiceV2.getDirectorPOListByPinyinLike(baseKey);//根据用户拼音模糊查找通讯录用户信息
            List<DirectorPO> directorPOList = new ArrayList<>();
            directorPOList.addAll(directorPOList2);
            directorPOList.addAll(directorPOList3);
            directorPOList.addAll(directorPOList4);
            directorPOList.addAll(directorPOList5);//把directorPOList2，3，4，5添加到一起

            Set<DirectorPO> directorPOSet = new HashSet<>(directorPOList);//作用去重
            Iterator iterator = directorPOSet.iterator();
            while (iterator.hasNext()) {
                directorPOListBySet.add((DirectorPO) iterator.next());
            }
            directorPOListAll.addAll(directorPOListBySet);
        }

        for (DirectorUsersPO directorUsersPO : directorUsersPOListAll) {
            for (DirectorPO directorPO : directorPOListAll) {
                if (directorUsersPO.getDirectorId().equals(directorPO.getDirectorId())) {
                    Map<String, Object> result = new HashMap<>();
                    result.put("director_users_id", directorUsersPO.getDirectorUsersId());//通讯录用户ID
                    result.put("director_id", directorUsersPO.getDirectorId());
                    result.put("user_id", directorUsersPO.getUserId());//用户ID（不知道是那个里面的user_id
                    result.put("catelog_name", directorUsersPO.getCatelogName());
                    result.put("companyname", directorPO.getCompanyname());
                    result.put("user_name", directorPO.getUserName());
                    result.put("sex", directorPO.getSex());
                    result.put("phone_number", directorPO.getPhoneNumber());
                    result.put("email", directorPO.getEmail());
                    if (directorPO.getImagePath() != null) {
                        String imagePath = attachmentServiceV2.getAttachmentPathByFileId(directorPO.getImagePath().longValue());
                        result.put("image_path", imagePath);
                    } else {
                        result.put("image_path", "timg.jpg");
                    }
                    mapList.add(result);
                }
            }
        }
        return mapList;
    }
}
