package cn.gson.oasys.ServiceV2.noteV2;

import cn.gson.oasys.ServiceV2.StatusServiceV2;
import cn.gson.oasys.ServiceV2.TypeServiceV2;
import cn.gson.oasys.mappers.NoteListPOMapper;
import cn.gson.oasys.model.entity.note.Note;
import cn.gson.oasys.model.po.NoteListPO;
import cn.gson.oasys.model.po.NoteListPOExample;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class NoteListPOServiceV2 {
    @Resource
    private NoteListPOMapper noteListPOMapper;
    @Resource
    private StatusServiceV2 statusServiceV2;
    @Resource
    private TypeServiceV2 typeServiceV2;


    /**
     * 根据用户笔记ids找笔记列表
     *
     * @param noteIds
     * @return
     */
    public List<NoteListPO> getNoteListPOSByNoteIdIn(List<Long> noteIds) {
        NoteListPOExample noteListPOExample = new NoteListPOExample();
        noteListPOExample.createCriteria().andNoteIdIn(noteIds);
        List<NoteListPO> noteListPOS = noteListPOMapper.selectByExample(noteListPOExample);
        return noteListPOS;
    }

    /**
     * 根据用户笔记ids和目录列表和是否收藏找笔记列表
     *
     * @param noteIds   笔记ids
     * @param catalogId 目录id
     * @param collected 是否收藏
     * @return
     */
    public List<NoteListPO> getNoteListPOSByNoteIdInAndCatalogIdAndCollected(List<Long> noteIds, Long catalogId, Long collected) {
        NoteListPOExample noteListPOExample = new NoteListPOExample();
        noteListPOExample.createCriteria().andNoteIdIn(noteIds).andCatalogIdEqualTo(catalogId).andIsCollectedEqualTo(collected);
        List<NoteListPO> noteListPOS = noteListPOMapper.selectByExample(noteListPOExample);
        return noteListPOS;
    }

    /**
     * 根据用户笔记ids和是否收藏找笔记列表
     *
     * @param noteIds   笔记ids
     * @param collected 是否收藏
     * @return
     */
    public List<NoteListPO> getNoteListPOSByNoteIdInAndCollected(List<Long> noteIds, Long collected) {
        NoteListPOExample noteListPOExample = new NoteListPOExample();
        noteListPOExample.createCriteria().andNoteIdIn(noteIds).andIsCollectedEqualTo(collected);
        List<NoteListPO> noteListPOS = noteListPOMapper.selectByExample(noteListPOExample);
        return noteListPOS;
    }
//类型，目录都纯在

    /**
     * 根据用户笔记ids和目录id和类型id找笔记列表并根据类型id降序
     *
     * @param noteIds   笔记ids
     * @param catalogId 目录id
     * @param typeId    类型id
     * @return
     */
    public List<NoteListPO> getNoteListPOSByNoteIdInAndCatalogIdAndTypeIdAndTypeIdDESC(List<Long> noteIds, Long catalogId, Long typeId) {
        NoteListPOExample noteListPOExample = new NoteListPOExample();
        noteListPOExample.setOrderByClause("type_id DESC");
        noteListPOExample.createCriteria().andNoteIdIn(noteIds).andCatalogIdEqualTo(catalogId).andTypeIdEqualTo(typeId);
        List<NoteListPO> noteListPOS = noteListPOMapper.selectByExample(noteListPOExample);
        return noteListPOS;
    }

    /**
     * 根据用户笔记ids和目录id和类型id找笔记列表并根据类型id升序
     *
     * @param noteIds   笔记id
     * @param catalogId 目录id
     * @param typeId    类型id
     * @return
     */
    public List<NoteListPO> getNoteListPOSByNoteIdInAndCatalogIdAndTypeIdAndTypeIdASC(List<Long> noteIds, Long catalogId, Long typeId) {
        NoteListPOExample noteListPOExample = new NoteListPOExample();
        noteListPOExample.setOrderByClause("type_id ASC");
        noteListPOExample.createCriteria().andNoteIdIn(noteIds).andCatalogIdEqualTo(catalogId).andTypeIdEqualTo(typeId);
        List<NoteListPO> noteListPOS = noteListPOMapper.selectByExample(noteListPOExample);
        return noteListPOS;
    }

    /**
     * 根据用户笔记ids和目录id和类型id找笔记列表并根据状态id降序
     *
     * @param noteIds   笔记ids
     * @param catalogId 目录id
     * @param typeId    类型id
     * @return
     */
    public List<NoteListPO> getNoteListPOSByNoteIdInAndCatalogIdAndTypeIdAndStatusIdDESC(List<Long> noteIds, Long catalogId, Long typeId) {
        NoteListPOExample noteListPOExample = new NoteListPOExample();
        noteListPOExample.setOrderByClause("status_id DESC");
        noteListPOExample.createCriteria().andNoteIdIn(noteIds).andCatalogIdEqualTo(catalogId).andTypeIdEqualTo(typeId);
        List<NoteListPO> noteListPOS = noteListPOMapper.selectByExample(noteListPOExample);
        return noteListPOS;
    }

    /**
     * 根据用户笔记ids和目录id和类型id找笔记列表并根据状态id升序
     *
     * @param noteIds   笔记id
     * @param catalogId 目录id
     * @param typeId    类型id
     * @return
     */
    public List<NoteListPO> getNoteListPOSByNoteIdInAndCatalogIdAndTypeIdAndStatusIdASC(List<Long> noteIds, Long catalogId, Long typeId) {
        NoteListPOExample noteListPOExample = new NoteListPOExample();
        noteListPOExample.setOrderByClause("status_id ASC");
        noteListPOExample.createCriteria().andNoteIdIn(noteIds).andCatalogIdEqualTo(catalogId).andTypeIdEqualTo(typeId);
        List<NoteListPO> noteListPOS = noteListPOMapper.selectByExample(noteListPOExample);
        return noteListPOS;
    }

    /**
     * 根据用户笔记ids和目录id和类型id找笔记列表并根据创建时间id降序
     *
     * @param noteIds   笔记ids
     * @param catalogId 目录id
     * @param typeId    类型id
     * @return
     */
    public List<NoteListPO> getNoteListPOSByNoteIdInAndCatalogIdAndTypeIdAndCreateTimeDESC(List<Long> noteIds, Long catalogId, Long typeId) {
        NoteListPOExample noteListPOExample = new NoteListPOExample();
        noteListPOExample.setOrderByClause("create_time DESC");
        noteListPOExample.createCriteria().andNoteIdIn(noteIds).andCatalogIdEqualTo(catalogId).andTypeIdEqualTo(typeId);
        List<NoteListPO> noteListPOS = noteListPOMapper.selectByExample(noteListPOExample);
        return noteListPOS;
    }

    /**
     * 根据用户笔记ids和目录id和类型id找笔记列表并根据创建时间id升序
     *
     * @param noteIds   笔记id
     * @param catalogId 目录id
     * @param typeId    类型id
     * @return
     */
    public List<NoteListPO> getNoteListPOSByNoteIdInAndCatalogIdAndTypeIdAndCreateTimeASC(List<Long> noteIds, Long catalogId, Long typeId) {
        NoteListPOExample noteListPOExample = new NoteListPOExample();
        noteListPOExample.setOrderByClause("create_time ASC");
        noteListPOExample.createCriteria().andNoteIdIn(noteIds).andCatalogIdEqualTo(catalogId).andTypeIdEqualTo(typeId);
        List<NoteListPO> noteListPOS = noteListPOMapper.selectByExample(noteListPOExample);
        return noteListPOS;
    }
//类型存在，目录不存在

    /**
     * 根据用户笔记ids和类型id找笔记列表并根据类型id降序
     *
     * @param noteIds 笔记ids
     * @param typeId  类型id
     * @return
     */
    public List<NoteListPO> getNoteListPOSByNoteIdInAndTypeIdAndTypeIdDESC(List<Long> noteIds, Long typeId) {
        NoteListPOExample noteListPOExample = new NoteListPOExample();
        noteListPOExample.setOrderByClause("type_id DESC");
        noteListPOExample.createCriteria().andNoteIdIn(noteIds).andTypeIdEqualTo(typeId);
        List<NoteListPO> noteListPOS = noteListPOMapper.selectByExample(noteListPOExample);
        return noteListPOS;
    }

    /**
     * 根据用户笔记ids和类型id找笔记列表并根据类型id升序
     *
     * @param noteIds 笔记id
     * @param typeId  类型id
     * @return
     */
    public List<NoteListPO> getNoteListPOSByNoteIdInAndTypeIdAndTypeIdASC(List<Long> noteIds, Long typeId) {
        NoteListPOExample noteListPOExample = new NoteListPOExample();
        noteListPOExample.setOrderByClause("type_id ASC");
        noteListPOExample.createCriteria().andNoteIdIn(noteIds).andTypeIdEqualTo(typeId);
        List<NoteListPO> noteListPOS = noteListPOMapper.selectByExample(noteListPOExample);
        return noteListPOS;
    }

    /**
     * 根据用户笔记ids和类型id找笔记列表并根据状态id降序
     *
     * @param noteIds 笔记ids
     * @param typeId  类型id
     * @return
     */
    public List<NoteListPO> getNoteListPOSByNoteIdInAndTypeIdAndStatusIdDESC(List<Long> noteIds, Long typeId) {
        NoteListPOExample noteListPOExample = new NoteListPOExample();
        noteListPOExample.setOrderByClause("status_id DESC");
        noteListPOExample.createCriteria().andNoteIdIn(noteIds).andTypeIdEqualTo(typeId);
        List<NoteListPO> noteListPOS = noteListPOMapper.selectByExample(noteListPOExample);
        return noteListPOS;
    }

    /**
     * 根据用户笔记ids和类型id找笔记列表并根据状态id升序
     *
     * @param noteIds 笔记id
     * @param typeId  类型id
     * @return
     */
    public List<NoteListPO> getNoteListPOSByNoteIdInAndTypeIdAndStatusIdASC(List<Long> noteIds, Long typeId) {
        NoteListPOExample noteListPOExample = new NoteListPOExample();
        noteListPOExample.setOrderByClause("status_id ASC");
        noteListPOExample.createCriteria().andNoteIdIn(noteIds).andTypeIdEqualTo(typeId);
        List<NoteListPO> noteListPOS = noteListPOMapper.selectByExample(noteListPOExample);
        return noteListPOS;
    }

    /**
     * 根据用户笔记ids和目录id和类型id找笔记列表并根据创建时间id降序
     *
     * @param noteIds 笔记ids
     * @param typeId  类型id
     * @return
     */
    public List<NoteListPO> getNoteListPOSByNoteIdInAndTypeIdAndCreateTimeDESC(List<Long> noteIds, Long typeId) {
        NoteListPOExample noteListPOExample = new NoteListPOExample();
        noteListPOExample.setOrderByClause("create_time DESC");
        noteListPOExample.createCriteria().andNoteIdIn(noteIds).andTypeIdEqualTo(typeId);
        List<NoteListPO> noteListPOS = noteListPOMapper.selectByExample(noteListPOExample);
        return noteListPOS;
    }

    /**
     * 根据用户笔记ids和类型id找笔记列表并根据创建时间id升序
     *
     * @param noteIds 笔记id
     * @param typeId  类型id
     * @return
     */
    public List<NoteListPO> getNoteListPOSByNoteIdInAndTypeIdAndCreateTimeASC(List<Long> noteIds, Long typeId) {
        NoteListPOExample noteListPOExample = new NoteListPOExample();
        noteListPOExample.setOrderByClause("create_time ASC");
        noteListPOExample.createCriteria().andNoteIdIn(noteIds).andTypeIdEqualTo(typeId);
        List<NoteListPO> noteListPOS = noteListPOMapper.selectByExample(noteListPOExample);
        return noteListPOS;
    }
//单纯目录查找

    /**
     * 根据用户笔记ids和目录id找笔记列表并根据类型id降序
     *
     * @param noteIds   笔记ids
     * @param catalogId 目录id
     * @return
     */
    public List<NoteListPO> getNoteListPOSByNoteIdInAndCatalogIdAndTypeIdDESC(List<Long> noteIds, Long catalogId) {
        NoteListPOExample noteListPOExample = new NoteListPOExample();
        noteListPOExample.setOrderByClause("type_id DESC");
        noteListPOExample.createCriteria().andNoteIdIn(noteIds).andCatalogIdEqualTo(catalogId);
        List<NoteListPO> noteListPOS = noteListPOMapper.selectByExample(noteListPOExample);
        return noteListPOS;
    }

    /**
     * 根据用户笔记ids和目录id找笔记列表并根据类型id升序
     *
     * @param noteIds   笔记id
     * @param catalogId 目录id
     * @return
     */
    public List<NoteListPO> getNoteListPOSByNoteIdInAndCatalogIdAndTypeIdASC(List<Long> noteIds, Long catalogId) {
        NoteListPOExample noteListPOExample = new NoteListPOExample();
        noteListPOExample.setOrderByClause("type_id ASC");
        noteListPOExample.createCriteria().andNoteIdIn(noteIds).andCatalogIdEqualTo(catalogId);
        List<NoteListPO> noteListPOS = noteListPOMapper.selectByExample(noteListPOExample);
        return noteListPOS;
    }

    /**
     * 根据用户笔记ids和目录id找笔记列表并根据状态id降序
     *
     * @param noteIds   笔记ids
     * @param catalogId 目录id
     * @return
     */
    public List<NoteListPO> getNoteListPOSByNoteIdInAndCatalogIdAndStatusIdDESC(List<Long> noteIds, Long catalogId) {
        NoteListPOExample noteListPOExample = new NoteListPOExample();
        noteListPOExample.setOrderByClause("status_id DESC");
        noteListPOExample.createCriteria().andNoteIdIn(noteIds).andCatalogIdEqualTo(catalogId);
        List<NoteListPO> noteListPOS = noteListPOMapper.selectByExample(noteListPOExample);
        return noteListPOS;
    }

    /**
     * 根据用户笔记ids和目录id找笔记列表并根据状态id升序
     *
     * @param noteIds   笔记id
     * @param catalogId 目录id
     * @return
     */
    public List<NoteListPO> getNoteListPOSByNoteIdInAndCatalogIdAndStatusIdASC(List<Long> noteIds, Long catalogId) {
        NoteListPOExample noteListPOExample = new NoteListPOExample();
        noteListPOExample.setOrderByClause("status_id ASC");
        noteListPOExample.createCriteria().andNoteIdIn(noteIds).andCatalogIdEqualTo(catalogId);
        List<NoteListPO> noteListPOS = noteListPOMapper.selectByExample(noteListPOExample);
        return noteListPOS;
    }

    /**
     * 根据用户笔记ids和目录id找笔记列表并根据创建时间id降序
     *
     * @param noteIds   笔记ids
     * @param catalogId 目录id
     * @return
     */
    public List<NoteListPO> getNoteListPOSByNoteIdInAndCatalogIdAndCreateTimeDESC(List<Long> noteIds, Long catalogId) {
        NoteListPOExample noteListPOExample = new NoteListPOExample();
        noteListPOExample.setOrderByClause("create_time DESC");
        noteListPOExample.createCriteria().andNoteIdIn(noteIds).andCatalogIdEqualTo(catalogId);
        List<NoteListPO> noteListPOS = noteListPOMapper.selectByExample(noteListPOExample);
        return noteListPOS;
    }

    /**
     * 根据用户笔记ids和目录id找笔记列表并根据创建时间id升序
     *
     * @param noteIds   笔记id
     * @param catalogId 目录id
     * @return
     */
    public List<NoteListPO> getNoteListPOSByNoteIdInAndCatalogIdAndCreateTimeASC(List<Long> noteIds, Long catalogId) {
        NoteListPOExample noteListPOExample = new NoteListPOExample();
        noteListPOExample.setOrderByClause("create_time ASC");
        noteListPOExample.createCriteria().andNoteIdIn(noteIds).andCatalogIdEqualTo(catalogId);
        List<NoteListPO> noteListPOS = noteListPOMapper.selectByExample(noteListPOExample);
        return noteListPOS;
    }
    //目录id不存在，类型id不存在和是否收藏不存在

    /**
     * 根据用户笔记ids找笔记列表并根据类型id降序
     *
     * @param noteIds 笔记ids
     * @return
     */
    public List<NoteListPO> getNoteListPOSByNoteIdInAndTypeIdDESC(List<Long> noteIds) {
        NoteListPOExample noteListPOExample = new NoteListPOExample();
        noteListPOExample.setOrderByClause("type_id DESC");
        noteListPOExample.createCriteria().andNoteIdIn(noteIds);
        List<NoteListPO> noteListPOS = noteListPOMapper.selectByExample(noteListPOExample);
        return noteListPOS;
    }

    /**
     * 根据用户笔记ids找笔记列表并根据类型id升序
     *
     * @param noteIds 笔记id
     * @return
     */
    public List<NoteListPO> getNoteListPOSByNoteIdInAndTypeIdASC(List<Long> noteIds) {
        NoteListPOExample noteListPOExample = new NoteListPOExample();
        noteListPOExample.setOrderByClause("type_id ASC");
        noteListPOExample.createCriteria().andNoteIdIn(noteIds);
        List<NoteListPO> noteListPOS = noteListPOMapper.selectByExample(noteListPOExample);
        return noteListPOS;
    }

    /**
     * 根据用户笔记ids找笔记列表并根据状态id降序
     *
     * @param noteIds 笔记ids
     * @return
     */
    public List<NoteListPO> getNoteListPOSByNoteIdInAndStatusIdDESC(List<Long> noteIds) {
        NoteListPOExample noteListPOExample = new NoteListPOExample();
        noteListPOExample.setOrderByClause("status_id DESC");
        noteListPOExample.createCriteria().andNoteIdIn(noteIds);
        List<NoteListPO> noteListPOS = noteListPOMapper.selectByExample(noteListPOExample);
        return noteListPOS;
    }

    /**
     * 根据用户笔记ids找笔记列表并根据状态id升序
     *
     * @param noteIds 笔记id
     * @return
     */
    public List<NoteListPO> getNoteListPOSByNoteIdInAndStatusIdASC(List<Long> noteIds) {
        NoteListPOExample noteListPOExample = new NoteListPOExample();
        noteListPOExample.setOrderByClause("status_id ASC");
        noteListPOExample.createCriteria().andNoteIdIn(noteIds);
        List<NoteListPO> noteListPOS = noteListPOMapper.selectByExample(noteListPOExample);
        return noteListPOS;
    }

    /**
     * 根据用户笔记ids找笔记列表并根据创建时间id降序
     *
     * @param noteIds 笔记ids
     * @return
     */
    public List<NoteListPO> getNoteListPOSByNoteIdInAndCreateTimeDESC(List<Long> noteIds) {
        NoteListPOExample noteListPOExample = new NoteListPOExample();
        noteListPOExample.setOrderByClause("create_time DESC");
        noteListPOExample.createCriteria().andNoteIdIn(noteIds);
        List<NoteListPO> noteListPOS = noteListPOMapper.selectByExample(noteListPOExample);
        return noteListPOS;
    }

    /**
     * 根据用户笔记ids找笔记列表并根据创建时间id升序
     *
     * @param noteIds 笔记id
     * @return
     */
    public List<NoteListPO> getNoteListPOSByNoteIdInAndCreateTimeASC(List<Long> noteIds) {
        NoteListPOExample noteListPOExample = new NoteListPOExample();
        noteListPOExample.setOrderByClause("create_time ASC");
        noteListPOExample.createCriteria().andNoteIdIn(noteIds);
        List<NoteListPO> noteListPOS = noteListPOMapper.selectByExample(noteListPOExample);
        return noteListPOS;
    }


    /**
     * 根据状态名和类型名模糊查询（前提用户的笔记）（全部文件进行模糊查询）
     *
     * @param baseKey
     * @param noteIds
     * @return
     */
    public List<NoteListPO> getNoteListPOSByNoteIdInAndStatusInOrTypeId(String baseKey, List<Long> noteIds) {
        List<Long> statusIds = statusServiceV2.getStatusPOIdListByStatusNameLike(baseKey);
        List<Long> typeIds = typeServiceV2.getTypePOIdByTypeNameLike(baseKey);
        NoteListPOExample noteListPOExample = new NoteListPOExample();
        if (typeIds.size() > 0) {
            noteListPOExample.createCriteria().andNoteIdIn(noteIds).andTypeIdIn(typeIds);
        }
        if (statusIds.size() > 0) {
            noteListPOExample.createCriteria().andNoteIdIn(noteIds).andStatusIdIn(statusIds);
        }
        List<NoteListPO> noteListPOS = noteListPOMapper.selectByExample(noteListPOExample);
        return noteListPOS;
    }

    /**
     * 根据状态名和类型名模糊查询（前提用户的笔记和目录id）（意思就是在目录里进行模糊查询）
     *
     * @param baseKey
     * @param noteIds   笔记ids
     * @param catalogId 目录id
     * @return
     */
    public List<NoteListPO> getNoteListPOSByNoteIdInAndCatalogIdAndStatusInOrTypeId(String baseKey, List<Long> noteIds, Long catalogId) {
        List<Long> statusIds = statusServiceV2.getStatusPOIdListByStatusNameLike(baseKey);
        List<Long> typeIds = typeServiceV2.getTypePOIdByTypeNameLike(baseKey);
        NoteListPOExample noteListPOExample = new NoteListPOExample();
        if (typeIds.size() > 0) {
            noteListPOExample.createCriteria().andNoteIdIn(noteIds).andTypeIdIn(typeIds).andCatalogIdEqualTo(catalogId);
        }
        if (statusIds.size() > 0) {
            noteListPOExample.createCriteria().andNoteIdIn(noteIds).andStatusIdIn(statusIds).andCatalogIdEqualTo(catalogId);
        }
        List<NoteListPO> noteListPOS = noteListPOMapper.selectByExample(noteListPOExample);
        return noteListPOS;
    }

    //======================

    /**
     * 根据笔记id找笔记
     *
     * @param noteId 笔记id
     * @return
     */
    public NoteListPO getNoteListPOByNoteId(Long noteId) {
        NoteListPO noteListPO = noteListPOMapper.selectByPrimaryKey(noteId);
        return noteListPO;
    }

    /**
     * 更新或插入
     *
     * @param noteListPO 笔记信息
     * @param noteListId 笔记ID
     * @return
     */
    public NoteListPO insertOrUpdateNoteListPOBy(NoteListPO noteListPO, Long noteListId) {
        if (noteListId > 0) {
            noteListPOMapper.updateByPrimaryKeySelective(noteListPO);
        } else {
            noteListPOMapper.insertSelective(noteListPO);
        }
        return noteListPO;
    }

    /**
     * 根据笔记ID删除笔记
     *
     * @param noteId
     */
    public void deleteNoteListPOByNoteListPOId(Long noteId) {
        noteListPOMapper.deleteByPrimaryKey(noteId);
    }

    /**
     * 更新是否收藏
     *
     * @param isCollected 是否收藏
     * @param noteId      笔记ID
     * @return
     */
    public Integer updateCollected(Long isCollected, Long noteId) {
        NoteListPO noteListPO = new NoteListPO();
        noteListPO.setNoteId(noteId);
        noteListPO.setIsCollected(isCollected);
        Integer rows = noteListPOMapper.updateByPrimaryKeySelective(noteListPO);
        return rows;
    }
}
