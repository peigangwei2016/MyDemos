package com.sunny.mydemos.ui;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ToggleButton;

import com.sunny.mydemos.R;

/**
 * Created by Administrator on 2016/9/5.
 */
public class TextViewActivity extends Activity {
    private android.widget.TextView mTextView;
    private android.widget.Button mButton;
    private android.widget.ToggleButton mToggleButton;
    private android.widget.CheckBox isJoinCloud;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_textview);
        this.isJoinCloud = (CheckBox) findViewById(R.id.isJoinCloud);
        this.mToggleButton = (ToggleButton) findViewById(R.id.mToggleButton);
        this.mButton = (Button) findViewById(R.id.mButton);
        this.mTextView = (TextView) findViewById(R.id.mTextView);
//        showTextView();
//
//        showButton();


//        showToggleButton();

        showCheckBox();


    }

    private void showCheckBox() {
        isJoinCloud.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked){
                    Toast.makeText(TextViewActivity.this, "选中！", Toast.LENGTH_SHORT).show();

                }else {
                    Toast.makeText(TextViewActivity.this, "没有选中！", Toast.LENGTH_SHORT).show();

                }
            }
        });
    }

    /**
     * ToggleButton的常用练习
     */
    private void showToggleButton() {
        mToggleButton.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked)
                    Toast.makeText(TextViewActivity.this, "开", Toast.LENGTH_SHORT).show();
                else
                    Toast.makeText(TextViewActivity.this, "关", Toast.LENGTH_SHORT).show();


            }
        });
    }

    /**
     * Button的事件练习
     */
    private void showButton() {
        mButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(TextViewActivity.this, "onClick!", Toast.LENGTH_SHORT).show();
            }
        });
        mButton.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                Toast.makeText(TextViewActivity.this, "onLongClick!", Toast.LENGTH_SHORT).show();
                return true;
            }
        });
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
