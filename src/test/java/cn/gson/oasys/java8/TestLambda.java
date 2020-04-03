package cn.gson.oasys.java8;

import cn.gson.oasys.lambda.MyFun;
import cn.gson.oasys.lambda.MyInterface;
import cn.gson.oasys.lambda.User;
import org.junit.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class TestLambda {
    List<User> userList = Arrays.asList(
            new User("张三", 38, 380.99),
            new User("李四", 48, 4800.99),
            new User("王五", 58, 5890.99),
            new User("赵六", 68, 6890.99),
            new User("田七", 78, 7890.99)
    );

    /**
     * 先根据年龄比在根据姓名比
     */
    @Test
    public void test1() {
        Collections.sort(userList, (x, y) -> {
            if (x.getAge() == y.getAge()) {
                return x.getName().compareTo(y.getName());
            } else {
                return -Integer.compare(x.getAge(), y.getAge());
            }
        });
        for (User user : userList) {
            System.err.println(user);
        }
    }

    @Test
    public void strUp() {
//        String str = "aksnksjn";
//        String strUP = strHandle(str, new MyInterface() {
//            @Override
//            public String getValue(String str) {
//                return str.toUpperCase();
//            }
//        });
        //转换大写
        String strUP = strHandle("aksnksjn", (str) -> str.toUpperCase());
        System.err.println(strUP);
        //截取第二个到第四个子字符串
        String subStr = strHandle("aksnksjn", str -> str.substring(2, 5));
        System.err.println(subStr);
    }

    /**
     * 用于处理字符串
     *
     * @param str         字符串
     * @param myInterface 处理字符串的规则
     * @return
     */
    public String strHandle(String str, MyInterface myInterface) {
        return myInterface.getValue(str);
    }

    /**
     * 对两个Long进行处理
     *
     * @param l1
     * @param l2
     * @param myFun
     * @return
     */
    public void longHandle(Long l1, Long l2, MyFun<Long, Long> myFun) {
        System.err.println(myFun.getValue(l1, l2));
    }

    @Test
    public void test() {
        longHandle(100L, 200L, (x, y) -> x + y);
        longHandle(100L, 200L, (x, y) -> x * y);
    }

}
