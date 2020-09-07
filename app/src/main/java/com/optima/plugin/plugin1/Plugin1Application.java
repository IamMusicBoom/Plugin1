package com.optima.plugin.plugin1;

import android.app.Application;
import android.os.IBinder;
import android.os.RemoteException;

import com.optima.plugin.host.IViewAidlInterface;
import com.optima.plugin.plugin1.binder.ViewBinder;
import com.optima.plugin.repluginlib.Logger;
import com.optima.plugin.repluginlib.pluginUtils.P_Binder;
import com.optima.plugin.repluginlib.pluginUtils.P_Constants;
import com.optima.plugin.repluginlib.pluginUtils.P_Context;
import com.qihoo360.replugin.RePlugin;

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
        P_Binder.registerPluginBinder("view_holder", new ViewBinder());
    }
}
