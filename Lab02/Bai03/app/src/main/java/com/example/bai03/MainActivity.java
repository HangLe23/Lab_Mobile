package com.example.bai03;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.RadioGroup;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    RadioGroup rg;
    EditText editId;
    EditText editName;
    Button btnNhap;
    ListView lvNhanvien;
    Employee employee = null;
    ArrayList<Employee> arrEmployee = new ArrayList<Employee>();
    ArrayAdapter<Employee> adapter = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editId = (EditText) findViewById(R.id.et_maNV);
        editName = (EditText) findViewById(R.id.et_tenNV);
        btnNhap = (Button) findViewById(R.id.btn_Enter);
        rg = (RadioGroup) findViewById(R.id.rg_LoaiNV);
        lvNhanvien = (ListView) findViewById(R.id.lv_person);
        adapter = new ArrayAdapter<Employee>(this, android.R.layout.simple_list_item_1, arrEmployee);
        lvNhanvien.setAdapter(adapter);
        btnNhap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                addNewEmployee();
            }
        });
    }
    public void addNewEmployee(){
        int rb_ID = rg.getCheckedRadioButtonId();
        String id = editId.getText()+"";
        String name=editName.getText()+"";
        if(rb_ID == R.id.rb_ChinhThuc)
            employee = new EmployeeFullTime();
        else
            employee = new EmployeePartTime();
        employee.setId(id);
        employee.setName(name);
        arrEmployee.add(employee);
        adapter.notifyDataSetChanged();
    }
}
