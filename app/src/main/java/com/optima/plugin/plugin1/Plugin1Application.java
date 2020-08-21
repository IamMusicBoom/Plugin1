package com.optima.plugin.plugin1;

import android.app.Application;

import com.optima.plugin.repluginlib.PluginUtils.P_Context;

/**
 * create by wma
 * on 2020/8/21 0021
 */
public class Plugin1Application extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        P_Context.setContext(this);
    }
}
