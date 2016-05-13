package com.example.michael.databasetest;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private Button button;
    private MyDataBaseHelper myDataBaseHelper;
    private Button update;
    private Button add_data;
    private Button delete_data;
    private Button change_data;
    private Button query_data;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button = (Button) findViewById(R.id.button);//创建一张新表 获取一个可写的数据库
        update = (Button) findViewById(R.id.update);//更新一张表
        add_data = (Button) findViewById(R.id.add_data);//增加数据
        change_data = (Button) findViewById(R.id.change_date);
        delete_data = (Button) findViewById(R.id.delete_data);
        query_data = (Button) findViewById(R.id.query_data);
        myDataBaseHelper=new MyDataBaseHelper(this,"BookStore.db",null,2);//表示对数据哭进行升级会将所有的数据库删除 再重新走一遍oncreate方法
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myDataBaseHelper.getWritableDatabase();
                //产生两个表 一个临时 一个是为了支持表生成产生的临时文件
            }
        });
        update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myDataBaseHelper.getWritableDatabase();//更新表
            }
        });

//步骤 先获取对象 然后调用其方法 put方法进行放置 插入采用insert方法
        add_data.setOnClickListener(new View.OnClickListener() {//表示已经插入成功
            @Override
            public void onClick(View v) {
                SQLiteDatabase db=myDataBaseHelper.getWritableDatabase();
                ContentValues contentValues=new ContentValues();
                //开始组装数据
                contentValues.put("name","The Da Vinci Code");
                contentValues.put("author","Miachael");
                contentValues.put("pages","454");
                contentValues.put("price", "16.96");
                db.insert("Book", null, contentValues);//将数据清除 插入第二条
                contentValues.clear();
                contentValues.put("name","The Lost Symbol");
                contentValues.put("author","Miachael");
                contentValues.put("pages","510");
                contentValues.put("price", "19.95");
                db.insert("Book", null, contentValues);
                //向booke中插入两条数据
            }
        });
        //Button changedata = (Button) findViewById(R.id.change_data);
        change_data.setOnClickListener(new View.OnClickListener() {//将其中一部分数据替换掉 看到10.99表示成功
            @Override
            public void onClick(View v) {
                SQLiteDatabase db = myDataBaseHelper.getWritableDatabase();
                ContentValues values = new ContentValues();
                values.put("price", 10.99);
                //在哪里更改 名字是什么？
                db.update("Book", values, "name = ?", new String[] { "The Da Vinci Code" });
            }
        });


        Button deleteButton = (Button) findViewById(R.id.delete_data);
        deleteButton.setOnClickListener(new View.OnClickListener() {//将大于500页的书删除 看不到表明删除成功
            @Override
            public void onClick(View v) {
                SQLiteDatabase db = myDataBaseHelper.getWritableDatabase();
                db.delete("Book", "pages > ?", new String[]{"500"});//删除大于500页的数据
            }
        });



        /*
        查询里面的起个参数
        。这个方法的参数非常复杂，最短的一个方法重载也需要传入七个参数。

        那我们就先来看一下这七个参数各自的含义吧，第一个参数不用说，当然还是表名，表示我们希望从哪张表中查询数据。
        第二个参数用于指定去查询哪几列，如果不指定则默认查询所有列。
        第三、第四个参数用于去约束查询某一行或某几行的数据，不指定则默认是查询所有行的数据。
        第五个参数用于指定需要去group by的列，不指定则表示不对查询结果进行group by操作。
        第六个参数用于对group by之后的数据进行进一步的过滤，
        不指定则表示不进行过滤。第七个参数用于指定查询结果的排序方式，不指定则表示使用默认的排序方式。
         */

        Button queryButton = (Button) findViewById(R.id.query_data);//查询 稍微复杂
        queryButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SQLiteDatabase db = myDataBaseHelper.getWritableDatabase();
                // 查询Book表中所有的数据
                //查询那个表 哪一列 例如第一列
                Cursor cursor = db.query("Book",null, null, null, null, null,null);
                if (cursor.moveToFirst()) {
                    do {
                        // 遍历Cursor对象，取出数据并打印
                        String name = cursor.getString(cursor. getColumnIndex("name"));
                        String author = cursor.getString(cursor. getColumnIndex("author"));
                        int pages = cursor.getInt(cursor.getColumnIndex ("pages"));
                        double price = cursor.getDouble(cursor. getColumnIndex("price"));
                        Log.d("MainActivity", "book name is " + name);
                        Log.d("MainActivity", "book author is " + author);
                        Log.d("MainActivity", "book pages is " + pages);
                        Log.d("MainActivity", "book price is " + price);
                    } while (cursor.moveToNext());
                }//不要忘记指针

                cursor.close();
            }
        });

    }
}
