package com.example.michael.c_;

import android.app.Activity;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import java.io.File;
import java.io.IOException;

/**
 * Created by Michael on 2016/4/21.
 */
public class MainActivity1 extends AppCompatActivity{

    private Button btn1;
    private Button btn2;
    private Button btn3;
    private File file;
    private MediaPlayer mediaPlayer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
       // btn1 = (Button) findViewById(R.id.play);
        //btn2 = (Button) findViewById(R.id.pause);
       // btn3 = (Button) findViewById(R.id.stop);
        mediaPlayer = new MediaPlayer();
        //init();


        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(mediaPlayer.isPlaying()){
                    mediaPlayer.start();
                }

            }
        });
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mediaPlayer.isPlaying()){
                    mediaPlayer.pause();
                }
            }
        });
        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(mediaPlayer.isPlaying()){
                    mediaPlayer.reset();
                    //init();//为下次做准备
                }
            }
        });


        /*
        准备 播放 暂停 停止
         */
/*
初始化播放器
 */


    }

    private void initMediaPlayer() {
        file = new File(Environment.getExternalStorageDirectory(),"qq.mp3");
        try {
            mediaPlayer.setDataSource(file.getPath());//指定路径。或者网络地址等等。
            mediaPlayer.prepare();
            Log.d("MainActivity","准备播放");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (mediaPlayer!=null){
            mediaPlayer.stop();//销毁对象并释放资源
            mediaPlayer.release();//销毁对象。
        }
    }
    //@Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.play:
                if (!mediaPlayer.isPlaying()) {
                    mediaPlayer.start(); // 开始播放
                }
                break;
            case R.id.pause:
                if (mediaPlayer.isPlaying()) {
                    mediaPlayer.pause(); // 暂停播放
                }
                break;
            case R.id.stop:
                if (mediaPlayer.isPlaying()) {
                    mediaPlayer.reset(); // 停止播放
                    initMediaPlayer();
                }
                break;
            default:
                break;
        }
    }

}
