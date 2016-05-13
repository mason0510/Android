package com.example.michael.hhh;

import android.content.ContentResolver;
import android.content.ContentValues;
import android.net.Uri;
import android.provider.ContactsContract;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import java.util.Date;

/*
向系统中插入短信
address  date body type
1代表发送 2代表接收
 */
public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ContentResolver contentResolver=this.getContentResolver();
        ContentValues contentValues=new ContentValues();
        Uri uri=Uri.parse("content://sms");
        try {
            Thread.sleep(5000);//
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        contentValues.put("address","110");
        contentValues.put("date",new Date().getTime());
        contentValues.put("body","你银行卡消费50000");
        contentValues.put("type","1");
        contentResolver.insert(uri, contentValues);
        Toast.makeText(getApplicationContext(),"插入成功",Toast.LENGTH_LONG).show();
    }
}
