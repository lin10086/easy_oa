package cn.gson.oasys.java8;

import cn.gson.oasys.lambda.Trader;
import cn.gson.oasys.lambda.Transaction;
import cn.gson.oasys.lambda.User;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class TestStreamAPI4 {
    @Test
    public void test() {
        Integer[] nums = {1, 2, 3, 4, 5};
        Arrays.stream(nums)
                .map(e -> e * e)
                .forEach(System.err::println);
    }

    @Test
    public void test2() {
        List<User> userList = Arrays.asList(
                new User("张三", 30, 380.99, User.Status.BUSY),
                new User("李四", 48, 4800.99, User.Status.FREE),
                new User("王五", 58, 5890.99, User.Status.BUSY),
                new User("赵六", 68, 6890.99, User.Status.VOCATION),
                new User("田七", 78, 7890.99, User.Status.FREE)
        );
        Optional<Integer> op = userList.stream()
                .map(e -> 1)
                .reduce(Integer::sum);
        System.err.println(op.get());
    }

    List<Transaction> transactions = null;

    @Before
    public void before() {
        Trader raoul = new Trader("Raoul", "Cambridge");
        Trader mario = new Trader("Mario", "Milan");
        Trader alan = new Trader("Alan", "Cambridge");
        Trader brian = new Trader("Brian", "Cambridge");
        transactions = Arrays.asList(
                new Transaction(brian, 2011, 300),
                new Transaction(raoul, 2012, 1000),
                new Transaction(raoul, 2011, 400),
                new Transaction(mario, 2012, 710),
                new Transaction(alan, 2012, 950)
        );
    }

    //1.找出2011年发生的左右交易
//2.交易员都在哪些不同的城市工作过
//3.查出所有来自剑桥的交易员，并按姓名排序
//4.返回所有交易员的名字字符串
//5.有没有交易员实在米兰工作过的
//6.打印生活在剑桥的交易员的所有交易额
//7.所有交易中，最高的交易额是多少
//8.找到交易额最小的交易

}
