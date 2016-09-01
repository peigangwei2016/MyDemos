package com.sunny.mydemos.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.sunny.mydemos.R;

/**
 * Created by Administrator on 2016/8/29.
 */
public class BActivity extends Activity {
    private static int mIndex=0;
    private String TAG="Sunny";

    @Override
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        Log.i(TAG, "BActivity onNewIntent instance="+mIndex+" TaskID="+getTaskId());

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_task);
        ++mIndex;
        Log.i(TAG, "BActivity onCreate instance="+mIndex+" TaskID="+getTaskId());
//        找到按钮，并启动AActivity
        findViewById(R.id.startA).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(BActivity.this,AActivity.class);
                startActivity(intent);
            }
        });
//        找到按钮，并启动BActivity
        findViewById(R.id.startB).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(BActivity.this,BActivity.class);
                startActivity(intent);
            }
        });
        TextView name = (TextView) findViewById(R.id.activityName);
        name.setText("BActivity");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.i(TAG, "BActivity onDestroy instance="+mIndex+" TaskID="+getTaskId());
    }
}
