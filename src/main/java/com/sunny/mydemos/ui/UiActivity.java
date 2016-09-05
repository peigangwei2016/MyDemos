package com.sunny.mydemos.ui;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.LinearLayout;

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
    public boolean onKeyUp(int keyCode, KeyEvent event) {
        Log.i(TAG, "UiActivity  onKeyUp: ");
        return super.onKeyUp(keyCode, event);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        float x = event.getX();
        float y = event.getY();

        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                Log.i(TAG, "onTouchEvent:  onClick");
                break;
            case MotionEvent.ACTION_MOVE:
                Log.i(TAG, "onTouchEvent: x=" + x + "  y=" + y);
                break;
            case MotionEvent.ACTION_UP:
                if((event.getEventTime()-event.getDownTime())>2000){
                    Log.i(TAG, "you Long Click! ");
                }
                break;

        }
        return super.onTouchEvent(event);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//         mButton = new CustomButton(this);
        /*LinearLayout linearLayout = new LinearLayout(this);
        ViewGroup.LayoutParams params = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);
        linearLayout.setOrientation(LinearLayout.VERTICAL);
        linearLayout.setLayoutParams(params);

        Button button=new Button(this);
        button.setText("Login");
        linearLayout.addView(button, LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT);*/

        setContentView(new DrawableView(this));

//        mHandler.sendMessageDelayed(mHandler.obtainMessage(),200);
//            mHandler.postDelayed(mRunnable,200);
       /* new Thread(new Runnable() {
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
        }).start();*/
    }
}
