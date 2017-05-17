package base.clanner.meizhuo.base.ui.activity;

import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.util.Log;
import android.view.View;

import java.util.List;

import base.clanner.meizhuo.base.R;
import base.clanner.meizhuo.base.adapter.DesignAdviceAdapter;
import base.clanner.meizhuo.base.base.BaseActivity;
import base.clanner.meizhuo.base.entity.DesignAdvice;
import base.clanner.meizhuo.base.entity.User;
import base.clanner.meizhuo.base.imp.GetAdviceImp;
import base.clanner.meizhuo.base.imp.LoginImp;
import base.clanner.meizhuo.base.presenter.GetAdvicePresenter;
import base.clanner.meizhuo.base.presenter.LoginPresenter;
import butterknife.BindView;
import butterknife.OnClick;

public class MainActivity extends BaseActivity implements LoginImp, GetAdviceImp {

    @BindView(R.id.list)
    RecyclerView list;
    private LoginPresenter loginPresenter;
    private GetAdvicePresenter getAdvicePresenter;
    private DesignAdviceAdapter adapter;

    @Override
    protected int ContentView() {
        return R.layout.activity_main;
    }

    @Override
    protected void init(Bundle savedInstanceState) {

    }


    @OnClick({R.id.btn_login, R.id.btn_test})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_login:
                login("13692190638", "123456");
                break;
            case R.id.btn_test:
                getAdvice();
                break;
        }
    }

    @Override
    public void login(String username, String password) {
        if (loginPresenter == null) loginPresenter = new LoginPresenter(this);
        loginPresenter.login(username, password);
    }

    @Override
    public void loginSuccess(User user) {
        toast("登陆成功");
        Log.e("DEBUG", "技能" + user.getSkill());
        Log.e("DEBUG", "名字" + user.getUsername());
        Log.e("DEBUG", "描述" + user.getDescription());
        Log.e("DEBUG", "头像" + user.getAvatar());
    }

    @Override
    public void loginFailure(String message) {
        toast(message);
    }

    @Override
    public void showProgress() {

    }

    @Override
    public void hideProgress() {

    }

    @Override
    public void getAdvice() {
        if (getAdvicePresenter == null) getAdvicePresenter = new GetAdvicePresenter(this);
        getAdvicePresenter.getAdvice(0, 0);
    }

    @Override
    public void getAdviceSuccess(List<DesignAdvice> dataBean) {
        if (adapter == null) {
            adapter = new DesignAdviceAdapter(this, R.layout.item_design_advice, dataBean);
            list.setAdapter(adapter);
            list.setLayoutManager(new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL));
        } else {
            adapter.addData(dataBean);
            adapter.notifyDataSetChanged();
        }
    }

    @Override
    public void getAdviceFailure(String message) {
        toast(message);
    }
}
