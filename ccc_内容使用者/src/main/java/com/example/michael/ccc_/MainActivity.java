package com.example.michael.ccc_;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;

/*
内容使用者
增删改查
 */
public class MainActivity extends AppCompatActivity {

    private Button btn1;
    private Button btn2;
    private Button btn3;
    private Button btn4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn1 = findViewById(R.id.btn1);
        btn2 = findViewById(R.id.btn2);
        btn3 = findViewById(R.id.btn3);
        btn4 = findViewById(R.id.btn4);
        WorkButton.onClick(btn1,1);
        WorkButton.onClick(btn2,2);
        WorkButton.onClick(btn3,3);
        WorkButton.onClick(btn4,4);
    }
}
