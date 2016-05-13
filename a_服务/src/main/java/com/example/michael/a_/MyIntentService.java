package com.example.michael.a_;

import android.app.IntentService;
import android.content.Intent;
import android.util.Log;

/**
 * Created by Michael on 2016/4/21.
 */
public class MyIntentService extends IntentService{


    /**
     * Creates an IntentService.  Invoked by your subclass's constructor.
     *
     * @param name Used to name the worker thread, important only for debugging.
     */
    public MyIntentService() {
        super("MyIntentService");
    }

    /*
    不用担心异常了 因为在子线程进行的
     */
    @Override
    protected void onHandleIntent(Intent intent) {
        Log.d("MyIntentService", "Thread id is " + Thread.currentThread(). getId());
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.d("MyIntentService", "onDestroy executed");
    }

}
