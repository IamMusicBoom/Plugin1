package com.optima.plugin.plugin1.activity;

import android.os.Bundle;
import android.os.Process;

import androidx.annotation.Nullable;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.optima.plugin.plugin1.R;
import com.optima.plugin.plugin1.fragment.TestFragment;
import com.optima.plugin.repluginlib.Logger;
import com.optima.plugin.repluginlib.base.BaseActivity;

/**
 * create by wma
 * on 2020/8/17 0017
 */
public class SecondActivity extends BaseActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();
        ft.add(R.id.container,new TestFragment(),"TestFragment");
        ft.commit();
        Logger.d(TAG, "onCreate: pid = " + Process.myPid() + " taskId = " + getTaskId());

    }
}
