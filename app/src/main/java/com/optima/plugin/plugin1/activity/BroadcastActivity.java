package com.optima.plugin.plugin1.activity;

import android.content.ComponentName;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.annotation.Nullable;

import com.optima.plugin.plugin1.R;
import com.optima.plugin.repluginlib.base.BaseActivity;
import com.optima.plugin.repluginlib.pluginUtils.P_Constants;
import com.qihoo360.replugin.RePlugin;

/**
 * create by wma
 * on 2020/8/17 0017
 */
public class BroadcastActivity extends BaseActivity implements View.OnClickListener{
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_broadcast);
    }

    @Override
    public void onClick(View v) {
        if(v.getId() == R.id.btn_send_broadcast_to_host){// 给宿主发送广播
            Intent intent = new Intent(P_Constants.ACTION_BROADCAST_RECEIVER);
            intent.setComponent(new ComponentName(P_Constants.HOST_PACKAGE_NAME,"com.optima.plugin.host.broadcast.BroadcastTest"));
            intent.putExtra(P_Constants.INTENT_ALIAS,P_Constants.ALIAS_PLUGIN_2);
            intent.putExtra(P_Constants.INTENT_CLASS_NAME,P_Constants.PACKAGE_NAME_PLUGIN_2+".activity.BroadcastActivity");
            sendBroadcast(intent);
        }else if(v.getId() == R.id.btn_send_broadcast_to_plugin){// 给插件发送广播
            Intent intent = new Intent(P_Constants.ACTION_BROADCAST_RECEIVER);
            intent.putExtra(P_Constants.INTENT_ALIAS,P_Constants.ALIAS_PLUGIN_2);
            intent.putExtra(P_Constants.INTENT_CLASS_NAME,P_Constants.PACKAGE_NAME_PLUGIN_2+".activity.BroadcastActivity");
            sendBroadcast(intent);
        }else if(v.getId() == R.id.btn_send_broadcast_to_self){// 给自己发送广播
            Intent intent = new Intent(P_Constants.ACTION_BROADCAST_RECEIVER);
            intent.putExtra(P_Constants.INTENT_ALIAS,P_Constants.ALIAS_PLUGIN_2);
            intent.putExtra(P_Constants.INTENT_CLASS_NAME,P_Constants.PACKAGE_NAME_PLUGIN_2+".activity.BroadcastActivity");
            sendBroadcast(intent);
        }
    }
}
