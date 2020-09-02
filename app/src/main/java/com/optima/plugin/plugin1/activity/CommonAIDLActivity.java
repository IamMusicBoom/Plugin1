package com.optima.plugin.plugin1.activity;

import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.os.RemoteException;
import android.view.View;

import androidx.annotation.Nullable;

import com.optima.plugin.plugin1.R;
import com.optima.plugin.repluginlib.ICommonAidlInterface;
import com.optima.plugin.repluginlib.Logger;
import com.optima.plugin.repluginlib.base.BaseActivity;
import com.optima.plugin.repluginlib.module.User;

import java.util.List;

/**
 * create by wma
 * on 2020/9/2 0002
 */
public class CommonAIDLActivity extends BaseActivity implements View.OnClickListener {
    ICommonAidlInterface iCommonAidlInterface;
    User mUser;
    List<User> mUsers;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_common_aidl);

    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.btn_bind_host_service) {
            Intent intent = new Intent("ACTION_COMMON_AIDL");
            intent.setClassName("com.optima.plugin.host","com.optima.plugin.host.service.CommonAIDLService");
            bindService(intent,conn,BIND_AUTO_CREATE);
        } else if (v.getId() == R.id.btn_unbind_host_service) {
            unbindService(conn);
        } else if (v.getId() == R.id.btn_set_user) {
            try {
                mUser = iCommonAidlInterface.getUser(1);
                mUser.setAge(100);
                mUser.setName("Change");
                iCommonAidlInterface.setUser(mUser, 1);
            } catch (RemoteException e) {
                e.printStackTrace();
            }

        }else if(v.getId() == R.id.btn_add_exist_user){
            try {
                User user = iCommonAidlInterface.getUser(1);
                iCommonAidlInterface.addUser(user);
            } catch (RemoteException e) {
                e.printStackTrace();
            }
        }else if(v.getId() == R.id.btn_add_new_user){
            User user = new User("user16",16);
            try {
                iCommonAidlInterface.addUser(user);
            } catch (RemoteException e) {
                e.printStackTrace();
            }
        }
    }
    CommonAIDLConnection conn = new CommonAIDLConnection();
    class CommonAIDLConnection implements ServiceConnection {

        @Override
        public void onServiceConnected(ComponentName name, IBinder service) {

            iCommonAidlInterface = ICommonAidlInterface.Stub.asInterface(service);
            try {
                iCommonAidlInterface.say("Hello CommonAIDL");
                mUsers = iCommonAidlInterface.getUsers();
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
