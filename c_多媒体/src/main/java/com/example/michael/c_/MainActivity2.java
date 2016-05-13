package com.example.michael.c_;

import android.app.Activity;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;
import java.io.File;

/**
 * Created by Michael on 2016/4/21.
 */
public class MainActivity2 extends AppCompatActivity implements View.OnClickListener{
    private Button play;

    private Button pause;

    private Button stop;

    private MediaPlayer mediaPlayer=new MediaPlayer();
    private File file;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        play = (Button) findViewById(R.id.play);
        pause = (Button) findViewById(R.id.pause);
        stop = (Button) findViewById(R.id.stop);
         play.setOnClickListener(this);
        pause.setOnClickListener(this);
        stop.setOnClickListener(this);
        initMediaPlayer();
      //  Toast.makeText(getApplicationContext(),"开放",Toast.LENGTH_LONG).show();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (mediaPlayer!=null){
            mediaPlayer.stop();
            mediaPlayer.release();
        }

        Toast.makeText(getApplicationContext(),"销毁",Toast.LENGTH_LONG).show();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.play:
                if (!mediaPlayer.isPlaying()){
                    mediaPlayer.start();
                    Toast.makeText(getApplicationContext(),"开始播放",Toast.LENGTH_LONG).show();
                }
                break;
            case R.id.pause:
                if (mediaPlayer.isPlaying()){
                    mediaPlayer.pause();
                    Toast.makeText(getApplicationContext(),"暂停播放",Toast.LENGTH_LONG).show();
                }
                break;
            case R.id.stop:
                if(mediaPlayer.isPlaying()){
                    mediaPlayer.reset();
                    Toast.makeText(getApplicationContext(),"停止播放",Toast.LENGTH_LONG).show();
                    initMediaPlayer();
                }
                break;
            default:
                break;
        }
    }

        void initMediaPlayer() {
        try {
            file = new File(Environment.getExternalStorageDirectory(), "qq.mp3");
            Log.d("MainActivity","准备播放");
            mediaPlayer.setDataSource(file.getPath()); // 指定音频文件的路径
            mediaPlayer.prepare(); // 让MediaPlayer进入到准备状态
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
