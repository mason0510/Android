package cn.it.homework6.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;

public class DBHelper extends SQLiteOpenHelper {

	private static final int VERSION =1;//数据库版本 

	public DBHelper(Context context) {
		super(context, "itcast.db", null, VERSION);
	}

	@Override
	public void onCreate(SQLiteDatabase db) {
		//创建用户表  创建 笔记表
		db.execSQL("create table t_diary(_id integer primary key autoincrement , title text,content text)");

	}
    //数据库版本更新时，回调该方法
	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		System.out.println("onUpgrade");
		db.execSQL("drop table  if exists t_diary");
		onCreate(db);
	}

}
