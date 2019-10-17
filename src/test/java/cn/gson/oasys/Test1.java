package cn.gson.oasys;

import java.text.SimpleDateFormat;
import java.util.*;
import java.util.logging.SimpleFormatter;


import eu.bitwalker.useragentutils.Browser;
import eu.bitwalker.useragentutils.OperatingSystem;
import eu.bitwalker.useragentutils.UserAgent;
import eu.bitwalker.useragentutils.Version;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpRequest;
import org.springframework.test.context.junit4.SpringRunner;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.github.stuxuhai.jpinyin.PinyinException;
import com.github.stuxuhai.jpinyin.PinyinFormat;
import com.github.stuxuhai.jpinyin.PinyinHelper;

import cn.gson.oasys.mappers.NoticeMapper;
import cn.gson.oasys.model.dao.attendcedao.AttendceService;
import cn.gson.oasys.model.dao.processdao.NotepaperDao;
import cn.gson.oasys.model.dao.user.UserDao;

import javax.servlet.http.HttpServletRequest;

@Slf4j
@SpringBootTest
@RunWith(SpringRunner.class)
public class Test1 {
    @Autowired
    private NotepaperDao notepaperDao;

    @Autowired
    private NoticeMapper nm;

    @Autowired
    AttendceService attendceService;
    @Autowired
    UserDao uDao;

    @Test
    public void test() {
        PageHelper.startPage(0, 10);
        List<Map<String, Object>> list = nm.findMyNotice(1L);
        PageInfo<Map<String, Object>> info = new PageInfo<Map<String, Object>>(list);
        System.out.println(info);
    }

    @Test
    public void test2() {
        String str = "罗祥";
        try {
            System.out.println(PinyinHelper.convertToPinyinString(str, "", PinyinFormat.WITH_TONE_MARK));
            System.out.println(PinyinHelper.convertToPinyinString(str, "", PinyinFormat.WITH_TONE_NUMBER));
            System.out.println(PinyinHelper.convertToPinyinString(str, "", PinyinFormat.WITHOUT_TONE));
            System.out.println(PinyinHelper.getShortPinyin(str));
        } catch (PinyinException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    @Test
    public void tests() {

        Date date = new Date();
        log.info("date={}", date);
        Long time = date.getTime();
        log.info("time={}", time);

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("w");
        String str = simpleDateFormat.format(date);
        log.info("str={}", str);

    }

    @Test
    public void dateTest() {
        Date date = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        String str = simpleDateFormat.format(date);
        log.info("date={},str={}", date, str);

        Calendar calendar = Calendar.getInstance();
        int year = calendar.get(Calendar.YEAR);
        int month = calendar.get(Calendar.MONTH) + 1;
        int day = calendar.get(Calendar.DATE);
        log.info("year={},month={},day={}", year, month, day);

        Date time = calendar.getTime();
        log.info("time={}", time);
    }

    @Test
    public void dateTest01() {

        Date date = new Date();
        System.out.println(date.toString());
        log.info("date={}", date);
    }


    //把float转换为Sting类型
    @Test
    public void numberFoemat() {
//		float f=2000.0f;
//		String i = (int)f+"";
//		Float ff = 1000f;
//		String s = ff.intValue()+"";
//		log.info("s={}",s);
//		String s =
//		int i =Integer.parseInt((1000.1/1)+"");

        //把Boolean类型转换为Integer类型
//        Boolean b = true;
//        Integer i = b == false ? 0 : 1;
//        if(b==false){
//            i=0;
//        }else {
//            i=1;
//        }
//        log.info("i={}", i);
        //把false改为true

    }

    //User-Agent 信息
    @Test
    public void userAgent() {

//        String str = UserAgent.parseUserAgentString(request.getHeader("User-Agent"))
//        "Mozilla/5.0 (Macintosh; Intel Mac OS X 10_14_6) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/76.0.3809.132 Safari/537.36"
        UserAgent userAgent = UserAgent.parseUserAgentString("Mozilla/5.0 (Macintosh; Intel Mac OS X 10_14_6) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/76.0.3809.132 Safari/537.36");
        Browser browser = userAgent.getBrowser();
        OperatingSystem operatingSystem = userAgent.getOperatingSystem();
        log.info("browser={},operatingSystem={}", browser, operatingSystem);
        Version version = browser.getVersion("Mozilla/5.0 (Macintosh; Intel Mac OS X 10_14_6) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/76.0.3809.132 Safari/537.36");
        log.info("version={}", version);
        String browserName = browser.getName();
        String str = version.getVersion();
        log.info("browserName={},str={}" + browserName, str);
        OperatingSystem os = userAgent.getOperatingSystem();
        log.info("os={}", os);
    }

    @Test
    public void stringBuilder() {
        String str = "ABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";
        Random random = new Random();
        StringBuilder stringBuilder = new StringBuilder(5);
        for (int i = 0; i<5; i++){
            stringBuilder.append(str.charAt(random.nextInt(str.length()-1)));
        }
        log.info("stringBuilder={}",stringBuilder);
    }


}
