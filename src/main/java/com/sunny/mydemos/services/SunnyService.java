package com.sunny.mydemos.services;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;
import android.util.Log;

/**
 * Created by Administrator on 2016/9/1.
 * <p>
 * 实现bindService，Service端实现步骤
 * 1.通过继承Binder类来实现IBider接口，并在IBinder接口中暴露被外部调用的方法
 * 2.声明IBider接口,并创建实例
 * 3.返回IBider接口实例
 */
public class SunnyService extends Service {
    private String TAG = "SunnyService";

    //    2.声明IBider接口,并创建实例
    IBinder mIBinder = new MyIBinder();


    //    1.实现IBider接口，并在IBinder接口中暴露被外部调用的方法
    class MyIBinder extends Binder {

        public String hello(String name){
            return "Your Name is :"+name;
        }

    }

    @Override
    public IBinder onBind(Intent intent) {
        Log.i(TAG, "onBind: ");
//        3.返回IBider接口实例
        return mIBinder;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        Log.i(TAG, "onCreate: ");
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.i(TAG, "onDestroy: ");
    }

    @Override
    public boolean onUnbind(Intent intent) {
        Log.i(TAG, "onUnbind: ");
        return super.onUnbind(intent);
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Log.i(TAG, "onStartCommand: ");
        helloService();
        return super.onStartCommand(intent, flags, startId);
    }

    private void helloService() {

        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 100; i++) {
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    Log.i(TAG, "helloService: " + i);
                }
            }
        }).start();

    }
}
