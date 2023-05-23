package com.example.lab06_1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Build;
import android.os.Bundle;
import android.telephony.SmsMessage;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private BroadcastReceiver broadcastReceiver = null;
    private IntentFilter filter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initBroadcastReceiver();
    }
    public void processReceive(Context context, Intent intent){
        Toast.makeText(context, "Hey! You have a new message", Toast.LENGTH_LONG).show();

        TextView tvContent = (TextView) findViewById(R.id.tv_content);

        final String SMS_EXTRA = "pdus";
        Bundle bundle = intent.getExtras();
        String sms = "";

        Object[] messages = (Object[]) bundle.get(SMS_EXTRA);

        SmsMessage smsMsg;
        for (int i = 0; i < messages.length; i++) {
            if (android.os.Build.VERSION.SDK_INT >= 23) {
                smsMsg = SmsMessage.createFromPdu((byte[]) messages[i]);
            } else {
                smsMsg = SmsMessage.createFromPdu((byte[]) messages[i]);
            }

            String msgBody = smsMsg.getMessageBody();
            String address = smsMsg.getDisplayOriginatingAddress();
            sms += address + ":\n" + msgBody + "\n";
        }
        tvContent.setText(sms);
    }
    private void initBroadcastReceiver(){
        filter = new IntentFilter("android.provider.Telephony.SMS_RECEIVED");

        broadcastReceiver = new BroadcastReceiver() {
            @Override
            public void onReceive(Context context, Intent intent) {
                processReceive(context, intent);
            }
        };
    }
    @Override
    protected void onResume(){
        super.onResume();

        if(broadcastReceiver == null)
            initBroadcastReceiver();

        registerReceiver(broadcastReceiver, filter);
    }
    @Override
    protected void onStop(){
        super.onStop();

        unregisterReceiver(broadcastReceiver);
    }
}