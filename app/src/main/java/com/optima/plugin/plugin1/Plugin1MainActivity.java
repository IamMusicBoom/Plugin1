package com.optima.plugin.plugin1;

import android.content.ComponentName;
import android.content.ContentResolver;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Process;
import android.os.RemoteException;
import android.provider.MediaStore;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.core.content.ContextCompat;

import com.optima.plugin.plugin1.activity.CommonAIDLActivity;
import com.optima.plugin.plugin1.activity.DBTestActivity;
import com.optima.plugin.plugin1.activity.FloatWindowActivity;
import com.optima.plugin.plugin1.activity.NotificationTestActivity;
import com.optima.plugin.plugin1.activity.SecondActivity;
import com.optima.plugin.plugin1.activity.ServiceTestActivity;
import com.optima.plugin.repluginlib.Logger;
import com.optima.plugin.repluginlib.TestActivity;
import com.optima.plugin.repluginlib.base.BaseActivity;
import com.optima.plugin.repluginlib.pluginUtils.P_Constants;
import com.optima.plugin.repluginlib.pluginUtils.P_Context;
import com.optima.plugin.repluginlib.pluginUtils.P_Manager;
import com.qihoo360.replugin.RePlugin;

public class Plugin1MainActivity extends BaseActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Logger.d(TAG, "onCreate: packageName = " + P_Constants.HOST_PACKAGE_NAME);
    }

    @Override
    public void onClick(View v) {
        int id = v.getId();
        if (id == R.id.btn_go_plugin_activity) {// 跳转至第二个插件Activity
            Intent intent = new Intent();
            intent.setComponent(new ComponentName(P_Constants.ALIAS_PLUGIN_2, P_Constants.PACKAGE_NAME_PLUGIN_2 + ".Plugin2MainActivity"));
            startActivity(intent, true);
        } else if (id == R.id.btn_go_inner_activity) {// 跳转到自己的一个Activity
            Intent intent = new Intent(this, SecondActivity.class);
            startActivity(intent);
        } else if (id == R.id.btn_go_plugin_activity_for_result) {// 跳转至第二个插件Activity并且带值返回
            Intent intent = P_Context.createIntent(P_Constants.ALIAS_PLUGIN_2, P_Constants.PACKAGE_NAME_PLUGIN_2 + ".Plugin2MainActivity");
            startActivityForResult(intent, P_Constants.REQUEST_CODE, true);
        } else if (id == R.id.btn_go_inner_activity_for_result) {// 跳转到自己的一个Activity并且带值返回
            Intent intent = new Intent(this, SecondActivity.class);
            startActivityForResult(intent, P_Constants.REQUEST_CODE);
        } else if (id == R.id.btn_go_host_activity) {// 跳转至宿主 Activity
            Intent intent = P_Context.createIntent(P_Constants.HOST_PACKAGE_NAME, P_Constants.HOST_PACKAGE_NAME + ".MainActivity");
            startActivity(intent, true);
        } else if (id == R.id.btn_go_host_activity_for_result) {// 跳转至宿主 Activity并且带值返回
            Intent intent = P_Context.createIntent(P_Constants.HOST_PACKAGE_NAME, P_Constants.HOST_PACKAGE_NAME + ".MainActivity");
            startActivityForResult(intent, P_Constants.REQUEST_CODE, true);
        } else if (id == R.id.btn_go_inner_activity_for_fragment) {// 跳转至Fragment，测试Fragment
            Intent intent = new Intent(this, SecondActivity.class);
            startActivity(intent);
        } else if (id == R.id.btn_go_inner_activity_for_aidl) {
//            Intent intent = new Intent(this, AIDLTestActivity.class);
//            startActivity(intent);
        } else if (id == R.id.btn_go_service_test) {
            Intent intent = new Intent(this, ServiceTestActivity.class);
            startActivity(intent);
        } else if (id == R.id.btn_go_common_aidl) {
            Intent intent = new Intent(this, CommonAIDLActivity.class);
            startActivity(intent);
        } else if (id == R.id.btn_go_float_window) {
            Uri imageUri = MediaStore.Images.Media.EXTERNAL_CONTENT_URI;//content://media/external/images/media
            ContentResolver contentResolver = P_Context.getContext().getContentResolver();
            Cursor cursor = contentResolver.query(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, null, null, null, null);
            Logger.d(TAG, "onClick: cursor = " + cursor);
            Intent intent = new Intent(this, TestActivity.class);
            startActivity(intent);
        } else if (id == R.id.btn_go_notification) {
            Intent intent = new Intent(Plugin1MainActivity.this, NotificationTestActivity.class);
            startActivity(intent);
        } else if (v.getId() == R.id.btn_db_test) {
            Intent intent = new Intent(Plugin1MainActivity.this, DBTestActivity.class);
            startActivity(intent);
        }
    }
}
