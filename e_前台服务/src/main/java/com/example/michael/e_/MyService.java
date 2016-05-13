package com.example.michael.e_;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.util.Log;

/**
 * Created by Michael on 2016/4/22.
 */
public class MyService extends Service {

    private NotificationManager manager;

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }
/*
在此处关闭 stopself();
 */
    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        return super.onStartCommand(intent, flags, startId);
    }
/*
第一次创建的售后激活
 */
    @Override
    public void onCreate() {
        super.onCreate();
        manager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
        Notification.Builder builder=new Notification.Builder(getApplicationContext());
        builder.setContentTitle("通知");
        builder.setContentText("WO SHI通知");
        builder.setSmallIcon(R.drawable.icon);
        Intent i=new Intent(this,MainActivity.class);
        PendingIntent pendingIntent=PendingIntent.getActivity(this,0,i,0);
        builder.setContentIntent(pendingIntent);
        builder.setWhen(System.currentTimeMillis());
        manager.notify(1,builder.build());

      /*  Notification notification = new Notification(R.drawable.icon,
                "Notification comes", System. currentTimeMillis());
        Intent notificationIntent = new Intent(this, MainActivity.class);
        PendingIntent pendingIntent = PendingIntent.getActivity(this, 0, notificationIntent, 0);
       // notification.setLatestEventInfo(this, "This is title", "This is content", pendingIntent);
        notification.
        startForeground(1, notification);*/
        Log.d("MyService", "onCreate executed");
    }
}
