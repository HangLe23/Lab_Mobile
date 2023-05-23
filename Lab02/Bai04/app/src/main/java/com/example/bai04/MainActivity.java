package com.example.bai04;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    EditText etID;
    EditText etFullName;
    CheckBox cbIsManager;
    Button btnNhap;
    ListView lvInfo;
    ArrayList<Employee> employees = new ArrayList<>();
    EmployeeAdapter employeeAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        AnhXa();
        employeeAdapter = new EmployeeAdapter(this, R.layout.item_employee, employees);
        lvInfo.setAdapter(employeeAdapter);

        btnNhap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                addNewEmployee();
            }
        });
    }

    private void AnhXa() {
        etID = findViewById(R.id.et_ID);
        etFullName = findViewById(R.id.et_FullName);
        cbIsManager = findViewById(R.id.cb_manager);
        btnNhap = findViewById(R.id.btn_Add);
        lvInfo = findViewById(R.id.lv_person);
    }

    public void addNewEmployee() {
        Employee employee = new Employee();
        boolean isManager = cbIsManager.isChecked();
        String id = etID.getText().toString();
        String name = etFullName.getText().toString();
        if (isManager == true) {
            employee.setMNG(true);
        } else {
            employee.setMNG(false);
        }
        employee.setID(id);
        employee.setFullName(name);
        employees.add(employee);
        employeeAdapter.notifyDataSetChanged();
    }
}