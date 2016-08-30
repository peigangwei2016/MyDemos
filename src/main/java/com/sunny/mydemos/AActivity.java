package com.sunny.mydemos;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

/**
 * Created by Administrator on 2016/8/29.
 */
public class AActivity extends Activity {
    private static int mIndex=0;
    private String TAG="AActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_task);
        ++mIndex;
        Log.i(TAG, "instance="+mIndex+" TaskID="+getTaskId());
//        找到按钮，并启动AActivity
        findViewById(R.id.start_a).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(AActivity.this,AActivity.class);
                startActivity(intent);
            }
        });
//        找到按钮，并启动BActivity
        findViewById(R.id.start_b).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(AActivity.this,BActivity.class);
                startActivity(intent);
            }
        });

        TextView name = (TextView) findViewById(R.id.text_name);
        name.setText("AActivity");

//        启动设置界面
//        Intent intent=new Intent();
//        intent.setAction("android.intent.action.MAIN");
//        intent.setData(Uri.parse("com.android.settings.PRIMARY_PROFILE_CONTROLLED"));
//        intent.setClassName("com.android.settings","Settings");
//        ComponentName component=new ComponentName("com.android.settings","com.android.settings.SubSettings");
//        intent.setComponent(component);
//        startActivity(intent);
    }
}
