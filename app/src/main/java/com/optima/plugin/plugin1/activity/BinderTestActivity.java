package com.optima.plugin.plugin1.activity;

import android.content.Intent;
import android.os.Bundle;
import android.os.IBinder;
import android.os.RemoteException;
import android.view.View;

import androidx.annotation.Nullable;

import com.optima.plugin.host.IHostImpl;
import com.optima.plugin.host.module.User;
import com.optima.plugin.plugin1.R;
import com.optima.plugin.plugin1.binder.HostBinder;
import com.optima.plugin.repluginlib.Logger;
import com.optima.plugin.repluginlib.PluginUtils.P_Binder;
import com.optima.plugin.repluginlib.PluginUtils.P_Constants;
import com.optima.plugin.repluginlib.base.BaseActivity;
import com.qihoo360.replugin.RePlugin;

import java.util.List;

/**
 * create by wma
 * on 2020/8/27 0027
 */
public class BinderTestActivity extends BaseActivity implements View.OnClickListener {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_binder_test);
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.get_host_binder) {
            try {
                IBinder main = P_Binder.getHostBinder(P_Constants.HOST_BINDER);
                IHostImpl iHost = IHostImpl.Stub.asInterface(main);
                iHost.say("已经获取到HostBinder");
                iHost.addUser(new User("赵云", 32));
                iHost.setUser(new User("赵云", 23), 0);
                List<User> users = iHost.getUsers();
                Logger.d(TAG, "onClick: users = " + users.size());
                User user = iHost.getUser(0);
                Logger.d(TAG, "onClick: name = " + user.getName() + " age = " + user.getAge());
            } catch (RemoteException e) {
                e.printStackTrace();
            }
        } else if (v.getId() == R.id.get_global_binder) {
            IBinder globalBinder = P_Binder.getGlobalBinder("globalBinder");
            IHostImpl iHost = IHostImpl.Stub.asInterface(globalBinder);
            try {
                iHost.say("已经获取到HostBinder");
                iHost.addUser(new User("赵云", 32));
                iHost.setUser(new User("赵云", 23), 0);
                List<User> users = iHost.getUsers();
                Logger.d(TAG, "onClick: users = " + users.size());
                User user = iHost.getUser(0);
                Logger.d(TAG, "onClick: name = " + user.getName() + " age = " + user.getAge());
            } catch (RemoteException e) {
                e.printStackTrace();
            }
        } else if (v.getId() == R.id.register_plugin_binder) {
            P_Binder.registerPluginBinder("plugin1Binder",new HostBinder());
        }
    }
}
