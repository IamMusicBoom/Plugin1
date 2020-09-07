package com.optima.plugin.dialog;

import android.app.Dialog;
import android.content.Context;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.optima.plugin.plugin1.R;

/**
 * create by wma
 * on 2020/9/4 0004
 */
public class TestDialog extends Dialog {
    public TestDialog(@NonNull Context context) {
        this(context,0);
        setContentView(R.layout.fragment_test);
    }

    public TestDialog(@NonNull Context context, int themeResId) {
        super(context, themeResId);
    }

    protected TestDialog(@NonNull Context context, boolean cancelable, @Nullable OnCancelListener cancelListener) {
        super(context, cancelable, cancelListener);
    }
}
