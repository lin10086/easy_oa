package cn.gson.oasys.java8;

import cn.gson.oasys.lambda.User;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class TestStreamAPI1 {
    /**
     * 创建Stream
     */
    @Test
    public void test1() {
//        1.通过collection集合的stream或parallelStream()
        List<String> list = new ArrayList<>();
        Stream<String> stringStream = list.stream();
//        2.通过Arrays的静态方法
        User[] user = new User[10];
        Stream<User> userStream = Arrays.stream(user);
        System.err.println(userStream);
//        3.通过stream类的静态of方法
        Stream<String> stringStream1 = Stream.of("a", "d", "f", "r");
//        4.创建无限流
        Stream<Integer> integerStream = Stream.iterate(0, x -> x + 2);
        integerStream.limit(10).forEach(System.err::println);
        //生成无限流
        Stream.generate(() -> Math.random())
                .forEach(System.err::println);

    }
}
