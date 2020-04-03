package cn.gson.oasys.java8;

import org.junit.Test;

import java.time.Duration;
import java.time.Instant;
import java.util.stream.LongStream;

public class TestForkJion {
    @Test
    public void test1() {
        Instant start = Instant.now();
        Long sum = 0L;
        for (Long i = 0L; i <= 100000000000L; i++) {
            sum += i;
        }
        Instant end = Instant.now();
        System.err.println(sum);
        System.err.println(Duration.between(start, end).toMillis());


    }

    @Test
    public void test2() {
        Instant start = Instant.now();
        Long sum = LongStream.rangeClosed(0, 100L)
                .parallel()
                .reduce(0, Long::sum);
        System.err.println(sum);
        Instant end = Instant.now();
        System.err.println(Duration.between(start, end).toMillis());
    }
}
