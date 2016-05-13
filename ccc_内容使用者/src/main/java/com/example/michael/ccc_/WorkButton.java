package com.example.michael.ccc_;

import android.content.ContentValues;
import android.net.Uri;
import android.view.View;
import android.widget.Button;

/**
 * Created by Michael on 2016/4/20.
 */
public class WorkButton {

    private static ContentValues contentValues;
    private static Uri uri;

    public static void onClick(Button button, final int code){
        uri = Uri.parse("content://.provider/book");
        contentValues = new ContentValues();
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switch (code){
                    case 1:
                    contentValues.put("name","A clash of Kings");
                    contentValues.put("author","乔治");
                    contentValues.put("pages",1040);
                    contentValues.put("price", 22.85);
                        Uri newUri =MyApplication.getContext().getContentResolver().insert(uri, contentValues);
                        try {
                            //获取返回的id
                            String newId=newUri.getPathSegments().get(1);
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                        break;
                    case 2:
                        break;
                    case 3:
                        break;
                    case 4:
                        break;
                }
            }
        });
    }
}
