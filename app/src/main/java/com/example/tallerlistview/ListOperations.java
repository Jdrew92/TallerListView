package com.example.tallerlistview;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

import java.util.ArrayList;

public class ListOperations extends AppCompatActivity {

    private TableLayout table;
    private ArrayList<Operation> operations;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_operations);

        table = findViewById(R.id.tblOpsDone);
        operations = Data.getOperationsList();

        //Log.i("Operaciones Realizadas",""+operations.size());

        for (int i = 0; i < operations.size(); i++) {

            TableRow row = new TableRow(this);

            TextView col_num = new TextView(this);
            TextView col_ops = new TextView(this);
            TextView col_data = new TextView(this);
            TextView col_rslt = new TextView(this);

            col_num.setText(""+(i+1));
            col_ops.setText(operations.get(i).getOperation());
            col_data.setText(operations.get(i).getData());
            col_rslt.setText(""+operations.get(i).getResult());

            row.addView(col_num);
            row.addView(col_ops);
            row.addView(col_data);
            row.addView(col_rslt);

            col_num.setGravity(Gravity.CENTER);
            col_ops.setGravity(Gravity.CENTER);
            col_data.setGravity(Gravity.CENTER);
            col_rslt.setGravity(Gravity.CENTER);

            table.addView(row);
        }
    }
}