package com.example.tallerlistview;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class ListVolumes extends AppCompatActivity {

    private ListView lstVol_opts;
    private String vol_opts[];
    private ArrayAdapter<String> adapter;
    private Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_volumes);

        lstVol_opts = findViewById(R.id.lstVolOpts);
        vol_opts = getResources().getStringArray(R.array.vol_opts);

        adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, vol_opts);
        lstVol_opts.setAdapter(adapter);

        lstVol_opts.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                switch (position){
                    case 0:
                        Calculate.setOp(position+4);
                        setSphereStrings();
                        intent = new Intent(ListVolumes.this, Calculate.class);
                        startActivity(intent);
                        break;
                    case 1:
                        Calculate.setOp(position+4);
                        setCylinderStrings();
                        intent = new Intent(ListVolumes.this, Calculate.class);
                        startActivity(intent);
                        break;
                    case 2:
                        Calculate.setOp(position+4);
                        setConeStrings();
                        intent = new Intent(ListVolumes.this, Calculate.class);
                        startActivity(intent);
                        break;
                    case 3:
                        Calculate.setOp(position+4);
                        setCubeStrings();
                        intent = new Intent(ListVolumes.this, Calculate.class);
                        startActivity(intent);
                        break;
                }
            }
        });
    }
    public void setCubeStrings(){
        Calculate.setStrTitle(R.string.cube);
        Calculate.setStrVar1(R.string.lbl_side_input);
    }

    public void setCylinderStrings(){
        Calculate.setStrTitle(R.string.cylinder);
        Calculate.setStrVar1(R.string.lbl_radius_input);
    }

    public void setConeStrings(){
        Calculate.setStrTitle(R.string.cone);
        Calculate.setStrVar1(R.string.lbl_radius_input);
    }

    public void setSphereStrings(){
        Calculate.setStrTitle(R.string.sphere);
        Calculate.setStrVar1(R.string.lbl_radius_input);
    }
}