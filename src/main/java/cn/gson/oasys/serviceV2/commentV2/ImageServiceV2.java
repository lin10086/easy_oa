package cn.gson.oasys.serviceV2.commentV2;

import org.springframework.stereotype.Service;
import org.springframework.util.ResourceUtils;

import javax.annotation.PostConstruct;
import java.io.IOException;

@Service
public class ImageServiceV2 {

    private String rootpath;

    @PostConstruct
    public void UserpanelController() {
        try {
            rootpath = ResourceUtils.getURL("classpath:").getPath().replace("/target/classes/", "/src/main/resources/attachment");
        } catch (IOException e) {
            System.out.println("获取项目路径异常");
        }
    }

}
