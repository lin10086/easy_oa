package cn.gson.oasys.java8;

import cn.gson.oasys.lambda.User;
import org.junit.Test;

import java.io.PrintStream;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.function.BiPredicate;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;

public class TestMethod {
    //lambda体中已经有方法的实现了，可以使用"方法引用"

    //lambda体重调用的方法参数和返回值类型要与接口中抽象方法的函数函数列表和返回值类型一致

    /**
     * 对象::实例方法名
     */
    @Test
    public void test1() {
        Consumer<String> consumer = (x) -> System.err.println(x);
        PrintStream ps = System.err;
        Consumer<String> consumer1 = System.err::println;
        consumer1.accept("akskdj");
    }

    @Test
    public void test2() {
        User user = new User();
        Supplier<String> stringSupplier = () -> user.getName();
        String str = stringSupplier.get();
        System.out.println(str);
        Supplier<Integer> integerSupplier = user::getAge;
        Integer i = integerSupplier.get();
        System.out.println(i);
    }

    /**
     * 类::静态方法名
     */
    @Test
    public void test3() {
        Comparator<Integer> comparator1 = (x, y) -> Integer.compare(x, y);
        Comparator<Integer> comparator2 = Integer::compare;
    }

    /**
     * 类::实例方法名
     * 若lambda参数列表中的第一个参数是方法的调用者，第二个参数是实例方法的参数时，可以使用ClassName::method
     */
    @Test
    public void test4() {
        BiPredicate<String, String> bp = (x, y) -> x.equals(y);
        BiPredicate<String, String> bp2 = String::equals;
    }

    //构造器引用
    //需要调用的构造器参数列表要和函数式接口中的抽象方法的参数列表一致
    @Test
    public void test5() {
        Supplier<User> userSupplier = () -> new User();
        Supplier<User> userSupplier1 = User::new;

        User user = userSupplier.get();
        System.out.println(user);
    }

    @Test
    public void test6() {
        Function<Integer, User> fun = (x) -> new User(x);
        User user = fun.apply(100);
        System.out.println(user);
        Function<Integer, User> fun2 = User::new;
        User user2 = fun2.apply(200);
        System.out.println(user2);

    }

    //数组的引用
    @Test
    public void test7() {
        Function<Integer, String[]> fun = (x) -> new String[x];
        String[] strs = fun.apply(10);
        System.err.println(strs.length);
        Function<Integer, String[]> fun2 = String[]::new;
        String[] strs2 = fun2.apply(20);
        System.err.println(strs2.length);
    }

}
