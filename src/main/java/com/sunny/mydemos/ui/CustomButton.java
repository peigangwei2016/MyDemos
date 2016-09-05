package com.sunny.mydemos.ui;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.Log;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;

/**
 * Created by Administrator on 2016/9/4.
 */
public class CustomButton extends View {
    private int mIndex = 0;
    private String TAG = "CustomButton";

    public CustomButton(Context context) {
        super(context);
//        设置焦点
        setFocusable(true);
        setFocusableInTouchMode(true);
    }


    //    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (mIndex > 100) mIndex = 0;

        ++mIndex;

//        定义画笔
        Paint paint = new Paint();

        Log.i(TAG, "onDraw: " + mIndex);

//        给画笔设置颜色
        paint.setColor(Color.GRAY);
//        switch (mIndex%4){
//            case 1:
//                paint.setColor(Color.RED);
//                break;
//            case 2:
//                paint.setColor(Color.GREEN);
//                break;
//            case 3:
//                paint.setColor(Color.BLUE);
//                break;
//            default:
//                paint.setColor(Color.GRAY);
//                break;
//        }


//        画一个正方形
//        canvas.drawRoundRect(20,20,160,120,5,5,paint);
        canvas.drawRect(20, 20, 160, 100, paint);
        paint.setColor(Color.BLACK);
        paint.setTextSize(30);
        canvas.drawText("Login", 50, 70, paint);

    }

    @Override
    public boolean onKeyUp(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK) {
            Log.i(TAG, "CustomButton  onKeyUp: ");
        }
        return false;
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

        }

        return super.onTouchEvent(event);
    }
}
