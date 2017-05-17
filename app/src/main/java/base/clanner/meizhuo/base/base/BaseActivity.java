package base.clanner.meizhuo.base.base;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.WindowManager;
import android.widget.Toast;

import base.clanner.meizhuo.base.R;
import butterknife.ButterKnife;
/**
 * Created by Clanner on 2017/4/11.
 */

public abstract class BaseActivity extends AppCompatActivity {

    protected Intent intent;
    protected boolean isTranslucent = false;
    protected ActionBar actionBar;

    protected abstract int ContentView();

    protected abstract void init(Bundle savedInstanceState);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(ContentView());
        ButterKnife.bind(this);
        intent = new Intent();
        init(savedInstanceState);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        if (isTranslucent) getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
    }

    protected void changeActivity(Class<?> cls) {
        intent.setClass(this, cls);
        startActivity(intent);
    }

    protected void changeActivity(Class<?> cls, String str) {
        intent.setClass(this, cls);
        intent.putExtra("STRING", str);
        startActivity(intent);
    }

    protected void changeActivity(Class<?> cls, int i) {
        intent.setClass(this, cls);
        intent.putExtra("INT", i);
        startActivity(intent);
    }

    protected void toast(String content) {
        Toast.makeText(this, content, Toast.LENGTH_SHORT).show();
    }

    protected void initToolBar(Toolbar toolbar, boolean isCanBack) {
        toolbar.setNavigationIcon(R.mipmap.icon_back);
        toolbar.setTitleTextColor(getResources().getColor(R.color.white));
        setSupportActionBar(toolbar);
        actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(isCanBack);
    }

    protected void initToolBar(Toolbar toolbar, int title, boolean isCanBack) {
        toolbar.setNavigationIcon(R.mipmap.icon_back);
        toolbar.setTitle(title);
        toolbar.setTitleTextColor(getResources().getColor(R.color.white));
        setSupportActionBar(toolbar);
        actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(isCanBack);
    }

    protected void initToolBar(Toolbar toolbar, String title, boolean isCanBack) {
        toolbar.setNavigationIcon(R.mipmap.icon_back);
        toolbar.setTitle(title);
        toolbar.setTitleTextColor(getResources().getColor(R.color.white));
        setSupportActionBar(toolbar);
        actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(isCanBack);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                finish();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    @Override
    protected void onPause() {
        super.onPause();
    }
}
