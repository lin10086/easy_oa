package cn.gson.oasys;

import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.File;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.HashMap;
import java.util.Map;

@Slf4j
@SpringBootTest
@RunWith(SpringRunner.class)
public class freemarker {

//    @Test
//    public void testFreeMarker() throws Exception {
//        //创建freemarker实例
//        Configuration configuration = new Configuration();
//        configuration.setDirectoryForTemplateLoading(new File("/src/main/resources/templates"));
//        //创建数据模型
//        Map map = new HashMap();
//        map.put("user","HelloWord");
//
//        Template template = configuration.getTemplate("a.ftl");
//        Writer out =new OutputStreamWriter(System.out);
//        template.process(map,out);
//
//        out.close();
//
//    }

    @Test
    public void pathTest(){


    }
}
