package com.optima.plugin.plugin1.binder;

import android.content.Intent;
import android.os.IBinder;
import android.os.RemoteException;

import com.optima.plugin.host.IViewAidlInterface;
import com.optima.plugin.plugin1.R;
import com.optima.plugin.repluginlib.Logger;
import com.optima.plugin.repluginlib.pluginUtils.P_Binder;
import com.optima.plugin.repluginlib.pluginUtils.P_Constants;
import com.qihoo360.replugin.RePlugin;

/**
 * create by wma
 * on 2020/9/7 0007
 */
public class ViewBinder extends IViewAidlInterface.Stub {
    String TAG = "Plugin1_ViewBinder";
    IViewAidlInterface iView;
    @Override
    public void onClick(int resId) throws RemoteException {
        Logger.d(TAG, "onClick: resId = " + resId);
        if(resId == R.id.btn_provide_onClick){
            IBinder host_view_binder = P_Binder.getHostBinder("host_view_binder");
            iView = Stub.asInterface(host_view_binder);
            try {
                iView.setText(R.id.tv_provide_test,"行行行");
            } catch (RemoteException e) {
                e.printStackTrace();
            }
        }else if(resId == R.id.btn_provide_setColor){
            Logger.d(TAG, "onClick: setColor");

        }
        else if(resId == R.id.tv_provide_test){
            iView.startAnim(R.id.custom_view);
        }
    }

    @Override
    public void onLongClick(int resId) throws RemoteException {
        Logger.d(TAG, "onLongClick: resId = " + resId);
        if(resId == R.id.btn_provide_onClick){
            Logger.d(TAG, "onLongClick: onclick");
        }else if(resId == R.id.btn_provide_setColor){
            Logger.d(TAG, "onLongClick: setColor");
        }
    }

    @Override
    public void setText(int resId, String text) throws RemoteException {

    }

    @Override
    public void startAnim(int resId) throws RemoteException {

    }
}
