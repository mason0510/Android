package com.example.michael.e_;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

/*
有别于后台服务
不会被回收 优先级高
 */
public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViewById(R.id.btn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // 打印主线程的id
                Log.d("MainActivity", "Thread id is " + Thread.currentThread(). getId());
                Intent intentService = new Intent(MainActivity.this, MyService.class);
                startService(intentService);
            }
        });
    }
}
