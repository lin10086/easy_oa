package cn.gson.oasys.ServiceV2.noteV2;

import cn.gson.oasys.mappers.NoteListPOMapper;
import cn.gson.oasys.model.po.NoteListPO;
import cn.gson.oasys.model.po.NoteListPOExample;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class NoteListPOServiceV2 {
    @Resource
    private NoteListPOMapper noteListPOMapper;

    /**
     * 根据笔记ids找笔记列表 并根据时间排序
     *
     * @param noteIds
     * @return
     */
    public List<NoteListPO> getNoteListPOSByNoteIdInAndCreateTimeDESC(List<Long> noteIds) {
        NoteListPOExample noteListPOExample = new NoteListPOExample();
        noteListPOExample.createCriteria().andNoteIdIn(noteIds);
        noteListPOExample.setOrderByClause("create_time DESC");
        List<NoteListPO> noteListPOS = noteListPOMapper.selectByExample(noteListPOExample);
        return noteListPOS;
    }


    /**
     * 根据笔记ids找笔记列表
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
}
