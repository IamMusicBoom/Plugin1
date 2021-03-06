package com.optima.plugin.plugin1.service;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;
import android.os.RemoteException;

import androidx.annotation.Nullable;
import androidx.core.app.NotificationCompat;

import com.optima.plugin.host.ILockScreenImpl;
import com.optima.plugin.host.IViewAidlInterface;
import com.optima.plugin.plugin1.R;
import com.optima.plugin.plugin1.activity.ServiceTestActivity;
import com.optima.plugin.plugin1.binder.ViewBinder;
import com.optima.plugin.repluginlib.Logger;
import com.optima.plugin.repluginlib.pluginUtils.P_Binder;
import com.optima.plugin.repluginlib.pluginUtils.P_Constants;
import com.optima.plugin.repluginlib.pluginUtils.P_Manager;
import com.optima.plugin.repluginlib.utils.NotificationUtils;
import com.qihoo360.replugin.RePlugin;

/**
 * create by wma
 * on 2020/8/18 0018
 */
public class Plugin1ServiceTest extends Service {
    String TAG = Plugin1ServiceTest.class.getSimpleName();
    boolean isGoToActivity;

    @Override
    public void onCreate() {
        super.onCreate();
//        IBinder host_view_binder = P_Binder.getHostBinder("host_view_binder");
//        IViewAidlInterface iView = IViewAidlInterface.Stub.asInterface(host_view_binder);
//        try {
//            iView.setText(R.id.tv_provide_test,"行行行");
//        } catch (RemoteException e) {
//            e.printStackTrace();
//        }
    }


    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        if(intent != null){
            String stringExtra = intent.getStringExtra(P_Constants.INTENT_KEY);
            Logger.d(TAG, "onStartCommand: stringExtra = " + stringExtra);
        }
        Logger.d(TAG, "onStartCommand: isGoToActivity = " + isGoToActivity);
        if (isGoToActivity) {
            Intent activityIntent = new Intent(this, ServiceTestActivity.class);
            activityIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            startActivity(activityIntent);
        }
        isGoToActivity = !isGoToActivity;
        return super.onStartCommand(intent, flags, startId);
    }


    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        if(intent != null){
            String stringExtra = intent.getStringExtra(P_Constants.INTENT_KEY);
            Logger.d(TAG, "onBind: stringExtra = " + stringExtra);
        }
        return new MyBinder();
    }

    @Override
    public boolean onUnbind(Intent intent) {
        Logger.d(TAG, "onUnbind: ");
        return super.onUnbind(intent);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Logger.d(TAG, "onDestroy: ");
    }

    class MyBinder extends Binder {

    }
}
