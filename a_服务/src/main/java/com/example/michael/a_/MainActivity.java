package com.example.michael.a_;

import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

/*
开启了服务 并传递了一个东西过去
 */
/*
构建
create
 */
public class MainActivity extends AppCompatActivity {

    private Button button1;
    private Button button2;
    private Button button3;
    private Button button4;
    private Button button5;
    private Intent binfIntent;

    private MyService.DownloadBinder downloadBinder;
    private ServiceConnection conn=new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName name, IBinder service) {
            //链接对象
            downloadBinder=(MyService.DownloadBinder)service;
            downloadBinder.startDownload();
            downloadBinder.getProgress();
        }

        @Override
        public void onServiceDisconnected(ComponentName name) {
            Log.d("MainActivity","服务没链接上");
        }
    };



    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button1 = (Button) findViewById(R.id.btn1);
        button2 = (Button) findViewById(R.id.btn2);
        button3= (Button) findViewById(R.id.bind_service);
        button4= (Button) findViewById(R.id.unbind_service);
        button5= (Button) findViewById(R.id.start_intent_service);


        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MainActivity.this,MyService.class);
                startService(intent);
            }
        });
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MainActivity.this,MyService.class);
                stopService(intent);
            }
        });
        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                binfIntent = new Intent(MainActivity.this,MyService.class);
            //表示自动创建服务
                /*
                oncreate

                 */
                bindService(binfIntent,conn,BIND_AUTO_CREATE);
            }
        });
        button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                unbindService(conn);
            }
        });

            button5.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intentservice=new Intent(getApplicationContext(),MyIntentService.class);
                    startService(intentservice);
                    Log.d("MainActivity", "Thread id is " + Thread.currentThread(). getId());
                }
            });

    }
}
