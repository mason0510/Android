package com.example.michael.bbb;

import android.database.Cursor;
import android.provider.ContactsContract;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    List<String> list=new ArrayList<>();
    private ListView listView;
    private Cursor cursor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        /*
        读取手机系统联系人的步骤
        1.适配器。
        2.两个布局。
        3.数据。读取数据
         */
        listView = (ListView)findViewById(R.id.lv);
        ArrayAdapter adapter=new ArrayAdapter(MainActivity.this,android.R.layout.simple_list_item_1,list);
        listView.setAdapter(adapter);
        readContract();
    }

    private void readContract() {
        /*
        1.获取指针
        2.便利指针
        3.取值
        4.关闭指针
         */
        Cursor cursor=null;
        cursor = this.getContentResolver().query(ContactsContract.CommonDataKinds.Phone.CONTENT_URI,null,null,null,null);
        while(cursor.moveToNext()){
            String name=cursor.getString(cursor.getColumnIndex(ContactsContract.CommonDataKinds.Phone.DISPLAY_NAME));
            String number=cursor.getString(cursor.getColumnIndex(ContactsContract.CommonDataKinds.Phone.NUMBER));
            list.add(name+"\n"+number);
        }
        if (cursor!=null){
            cursor.close();
        }

    }


}
