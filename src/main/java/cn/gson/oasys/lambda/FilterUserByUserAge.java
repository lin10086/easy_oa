package cn.gson.oasys.lambda;

public class FilterUserByUserAge implements MyUserInterface<User> {
    @Override
    public boolean test(User user) {
        return user.getAge() > 55;
    }
}
