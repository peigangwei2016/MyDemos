package com.sunny.mydemos.activity;

import android.app.Activity;
import android.content.res.Configuration;
import android.os.Bundle;
import android.util.Log;
import android.widget.EditText;

import com.sunny.mydemos.R;

/**
 * Created by Administrator on 2016/8/28.
 */
public class LifeActivity extends Activity {


    private String TAG="LifeActivity";

    private EditText mEditText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_life);
        Log.i(TAG, "onCreate:Activity On Create!你好 ");

        mEditText= (EditText) findViewById(R.id.editText);



    }

    /**
     * 在设置发生改变的时候调用，例如横竖屏切换
     * @param newConfig
     */
    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        Log.d(TAG, "onConfigurationChanged: ");
    }

    /**
     * Activity退出时保存Activity数据
     * @param outState
     */
    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        String value = mEditText.getText().toString();
        outState.putString("value",    value);


        Log.d(TAG, "onSaveInstanceState: ");
    }

    /**
     * Activity重启时回复Activity数据
     * @param savedInstanceState
     */
    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        Log.d(TAG, "onRestoreInstanceState: ");
        if (savedInstanceState != null) {
            String value = savedInstanceState.getString("value");
            mEditText.setText("sunny:"+value);

        }
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.i(TAG, "onStart: ");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.i(TAG, "onResume: ");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.i(TAG, "onPause: ");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.i(TAG, "onStop: ");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.i(TAG, "onDestroy: ");
    }
}
