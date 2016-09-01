package com.sunny.mydemos.services;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.sunny.mydemos.R;

/**
 * Created by Administrator on 2016/9/1.
 */
public class ServiceActivity extends Activity {
    private android.widget.Button butStartService;
    private android.widget.Button butStopService;
    private Intent mIntent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_service);
        this.butStopService = (Button) findViewById(R.id.butStopService);
        this.butStartService = (Button) findViewById(R.id.butStartService);
//        开启服务
        butStartService.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mIntent = new Intent(ServiceActivity.this,SunnyIntentService.class);
                startService(mIntent);
            }
        });
//        停止服务
        butStopService.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                stopService(mIntent);
            }
        });

    }
}
