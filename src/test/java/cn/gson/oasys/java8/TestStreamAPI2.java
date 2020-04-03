package cn.gson.oasys.java8;

import cn.gson.oasys.lambda.User;
import org.junit.Test;

import java.util.*;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.stream.Stream;

public class TestStreamAPI2 {
    List<User> userList = Arrays.asList(
            new User("张三", 38, 380.99),
            new User("李四", 48, 4800.99),
            new User("王五", 58, 5890.99),
            new User("赵六", 68, 6890.99),
            new User("田七", 78, 7890.99),
            new User("田七", 78, 7890.99),
            new User("田七", 78, 7890.99)
    );

    /**
     * 筛选与切片
     * 1.filter接收lambda，从流中排除某些元素
     * 2.limit截断流，使其不超过给定个数
     * 3.skip(n)，跳过元素，返回扔掉前n个元素的流，如果元素不足n个返回空流，与limit(n)互补。
     * 4.distanct帅选，通过流所产生元素的hashCode()和equals()去除重复元素。
     */
    @Test
    public void test() {

        //中间操作不会执行任何的处理
        //内部迭代《内部操作有Stream API完成
        Stream stream = userList.stream()
                .filter(t -> t.getAge() > 50);
//       终止操作：一次性执行全部内容，惰性求值
        stream.forEach(System.err::println);

    }

    //外部迭代
    @Test
    public void test2() {
        Iterator iterator = userList.iterator();
        while (iterator.hasNext()) {
            System.err.println(iterator.next());
        }
    }

    //limit找到满足条件后不再迭代，相当于短路
    @Test
    public void test3() {
        userList.stream()
                .filter(t -> t.getAge() > 40)
                .limit(2)
                .forEach(System.err::println);
    }

    //skip(n)与limit互补
    @Test
    public void test4() {
        userList.stream()
                .filter(t -> t.getAge() > 40)
                .skip(2)
                .forEach(System.err::println);
    }

    //distinct()必须从写hashCode和equals
    @Test
    public void test5() {
        userList.stream()
                .filter(t -> t.getAge() > 60)
                .distinct()
                .forEach(System.err::println);
    }

    /**
     * 映射
     * map：接收lambda将元素转换为其他元素或提取信息，接收一个函数作为参数，该参数会应用到每个元素上，并将其映射成一个新的元素.
     * flatMap-接收一个函数作为参数,将流中每个值都转换为另一个流，然后把所有流连接成一个流
     */
    @Test
    public void test6() {
        List<String> list = Arrays.asList("aa", "fsg", "ghbss", "svhbc");
        list.stream()
                .map(x -> x.toUpperCase())
                .forEach(System.err::println);
//        userList.stream()
//                .map(user -> user.getName())
//                .forEach(System.err::println);
//        userList.stream()
//                .map(User::getName)
//                .forEach(System.err::println);
        Stream<Stream<Character>> stream = list.stream()
                .map(TestStreamAPI2::filterCharacter);//{{a,a,a},{b,b,b},{h,m,m}}

        stream.forEach(sm ->
                sm.map(x -> x.toString().toUpperCase())
                        .forEach(System.err::print));
        System.err.println("----------------");
        list.stream()
                .flatMap(TestStreamAPI2::filterCharacter)//{a,a,a,b,b,b,h,m,m}
                .forEach(System.err::print);
    }

    public static Stream<Character> filterCharacter(String str) {
        List<Character> list = new ArrayList<>();
        for (Character ch : str.toCharArray()) {
            list.add(ch);
        }
        Stream stream = list.stream();
        return stream;
    }

    /**
     * add与addAll的区别
     */
    @Test
    public void test7() {
        List<String> list = Arrays.asList("aa", "fsg", "ghbss", "svhbc");
        List list1 = new ArrayList();
        list1.add(22);
        list1.add(44);
        list1.addAll(list);
        System.err.println(list1);
    }

    //排序
//    sorted()自然排序 Comparable
//    sorted(Comparator comparator)定制排序
    @Test
    public void test8() {
        List<String> list = Arrays.asList("asd", "svdzv", "svdz", "vd");
        list.stream().sorted().forEach(System.err::println);
        userList.stream()
                .sorted((e1, e2) -> {
                    if (e1.getAge().equals(e2.getAge())) {
                        return e1.getName().compareTo(e2.getName());
                    } else {
                        return -e1.getAge().compareTo(e2.getAge());
                    }
                }).forEach(System.err::println);
    }
}
