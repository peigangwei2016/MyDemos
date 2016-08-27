package com.sunny.mydemos;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.LinearLayout;

public class MainActivity extends Activity {


    private String TAG = "MainActivity";

    private Button addBut;
    private LinearLayout ll;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        addBut = (Button) findViewById(R.id.add_but);
        ll = (LinearLayout) findViewById(R.id.ll);


        addBut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                新建一个Button
                Button button = new Button(MainActivity.this);
                button.setText("我是新添加的Button");
//              将新建的Button添加到LinerLayout中
                ll.addView(button, WindowManager.LayoutParams.MATCH_PARENT, WindowManager.LayoutParams.WRAP_CONTENT);

//                button.clearFocus();
////                LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT);
////                button.setLayoutParams(params);
//                WindowManager windowManager = getWindowManager();
//
//                WindowManager.LayoutParams params = new WindowManager.LayoutParams();
//                params.width= WindowManager.LayoutParams.MATCH_PARENT;
//                params.height= WindowManager.LayoutParams.WRAP_CONTENT;
//                params.x=0;
//                params.y=0;
//                windowManager.addView(button,params);
            }
        });

    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.i(TAG, "onDestroy: ");
    }


}
