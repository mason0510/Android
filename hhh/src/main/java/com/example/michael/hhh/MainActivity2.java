package com.example.michael.hhh;

import android.app.Activity;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;

/**
 * Created by Michael on 2016/4/20.
 */
/*
读取手机短信
1.获取指针。
2.指向短信。
3.关闭指针。
 */
public class MainActivity2 extends Activity {

    private Uri uri;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        uri = Uri.parse("content://sms");
        readSMS();
    }

    private void readSMS() {
        Cursor cursor=null;
        /*
        定义查询的内容
         */
        cursor=getContentResolver().query(uri,new String[]{"address","date","body","type"},null,null,null);
        while(cursor.moveToNext()){
            String address=cursor.getString(cursor.getColumnIndex("address"));
            String date=cursor.getString(cursor.getColumnIndex("date"));
            String body=cursor.getString(cursor.getColumnIndex("body"));
            String type=cursor.getString(cursor.getColumnIndex("type"));
            Log.d("MainActivity2","地址"+address+"日期"+date+"消息是"+body+(type.equals("1")?"发送方":"接收方"));
        }
        if(cursor!=null){
            cursor.close();
        }
    }
}
