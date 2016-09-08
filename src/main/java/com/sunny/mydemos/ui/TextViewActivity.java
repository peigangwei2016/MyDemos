package com.sunny.mydemos.ui;

import android.app.Activity;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.Html;
import android.text.SpannableStringBuilder;
import android.text.Spanned;
import android.text.style.ClickableSpan;
import android.text.style.ImageSpan;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.sunny.mydemos.R;

/**
 * Created by Administrator on 2016/9/5.
 */
public class TextViewActivity extends Activity {
    private android.widget.TextView mTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_textview);
        this.mTextView = (TextView) findViewById(R.id.mTextView);
        showTextView();

        showButton();




    }

    private void showButton() {

    }

    /**
     * TextView的一些常用练习
     */
    private void showTextView() {
/* 显示HTML
               String html= "<font color='blue'>Toms</font><img src='http://icons.iconarchive.com/icons/paomedia/small-n-flat/1024/sign-check-icon.png'>";
        Html.ImageGetter imgGetter =new Html.ImageGetter() {
            @Override
            public Drawable getDrawable(String source) {
                Drawable drawable = getResources().getDrawable(R.drawable.icon);
                drawable.setBounds(0,0,drawable.getIntrinsicWidth(),drawable.getIntrinsicHeight());
                return drawable;
            }
        };
        Spanned spanned = Html.fromHtml(html, imgGetter, null);*/

        /*设置不同范围的显示风格
        SpannableStringBuilder spannableStringBuilder=new SpannableStringBuilder("#Sunny# 大家好！");

        ImageSpan imageSpan=new ImageSpan(this, R.drawable.icon);

        ClickableSpan clickableSpan=new ClickableSpan() {
            @Override
            public void onClick(View widget) {
                Toast.makeText(TextViewActivity.this, "你点击了!", Toast.LENGTH_SHORT).show();
            }
        };
        spannableStringBuilder.setSpan(clickableSpan,0,7, Spanned.SPAN_INCLUSIVE_EXCLUSIVE);

        spannableStringBuilder.setSpan(imageSpan,7,8,Spanned.SPAN_INCLUSIVE_INCLUSIVE);

        mTextView.setText(spannableStringBuilder);*/

    }
}
