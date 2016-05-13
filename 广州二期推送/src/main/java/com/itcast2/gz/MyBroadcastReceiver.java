package com.itcast2.gz;

import org.json.JSONObject;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import cn.jpush.android.api.JPushInterface;

public class MyBroadcastReceiver extends BroadcastReceiver {
    private static final String TAG = "MyReceiver";
     
    @Override
    public void onReceive(Context context, Intent intent) {
         
        Bundle bundle = intent.getExtras();
        if (JPushInterface.ACTION_NOTIFICATION_OPENED.equals(intent.getAction())) {
            Log.d(TAG, "用户点击打开了通知");
            openNotification(context,bundle);
        } 
    }
 
   private void openNotification(Context context, Bundle bundle){
        String extras = bundle.getString(JPushInterface.EXTRA_EXTRA);
        String myValue = ""; 
        try {
        	//当前的url的值是由，极光推送的服务传递过来的，http://www.itheima.com
//        	{
//        		url:"http://www.itheima.com";
//        	}
            JSONObject extrasJson = new JSONObject(extras);
            myValue = extrasJson.optString("url");
            
        } catch (Exception e) {
            Log.w(TAG, "Unexpected: extras is not a valid json", e);
            return;
        }
        Intent mIntent = new Intent(context, ThisActivity.class);
        mIntent.putExtra("url", myValue);
        mIntent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        context.startActivity(mIntent);
    }
}