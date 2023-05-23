package com.example.bai02;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        EditText etName = (EditText) findViewById(R.id.et_name);
        final TextView tvSelection = (TextView) findViewById(R.id.tv_selection);
        ListView lvPerson = (ListView) findViewById(R.id.lv_person);
        //final String arr[]={};
        //Tao ArryList object
        ArrayList<String> names = new ArrayList<String>();
        //names.add("Teo");
        //names.add("Ty");
        //names.add("Bin");
        //names.add("Bo");

        ArrayAdapter<String>adapter=new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, names);
        lvPerson.setAdapter(adapter);

        Button btnEnter=(Button) findViewById(R.id.btn_Enter);
        btnEnter.setOnClickListener(new View.OnClickListener() {
            public void onClick(View arg0){
                names.add(etName.getText().toString());
                etName.setText("");
                adapter.notifyDataSetChanged();
            }
        });

        lvPerson.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick (AdapterView<?>arg0, View arg1, int arg2, long arg3){
                tvSelection.setText("postion: " + arg2 + ", value=" + names.get(arg2));
            }
        });

        lvPerson.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> arg0, View arg1, int arg2, long arg3) {
                names.remove(arg2);
                adapter.notifyDataSetChanged();
                return false;
            }
        });
    }
}