package com.example.lab06_3;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.telephony.SmsMessage;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Locale;

public class SmsReceiver extends BroadcastReceiver {
    public static final String SMS_FORWARD_BROADCAST_RECEIVER = "sms_forward_broadcast";
    public static final String SMS_MESSAGE_ADDRESS_KEY = "sms_messages_key";

    @Override
    public void onReceive(Context context, Intent intent){
        String queryString = "Are you OK?".toLowerCase();

        Bundle bundle = intent.getExtras();
        if(bundle != null){
            Object[] pdus = (Object[]) bundle.get("pdus");
            SmsMessage[] messages = new SmsMessage[pdus.length];
            for (int i = 0; i < pdus.length; i++){
                if(android.os.Build.VERSION.SDK_INT >= 23){
                    messages[i] = SmsMessage.createFromPdu((byte[]) pdus[i]);
                } else
                    messages[i] = SmsMessage.createFromPdu((byte[]) pdus[i]);
            }
            ArrayList<String> addresses = new ArrayList<>();

            for(SmsMessage message: messages){
                if(message.getMessageBody().toLowerCase().contains(queryString)){
                    addresses.add(message.getOriginatingAddress());
                    Toast.makeText(context, message.getMessageBody(), Toast.LENGTH_LONG).show();
                }
                else{
                    Toast.makeText(context, message.getMessageBody(), Toast.LENGTH_LONG).show();
                }
            }
            if(addresses.size() > 0){
                if(!MainActivity.isRunning){
                   // Toast.makeText(context, "ok", Toast.LENGTH_SHORT).show();
                    Intent iMainActivity = new Intent(context, MainActivity.class);
                    iMainActivity.putStringArrayListExtra(SMS_MESSAGE_ADDRESS_KEY, addresses);
                    iMainActivity.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK|Intent.FLAG_ACTIVITY_CLEAR_TOP);
                    context.sendBroadcast(iMainActivity);
                    context.startActivity(iMainActivity);
                }
                else {
                    Intent iForwardBroadcastReceiver = new Intent(SMS_FORWARD_BROADCAST_RECEIVER);
                    iForwardBroadcastReceiver.putStringArrayListExtra(SMS_MESSAGE_ADDRESS_KEY, addresses);
                    context.sendBroadcast(iForwardBroadcastReceiver);
                }
            }
        }
    }

}
