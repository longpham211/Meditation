package com.engineer.lup.meditation;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;


public class MeditationActivity extends AppCompatActivity {

    int minutes;
    MediaPlayer mPlayer;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_meditation);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        Intent intent = getIntent();
        minutes = intent.getIntExtra("minutes", 45);
        mPlayer = MediaPlayer.create(MeditationActivity.this, R.raw.xathien);
        if(mPlayer == null){
            Log.e("MediatationActivity", "create mPlayer failed");
        }
        else{
            mPlayer.setOnSeekCompleteListener(new MediaPlayer.OnSeekCompleteListener() {
                @Override
                public void onSeekComplete(MediaPlayer mp) {
                    mPlayer.stop();
                    mPlayer.release();
                }
            });
            mPlayer.start();
        }


    }

    @Override
    public void onDestroy(){
        mPlayer.stop();
        super.onDestroy();
    }
}
