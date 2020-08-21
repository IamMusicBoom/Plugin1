package com.optima.plugin.plugin1;

import android.content.ComponentName;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.optima.plugin.plugin1.activity.AIDLTestActivity;
import com.optima.plugin.plugin1.activity.NotificationTestActivity;
import com.optima.plugin.plugin1.activity.SecondActivity;
import com.optima.plugin.repluginlib.Logger;
import com.optima.plugin.repluginlib.PluginUtils.P_Constants;
import com.optima.plugin.repluginlib.PluginUtils.P_Context;
import com.optima.plugin.repluginlib.base.BaseActivity;

public class Plugin1MainActivity extends BaseActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ClassLoader hostClassLoader = P_Context.getHostClassLoader();
        ClassLoader pluginClassLoader = P_Context.getPluginClassLoader(P_Constants.ALIAS_PLUGIN_1);
        Logger.d(TAG, "onCreate: hostClassLoader = " + hostClassLoader);
        Logger.d(TAG, "onCreate: pluginClassLoader = " + pluginClassLoader);
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
        }else if(id == R.id.btn_go_inner_activity_for_fragment){// 跳转至Fragment，测试Fragment
            Intent intent = new Intent(this,SecondActivity.class);
            startActivity(intent);
        }else if(id == R.id.btn_go_inner_activity_for_aidl){
            Intent intent = new Intent(this, NotificationTestActivity.class);
            startActivity(intent);
        }
    }
}
