package cn.gson.oasys.lambda;
@FunctionalInterface
public interface MyUserInterface<T> {
    boolean test(T t);
}
