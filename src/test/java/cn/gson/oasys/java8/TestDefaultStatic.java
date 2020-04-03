package cn.gson.oasys.java8;

import cn.gson.oasys.lambda.DefaultStatic;
import org.junit.Test;

public class TestDefaultStatic {

    @Test
    public void test1() {
        DefaultStatic defaultStatic = new DefaultStatic();
        System.err.println(defaultStatic.getName());
    }
}
