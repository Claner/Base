package base.clanner.meizhuo.base.presenter;


import base.clanner.meizhuo.base.entity.User;
import base.clanner.meizhuo.base.imp.LoginImp;
import base.clanner.meizhuo.base.model.LoginModel;

/**
 * Created by Clanner on 2017/4/12.
 */

public class LoginPresenter {

    private LoginImp loginImp;
    private LoginModel loginModel;

    public LoginPresenter(LoginImp loginImp) {
        this.loginImp = loginImp;
    }

    public void login(String account, String password) {
        loginImp.showProgress();
        loginModel = new LoginModel(this);
        loginModel.login(account, password);
    }

    public void loginSuccess(User user) {
        loginImp.hideProgress();
        loginImp.loginSuccess(user);
    }

    public void loginFailure(String message) {
        loginImp.hideProgress();
        loginImp.loginFailure(message);
    }
}
