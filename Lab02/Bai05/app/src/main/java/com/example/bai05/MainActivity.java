package com.example.bai05;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.GridView;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    GridView gv;
    Spinner spinnerThumb;
    EditText editTextName;
    CheckBox cbPromotion;
    List<dish>dishes;
    List<Thumbnail>thumbnailList;
    dishAdapter dishAdapter;
    Button btnAdd;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        gv = findViewById(R.id.gvMenu);
        spinnerThumb = findViewById(R.id.spinnerThumb);
        editTextName = findViewById(R.id.editName);
        cbPromotion = findViewById(R.id.cbPromotion);
        btnAdd = findViewById(R.id.btnAddNew);

        thumbnailList = new ArrayList<>();
        thumbnailList.add(Thumbnail.Thumbnail1);
        thumbnailList.add(Thumbnail.Thumbnail2);
        thumbnailList.add(Thumbnail.Thumbnail3);
        thumbnailList.add(Thumbnail.Thumbnail4);
        ThumbnailAdapter thumbnailAdapter = new ThumbnailAdapter(MainActivity.this, 1, thumbnailList);
        spinnerThumb.setAdapter(thumbnailAdapter);

        dishes = new ArrayList<>();
        dishAdapter = new dishAdapter(MainActivity.this, R.layout.item_dish, dishes);
        gv.setAdapter(dishAdapter);

        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(editTextName.getText().toString() + "" ==""){
                    Toast.makeText(MainActivity.this,
                            "Vui lòng nhập thông tin",
                            Toast.LENGTH_SHORT).show();
                } else {
                    Addnew();
                    Toast.makeText(MainActivity.this,
                            "Added successfully!",
                            Toast.LENGTH_LONG).show();
                }
            }
        });
    }
    public void Addnew(){
        if(editTextName.getText().length() == 0) return;

        String name = editTextName.getText().toString();
        Thumbnail thumbnail =(Thumbnail) spinnerThumb.getSelectedItem();
        boolean promotion = cbPromotion.isChecked();
        dish dish = new dish(name, thumbnail, promotion);
        dishes.add(dish);
        dishAdapter.notifyDataSetChanged();
        // renew
        editTextName.setText("");
        spinnerThumb.setSelection(0);
        cbPromotion.setChecked(false);
    }
}