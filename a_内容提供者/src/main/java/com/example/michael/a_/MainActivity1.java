package com.example.michael.a_;

import android.app.Activity;
import android.os.Bundle;
import android.widget.Button;

import com.example.michael.a_.myselfContentProvider.Code;

/**
 * Created by Michael on 2016/4/19.
 */
public class MainActivity1 extends Activity {

    private Button button1;
    private Button button2;
    private Button button3;
    private Button button4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button1 = (Button) findViewById(R.id.add_data);
        button2 = (Button) findViewById(R.id.delete_data);
        button3 = (Button) findViewById(R.id.update_data);
        button4 = (Button) findViewById(R.id.query_data);
        ButtonWork.onClick(button1,1);
        ButtonWork.onClick(button2,2);
        ButtonWork.onClick(button3,3);
        ButtonWork.onClick(button4,4);

    }
}
