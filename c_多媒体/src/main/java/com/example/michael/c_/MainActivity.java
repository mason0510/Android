package com.example.michael.c_;

import android.content.DialogInterface;
import android.media.MediaPlayer;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.io.File;

/*
播放手机音乐
播放视频
 */
public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private Button play;

    private Button pause;

    private Button stop;

    private MediaPlayer mediaPlayer = new MediaPlayer();

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
        initMediaPlayer(); // 初始化MediaPlayer

    }

    private void initMediaPlayer() {
        try {
            File file = new File(Environment.getExternalStorageDirectory(), "qq.mp3");
            Log.d("MainActivity","准备播放");
            mediaPlayer.setDataSource(file.getPath()); // 指定音频文件的路径
            mediaPlayer.prepare(); // 让MediaPlayer进入到准备状态
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.play:
                if (!mediaPlayer.isPlaying()) {
                    mediaPlayer.start(); // 开始播放
                    Toast.makeText(getApplicationContext(),"开放",Toast.LENGTH_LONG).show();
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

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (mediaPlayer != null) {
            mediaPlayer.stop();
            mediaPlayer.release();
        }
    }
}
