    package com.optima.plugin.plugin1;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;


    /**
 * create by wma
 * on 2020/8/17 0017
 */
public class TestFragment extends Fragment implements View.OnClickListener{
    Button btn1,btn2,btn3,btn4,btn5,btn6;
    Button btn7,btn8,btn9,btn10,btn11,btn12,btn13,btn14,btn15,btn16,btn17;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_test,container,false);
        btn1 = view.findViewById(R.id.btn_go_plugin_activity);
        btn1.setOnClickListener(this);
        btn2 = view.findViewById(R.id.btn_go_inner_activity);
        btn2.setOnClickListener(this);
        btn3 = view.findViewById(R.id.btn_go_plugin_activity_for_result);
        btn3.setOnClickListener(this);
        btn4 = view.findViewById(R.id.btn_go_inner_activity_for_result);
        btn4.setOnClickListener(this);
        btn5 = view.findViewById(R.id.btn_go_host_activity);
        btn5.setOnClickListener(this);
        btn6 = view.findViewById(R.id.btn_go_host_activity_for_result);
        btn6.setOnClickListener(this);


        btn7 = view.findViewById(R.id.btn_start_plugin_service);
        btn7.setOnClickListener(this);
        btn8 = view.findViewById(R.id.btn_stop_plugin_service);
        btn8.setOnClickListener(this);
        btn9 = view.findViewById(R.id.btn_bind_plugin_service);
        btn9.setOnClickListener(this);
        btn10 = view.findViewById(R.id.btn_unbind_plugin_service);
        btn10.setOnClickListener(this);
        btn11 = view.findViewById(R.id.btn_start_host_service);
        btn11.setOnClickListener(this);
        btn12 = view.findViewById(R.id.btn_stop_host_service);
        btn12.setOnClickListener(this);
        btn13 = view.findViewById(R.id.btn_bind_host_service);
        btn13.setOnClickListener(this);
        btn14 = view.findViewById(R.id.btn_unbind_host_service);
        btn14.setOnClickListener(this);



        return view;
    }

    @Override
    public void onClick(View v) {
//        int id = v.getId();
//        if (id == R.id.btn_go_plugin_activity) {// 跳转至第二个插件Activity
//            Intent intent = new Intent();
//            intent.setComponent(new ComponentName(P_Constants.ALIAS_PLUGIN_2, P_Constants.PACKAGE_NAME_PLUGIN_2 + ".Plugin2MainActivity"));
//            startActivity(intent, true);
//        } else if (id == R.id.btn_go_inner_activity) {// 跳转到自己的一个Activity
//            Intent intent = new Intent(getActivity(), SecondActivity.class);
//            startActivity(intent);
//        } else if (id == R.id.btn_go_plugin_activity_for_result) {// 跳转至第二个插件Activity并且带值返回
//            Intent intent = P_Context.createIntent(P_Constants.ALIAS_PLUGIN_2, P_Constants.PACKAGE_NAME_PLUGIN_2 + ".Plugin2MainActivity");
//            startActivityForResult(intent, P_Constants.REQUEST_CODE, true);
//        } else if (id == R.id.btn_go_inner_activity_for_result) {// 跳转到自己的一个Activity并且带值返回
//            Intent intent = new Intent(getActivity(), SecondActivity.class);
//            startActivityForResult(intent, P_Constants.REQUEST_CODE);
//        } else if (id == R.id.btn_go_host_activity) {// 跳转至宿主 Activity
//            Intent intent = P_Context.createIntent(P_Constants.HOST_PACKAGE_NAME, P_Constants.HOST_PACKAGE_NAME + ".MainActivity");
//            startActivity(intent, true);
//        } else if (id == R.id.btn_go_host_activity_for_result) {// 跳转至宿主 Activity并且带值返回
//            Intent intent = P_Context.createIntent(P_Constants.HOST_PACKAGE_NAME, P_Constants.HOST_PACKAGE_NAME + ".MainActivity");
//            startActivityForResult(intent, P_Constants.REQUEST_CODE, true);
//        }
    }
}
