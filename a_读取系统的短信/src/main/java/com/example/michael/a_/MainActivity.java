package com.example.michael.a_;

import android.app.Activity;
import android.content.ContentResolver;
import android.content.ContentValues;
import android.database.Cursor;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import java.text.SimpleDateFormat;
import java.util.Date;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ContentResolver contentResolver=this.getContentResolver();
        Uri uri=Uri.parse("content://sms");
        try {
            Thread.sleep(5500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        ContentValues contentValues=new ContentValues();
        contentValues.put("address", "95508");
/*        Date date=new Date();*/
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");//格式化后的时间
        contentValues.put("date",sdf.format(new Date().getTime()));
        contentValues.put("body","你消费了100元，余额100,000,000");
        contentValues.put("type","1");

        contentResolver.insert(uri,contentValues);





    }




    /*
    读取手机的短信内容：

     */
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
            cursor.close();
            Log.d("MainActivity","地址"+address+"日期"+date+"消息提"+body+"类型"+(type.equals("1")?"接收":"发送"));
        }

    }
}
