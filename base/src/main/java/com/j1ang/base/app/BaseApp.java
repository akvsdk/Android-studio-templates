package com.j1ang.base.app;

import android.app.Application;
import android.content.Context;
import android.content.res.Resources;
import android.support.multidex.MultiDex;

/**
 * author  Joy
 * Date:  2017/9/5.
 * version:  V1.0
 * Description:
 */
public class BaseApp extends Application {
    private static BaseApp BaseApp;


    @Override
    public void onCreate() {
        super.onCreate();
        BaseApp = this;
    }


    public static Context getAppContext() {
        return BaseApp;
    }

    public static Resources getAppResources() {
        return BaseApp.getResources();
    }

    @Override
    public void onTerminate() {
        super.onTerminate();
    }

    /**
     * 分包
     *
     * @param base
     */
    @Override
    protected void attachBaseContext(Context base) {
        super.attachBaseContext(base);
        MultiDex.install(this);
    }


}
