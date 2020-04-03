package cn.gson.oasys.java8;

import cn.gson.oasys.lambda.Trader;
import cn.gson.oasys.lambda.Transaction;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

public class TestTransaction {
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


    /**
     * 1.找出2011年发生的所有交易，并按交易额排序（从低到高）
     */
    @Test
    public void test1() {
        Stream<Transaction> transaction = transactions.stream()
                .filter(e -> e.getYear() == 2011)
                .sorted((e1, e2) -> Integer.compare(e1.getValue(), e2.getValue()));
        transaction.forEach(System.err::println);
    }

    /**
     * 2.交易员都在哪些不同的城市工作过
     */
    @Test
    public void test2() {
        Stream<String> list = transactions.stream()
                .map(t -> t.getTrader().getCity())
                .distinct();
        list.forEach(System.err::println);
    }

    /**
     * 3.查出所有来自剑桥的交易员，并按姓名排序
     */
    @Test
    public void test3() {
        transactions.stream()
                .filter(e -> e.getTrader().getCity().equals("Cambridge"))
                .map(Transaction::getTrader)
                .sorted((e1, e2) -> e1.getName().compareTo(e2.getName()))
                .distinct()
                .forEach(System.err::println);
    }

    /**
     * 4.返回所有交易员的名字字符串
     */
    @Test
    public void test4() {
        transactions.stream()
                .map(e -> e.getTrader().getName())
                .sorted()
                .forEach(System.err::print);
//                .collect(Collectors.joining());
//        System.err.println(str);
        System.err.println("---------");
        String str = transactions.stream()
                .map(e -> e.getTrader().getName())
                .sorted()
                .reduce("", String::concat);
        System.err.println(str);
        System.err.println("----------");
        transactions.stream()
                .map(e -> e.getTrader().getName())
                .flatMap(TestTransaction::characterStream)
                .sorted()
                .forEach(System.err::print);

    }

    public static Stream<Character> characterStream(String str) {
        List<Character> list = new ArrayList<>();
        for (Character ch : str.toCharArray()) {
            list.add(ch);
        }
        return list.stream();
    }

    /**
     * 5.有没有交易员实在米兰工作过的
     */
    @Test
    public void test5() {
        Boolean b = transactions.stream()
                .anyMatch(e -> e.getTrader().getCity().equals("Milan"));
        System.err.println(b);
    }

    /**
     * 6.打印生活在剑桥的交易员的所有交易额
     */
    @Test
    public void test6() {
        Optional<Integer> op = transactions.stream()
                .filter(e -> e.getTrader().getCity().equals("Cambridge"))
                .map(Transaction::getValue)
                .reduce(Integer::sum);
        System.err.println(op.get());
    }

    /**
     * 7.所有交易中，最高的交易额是多少
     */
    @Test
    public void test7() {
        Optional<Integer> op = transactions.stream()
                .map(Transaction::getValue)
                .max(Integer::compare);
        System.err.println(op.get());
    }

    /**
     * 8.找到交易额最小的交易
     */
    @Test
    public void test8() {
        Optional<Transaction> op = transactions.stream()
                .min((e1, e2) -> Integer.compare(e1.getValue(), e2.getValue()));
        System.err.println(op.get());
    }
}
