package com.optima.plugin.plugin1.utils;

import androidx.annotation.NonNull;

import com.optima.plugin.repluginlib.Logger;

/**
 * create by wma
 * on 2020/8/20 0020
 */
public class TestReflexUtil {
   static String TAG = TestReflexUtil.class.getSimpleName() + "-Plugin1";


    private String name;
    public int age;


    public TestReflexUtil(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public TestReflexUtil() {
    }

    private void noPnoR() {
        Logger.d(TAG, "noPnoR: ");
    }

    private String noPhR() {
        Logger.d(TAG, "noPhR: ");
        return "noPhR";
    }

    private void hPnoR(String s) {
        Logger.d(TAG, "hPnoR: s = " + s);
    }

    private String hPhR(String s) {
        Logger.d(TAG, "hPhR: s = " + s);
        String s2 = s + " 做个拼接吧";
        return s2;
    }

    private void mPs(String name, int age) {
        Logger.d(TAG, "mPs: name = " + name + " age = " + age);
    }

    public void show(){
        Logger.d(TAG, "show: name = " + name + "  age = " + age);
    }

    public static String jump(String jump){
        Logger.d(TAG, "jump: " + jump);
        jump = jump + "  拼接一下";
        return jump;
    }

}
