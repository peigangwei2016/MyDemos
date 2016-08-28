package com.sunny.mydemos;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by Administrator on 2016/8/28.
 */
public class OtherActivity extends Activity {
    private TextView mTextView;
    private Button mButton;
    private Intent mIntent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_other);
        mButton = (Button) findViewById(R.id.return_button);
        mTextView = (TextView) findViewById(R.id.textView);
//        获取传递过来的值
        mIntent = getIntent();
        if (mIntent != null) {
            String name = mIntent.getStringExtra("name");
            String data = mIntent.getDataString();

            Toast.makeText(OtherActivity.this, data, Toast.LENGTH_SHORT).show();
        }

        mButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                设置Activity的返回值
                mIntent.putExtra("name","Hi Sunny!");

                setResult(4321,mIntent);
                finish();

            }
        });

    }
}
