package cn.gson.oasys.lambda;

public class FilterUserByUserSalary implements MyUserInterface<User> {
    @Override
    public boolean test(User user) {
        return user.getSalary() > 5000;
    }
}
