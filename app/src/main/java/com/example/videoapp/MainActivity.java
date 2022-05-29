package com.example.videoapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.View;
import android.widget.Button;
import android.widget.SeekBar;

public class MainActivity extends AppCompatActivity {
    private Button Play;
    private Button Pause;
    private SurfaceView surfaceView;
    private MediaPlayer media;
    private SeekBar seekBar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        surfaceView=findViewById(R.id.surfaceView);
        Play=findViewById(R.id.Play);
        Pause=findViewById(R.id.Pause);
        seekBar=findViewById(R.id.seekBar);
        media=MediaPlayer.create(this,R.raw.video);
        surfaceView.setKeepScreenOn(true);
        SurfaceHolder holder= surfaceView.getHolder();
        Play.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                media.start();
            }
        });
        Pause.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                media.pause();
            }
        });
        holder.addCallback(new SurfaceHolder.Callback() {
            @Override
            public void surfaceCreated(@NonNull SurfaceHolder surfaceHolder) {
                media.setDisplay(surfaceHolder);
            }

            @Override
            public void surfaceChanged(@NonNull SurfaceHolder surfaceHolder, int i, int i1, int i2) {

            }

            @Override
            public void surfaceDestroyed(@NonNull SurfaceHolder surfaceHolder) {

            }
        });
        seekBar.setMax(media.getDuration());
        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                if(fromUser)
                {
                    media.seekTo(progress);
                }
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

    }
}
