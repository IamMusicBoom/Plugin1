package com.optima.plugin.plugin1.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.optima.plugin.plugin1.R;
import com.optima.plugin.repluginlib.Logger;
import com.optima.plugin.repluginlib.pluginUtils.P_Context;

import java.util.List;

/**
 * create by wma
 * on 2020/9/8 0008
 */
public class MyRecyclerAdapter extends RecyclerView.Adapter<MyRecyclerAdapter.MyRecyclerHolder> {
    String TAG = MyRecyclerAdapter.class.getSimpleName();
    List<String> mList;

    public MyRecyclerAdapter(List<String> mList) {
        this.mList = mList;
    }

    @NonNull
    @Override
    public MyRecyclerHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(P_Context.getContext()).inflate(R.layout.item_view,parent,false);
        return new MyRecyclerHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyRecyclerHolder holder, final int position) {
        holder.textView.setText(mList.get(position));
        holder.textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Logger.d(TAG, "onClick: " + mList.get(position));
            }
        });
    }

    @Override
    public int getItemCount() {
        return mList.size();
    }

    class MyRecyclerHolder extends RecyclerView.ViewHolder{
        TextView textView;
        public MyRecyclerHolder(@NonNull View itemView) {
            super(itemView);
            textView = itemView.findViewById(R.id.tv_item);
        }
    }
}
