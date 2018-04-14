package com.j1ang.demo;

import com.facebook.stetho.Stetho;
import com.j1ang.base.utils.L;

/**
 * Date:  2018/4/12.
 * version:  V1.0
 * Description:
 *
 * @author Joy
 */
public class App extends com.j1ang.base.app.BaseApp {

    @Override
    public void onCreate() {
        super.onCreate();
        L.init(BuildConfig.DEBUG);
        Stetho.initializeWithDefaults(this);
    }
}
