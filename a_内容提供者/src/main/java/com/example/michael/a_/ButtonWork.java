package com.example.michael.a_;

import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Switch;

import com.example.michael.a_.myselfContentProvider.Code;

/**
 * Created by Michael on 2016/4/19.
 */
public class ButtonWork {
    public static void onClick(Button button, final int code){
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switch (code){
                    case Code.add:
                        Log.d("ButtonWork","哈哈哈哈哈");
                        break;
                    case Code.delete:
                        break;
                    case Code.change:
                        break;
                    case Code.query:
                        break;
                    default:
                        break;
                }
            }
        });
    }
}
