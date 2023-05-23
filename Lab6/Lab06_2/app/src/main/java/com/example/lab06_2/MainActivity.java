package com.example.lab06_2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        IntentFilter filter = new IntentFilter();
        filter.addAction("android.intent.action.ACTION_POWER_CONNECTED");
        filter.addAction("android.intent.action.ACTION_POWER_DISCONNECTED");

        BroadcastReceiver receiver = new BroadcastReceiver() {

            @Override
            public void onReceive(Context context, Intent intent) {
                if(context==null)
                    return;
                if(intent.getAction().equals(Intent.ACTION_POWER_CONNECTED)){
                    Toast.makeText(context, "Power connected", Toast.LENGTH_LONG).show();
                }
                if(intent.getAction().endsWith(Intent.ACTION_POWER_DISCONNECTED)){
                    Toast.makeText(context, "Power disconnected", Toast.LENGTH_LONG).show();
                }
            }
        };
        registerReceiver(receiver, filter);
    }
}
