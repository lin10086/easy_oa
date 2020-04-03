package cn.gson.oasys.java8;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

/**
 * 四大内置函数核心函数式接口
 */
public class LambdaTest3 {
    public void happy(Double money, Consumer<Double> consumer) {
        consumer.accept(money);
    }

    /**
     * Consumer<T> consumer:消费型接口，无返回值
     */
    @Test
    public void test1() {
        happy(10000.0, m -> System.err.println("消费了" + m + "元"));
    }

    //需求：生产指定个数的整数放入集合中
    public List<Integer> getNumList(int num, Supplier<Integer> supplier) {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < num; i++) {
            Integer n = supplier.get();
            list.add(n);
        }
        return list;
    }

    /**
     * Supplier<T>供给型接口
     */
    @Test
    public void test2() {
        List<Integer> integerList = getNumList(10, () -> (int) (Math.random() * 100));
        for (Integer i : integerList) {
            System.err.println(i);
        }
    }

    //    用于处理字符串
    public String strHandle(String str, Function<String, String> function) {
        return function.apply(str);
    }

    /**
     * Function<T,R>函数型接口 T参数类型R返回值类型
     */
    @Test
    public void test3() {
        String str = strHandle("shfaih", (s) -> s.toUpperCase());
        System.err.println(str);
    }

    //将满足条件的字符串放入集合中
    public List<String> filterStr(List<String> list, Predicate<String> predicate) {
        List<String> stringList = new ArrayList<>();
        for (String str : list) {
            if (predicate.test(str)) {
                stringList.add(str);
            }
        }
        return stringList;
    }

    /**
     * Predicate<T>:断言型接口
     */
    @Test
    public void test4() {
        List<String> stringList = Arrays.asList("Hello", "world", "ok", "akhkvb", "sajhfish");
        List<String> strList = filterStr(stringList, (s) -> s.length() > 3);
        for (String str : strList) {
            System.err.println(str);
        }
    }
}
