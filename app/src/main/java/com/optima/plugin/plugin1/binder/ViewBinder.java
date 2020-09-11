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
        if(resId == R.id.btn_get_host_binder){
            IBinder host_view_binder = P_Binder.getHostBinder("host_view_binder");
            iView = IViewAidlInterface.Stub.asInterface(host_view_binder);
        }else if(resId == R.id.btn_click){
            Logger.d(TAG, "onClick: 点击");
            iView.setImgId(R.id.img_provider,R.mipmap.xiao_jie_jie);
        }else if(resId == R.id.btn_start_anim){
            iView.startAnim(R.id.wave_view);
        }else if(resId == R.id.tv_set_text){
            iView.setText(R.id.tv_set_text,"这是我设置的值");
        }
    }

    @Override
    public void onLongClick(int resId) throws RemoteException {
        if(resId == R.id.btn_long_click){

            Logger.d(TAG, "onLongClick: 长按");
        }
    }

    @Override
    public void setText(int resId, String text) throws RemoteException {

    }

    @Override
    public void setImgId(int resId,int imgId) throws RemoteException {

    }

    @Override
    public void startAnim(int resId) throws RemoteException {

    }
}
