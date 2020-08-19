package com.optima.plugin.plugin1.activity;

import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.os.RemoteException;
import android.view.View;

import androidx.annotation.Nullable;

import com.optima.plugin.host.IHostImpl;
import com.optima.plugin.host.module.User;
import com.optima.plugin.plugin1.R;
import com.optima.plugin.repluginlib.Logger;
import com.optima.plugin.repluginlib.base.BaseActivity;

import java.util.List;

/**
 * create by wma
 * on 2020/8/19 0019
 */
public class AIDLTestActivity extends BaseActivity implements View.OnClickListener {
    IHostImpl iHost;
    User mUser;
    List<User> mUsers;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_aidl_test);
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.btn_bind_host_service) {
            Intent intent = new Intent("hostMainService");
            intent.setClassName("com.optima.plugin.host", "com.optima.plugin.host.service.AIDLService");
            bindService(intent, conn, BIND_AUTO_CREATE);
        } else if (v.getId() == R.id.btn_unbind_host_service) {
            unbindService(conn);
        } else if (v.getId() == R.id.btn_set_user) {
            try {
                mUser = iHost.getUser(1);
                mUser.setAge(100);
                mUser.setName("Change");
                iHost.setUser(mUser, 1);
            } catch (RemoteException e) {
                e.printStackTrace();
            }

        }else if(v.getId() == R.id.btn_add_exist_user){
            try {
                User user = iHost.getUser(1);
                iHost.addUser(user);
            } catch (RemoteException e) {
                e.printStackTrace();
            }
        }else if(v.getId() == R.id.btn_add_new_user){
            User user = new User("user16",16);
            try {
                iHost.addUser(user);
            } catch (RemoteException e) {
                e.printStackTrace();
            }
        }
    }

    PluginServiceConnection conn = new PluginServiceConnection();

    class PluginServiceConnection implements ServiceConnection {

        @Override
        public void onServiceConnected(ComponentName name, IBinder service) {
            iHost = IHostImpl.Stub.asInterface(service);
            try {
                iHost.say("Hello AIDL");
                mUsers = iHost.getUsers();
                for (int i = 0; i < mUsers.size(); i++) {
                    User user = mUsers.get(i);
                    Logger.d(TAG, "onServiceConnected: " + user.getName() + " " + user.getAge());
                }
            } catch (RemoteException e) {
                e.printStackTrace();
            }
        }

        @Override
        public void onServiceDisconnected(ComponentName name) {

        }
    }
}
