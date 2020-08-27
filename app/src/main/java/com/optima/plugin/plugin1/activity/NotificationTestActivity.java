package com.optima.plugin.plugin1.activity;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.View;
import android.widget.RemoteViews;

import androidx.annotation.Nullable;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;

import com.optima.plugin.plugin1.Plugin1MainActivity;
import com.optima.plugin.plugin1.R;
import com.optima.plugin.plugin1.service.Plugin1ServiceTest;
import com.optima.plugin.repluginlib.PluginUtils.P_Context;
import com.optima.plugin.repluginlib.base.BaseActivity;
import com.optima.plugin.repluginlib.utils.NotificationUtils;

/**
 * create by wma
 * on 2020/8/19 0019
 */
public class NotificationTestActivity extends BaseActivity implements View.OnClickListener {
    NotificationUtils utils;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notification_test);
        utils = new NotificationUtils();
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.btn_show_default_notification) {// 展示默认通知栏
            Intent intent = new Intent(P_Context.getContext(), Plugin1MainActivity.class);
            PendingIntent sure = PendingIntent.getActivity(P_Context.getContext(), 0, intent, 0);
            NotificationCompat.Builder builder = utils.createDefaultBuilder();
            builder.setContentText("通知").setContentTitle("默认通知").setLargeIcon(BitmapFactory.decodeResource(getResources(), R.mipmap.icon_large)).setContentIntent(sure);
            utils.showNotification(666, builder.build());

        } else if (v.getId() == R.id.btn_show_importance_notification) {// 展示重要通知栏
            Intent service = new Intent(NotificationTestActivity.this, Plugin1ServiceTest.class);
            PendingIntent service1 = PendingIntent.getService(NotificationTestActivity.this, 0, service, PendingIntent.FLAG_UPDATE_CURRENT);
            NotificationCompat.Builder builder = utils.createImportanceBuilder();
            builder.setContentText("通知").setContentTitle("重要通知").setLargeIcon(BitmapFactory.decodeResource(getResources(), R.mipmap.icon_large)).setContentIntent(service1);
            utils.showNotification(777, builder.build());
        } else if (v.getId() == R.id.btn_show_customize_notification) {
            NotificationManagerCompat manager = NotificationManagerCompat.from(NotificationTestActivity.this);
            if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.O) {
                NotificationChannel channel = new NotificationChannel("888","annn", NotificationManager.IMPORTANCE_DEFAULT);
            }
            NotificationCompat.Builder builder = new NotificationCompat.Builder(NotificationTestActivity.this,"888");
            Notification build = builder.build();



        }
    }

}
