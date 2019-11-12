package cn.gson.oasys.path;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.util.ClassUtils;
import org.springframework.util.ResourceUtils;

import java.io.File;

@Slf4j
@RunWith(SpringRunner.class)
@SpringBootTest
public class PathTest {



    @Test
    public void path() throws  Exception{
        String str =System.getProperty("user.dir");//获取项目路径
        log.info("str={}",str);
        File file1 = new File(str,"/resources/attachment");
        String str1 = file1.getPath();
        log.info("str1={}",str1);
        String path = ResourceUtils.getURL("classpath:").getPath();
        log.info("path={}",path);
        String rootPath =path.replace("/target/classes/","/resources/attachment");
        log.info("rootPath={}",rootPath);
//        String path2 = ClassUtils.getDefaultClassLoader().getResource("").getPath();
//        log.info("path={}",path2);
        File file = new File(path,"static/images");
        String filePath =file.getPath();
        log.info("filePath={}",filePath);
        String filePath1 = file.getAbsolutePath();
        log.info("filePath1={}",filePath1);
//        String path1 = ResourceUtils.getURL("templates").getPath();
        String rootpath1 = ResourceUtils.getURL("classpath:").getPath().replace("/target/classes/", "resources/attachment");

        log.info("rootpath1={}",rootpath1);

    }
    @Test
    public void String(){
        String str ="sjknfdzjvna";
        String str1 =str.replace("z","");
        log.info("str1={}",str1);
    }
}
