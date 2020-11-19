package com.example.tallerlistview;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class ListAreas extends AppCompatActivity {

    private ListView lstArea_opts;
    private String area_opts[];
    private ArrayAdapter<String> adapter;
    private Intent intent;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_areas);

        lstArea_opts = findViewById(R.id.lstAreaOpts);
        area_opts = getResources().getStringArray(R.array.area_opts);

        adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, area_opts);
        lstArea_opts.setAdapter(adapter);

        lstArea_opts.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                switch (position){
                    case 0:
                        Calculate.setOp(position);
                        setSqrStrings();
                        intent = new Intent(ListAreas.this, Calculate.class);
                        startActivity(intent);
                        break;
                    case 1:
                        Calculate.setOp(position);
                        setRectangleStrings();
                        intent = new Intent(ListAreas.this, Calculate.class);
                        startActivity(intent);
                        break;
                    case 2:
                        Calculate.setOp(position);
                        setTriangleStrings();
                        intent = new Intent(ListAreas.this, Calculate.class);
                        startActivity(intent);
                        break;
                    case 3:
                        Calculate.setOp(position);
                        setCircleStrings();
                        intent = new Intent(ListAreas.this, Calculate.class);
                        startActivity(intent);
                        break;
                }
            }
        });
    }

    public void setSqrStrings(){
        Calculate.setStrTitle(R.string.square);
        Calculate.setStrVar1(R.string.lbl_side_input);
    }

    public void setRectangleStrings(){
        Calculate.setStrTitle(R.string.rectangle);
        Calculate.setStrVar1(R.string.lbl_base_input);
    }

    public void setTriangleStrings(){
        Calculate.setStrTitle(R.string.triangle);
        Calculate.setStrVar1(R.string.lbl_base_input);
    }

    public void setCircleStrings(){
        Calculate.setStrTitle(R.string.circle);
        Calculate.setStrVar1(R.string.lbl_radius_input);
    }
}