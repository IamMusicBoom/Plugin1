package com.optima.plugin.plugin1.broadcast;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

import com.optima.plugin.plugin1.activity.BroadcastActivity;
import com.optima.plugin.repluginlib.Logger;
import com.optima.plugin.repluginlib.PluginUtils.P_Constants;

/**
 * create by wma
 * on 2020/8/17 0017
 */
public class BroadcastTest extends BroadcastReceiver {
    String TAG = BroadcastTest.class.getName();
    @Override
    public void onReceive(Context context, Intent intent) {
        if(intent != null){
            String stringExtra = intent.getStringExtra(P_Constants.INTENT_KEY);
            Logger.d(TAG, "onReceive: " + stringExtra);
            if("WMA-OK".equals(stringExtra)){
                Intent activityIntent = new Intent(context, BroadcastActivity.class);
                activityIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                context.startActivity(activityIntent);
            }
        }
    }
}
