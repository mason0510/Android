package com.example.michael.a_.myselfContentProvider;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.content.UriMatcher;
import android.database.Cursor;
import android.net.Uri;
import android.support.annotation.Nullable;
import android.widget.Switch;

/**
 * Created by Michael on 2016/4/19.
 */
/*
content://com.example.app.provider/table1一个标准uri的写法。
或者是content://com.example.app.provider/table1/1
*任意字符
* #表示任意长度的数字
*
* content://com.example.app.provider/*
*
* content://com.example.app.provider/table1/#
*
* 自定义一个匹配器
*
 */
public class myprovider extends ContentProvider {
    public static final int TABLE1_DIR = 0;

    public static final int TABLE1_ITEM = 1;

    public static final int TABLE2_DIR = 2;

    public static final int TABLE2_ITEM = 3;

    private static UriMatcher uriMatcher;
    static {
        //不要添加隐私的uri
        uriMatcher=new UriMatcher(-1);//不匹配任何路径的返回码 程序员自己定义的 用于匹配器初始化
        uriMatcher.addURI("com.example.michael.a_.myselfContentProvider","table1",TABLE1_DIR);
        uriMatcher.addURI("com.example.michael.a_.myselfContentProvider","table/#",TABLE1_ITEM);
        uriMatcher.addURI("com.example.michael.a_.myselfContentProvider","table2",TABLE2_DIR);
        uriMatcher.addURI("com.example.michael.a_.myselfContentProvider","table2/#",TABLE2_ITEM);
    }

    @Override
    public boolean onCreate() {
        return false;
    }

    @Nullable
    @Override
    public Cursor query(Uri uri, String[] projection, String selection, String[] selectionArgs, String sortOrder) {
        switch(uriMatcher.match(uri)){//对传入的进行匹配
            case TABLE1_DIR:
                break;
            case TABLE1_ITEM:
                break;
            case TABLE2_DIR:
                break;
            case TABLE2_ITEM:
                break;
            default:
                break;
        }


        return null;
    }

    @Nullable
    @Override
    public String getType(Uri uri) {//它是所有的内容提供器都必须提供的一个方法，用于获取Uri对象所对应的MIME类型。
        /*
        标准写法
        1.必须以vnd开头。
    2.如果内容URI以路径结尾，则后接android.cursor.dir/，如果内容URI以id结尾，则后接android.cursor.item/。
    3.最后接上vnd.<authority>.<path>。


    content://com.example.app.provider/table1

    写法
    vnd.android.cursor.item/vnd.com.example.app.provider.table1
         */

        switch (uriMatcher.match(uri)) {
            case TABLE1_DIR:
                return "vnd.android.cursor.dir/vnd.com.example.app.provider. table1";
            case TABLE1_ITEM:
                return "vnd.android.cursor.item/vnd.com.example.app.provider. table1";
            case TABLE2_DIR:
                return "vnd.android.cursor.dir/vnd.com.example.app.provider. table2";
            case TABLE2_ITEM:
                return "vnd.android.cursor.item/vnd.com.example.app.provider. table2";
            default:
                break;

        }
        return null;
    }

    @Nullable
    @Override
    public Uri insert(Uri uri, ContentValues values) {
        return null;
    }

    @Override
    public int delete(Uri uri, String selection, String[] selectionArgs) {
        return 0;
    }

    @Override
    public int update(Uri uri, ContentValues values, String selection, String[] selectionArgs) {
        return 0;
    }
}
