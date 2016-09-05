package com.sunny.mydemos.ui;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.view.View;

import com.sunny.mydemos.R;

/**
 * Created by Administrator on 2016/9/4.
 */
public class DrawableView extends View {

    Drawable mBD;
    public DrawableView(Context context) {
        super(context);
        mBD= getResources().getDrawable(R.drawable.rect);
        mBD.setBounds(20,20,360,60);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        mBD.draw(canvas);

    }
}
