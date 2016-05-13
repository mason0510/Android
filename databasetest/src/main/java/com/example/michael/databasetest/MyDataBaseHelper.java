package com.example.michael.databasetest;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;
import android.widget.Toast;

/**
 * Created by Michael on 2016/4/17.
 */
/*
内置 的数据库是如何工作的
 */


    /*
    integer表示整型，real表示浮点型，text表示文本类型，blob表示二进制类型
    将id设为主键 并且是可以自动增长的
     */


//两个抽象方法 留给子类实现
//两个重要的实例方法 获取可读的数据库和可写 的数据库
    /*
    数据库写满时 可写de数据库出现异常
     */
public class MyDataBaseHelper extends SQLiteOpenHelper {


    public static final String CREATE_BOOK="create table Book (\n"+
            "    id integer primary key autoincrement,\n"+
            "    author text,\n"+
            "    price real,\n"+
            "    pages integer,\n"+
            "    name text)";
    public static final String CREATE_CATEGORY="create table Category (\n" +
            "    \tid integer primary key autoincrement,\n" +
            "    \tcategory_name text,\n" +
            "    \tcategory_code integer)";
 /*
 上下文
 名字游标工厂 数据库表明
 自定义指针
1.0 用于对数据库的升级
  */
    private Context mContext;
    public MyDataBaseHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
        mContext=context;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_BOOK);//执行本条语句
        db.execSQL(CREATE_CATEGORY);//创建另一张表
        Log.d("MyDataBaseHelper","创建");
        Toast.makeText(mContext,"成功创建了表",Toast.LENGTH_LONG).show();

    }
//如果不是1就将其删除
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("drop table if exists Book");
        db.execSQL("drop table if exists Category");
        onCreate(db);

    }
}
