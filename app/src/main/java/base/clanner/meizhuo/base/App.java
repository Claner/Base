package base.clanner.meizhuo.base;

import android.app.Application;

import java.util.concurrent.TimeUnit;

import base.clanner.meizhuo.base.base.config.CookieJarImpl;
import base.clanner.meizhuo.base.base.config.PersistentCookieStore;
import okhttp3.OkHttpClient;

/**
 * Created by Clanner on 2017/5/17.
 */
public class App extends Application {
    private static App instance;
    private static OkHttpClient okHttpClient;

    public static App getInstances() {
        return instance;
    }

    public OkHttpClient getOkHttpClient() {
        return okHttpClient;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        instance = this;
        CookieJarImpl cookieJar = new CookieJarImpl(new PersistentCookieStore(getApplicationContext()));
        okHttpClient = new OkHttpClient.Builder()
                .connectTimeout(10000L, TimeUnit.MILLISECONDS)
                .readTimeout(10000L, TimeUnit.MILLISECONDS)
                .cookieJar(cookieJar)
                //其他配置
                .build();
    }
}
