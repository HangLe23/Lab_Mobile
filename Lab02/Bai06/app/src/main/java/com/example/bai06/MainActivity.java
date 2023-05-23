package com.example.bai06;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    EditText editID;
    EditText editName;
    CheckBox cbManager;
    RecyclerView recyclerView;
    ArrayList<Employee>arr;
    EmployeeAdapter adapter;
    Button btnAdd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editID = findViewById(R.id.et_ID);
        editName = findViewById(R.id.et_FullName);
        cbManager = findViewById(R.id.cb_manager);
        recyclerView = findViewById(R.id.Recyclerview);
        btnAdd = findViewById(R.id.btn_Add);

        arr = new ArrayList<Employee>();
        adapter = new EmployeeAdapter(this, arr);
        recyclerView.setAdapter(adapter);

        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(editName.getText().toString() + ""!= ""
                        && editID.getText().toString()+ "" != ""){
                    addnew();
                } else return;
            }
        });

    }
    protected void addnew(){
        String name = editName.getText().toString();
        String id = editID.getText().toString();
        Employee employee = new Employee();
        if (cbManager.isChecked()){
            employee.setId(id);
            employee.setName(name);
            employee.setManager(true);
        } else {
            employee.setId(id);
            employee.setName(name);
            employee.setManager(false);
        }
        arr.add(employee);
        adapter.notifyDataSetChanged();
        editName.setText("");
        editID.setText("");
        cbManager.setChecked(false);
        Toast.makeText(MainActivity.this, "Added Successfully", Toast.LENGTH_SHORT).show();
    }
}