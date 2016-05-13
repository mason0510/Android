package com.example.michael.a_;

import android.content.ContentResolver;
import android.database.Cursor;
import android.net.Uri;
import android.provider.ContactsContract;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private ListView listView;
    List<String> contractsList = new ArrayList();
    private Cursor cursor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }
}
    /* @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listView = (ListView) findViewById(R.id.contract_view);
        for (int i = 0; i <= 30; i++) {
            contractsList.add("打折促销" + i);
        }
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(getApplicationContext(), android.R.layout.simple_list_item_1, contractsList);
        listView.setAdapter(adapter);
        *//**/
   /*     内容提供者 读取系统联系人并返回
         */
        //getContentResolver();
     /*   readContracts();//读取成功了。*/
  /*  }*/

  /*  private String readContracts() {*/
  /*      cursor = getContentResolver().query(ContactsContract.CommonDataKinds.Phone.CONTENT_URI, null, null, null, null);
        Cursor cur = getContentResolver().query(Uri.parse("content://sms/"), null, null, null, "date desc");
        Log.d("MainActivity",cursor+"");*/


/*        try {
            while (cursor.moveToNext()) {*/
        //获取列名 获取值 接收返回值
     /*           String name=cursor.getString(cursor.getColumnIndex(ContactsContract.CommonDataKinds.Phone.DISPLAY_NAME));
                String number=cursor.getString(cursor.getColumnIndex(ContactsContract.CommonDataKinds.Phone.NUMBER));
                contractsList.add(name+"\n"+number);*/
/*                String number = cur.getString(cur.getColumnIndex("address"));//手机号
                String name = cur.getString(cur.getColumnIndex("person"));//联系人姓名列表
                String body = cur.getString(cur.getColumnIndex("body"));
                contractsList.add(name+"\n"+number+"\n"+body);*/

/*
                final String SMS_URI_ALL = "content://sms/";
                final String SMS_URI_INBOX = "content://sms/inbox";
                final String SMS_URI_SEND = "content://sms/sent";
                final String SMS_URI_DRAFT = "content://sms/draft";
                StringBuilder smsBuilder = new StringBuilder();

                try {
                    ContentResolver cr = getContentResolver();
                    String[] projection = new String[]{"_id", "address", "person",
                            "body", "date", "type"};
                    Uri uri = Uri.parse(SMS_URI_ALL);
                    Cursor cur = cr.query(uri, projection, null, null, "date desc");

                    if (cur.moveToFirst()) {
                        String name;
                        String phoneNumber;
                        String smsbody;
                        String date;
                        String type;

                        int nameColumn = cur.getColumnIndex("person");
                        int phoneNumberColumn = cur.getColumnIndex("address");
                        int smsbodyColumn = cur.getColumnIndex("body");
                        int dateColumn = cur.getColumnIndex("date");
                        int typeColumn = cur.getColumnIndex("type");

                        do {
                            name = cur.getString(nameColumn);
                            phoneNumber = cur.getString(phoneNumberColumn);
                            smsbody = cur.getString(smsbodyColumn);

                            SimpleDateFormat dateFormat = new SimpleDateFormat(
                                    "yyyy-MM-dd hh:mm:ss");
                            Date d = new Date(Long.parseLong(cur.getString(dateColumn)));
                            date = dateFormat.format(d);

                            int typeId = cur.getInt(typeColumn);
                            if (typeId == 1) {
                                type = "接收";
                            } else if (typeId == 2) {
                                type = "发送";
                            } else {
                                type = "";
                            }

                            smsBuilder.append("[");
                            smsBuilder.append(name + ",");
                            smsBuilder.append(phoneNumber + ",");
                            smsBuilder.append(smsbody + ",");
                            smsBuilder.append(date + ",");
                            smsBuilder.append(type);
                            smsBuilder.append("] ");

                            if (smsbody == null) smsbody = "";
                        } while (cur.moveToNext());
                    } else {
                        smsBuilder.append("no result!");
                    }

                    smsBuilder.append("getSmsInPhone has executed!");
                } catch (Exception ex) {
                    Log.d("SQLiteException in getSmsInPhone", ex.getMessage());
                }
                return smsBuilder.toString();
            }
    }
}
        }*/

/*
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            if(cursor!=null){
                cursor.close();
            }
        }*/

