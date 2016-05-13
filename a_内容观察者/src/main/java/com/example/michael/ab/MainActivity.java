package com.example.michael.ab;

import android.content.ContentResolver;
import android.database.ContentObserver;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //如果无数据库则创建数据库

//获取内容解决这
        ContentResolver contentResolver=this.getContentResolver();
        //解析口令
        Uri uri=Uri.parse("content://father/son");
        //向中介注册 这就是有名的短信窃听器 可以获取 利用handler哈哈信息 接口回调
       /* contentResolver.registerContentObserver(uri, false, new ContentObserver(new android.os.Handler()) {
            @Override
            public void onChange(boolean selfChange) {
                //我检测到你的信息了
                Toast.makeText(getApplicationContext(),"内容发布者，我检测到你测信息了",Toast.LENGTH_LONG).show();
                Log.d("MainActivity","插入数据了");
                super.onChange(selfChange);
                //这里就获取到了信息 四个字段 address/body/type/data
                //发送短信到对方的手机中。

            }
        });*/
        //内容变化的时候立刻回调。 传一个处理器 不全匹配
        contentResolver.registerContentObserver(uri,true,new ABC(new Handler()));
    }
    /**
     * 有名内部类 含参数的构造
     */
    private class ABC extends ContentObserver{
        public ABC(Handler handler) {
            super(handler);
        }
        /**
         * 一旦应用A向数据库表插入记录时，中介会回调ABC对象以下面这个方法
         */
        @Override
        public void onChange(boolean selfChange) {
            System.out.println("24号，你插入了一条记录，别a我，我d到了");
            Log.d("MainActivity", "插入数据了");

            //NO1)如果能够获取sms表中的address/body/type/date的四个字段
            //NO2)发送短信到对方手机号中
            //上述就是有名的短信窃听器

        }
    }
    //先部署观察者？？？？对
}
