package com.sunny.mydemos.ui;

import android.app.Activity;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RadioGroup;
import android.widget.RatingBar;
import android.widget.SeekBar;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ToggleButton;

import com.sunny.mydemos.R;

import java.util.ArrayList;

/**
 * Created by Administrator on 2016/9/5.
 */
public class TextViewActivity extends Activity {
    private android.widget.TextView mTextView;
    private android.widget.Button mButton;
    private android.widget.ToggleButton mToggleButton;
    private android.widget.CheckBox isJoinCloud;
    private android.widget.RadioGroup mSex;
    private android.widget.Spinner spinner;
    private android.widget.ProgressBar progressBar;
    private android.widget.SeekBar seekBar;
    private android.widget.RatingBar ratingBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_textview);
        this.ratingBar = (RatingBar) findViewById(R.id.ratingBar);
        this.seekBar = (SeekBar) findViewById(R.id.seekBar);
        this.progressBar = (ProgressBar) findViewById(R.id.progressBar);
        this.spinner = (Spinner) findViewById(R.id.spinner);
        this.mSex = (RadioGroup) findViewById(R.id.mSex);
        this.isJoinCloud = (CheckBox) findViewById(R.id.isJoinCloud);
        this.mToggleButton = (ToggleButton) findViewById(R.id.mToggleButton);
        this.mButton = (Button) findViewById(R.id.mButton);
        this.mTextView = (TextView) findViewById(R.id.mTextView);
//        showTextView();
//
//        showButton();


//        showToggleButton();

//        showCheckBox();

//        showRadioGroup();

//        showSpinner();

//        showSeekBar();
    }

    private void showSeekBar() {
        Drawable ic = getResources().getDrawable(R.drawable.handle);
        ic.setBounds(0, 0, ic.getIntrinsicWidth(), ic.getIntrinsicHeight());

        seekBar.setThumb(ic);

    }

    private void showSpinner() {
//        创建数据源
        String[] names = getResources().getStringArray(R.array.names);
//        创建Adapter
//        ArrayAdapter<String> adapter=new ArrayAdapter<String>(this,android.R.layout.simple_dropdown_item_1line,names);
//        使用自定义Adapter
        ArrayList<User> users = new ArrayList<User>();
        users.add(new User(R.drawable.ic_zjl, "周杰伦", "台湾"));
        users.add(new User(R.drawable.ic_ldh, "刘德华", "香港"));
        users.add(new User(R.drawable.ic_lzl, "林志玲", "台湾"));
        UserAdapter adapter = new UserAdapter(this, users);
//        绑定Adapter和Spinner的连接
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if (view instanceof LinearLayout) {
                    TextView nameView = (TextView) view.findViewById(R.id.name);
                    Toast.makeText(TextViewActivity.this, nameView.getText(), Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

    }

    private void showRadioGroup() {
        mSex.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {

                Toast.makeText(TextViewActivity.this, "id=" + checkedId, Toast.LENGTH_SHORT).show();
            }
        });
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
