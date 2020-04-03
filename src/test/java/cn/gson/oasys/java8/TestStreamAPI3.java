package cn.gson.oasys.java8;

import cn.gson.oasys.lambda.User;
import cn.gson.oasys.lambda.User.Status;
import org.junit.Test;

import java.util.*;
import java.util.stream.Collectors;

public class TestStreamAPI3 {
    List<User> userList = Arrays.asList(
            new User("张三", 30, 380.99, Status.BUSY),
            new User("李四", 48, 4800.99, Status.FREE),
            new User("王五", 58, 5890.99, Status.BUSY),
            new User("赵六", 68, 6890.99, Status.VOCATION),
            new User("田七", 78, 7890.99, Status.FREE)
    );

    @Test
    public void test1() {
        //是否所有元素都是Status.BUSY
        Boolean b = userList.stream()
                .allMatch(e -> e.getStatus().equals(Status.BUSY));
        System.err.println(b);
        //检查至少有一个是Status.BUSY
        Boolean b1 = userList.stream()
                .anyMatch(e -> e.getStatus().equals(Status.BUSY));
        System.err.println(b1);
//        是不是没有Status.BUSY
        Boolean b2 = userList.stream()
                .noneMatch(e -> e.getStatus().equals(Status.BUSY));
        System.err.println(b2);
        //返回第一个元素
        Optional<User> op = userList.stream()
                .sorted((e1, e2) -> Double.compare(e1.getSalary(), e2.getSalary()))
                .findFirst();
        System.err.println(op.get());
        //返回流中任意元素
        Optional<User> op1 = userList.stream()
                .filter(e -> e.getStatus().equals(Status.BUSY))
                .findAny();
        System.err.println(op1.get());

    }

    @Test
    public void test2() {
        //流中的总数
        Long c = userList.stream()
                .count();
        System.err.println(c);
        //最大工资的用户
        Optional<User> op = userList.stream()
                .max((e1, e2) -> e1.getSalary().compareTo(e2.getSalary()));
        System.err.println(op.get());
        //最小的工资数
        Optional<Double> op2 = userList.stream()
                .map(User::getSalary)
                .min(Double::compareTo);
        System.err.println(op2.get());
    }

    @Test
    public void test3() {
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        Integer sum = list.stream()
                .reduce(0, (x, y) -> x + y);
        System.err.println(sum);
        //工资的总和
        Optional<Double> op = userList.stream()
                .map(User::getSalary)
                .reduce(Double::sum);
        System.err.println(op.get());
    }

    @Test
    public void test4() {
        List<String> list = userList.stream()
                .map(User::getName)
                .collect(Collectors.toList());
        list.forEach(System.err::println);
        System.err.println("--------------");
        Set<String> set = userList.stream()
                .map(User::getName)
                .collect(Collectors.toSet());
        set.forEach(System.err::println);
        System.err.println("---------------");
        HashSet hashSet = userList.stream()
                .map(User::getName)
                .collect(Collectors.toCollection(HashSet::new));
        hashSet.forEach(System.err::println);

    }

    @Test
    public void test5() {
        //总数
        Long count = userList.stream()
                .collect(Collectors.counting());
        System.err.println(count);
        Long count1 = userList.stream()
                .count();
        System.err.println(count1);
        //平均值工资
        Double avg = userList.stream()
                .collect(Collectors.averagingDouble(User::getSalary));
        System.err.println(avg);
        //总和工资
        Double sum = userList.stream()
                .collect(Collectors.summingDouble(User::getSalary));
        System.err.println(sum);
        //最大值工资用户
        Optional<User> max = userList.stream()
                .collect(Collectors.maxBy((e1, e2) -> Double.compare(e1.getSalary(), e2.getSalary())));
        System.err.println(max.get());
        //最小值工资
        Optional<Double> min = userList.stream()
                .map(User::getSalary)
                .collect(Collectors.minBy(Double::compare));
        System.err.println(min.get());
    }

    @Test
    public void test6() {
        //分组
        Map<Status, List<User>> statusListMap = userList.stream()
                .collect(Collectors.groupingBy(User::getStatus));
        System.err.print(statusListMap);
    }

    @Test
    public void test7() {
        //多级分组
        Map<Status, Map<String, List<User>>> mapMap = userList.stream()
                .collect(Collectors.groupingBy(User::getStatus, Collectors.groupingBy((e) -> {
                    if (e.getAge() < 30) {
                        return "青年";
                    } else if (e.getAge() < 50) {
                        return "中年";
                    } else {
                        return "老年";
                    }
                })));
        System.err.println(mapMap);
    }

    @Test
    public void test8() {
        //分区(根据满足条件和不满足条件进行分区
        Map<Boolean, List<User>> map = userList.stream()
                .collect(Collectors.partitioningBy((e) -> e.getSalary() > 5000));
        System.err.println(map);
    }

    @Test
    public void test9() {
        DoubleSummaryStatistics dss = userList.stream()
                .collect(Collectors.summarizingDouble(User::getSalary));
        System.err.println(dss.getCount());//工资个数
        System.err.println(dss.getAverage());//平均工资
        System.err.println(dss.toString());
        // DoubleSummaryStatistics{count=5, sum=25854.950000, min=380.990000, average=5170.990000, max=7890.990000}
        System.err.println(dss.getMax());//最大工资
        System.err.println(dss.getMin());//最小工资
        System.err.println(dss.getSum());//工资总和
    }

    @Test
    public void test10() {
        //用户名的拼接,
        String str = userList.stream()
                .map(User::getName)
                .collect(Collectors.joining());
        System.err.println(str);//张三李四王五赵六田七
        String str2 = userList.stream()
                .map(User::getName)
                .collect(Collectors.joining(","));
        System.err.println(str2);//张三,李四,王五,赵六,田七
        String str3 = userList.stream()
                .map(User::getName)
                .collect(Collectors.joining(",", "[", "]"));
        System.err.println(str3);//[张三,李四,王五,赵六,田七]
    }
}
