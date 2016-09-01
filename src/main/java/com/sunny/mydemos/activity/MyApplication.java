package com.sunny.mydemos.activity;

import android.app.Application;
import android.content.res.Configuration;
import android.util.Log;

/**
 * Created by Administrator on 2016/8/27.
 */
public class MyApplication extends Application {

    private String TAG ="MyApplication";

    @Override
    public void onCreate() {
        super.onCreate();
//        "On Create".to

        Log.d(TAG, "MyApplication onCreate: ");


    }


    @Override
    public void onTerminate() {
        super.onTerminate();

        Log.d(TAG, "onTerminate: ");

    }

    @Override
    public void onLowMemory() {
        super.onLowMemory();

        Log.d(TAG, "onLowMemory: ");



    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        Log.d(TAG, "onConfigurationChanged: ");

    }
}
