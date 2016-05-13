package com.example.michael.hhh;

import android.app.Activity;
import android.database.Cursor;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Michael on 2016/4/20.
 */
/*
读取联系人 读取成功。
 */
public class MainActivity1 extends Activity {
    List<String> list=new ArrayList<>();
    private ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listView = (ListView) findViewById(R.id.lv);
        ArrayAdapter<String> adapter=new ArrayAdapter<>(this,android.R.layout.simple_list_item_1,list);
        listView.setAdapter(adapter);
        readContract();
    }

    private void readContract() {
        Cursor cursor=null;
        cursor=getContentResolver().query(ContactsContract.CommonDataKinds.Phone.CONTENT_URI,null,null,null,null);
        while(cursor.moveToNext()){
            String name=cursor.getString(cursor.getColumnIndex(ContactsContract.CommonDataKinds.Phone.DISPLAY_NAME));
            String number=cursor.getString(cursor.getColumnIndex(ContactsContract.CommonDataKinds.Phone.NUMBER));
            list.add(name+"\n"+number);
            Log.d("MainActivity",""+list);
        }
        if (cursor!=null){
            cursor.close();
        }
    }
}
