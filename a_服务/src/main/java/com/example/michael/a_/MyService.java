package com.example.michael.a_;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.os.Binder;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.util.Log;

/**
 * Created by Michael on 2016/4/21.
 */
public class MyService extends Service {
    private Context context;
    private DownloadBinder mbinder=new DownloadBinder();
    //绑定一个意图 然后结束
    class DownloadBinder extends Binder{
        protected int getProgress(){
            Log.d("MyService", "getProgress executed");
            return 0;
        }
        public void startDownload(){
            Log.d("MyService", "startDownload executed");
        }
    }



/*

获取实例的方法
 */
    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return mbinder;
    }


    @Override
    public void onCreate() {
        super.onCreate();
        Notification.Builder builder=new Notification.Builder(getApplicationContext());
        builder.setAutoCancel(true);
        builder.setContentTitle("通知");
        builder.setSmallIcon(R.drawable.aaa);
        builder.setContentText("我是一个通知");
        Intent intent=new Intent(this,MyService.class);
        PendingIntent pendingIntent=PendingIntent.getActivity(this,0,intent,0);
        builder.setContentIntent(pendingIntent);
        NotificationManager manager= (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
        manager.notify(0,builder.build());
        Log.d("MyService", "onCreate executed");
    }

    public MyService() {
            super();


/*
先走的这个方法
 */

        Log.d("MyService","创建服务");
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Log.d("MyService", "onStartCommand executed");
       /*
       就会直接执行
        */
        new Thread(new Runnable() {
            @Override
            public void run() {
            stopSelf();
            }
        });






        return super.onStartCommand(intent, flags, startId);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.d("MyService", "onDestroy executed");
    }
}
