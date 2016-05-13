package com.example.michael.e_;

import android.content.Intent;
import android.util.Log;

/**
 * Created by Michael on 2016/4/22.
 */
public class IntentService extends android.app.IntentService {
    /**
     * Creates an IntentService.  Invoked by your subclass's constructor.
     *
     * @param name Used to name the worker thread, important only for debugging.
     */
    public IntentService() {
        super("IntentService");//
    }
/*
子类实现 在子线程运行 结束后自动停止
 */
    @Override
    protected void onHandleIntent(Intent intent) {
        Log.d("IntentService","当前的线程"+Thread.currentThread().getId());
    }
    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.d("MyIntentService", "onDestroy executed");
    }
}
