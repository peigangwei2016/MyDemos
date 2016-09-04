package com.sunny.mydemos.ui;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.Log;

/**
 * Created by Administrator on 2016/9/4.
 */
public class UiActivity extends Activity {

    private CustomButton mButton;
    private String TAG = "UiActivity";

/*    private Handler mHandler=new Handler(){
        @Override
        public void handleMessage(Message msg) {

//            sendMessageDelayed(msg,200);
            Log.i(TAG, "handleMessage: ");
            postDelayed(mRunnable,200);

        }
    };

    Runnable mRunnable=new Runnable() {
        @Override
        public void run() {
            mButton.invalidate();
        }
    };*/

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mButton = new CustomButton(this);
        setContentView(mButton);

//        mHandler.sendMessageDelayed(mHandler.obtainMessage(),200);
//            mHandler.postDelayed(mRunnable,200);
        new Thread(new Runnable() {
            @Override
            public void run() {
                while(!Thread.currentThread().isInterrupted()){
                    try {
                        Thread.sleep(200);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    mButton.postInvalidate();
                }
            }
        }).start();
    }
}
