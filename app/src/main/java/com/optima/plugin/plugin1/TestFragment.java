package com.optima.plugin.plugin1;

import android.app.Fragment;
import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;

import com.optima.plugin.plugin1.R;
import com.optima.plugin.plugin1.adapter.MyRecyclerAdapter;
import com.optima.plugin.plugin1.view.WaveView;
import com.optima.plugin.repluginlib.Logger;
import com.optima.plugin.repluginlib.base.BaseFragment;
import com.optima.plugin.repluginlib.pluginUtils.P_Constants;
import com.optima.plugin.repluginlib.pluginUtils.P_Context;
import com.qihoo360.replugin.RePlugin;

import java.util.ArrayList;
import java.util.List;


/**
 * create by wma
 * on 2020/8/17 0017
 */
public class TestFragment extends Fragment implements View.OnClickListener, View.OnLongClickListener {
    final String TAG = TestFragment.class.getSimpleName();
    Button click,longClick,startAnim;
    TextView tvText;
    WaveView waveView;
    RecyclerView mRecyclerView;
    MyRecyclerAdapter mAdapter;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = LayoutInflater.from(P_Context.getContext()).inflate(R.layout.provide_layout, container,false);
        click = view.findViewById(R.id.btn_click);
        click.setOnClickListener(this);
        longClick = view.findViewById(R.id.btn_long_click);
        longClick.setOnLongClickListener(this);
        startAnim = view.findViewById(R.id.btn_start_anim);
        startAnim.setOnClickListener(this);
        tvText = view.findViewById(R.id.tv_set_text);
        tvText.setOnClickListener(this);
        waveView = view.findViewById(R.id.custom_view);
        mRecyclerView = view.findViewById(R.id.recycler_view);
        List<String> list = new ArrayList<>();
        for (int i = 0; i < 20; i++) {
            list.add("我是第 " + i + "项");
        }
        mAdapter = new MyRecyclerAdapter(list);
        mRecyclerView.setAdapter(mAdapter);
        return view;
    }

    @Override
    public void onClick(View v) {
        if(v.getId() == R.id.tv_set_text){
            tvText.setText("已经设置了");
            tvText.setTextColor(Color.GREEN);
        }else if(v.getId() == R.id.btn_click){
            Logger.d(TAG, "onClick: ");
        }else if(v.getId() == R.id.btn_start_anim){
            waveView.startAnim();
        }
    }

    @Override
    public boolean onLongClick(View v) {
        Logger.d(TAG, "onLongClick: ");
        return false;
    }

}
