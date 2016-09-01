package com.sunny.mydemos.activity;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.sunny.mydemos.R;

/**
 * Created by Administrator on 2016/8/29.
 */
public class AActivity extends Activity {
    private static int mIndex=0;
    private String TAG = "Sunny";
    private Button startA;
    private Button startB;
    private TextView activityName;
    private Button openBaidu;
    private Button call;
    private Button openSunnyTest;


    @Override
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        Log.i(TAG, "AActivity onNewIntent instance="+mIndex+" TaskID="+getTaskId());
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_task);
        this.openSunnyTest = (Button) findViewById(R.id.openSunnyTest);
        this.call = (Button) findViewById(R.id.call);
        this.openBaidu = (Button) findViewById(R.id.openBaidu);
        this.activityName = (TextView) findViewById(R.id.activityName);
        this.startB = (Button) findViewById(R.id.startB);
        this.startA = (Button) findViewById(R.id.startA);

        ++mIndex;
        Log.i(TAG, "AActivity OnCreate instance="+mIndex+" TaskID="+getTaskId());
//        找到按钮，并启动AActivity
        findViewById(R.id.startA).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(AActivity.this,AActivity.class);
                startActivity(intent);
            }
        });
//        找到按钮，并启动BActivity
        findViewById(R.id.startB).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(AActivity.this,BActivity.class);
                startActivity(intent);
            }
        });


//        TextView name = (TextView) findViewById(R.id.activityName);
        activityName.setText("AActivity");
//        打开百度
        openBaidu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(Intent.ACTION_VIEW);
                intent.setData(Uri.parse("http://www.baidu.com"));
                startActivity(intent);
            }
        });

//        拨打10086
        call.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_CALL);
                intent.setData(Uri.parse("tel:10086"));
                startActivity(intent);
            }
        });

//        打开自己定义的Activity

        openSunnyTest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent("com.sunny.test");
                intent.setData(Uri.parse("sunny:HelloSunny"));
                startActivity(intent);
            }
        });
//        启动设置界面
//        Intent intent=new Intent();
//        intent.setAction("android.intent.action.MAIN");
//        intent.setData(Uri.parse("com.android.settings.PRIMARY_PROFILE_CONTROLLED"));
//        intent.setClassName("com.android.settings","Settings");
//        ComponentName component=new ComponentName("com.android.settings","com.android.settings.SubSettings");
//        intent.setComponent(component);
//        startActivity(intent);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.i(TAG, "AActivity onDestroy instance="+mIndex+" TaskID="+getTaskId());
    }
}
