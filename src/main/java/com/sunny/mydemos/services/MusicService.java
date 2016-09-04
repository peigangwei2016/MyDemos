package com.sunny.mydemos.services;

import android.app.Service;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.IBinder;

import com.sunny.mydemos.R;

/**
 * Created by Administrator on 2016/9/3.
 */
public class MusicService extends Service {
    MediaPlayer mMediaPlayer;

    public static final int ACTION_START  = 1;
    public static final int ACTION_PAUSE = 2;
    public static final int ACTION_STOP  = 3;
    @Override
    public void onCreate() {
        super.onCreate();
//        mMediaPlayer=MediaPlayer.create(this, R.raw.may);
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        if (intent != null) {
            int action = intent.getIntExtra("action",0);
            if (action != 0 && mMediaPlayer != null) {
                switch (action){
                    case ACTION_START:
                        mMediaPlayer.start();

                        break;
                    case ACTION_PAUSE:
                        mMediaPlayer.pause();
                        break;
                    case ACTION_STOP:
                        mMediaPlayer.release();
                        mMediaPlayer=null;
                        break;
                }

            }

        }
        return super.onStartCommand(intent, flags, startId);
    }

    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }
}
