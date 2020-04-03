package cn.gson.oasys.lambda;

@FunctionalInterface
public interface MyFun<T, R> {
    R getValue(T t, R r);
}
