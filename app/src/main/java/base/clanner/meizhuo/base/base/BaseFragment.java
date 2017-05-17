package base.clanner.meizhuo.base.base;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import base.clanner.meizhuo.base.R;
import butterknife.ButterKnife;

/**
 * Created by Clanner on 2017/4/11.
 */

public abstract class BaseFragment extends Fragment {
    protected boolean isViewInitiated;
    protected boolean isVisibleToUser;
    protected boolean isDataInitiated;

    protected View rootView;
    protected Intent intent;

    protected abstract int layout();

    protected abstract void init(Bundle savedInstanceState);
    //网络请求在这里进行
    public abstract void fetchData();


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setHasOptionsMenu(true);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        if (rootView == null) {
            rootView = inflater.inflate(layout(), container, false);
            ButterKnife.bind(this, rootView);
            intent = new Intent();
            init(savedInstanceState);
        }
        return rootView;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        ((ViewGroup) rootView.getParent()).removeView(rootView);
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        isViewInitiated = true;
        prepareFetchData();
    }

    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        super.setUserVisibleHint(isVisibleToUser);
        this.isVisibleToUser = isVisibleToUser;
        prepareFetchData();
    }

    public boolean prepareFetchData() {
        return prepareFetchData(false);
    }

    public boolean prepareFetchData(boolean forceUpdate) {
        /**
         * 当前fragment对用户可见并且已经初始化并且还未加载数据
         * 则调用fetchData方法，即在可这里进行网络加载数据
         * 加载数据后使isDataInitiated为false确保不重复加载数据
         */
        if (isVisibleToUser && isViewInitiated && (!isDataInitiated || forceUpdate)) {
            fetchData();
            isDataInitiated = true;
            return true;
        }
        return false;
    }

    protected Fragment getRootFragment() {
        Fragment fragment = getParentFragment();
        while (fragment.getParentFragment() != null) {
            fragment = fragment.getParentFragment();
        }
        return fragment;
    }

    protected void initToolBar(Toolbar toolbar, String title, final boolean isFinish) {
        toolbar.setNavigationIcon(R.mipmap.icon_back);
        toolbar.setTitle(title);
        toolbar.setNavigationIcon(R.mipmap.icon_back);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (isFinish) {
                    getActivity().finish();
                } else {
                    getActivity().onBackPressed();
                }
            }
        });
    }

    protected void changeActivity(Class<?> cls,String string,boolean isFinish){
        intent.setClass(getActivity(),cls);
        intent.putExtra("STRING",string);
        startActivity(intent);
        if (isFinish) getActivity().finish();
    }

    protected void changeActivity(Class<?> cls,int i,boolean isFinish){
        intent.setClass(getActivity(),cls);
        intent.putExtra("INT",i);
        startActivity(intent);
        if (isFinish) getActivity().finish();
    }

    protected void changeActivity(Class<?> cls,boolean isFinish){
        intent.setClass(getActivity(),cls);
        startActivity(intent);
        if (isFinish) getActivity().finish();
    }

    protected void toast(String content){
        Toast.makeText(getContext(), content, Toast.LENGTH_SHORT).show();
    }

    protected void addFragment(BaseFragment fragment, FragmentActivity activity) {
        activity.addFragment(fragment);
    }

    protected void removeFragment(FragmentActivity activity) {
        activity.removeFragment();
    }
}
