package base.clanner.meizhuo.base.model;

import android.text.TextUtils;

import base.clanner.meizhuo.base.base.BaseEntity;
import base.clanner.meizhuo.base.entity.User;
import base.clanner.meizhuo.base.presenter.LoginPresenter;
import base.clanner.meizhuo.base.utils.Constant;
import base.clanner.meizhuo.base.utils.RetrofitManager;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

/**
 * Created by Clanner on 2017/4/12.
 */

public class LoginModel {

    private LoginPresenter loginPresenter;

    public LoginModel(LoginPresenter loginPresenter) {
        this.loginPresenter = loginPresenter;
    }

    public void login(String account, String password) {
        if (TextUtils.isEmpty(account) || TextUtils.isEmpty(password)) {
            loginPresenter.loginFailure("用户名和密码不能为空");
            return;
        }
        LoginImp loginImp = RetrofitManager.getRetrofit().create(LoginImp.class);
        Call<BaseEntity<User,Object>> call = loginImp.addParams(account, password);
        call.enqueue(new Callback<BaseEntity<User,Object>>() {
            @Override
            public void onResponse(Call<BaseEntity<User,Object>> call, Response<BaseEntity<User,Object>> response) {
                if (response.body() == null) {
                    loginPresenter.loginFailure("解析json失败");
                    return;
                }
                if (response.body().getCode() == Constant.getInstance().SUCCESS) {
                    loginPresenter.loginSuccess(response.body().getData());
                } else {
                    loginPresenter.loginFailure("用户名或密码错误");
                }
            }

            @Override
            public void onFailure(Call<BaseEntity<User,Object>> call, Throwable t) {
                loginPresenter.loginFailure("登陆失败，请检查网络连接");
            }
        });
    }

    private interface LoginImp {
        @FormUrlEncoded
        @POST("Home/User/login")
        Call<BaseEntity<User,Object>> addParams(@Field("phone") String phone,
                                   @Field("password") String password);
    }
}
