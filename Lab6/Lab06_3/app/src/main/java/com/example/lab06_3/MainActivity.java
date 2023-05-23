package com.example.lab06_3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.os.Build;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.telephony.SmsMessage;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.concurrent.locks.ReentrantLock;

public class MainActivity extends AppCompatActivity {

    private ReentrantLock reentrantLock;
    private Switch swAutoResponse;
    private LinearLayout llButtons;
    private Button btnSafe, btnMayday;
    private ArrayList<String> requesters;
    private ArrayAdapter<String> adapter;
    private ListView lvMessages;
    private BroadcastReceiver broadcastReceiver;
    public static boolean isRunning;
    private SharedPreferences.Editor editor;
    private SharedPreferences sharedPreferences;
    private final String AUTO_RESPONSE = "auto_response";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViewsByIds();
        initVariables();
        handleOnClickListenner();

        Intent intent = getIntent();
        /*if(intent.getFlags() == Intent.FLAG_ACTIVITY_NEW_TASK && intent.getFlags() == Intent.FLAG_ACTIVITY_CLEAR_TOP)
        {*/
        ArrayList<String> addresses = getIntent().getStringArrayListExtra(SmsReceiver.SMS_MESSAGE_ADDRESS_KEY);
        if(addresses == null || addresses.size() < 1)
        {
        }
        // Process these addresses
        else
            processReceiveAddresses(addresses);
    }
    private void findViewsByIds() {
        swAutoResponse = (Switch) findViewById(R.id.sw_auto_response);
        llButtons = (LinearLayout) findViewById(R.id.ll_buttons);
        lvMessages = (ListView) findViewById(R.id.lv_messages);
        btnSafe = (Button) findViewById(R.id.btn_safe);
        btnMayday = (Button) findViewById(R.id.btn_mayday);
    }
    private void respond(String to, String response){
        reentrantLock.lock();
        requesters.remove(to);
        adapter.notifyDataSetChanged();
        reentrantLock.unlock();

        SmsManager sms = SmsManager.getDefault();
        sms.sendTextMessage(to, null, response, null, null);
    }
    public void respond(boolean ok){
        String okString = getString(R.string.i_am_safe_and_well_worry_not);
        String notOkString = getString(R.string.tell_my_mother_i_love_her);
        String outputString = ok ? okString: notOkString;
        ArrayList<String> requestersCopy = (ArrayList<String>) requesters.clone();
        for(String to : requestersCopy)
            respond(to, outputString);
    }
    public void processReceiveAddresses(ArrayList<String> addresses){
        for(int i = 0; i < addresses.size(); i++){
            if(!requesters.contains(addresses.get(i))){
                reentrantLock.lock();
                requesters.add(addresses.get(i));
                adapter.notifyDataSetChanged();
                reentrantLock.unlock();
            }
            if(swAutoResponse.isChecked())
                respond(true);
        }
    }
    private void handleOnClickListenner() {
// Handle onClickListenner
        btnSafe.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                respond(true);
            }
        });
        btnMayday.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                respond(false);
            }
        });
        swAutoResponse.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) llButtons.setVisibility(View.GONE);
                else llButtons.setVisibility(View.VISIBLE);
// Save auto response setting
                editor.putBoolean(AUTO_RESPONSE, isChecked);
                editor.commit();
            }
        });
    }
    private  void initBroadcastReceiver(){
        broadcastReceiver = new BroadcastReceiver() {
            @Override
            public void onReceive(Context context, Intent intent) {
                ArrayList<String> addresses = intent.getStringArrayListExtra(SmsReceiver.SMS_MESSAGE_ADDRESS_KEY);
                processReceiveAddresses(addresses);
            }
        };
    }
    @Override
    protected void onResume() {
        super.onResume();
        isRunning = true;
// Make sure broadcastReceiver was inited
        if (broadcastReceiver == null) initBroadcastReceiver();
// RegisterReceiver
        IntentFilter intentFilter = new IntentFilter(SmsReceiver.SMS_FORWARD_BROADCAST_RECEIVER);
        registerReceiver(broadcastReceiver, intentFilter);
    }
    @Override
    protected void onStop() {
        super.onStop();
        isRunning = false;
// UnregisterReceiver
        unregisterReceiver(broadcastReceiver);
    }
    private void initVariables(){
        sharedPreferences = getPreferences(MODE_PRIVATE);
        editor = sharedPreferences.edit();
        reentrantLock = new ReentrantLock();
        requesters = new ArrayList<String>();
        adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, requesters);
        lvMessages.setAdapter(adapter);

        boolean autoResponse = sharedPreferences.getBoolean(AUTO_RESPONSE, false);
        swAutoResponse.setChecked(autoResponse);
        if(autoResponse)
            llButtons.setVisibility(View.GONE);
        initBroadcastReceiver();


    }
}