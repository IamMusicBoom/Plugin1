package com.optima.plugin.plugin1;

import android.app.Application;

import com.optima.plugin.repluginlib.Logger;
import com.optima.plugin.repluginlib.pluginUtils.P_Context;

/**
 * create by wma
 * on 2020/8/21 0021
 */
public class Plugin1Application extends Application {
    String TAG = Plugin1Application.class.getSimpleName();
    @Override
    public void onCreate() {
        super.onCreate();
        P_Context.setContext(this);
        Logger.d(TAG, "onCreate: -------------------------------------------");
    }
}
