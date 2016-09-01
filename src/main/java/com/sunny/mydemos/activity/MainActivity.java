package com.sunny.mydemos.activity;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.sunny.mydemos.R;

public class MainActivity extends Activity implements View.OnClickListener {


    private String TAG = "MainActivity";

    private Button mButton;
    private LinearLayout ll;
    private int requestCode=123;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mButton = (Button) findViewById(R.id.button);


        mButton.setOnClickListener(this);

    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.i(TAG, "onDestroy: ");
    }



    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.button:
                startOtherActivity();
                break;
        }
    }

    private void startOtherActivity() {
//        使用显示的方法来启动Activity
//        Intent _intent=new Intent(this,OtherActivity.class);

//        使用隐式的方法来启动Activity
        Intent _intent=new Intent( );
        _intent.setAction("com.sunny.WATCHMOIVE");
        _intent.putExtra("name","sunny");
        _intent.setData(Uri.parse("http://www.google.com"));
        startActivityForResult(_intent,  requestCode);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == 4321) {
            Toast.makeText(MainActivity.this, data.getStringExtra("name"), Toast.LENGTH_SHORT).show();


        }


    }
}
