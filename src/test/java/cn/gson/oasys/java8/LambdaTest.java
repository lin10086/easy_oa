package cn.gson.oasys.java8;

import cn.gson.oasys.lambda.FilterUserByUserAge;
import cn.gson.oasys.lambda.FilterUserByUserSalary;
import cn.gson.oasys.lambda.MyUserInterface;
import cn.gson.oasys.lambda.User;
import org.junit.Test;

import java.util.*;

public class LambdaTest {
    //原来的匿名内部类
    @Test
    public void test1() {
        Comparator<Integer> comparator = new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return Integer.compare(o1, o2);
            }
        };
        TreeSet<Integer> trr = new TreeSet<>(comparator);
    }

    //lambda表达式
    @Test
    public void test2() {
        Comparator<Integer> comparator = (x, y) -> Integer.compare(x, y);
        TreeSet<Integer> treeSet = new TreeSet<>(comparator);
    }

    //员工集合
    List<User> userList = Arrays.asList(
            new User("张三", 38, 380.99),
            new User("李四", 48, 4800.99),
            new User("王五", 58, 5890.99),
            new User("赵六", 68, 6890.99),
            new User("田七", 78, 7890.99)

    );

    //老方式
    //过滤年龄>35的员工信息
    public List<User> filterUserAge(List<User> userList) {
        List<User> users = new ArrayList<>();
        for (User user : userList) {
            if (user.getAge() > 55) {
                users.add(user);
            }
        }
        return users;
    }

    //员工工资>5000的员工信息
    public List<User> filterUserSalary(List<User> userList) {
        List<User> users = new ArrayList<>();
        for (User user : userList) {
            if (user.getSalary() > 5000) {
                users.add(user);
            }
        }
        return users;
    }

    @Test
    public void test3() {
        List<User> users = filterUserAge(userList);
        for (User user : users) {
            System.err.println(user);
        }
    }

    @Test
    public void test4() {
        List<User> users = filterUserSalary(userList);
        for (User user : users) {
            System.err.println(user);
        }
    }

    //    优化一：策略设计模式
    public List<User> filterUser(List<User> userList, MyUserInterface<User> userMyUserInterface) {
        List<User> users = new ArrayList<>();
        for (User user : userList) {
            if (userMyUserInterface.test(user)) {
                users.add(user);
            }
        }
        return users;
    }

    @Test
    public void test5() {
        List<User> users = filterUser(userList, new FilterUserByUserAge());
        for (User user : users) {
            System.err.println(user);
        }
        System.err.println("------------------");
        List<User> users1 = filterUser(userList, new FilterUserByUserSalary());
        for (User user : users1) {
            System.err.println(user);
        }
    }

    //    优化二
    @Test
    public void test6() {
        List<User> users = filterUser(userList, new MyUserInterface<User>() {
            @Override
            public boolean test(User user) {
                return user.getSalary() > 5000;
            }
        });
        for (User user : users) {
            System.err.println(user);
        }
    }

    //    优化三：lambda
    @Test
    public void test7() {
        List<User> users = filterUser(userList, (e) -> e.getSalary() > 5000);
        users.forEach(System.err::println);
    }

    //    优化方式四 stream API
    @Test
    public void test8() {
        userList.stream()
                // 过滤规则
                .filter((e) -> e.getSalary() > 5000)
                //只取前两条
                .limit(2)
                //遍历
                .forEach(System.err::println);
        userList.stream()
                //获取userList中的用户名
                .map(User::getName)
                // 遍历
                .forEach(System.err::println);
    }

}
