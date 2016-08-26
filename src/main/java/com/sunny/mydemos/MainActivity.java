package com.sunny.mydemos;

import android.content.res.Resources;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        获取Resource中的值
        Resources resources = getResources();
//        获取字符串
        String appName = resources.getString(R.string.app_name);

//        获取颜色
        int color = resources.getColor(R.color.blue);

//        获取尺寸
        float dime = resources.getDimension(R.dimen.top_padding);

//        获取bool值
        boolean isFirstRun = resources.getBoolean(R.bool.is_first_run);

//        获取数组
        int[] colors = resources.getIntArray(R.array.colors);

//        获取字符串数组
        String[] names = resources.getStringArray(R.array.names);



    }
}
