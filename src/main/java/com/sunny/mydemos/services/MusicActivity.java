package com.sunny.mydemos.services;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.sunny.mydemos.R;

/**
 * Created by Administrator on 2016/9/3.
 */
public class MusicActivity extends Activity {
    private android.widget.Button butStartPlay;
    private android.widget.Button butPusePlay;
    private android.widget.Button butStopPaly;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_music);
        this.butStopPaly = (Button) findViewById(R.id.butStopPaly);
        this.butPusePlay = (Button) findViewById(R.id.butPusePlay);
        this.butStartPlay = (Button) findViewById(R.id.butStartPlay);

        butStartPlay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MusicActivity.this,MusicService.class);
                intent.putExtra("action",MusicService.ACTION_START);
                startService(intent);

            }
        });

        butPusePlay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MusicActivity.this,MusicService.class);
                intent.putExtra("action",MusicService.ACTION_PAUSE);
                startService(intent);
            }
        });

        butStopPaly.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MusicActivity.this,MusicService.class);
                intent.putExtra("action",MusicService.ACTION_STOP);
                startService(intent);
            }
        });
    }
}
