package cn.gson.oasys.ServiceV2.noteV2;

import cn.gson.oasys.model.entity.note.Note;
import cn.gson.oasys.model.po.NoteListPO;
import cn.gson.oasys.model.po.ReceiverNotePO;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import javax.annotation.Resource;
import java.util.List;

@Service
public class NoteServiceV2 {
    @Resource
    private ReceiverNotePOServiceV2 receiverNotePOServiceV2;
    @Resource
    private NoteListPOServiceV2 noteListPOServiceV2;


    //排序分页
    public List<NoteListPO> sortPage(String baseKey, long userId, Long isCollected, Long catalogId, Long typeId, Object type, Object status, Object time) {
        List<ReceiverNotePO> receiverNotePOS = receiverNotePOServiceV2.getReceiverNotePOSByUserId(userId);//根据userId 找出关联表列表
        List<Long> noteIds = receiverNotePOServiceV2.getNoteIdByReceiverNotePO(receiverNotePOS);//在关联表列表找笔记集合
        if (!StringUtils.isEmpty(baseKey) && StringUtils.isEmpty(catalogId)) {
            return noteListPOServiceV2.getNoteListPOSByNoteIdInAndStatusInOrTypeId(baseKey, noteIds);
        }
        if (!StringUtils.isEmpty(baseKey) && !StringUtils.isEmpty(catalogId)) {
            return noteListPOServiceV2.getNoteListPOSByNoteIdInAndCatalogIdAndStatusInOrTypeId(baseKey, noteIds, catalogId);
        }
        //0为降序 1为升序
        if (!StringUtils.isEmpty(isCollected)) {
            //通过目录查找是否已经收藏
            if (!StringUtils.isEmpty(isCollected) && !StringUtils.isEmpty(catalogId)) {
                List<NoteListPO> noteListPOS = noteListPOServiceV2.getNoteListPOSByNoteIdInAndCatalogIdAndCollected(noteIds, catalogId, catalogId);
                return noteListPOS;
            }
            //单纯查找是否已经收藏
            if (!StringUtils.isEmpty(isCollected) && StringUtils.isEmpty(catalogId)) {
                List<NoteListPO> noteListPOS = noteListPOServiceV2.getNoteListPOSByNoteIdInAndCollected(noteIds, catalogId);
                return noteListPOS;
            }
        }

        if (!StringUtils.isEmpty(typeId)) {
            if (!StringUtils.isEmpty(typeId) && !StringUtils.isEmpty(catalogId)) {
                //根据目录 然后再根据类型查找
                if (!StringUtils.isEmpty(type)) {
                    if (type.toString().equals("0")) {
                        List<NoteListPO> noteListPOS = noteListPOServiceV2.getNoteListPOSByNoteIdInAndCatalogIdAndTypeIdAndTypeIdDESC(noteIds, catalogId, typeId);
                        return noteListPOS;
                    }
                    if (type.toString().equals("1")) {
                        List<NoteListPO> noteListPOS = noteListPOServiceV2.getNoteListPOSByNoteIdInAndCatalogIdAndTypeIdAndTypeIdASC(noteIds, catalogId, typeId);
                        return noteListPOS;
                    }
                }
                if (!StringUtils.isEmpty(status)) {
                    if (status.toString().equals("0")) {
                        List<NoteListPO> noteListPOS = noteListPOServiceV2.getNoteListPOSByNoteIdInAndCatalogIdAndTypeIdAndStatusIdDESC(noteIds, catalogId, typeId);
                        return noteListPOS;
                    }
                    if (status.toString().equals("1")) {
                        List<NoteListPO> noteListPOS = noteListPOServiceV2.getNoteListPOSByNoteIdInAndCatalogIdAndTypeIdAndStatusIdASC(noteIds, catalogId, typeId);
                        return noteListPOS;
                    }
                }
                if (!StringUtils.isEmpty(time)) {

                    if (time.toString().equals("0")) {
                        List<NoteListPO> noteListPOS = noteListPOServiceV2.getNoteListPOSByNoteIdInAndCatalogIdAndTypeIdAndCreateTimeDESC(noteIds, catalogId, typeId);
                        return noteListPOS;
                    }
                    if (time.toString().equals("1")) {
                        List<NoteListPO> noteListPOS = noteListPOServiceV2.getNoteListPOSByNoteIdInAndCatalogIdAndTypeIdAndCreateTimeASC(noteIds, catalogId, typeId);
                        return noteListPOS;
                    }
                } else {
                    List<NoteListPO> noteListPOS = noteListPOServiceV2.getNoteListPOSByNoteIdInAndCatalogIdAndTypeIdAndCreateTimeDESC(noteIds, catalogId, typeId);
                    return noteListPOS;
                }
            }
            if (!StringUtils.isEmpty(typeId) && StringUtils.isEmpty(catalogId)) {
                System.out.println("单纯类型");
                //目录为空就直接按照类型查找
                if (!StringUtils.isEmpty(type)) {
                    if (type.toString().equals("0"))
                        return noteListPOServiceV2.getNoteListPOSByNoteIdInAndTypeIdAndTypeIdDESC(noteIds, typeId);
                    if (type.toString().equals("1"))
                        return noteListPOServiceV2.getNoteListPOSByNoteIdInAndTypeIdAndTypeIdASC(noteIds, typeId);
                }
                if (!StringUtils.isEmpty(status)) {
                    if (status.toString().equals("0"))
                        return noteListPOServiceV2.getNoteListPOSByNoteIdInAndTypeIdAndStatusIdDESC(noteIds, typeId);
                    if (status.toString().equals("1"))
                        return noteListPOServiceV2.getNoteListPOSByNoteIdInAndTypeIdAndStatusIdASC(noteIds, typeId);
                }
                if (!StringUtils.isEmpty(time)) {
                    if (time.toString().equals("0"))
                        return noteListPOServiceV2.getNoteListPOSByNoteIdInAndTypeIdAndCreateTimeDESC(noteIds, typeId);
                    if (time.toString().equals("1"))
                        return noteListPOServiceV2.getNoteListPOSByNoteIdInAndTypeIdAndCreateTimeASC(noteIds, typeId);
                } else {
                    return noteListPOServiceV2.getNoteListPOSByNoteIdInAndTypeIdAndCreateTimeDESC(noteIds, typeId);
                }
            }
        }


        if (!StringUtils.isEmpty(catalogId) && (StringUtils.isEmpty(typeId)) && (StringUtils.isEmpty(isCollected))) {//单纯查找目录
            if (!StringUtils.isEmpty(type)) {
                if (type.toString().equals("0"))
                    return noteListPOServiceV2.getNoteListPOSByNoteIdInAndCatalogIdAndTypeIdDESC(noteIds, catalogId);
                if (type.toString().equals("1"))
                    return noteListPOServiceV2.getNoteListPOSByNoteIdInAndCatalogIdAndTypeIdASC(noteIds, catalogId);
            }
            if (!StringUtils.isEmpty(status)) {
                if (status.toString().equals("0"))
                    return noteListPOServiceV2.getNoteListPOSByNoteIdInAndCatalogIdAndStatusIdDESC(noteIds, catalogId);
                if (status.toString().equals("1"))
                    return noteListPOServiceV2.getNoteListPOSByNoteIdInAndCatalogIdAndStatusIdASC(noteIds, catalogId);
            }
            if (!StringUtils.isEmpty(time)) {
                if (time.toString().equals("0"))
                    return noteListPOServiceV2.getNoteListPOSByNoteIdInAndCatalogIdAndCreateTimeDESC(noteIds, catalogId);
                if (time.toString().equals("1"))
                    return noteListPOServiceV2.getNoteListPOSByNoteIdInAndCatalogIdAndCreateTimeASC(noteIds, catalogId);
            } else {
                return noteListPOServiceV2.getNoteListPOSByNoteIdInAndCatalogIdAndCreateTimeDESC(noteIds, catalogId);
            }
        }


        if (StringUtils.isEmpty(isCollected) && StringUtils.isEmpty(typeId) && StringUtils.isEmpty(catalogId)) {
            if (!StringUtils.isEmpty(type)) {
                if (type.toString().equals("0")) {
                    return noteListPOServiceV2.getNoteListPOSByNoteIdInAndTypeIdDESC(noteIds);
                } else {
                    return noteListPOServiceV2.getNoteListPOSByNoteIdInAndTypeIdASC(noteIds);
                }
            }
            if (!StringUtils.isEmpty(status)) {
                if (status.toString().equals("0")) {
                    return noteListPOServiceV2.getNoteListPOSByNoteIdInAndStatusIdDESC(noteIds);
                } else {
                    return noteListPOServiceV2.getNoteListPOSByNoteIdInAndStatusIdASC(noteIds);
                }
            }
            if (!StringUtils.isEmpty(time)) {
                if (time.toString().equals("0")) {
                    System.out.println("时间" + time);
                    return noteListPOServiceV2.getNoteListPOSByNoteIdInAndCreateTimeDESC(noteIds);
                } else {
                    return noteListPOServiceV2.getNoteListPOSByNoteIdInAndCreateTimeASC(noteIds);
                }
            }
        }
        if (!StringUtils.isEmpty(userId)) {
            List<NoteListPO> noteListPOS = noteListPOServiceV2.getNoteListPOSByNoteIdInAndCreateTimeDESC(noteIds);
            return noteListPOS;
        } else {
            List<NoteListPO> noteListPOS = noteListPOServiceV2.getNoteListPOSByNoteIdIn(noteIds);
            return noteListPOS;
        }

    }
}
