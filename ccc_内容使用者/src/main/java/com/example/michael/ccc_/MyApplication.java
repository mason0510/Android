package com.example.michael.ccc_;

import android.app.Application;
import android.content.Context;

/**
 * Created by Michael on 2016/4/20.
 */
public class MyApplication extends Application {
    private  static Context context;

    @Override
    public void onCreate() {
        super.onCreate();
        context=getApplicationContext();
    }

    public static Context getContext(){
        return context;
    }
}
