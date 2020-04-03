package cn.gson.oasys.java8;

import cn.gson.oasys.lambda.MyFun;
import org.junit.Test;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Consumer;

public class LambdaTest2 {
//    lamnda表达式基础语法：新的操作符 -> , 成为箭头操作符或lambda操作符；
//    将表达式分为两部分：
//    左侧lambda的参数列表
//    右侧lambda表达式所执行的功能，即lambda体

    /**
     * 语法一：无参数无返回值
     */
    @Test
    public void test1() {
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                System.err.println("Hello World");
            }
        };
        runnable.run();
//        Thread thread = new Thread(runnable);
//        thread.start();
        Runnable runnable1 = () -> System.err.println("Hello Lambda");
        runnable1.run();
    }

    /**
     * 语法二：有一个参数无返回值
     * (x) -> System.err.println(x);
     */
    @Test
    public void test2() {
        Consumer<String> consumer = (x) -> System.err.println(x);
        consumer.accept("我是linsuoting");
    }

    /**
     * 有一个参数(小括号可以不写）无返回值
     */
    @Test
    public void test3() {
        Consumer<String> consumer = x -> System.err.println(x);
        consumer.accept("我是linsuoting");
    }

    /**
     * 语法二：有两个参数，有返回值,有多条语句
     */
    @Test
    public void test4() {
        Comparator<Integer> comparator = (x, y) -> {
            System.err.println("函数式接口");
            return Integer.compare(x, y);
        };

    }

    /*
     * 有两个参数，有返回值,只有一条语句,return和{}都可以不写
     */
    @Test
    public void test5() {
        Comparator<Integer> comparator = (x, y) -> Integer.compare(x, y);
    }

    /**
     * 六：lambda表达式中的参数列表里的参数类型可以不写，因为JVM通过上下文推断
     */
    @Test
    public void test8() {
        Comparator<Integer> comparator = (Integer x, Integer y) -> Integer.compare(x, y);
    }

    @Test
    public void test6() {
//        String[] str ;
//        str={"a","b","c"}
        show(new HashMap<>());

    }

    public void show(Map<String, String> map) {

    }

    @Test
    public void test7() {
//        Integer num = operation(100, (x) -> x * x);
//        System.err.println(num);
    }

//    public Integer operation(Integer num, MyFun myFun) {
//        return myFun.intValue(num);
//    }
}
