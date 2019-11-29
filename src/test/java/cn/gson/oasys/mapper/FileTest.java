package cn.gson.oasys.mapper;

import cn.gson.oasys.mappers.FileListPOMapper;
import cn.gson.oasys.model.po.FileListPO;
import cn.gson.oasys.model.po.FileListPOExample;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.util.List;

@Slf4j
@SpringBootTest
@RunWith(SpringRunner.class)
public class FileTest {
    @Resource
    private FileListPOMapper fileListPOMapper;

    @Test
    public void getDocument() {
        FileListPOExample fileListPOExample = new FileListPOExample();
        fileListPOExample.createCriteria().andFileUserIdEqualTo(5L).andFileIstrashEqualTo(0L)
                .andContentTypeNotLike("image/%").andContentTypeNotLike("application/x%")
                .andContentTypeNotLike("video/%").andContentTypeNotLike("audio/%");
        List<FileListPO> fileListPOS = fileListPOMapper.selectByExample(fileListPOExample);
        log.info("fileListPOS={}", fileListPOS);
    }
}
