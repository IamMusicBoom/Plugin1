package com.optima.plugin.plugin1.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;

import com.optima.plugin.plugin1.R;
import com.optima.plugin.repluginlib.Logger;
import com.optima.plugin.repluginlib.base.BaseActivity;
import com.optima.plugin.repluginlib.databases.ConfigDB;
import com.optima.plugin.repluginlib.module.PluginInfoModule;

import org.xutils.DbManager;

import java.util.List;

public class DBTestActivity extends BaseActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dbtest);
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.go_query) {
            List<PluginInfoModule> pluginConfigList = ConfigDB.getPluginConfigList();
            for (int i = 0; i < pluginConfigList.size(); i++) {
                PluginInfoModule pluginInfoModule = pluginConfigList.get(i);
                Logger.d(TAG, "onClick: plugin name = " + pluginInfoModule.getName());
                ConfigDB.getPluginInfoByName(pluginInfoModule.getName());
            }

        }
    }
}
