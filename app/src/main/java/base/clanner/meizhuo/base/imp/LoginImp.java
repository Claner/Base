package base.clanner.meizhuo.base.imp;


import base.clanner.meizhuo.base.entity.User;

/**
 * Created by Clanner on 2017/4/12.
 */

public interface LoginImp extends Progress{
    void login(String username, String password);

    void loginSuccess(User user);

    void loginFailure(String message);
}
