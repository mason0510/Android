package com.example.michael.a_;

import android.app.Activity;
import android.content.ContentResolver;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;

/**
 * Created by Michael on 2016/4/20.
 */
public class MainActivity1 extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ContentResolver contentResolver=this.getContentResolver();
        Uri uri=Uri.parse("content://sms");
        readSMS(contentResolver,uri);

    }
    private void readSMS(ContentResolver contentResolver,Uri uri){
        /*
        增删改查
         */
        /*
        返回一个结果集
         */
        Cursor cursor=contentResolver.query(uri, new String[]{"address", "date", "body", "type"}, null, null, null);
        while (cursor.moveToNext()){
            String address=cursor.getString(0);
            String date=cursor.getString(1);
            String body=cursor.getString(2);
            String type=cursor.getString(3);
            Log.d("MainActivity", "地址" + address + "日期" + date + "消息提" + body + "类型" + (type.equals("1") ? "接收" : "发送"));
        }
        cursor.close();
    }
}
