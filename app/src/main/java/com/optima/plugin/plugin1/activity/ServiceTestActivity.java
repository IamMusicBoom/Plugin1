package com.optima.plugin.plugin1.activity;

import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Build;
import android.os.Bundle;
import android.os.IBinder;
import android.view.View;

import androidx.annotation.Nullable;

import com.optima.plugin.plugin1.R;
import com.optima.plugin.repluginlib.Logger;
import com.optima.plugin.repluginlib.base.BaseActivity;
import com.optima.plugin.repluginlib.pluginUtils.P_Constants;

/**
 * create by wma
 * on 2020/8/18 0018
 */
public class ServiceTestActivity extends BaseActivity implements View.OnClickListener {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_service_test);
    }

    MyServiceConnection connection = new MyServiceConnection();

    @Override
    public void onClick(View v) {
        Intent pluginIntent = new Intent();
        pluginIntent.putExtra(P_Constants.INTENT_KEY,"WMA-OK");
        pluginIntent.setComponent(new ComponentName(P_Constants.ALIAS_PLUGIN_2, "com.optima.plugin.plugin2.service.Plugin2ServiceTest"));
        Intent hostIntent = new Intent();
        hostIntent.putExtra(P_Constants.INTENT_KEY,"WMA-OK");
        hostIntent.setComponent(new ComponentName(P_Constants.HOST_PACKAGE_NAME, "com.optima.plugin.host.service.HostServiceTest"));
        if (v.getId() == R.id.btn_start_plugin_service) {// 开启插件服务
            startService(pluginIntent);
        } else if (v.getId() == R.id.btn_stop_plugin_service) {// 停止插件服务
            stopService(pluginIntent);
        } else if (v.getId() == R.id.btn_bind_plugin_service) {// 绑定插件服务
            bindService(pluginIntent,connection,BIND_AUTO_CREATE);
        } else if (v.getId() == R.id.btn_unbind_plugin_service) {// 解绑插件服务
            unbindService(connection);
        } else if (v.getId() == R.id.btn_start_host_service) {// 开启宿主服务
           startService(hostIntent);
        } else if (v.getId() == R.id.btn_stop_host_service) {// 停止宿主服务
            stopService(hostIntent);
        } else if (v.getId() == R.id.btn_bind_host_service) {// 绑定宿主服务
            bindService(hostIntent,connection,BIND_AUTO_CREATE);
        } else if (v.getId() == R.id.btn_unbind_host_service) {// 解绑宿主服务
            unbindService(connection);
        }else if(v.getId() == R.id.btn_start_foreground_service){
            Intent intent = new Intent("ACTION_FOREGROUND_SERVICE");
            intent.setComponent(new ComponentName("com.optima.plugin.plugin1","com.optima.plugin.plugin1.service.Plugin1ServiceTest"));
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                startForegroundService(intent);
            }else{
                startService(intent);
            }
        }
    }

    class MyServiceConnection implements ServiceConnection {

        @Override
        public void onServiceConnected(ComponentName name, IBinder service) {
            Logger.d(TAG, "onServiceConnected: ");
        }

        @Override
        public void onServiceDisconnected(ComponentName name) {
            Logger.d(TAG, "onServiceDisconnected: ");
        }
    }
}
