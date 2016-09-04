package com.sunny.mydemos.ui;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.Log;
import android.view.View;

/**
 * Created by Administrator on 2016/9/4.
 */
public class CustomButton extends View {
    private int mIndex=0;
    private String TAG ="CustomButton";

    public CustomButton(Context context) {
        super(context);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if(mIndex>100)mIndex=0;

        ++mIndex;

//        定义画笔
        Paint paint=new Paint();

        Log.i(TAG, "onDraw: "+mIndex);

//        给画笔设置颜色
        switch (mIndex%4){
            case 1:
                paint.setColor(Color.RED);
                break;
            case 2:
                paint.setColor(Color.GREEN);
                break;
            case 3:
                paint.setColor(Color.BLUE);
                break;
            default:
                paint.setColor(Color.GRAY);
                break;
        }


//        画一个正方形
        canvas.drawRect(0,0,120,60,paint);


    }
}
