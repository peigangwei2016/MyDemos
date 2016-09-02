package com.sunny.mydemos.services;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.sunny.mydemos.R;

/**
 * Created by Administrator on 2016/9/1.
 * BindService调用步骤
 * 1.定义ServiceConnection接口
 * 2.实现ServiceConnection接口
 * 3.创建调用接口的Intent
 * 4.调用bindService方法传入Intent，ServiceConnect，Flag
 * 5.绑定成功后在onServiceConnected方法中得到IBider的句柄对象，绑定失败调用onServiceDisconnected方法
 * 6.通过句柄对象来调IBinder接口中定义的方法
 * 7.解绑Service调用unBindService方法
 */
public class ServiceActivity extends Activity {
    private android.widget.Button butStartService;
    private android.widget.Button butStopService;
    private Intent mIntent;
    private Button butBindService;
    private Button butUnBindService;
//    1.定义ServiceConection接口
    private ServiceConnection mServiceConn=new MyServiceConnection();
    private String TAG = "ServiceActivity";

    //    2.实现ServiceConnection接口
    class MyServiceConnection implements ServiceConnection {

        @Override
        public void onServiceConnected(ComponentName name, IBinder service) {
//            5.绑定成功后在onServiceConnected方法中得到IBider的句柄对象
            Log.i(TAG, "onServiceConnected:BindService Success! ");
//            6.通过句柄对象来调IBinder接口中定义的方法
            SunnyService.MyIBinder myIBinder = (SunnyService.MyIBinder) service;
            String value = myIBinder.hello("Sunny");
            Toast.makeText(ServiceActivity.this, value, Toast.LENGTH_SHORT).show();

        }

        @Override

        public void onServiceDisconnected(ComponentName name) {
            Log.i(TAG, "onServiceDisconnected: BindService Fail!");
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_service);
        this.butUnBindService = (Button) findViewById(R.id.butUnBindService);
        this.butBindService = (Button) findViewById(R.id.butBindService);
        this.butStopService = (Button) findViewById(R.id.butStopService);
        this.butStartService = (Button) findViewById(R.id.butStartService);

//        开启服务
        butStartService.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mIntent = new Intent(ServiceActivity.this, SunnyIntentService.class);
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

//        BindService
        butBindService.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                3.创建调用接口的Intent
//                Intent intent=new Intent(ServiceActivity.this,SunnyService.class);
//                调用远程Service
                Intent intent=new Intent();
//                intent.setComponent()
//                4.调用bindService方法传入Intent，ServiceConnect，Flag
                bindService(intent,mServiceConn,BIND_AUTO_CREATE);

            }
        });

//        UnBindService
        butUnBindService.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                7.解绑Service调用unBindService方法
                unbindService(mServiceConn);
            }
        });

    }
}
