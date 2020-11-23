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
                Calculate.setOp(position);
                intent = new Intent(ListAreas.this, Calculate.class);
                startActivity(intent);
            }
        });
    }

}