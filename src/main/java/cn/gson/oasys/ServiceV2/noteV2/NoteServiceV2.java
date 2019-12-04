package cn.gson.oasys.ServiceV2.noteV2;

import cn.gson.oasys.model.bo.PageBO;
import cn.gson.oasys.model.entity.note.Note;
import cn.gson.oasys.model.po.NoteListPO;
import cn.gson.oasys.model.po.ReceiverNotePO;
import com.github.pagehelper.PageHelper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@Service
public class NoteServiceV2 {
    @Resource
    private ReceiverNotePOServiceV2 receiverNotePOServiceV2;
    @Resource
    private NoteListPOServiceV2 noteListPOServiceV2;


    //排序分页
    public List<NoteListPO> sortPage(int page, String baseKey, long userId, Long isCollected, Long catalogId, Long typeId, Object type, Object status, Object time) {

        /*if (!StringUtils.isEmpty(baseKey) && StringUtils.isEmpty(catalogId)) {

            return noteDao.findBytitleOrderByCreateTimeDesc(baseKey, userId, pa);
        }
        if (!StringUtils.isEmpty(baseKey) && !StringUtils.isEmpty(catalogId)) {

            return noteDao.findBytitleAndCatalogId(baseKey, userId, catalogId, pa);
        }//0为降序 1为升序
        if (!StringUtils.isEmpty(isCollected)) {

            if (!StringUtils.isEmpty(isCollected) && !StringUtils.isEmpty(catalogId)) {

                return noteDao.findByIsCollectedAndCatalogIdOrderByCreateTimeDesc(isCollected, catalogId, userId, pa);
            }
            if (!StringUtils.isEmpty(isCollected) && StringUtils.isEmpty(catalogId)) {
                return noteDao.findByIsCollectedOrderByCreateTimeDesc(isCollected, userId, pa);
            }
        }

        if (!StringUtils.isEmpty(typeId)) {
            if (!StringUtils.isEmpty(typeId) && !StringUtils.isEmpty(catalogId)) {
                System.out.println("目录类型");

                //根据目录 然后再根据类型查找
                if (!StringUtils.isEmpty(type)) {
                    if (type.toString().equals("0"))
                        return noteDao.findByTypeIdOrderByTypeIdDesc(typeId, catalogId, userId, pa);
                    if (type.toString().equals("1"))
                        return noteDao.findByTypeIdOrderByTypeIdAsc(typeId, catalogId, userId, pa);
                }
                if (!StringUtils.isEmpty(status)) {
                    if (status.toString().equals("0"))
                        return noteDao.findByTypeIdOrderByStatusIdDesc(typeId, catalogId, userId, pa);
                    if (status.toString().equals("1"))
                        return noteDao.findByTypeIdOrderByStatusIdAsc(typeId, catalogId, userId, pa);
                }
                if (!StringUtils.isEmpty(time)) {

                    if (time.toString().equals("0"))
                        return noteDao.findByTypeIdOrderByCreateTimeDesc(typeId, catalogId, userId, pa);
                    if (time.toString().equals("1"))
                        return noteDao.findByTypeIdOrderByCreateTimeAsc(typeId, catalogId, userId, pa);
                } else return noteDao.findByTypeIdOrderByCreateTimeDesc(typeId, catalogId, userId, pa);
            }
            if (!StringUtils.isEmpty(typeId) && StringUtils.isEmpty(catalogId)) {
                System.out.println("单纯类型");
                //为空就直接按照类型查找

                if (!StringUtils.isEmpty(type)) {
                    if (type.toString().equals("0")) return noteDao.findByTypeIdOrderByTypeIdDesc(typeId, userId, pa);
                    if (type.toString().equals("1")) return noteDao.findByTypeIdOrderByTypeIdAsc(typeId, userId, pa);
                }
                if (!StringUtils.isEmpty(status)) {
                    if (status.toString().equals("0"))
                        return noteDao.findByTypeIdOrderByStatusIdDesc(typeId, userId, pa);
                    if (status.toString().equals("1"))
                        return noteDao.findByTypeIdOrderByStatusIdAsc(typeId, userId, pa);
                }
                if (!StringUtils.isEmpty(time)) {

                    if (time.toString().equals("0"))
                        return noteDao.findByTypeIdOrderByCreateTimeDesc(typeId, userId, pa);
                    if (time.toString().equals("1"))
                        return noteDao.findByTypeIdOrderByCreateTimeAsc(typeId, userId, pa);
                } else return noteDao.findByTypeIdOrderByCreateTimeDesc(typeId, userId, pa);
            }
        }


        if (!StringUtils.isEmpty(catalogId) && (StringUtils.isEmpty(typeId)) && (StringUtils.isEmpty(isCollected))) {//单纯查找目录
            if (!StringUtils.isEmpty(type)) {
                if (type.toString().equals("0")) return noteDao.findByCatalogIdOrderByTypeIdDesc(catalogId, userId, pa);
                if (type.toString().equals("1")) return noteDao.findByCatalogIdOrderByTypeIdAsc(catalogId, userId, pa);
            }
            if (!StringUtils.isEmpty(status)) {
                if (status.toString().equals("0"))
                    return noteDao.findByCatalogIdOrderByStatusIdDesc(catalogId, userId, pa);
                if (status.toString().equals("1"))
                    return noteDao.findByCatalogIdOrderByStatusIdAsc(catalogId, userId, pa);
            }
            if (!StringUtils.isEmpty(time)) {
                if (time.toString().equals("0"))
                    return noteDao.findByCatalogIdOrderByCreateTimeDesc(catalogId, userId, pa);
                if (time.toString().equals("1"))
                    return noteDao.findByCatalogIdOrderByCreateTimeAsc(catalogId, userId, pa);
            } else return noteDao.findByCatalogIdOrderByCreateTimeDesc(catalogId, userId, pa);
        }


        if (StringUtils.isEmpty(isCollected) && StringUtils.isEmpty(typeId) && StringUtils.isEmpty(catalogId)) {
            if (!StringUtils.isEmpty(type)) {
                if (type.toString().equals("0")) {
                    //降序
                    return noteDao.findByUserssOrderByTypeIdDesc(userId, pa);
                } else {
                    //升序
                    return noteDao.findByUserssOrderByTypeIdAsc(userId, pa);
                }
            }
            if (!StringUtils.isEmpty(status)) {
                if (status.toString().equals("0")) {

                    return noteDao.findByUserssOrderByStatusIdDesc(userId, pa);
                } else {
                    return noteDao.findByUserssOrderByStatusIdAsc(userId, pa);
                }
            }
            if (!StringUtils.isEmpty(time)) {
                if (time.toString().equals("0")) {
                    System.out.println("时间" + time);
                    return noteDao.findByUserssOrderByCreateTimeDesc(userId, pa);
                } else {
                    return noteDao.findByUserssOrderByCreateTimeAsc(userId, pa);
                }
            }
        }*/
        if (!StringUtils.isEmpty(userId)) {
            List<ReceiverNotePO> receiverNotePOS = receiverNotePOServiceV2.getReceiverNotePOSByUserId(userId);
            List<Long> noteIds = receiverNotePOServiceV2.getNoteIdByReceiverNotePO(receiverNotePOS);
//            PageHelper.startPage(pageBO.getPageNo(), pageBO.getPageSize());
            List<NoteListPO> noteListPOS = noteListPOServiceV2.getNoteListPOSByNoteIdInAndCreateTimeDESC(noteIds);

            return noteListPOS;
        } else {
            List<ReceiverNotePO> receiverNotePOS = receiverNotePOServiceV2.getReceiverNotePOSByUserId(userId);
            List<Long> noteIds = receiverNotePOServiceV2.getNoteIdByReceiverNotePO(receiverNotePOS);
//            PageHelper.startPage(pageBO.getPageNo(), pageBO.getPageSize());
            List<NoteListPO> noteListPOS = noteListPOServiceV2.getNoteListPOSByNoteIdIn(noteIds);
            return noteListPOS;
        }

    }
}
