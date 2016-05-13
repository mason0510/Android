package com.example.michael.c_;

import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText msgInput;
    private EditText to;
    private IntentFilter sendFilter;

    private SendStatusReceiver sendStatusReceiver;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        to = (EditText) findViewById(R.id.to);
        msgInput = (EditText) findViewById(R.id.msg_input);
        Button send = (Button) findViewById(R.id.send);
        sendFilter = new IntentFilter();
        sendFilter.addAction("SENT_SMS_ACTION");
        sendStatusReceiver = new SendStatusReceiver();
        registerReceiver(sendStatusReceiver, sendFilter);
        send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SmsManager smsManager = SmsManager.getDefault();
                Intent sentIntent = new Intent("SENT_SMS_ACTION");
                PendingIntent pi = PendingIntent.getBroadcast (MainActivity.this, 0, sentIntent, 0);
                smsManager.sendTextMessage(to.getText().toString(), null,
                        msgInput.getText().toString(), pi, null);
            }
        });



    }
    class SendStatusReceiver extends BroadcastReceiver {

        @Override
        public void onReceive(Context context, Intent intent) {
            if (getResultCode() == RESULT_OK) {
                // 短信发送成功
                Toast.makeText(context, "Send succeeded", Toast.LENGTH_LONG).show();
            } else {
                // 短信发送失败
                Toast.makeText(context, "Send failed", Toast.LENGTH_LONG).show();
            }
        }
    }
    @Override
    protected void onDestroy() {
        super.onDestroy();
       // unregisterReceiver(messageReceiver);
        unregisterReceiver(sendStatusReceiver);
    }
}
