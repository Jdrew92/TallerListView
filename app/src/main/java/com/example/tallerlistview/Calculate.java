package com.example.tallerlistview;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

public class Calculate extends AppCompatActivity implements View.OnClickListener{

    private static int strTitle, strVar1, strVar2, op;
    private TextView title, var1, var2, result;
    private EditText txtVar1, txtVar2;
    private Button btnCalc;
    private static LinearLayout grpvar2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculate);

        title = findViewById(R.id.lblTitleOp);
        var1 = findViewById(R.id.lblVar1);
        var2 = findViewById(R.id.lblVar2);
        txtVar1 = findViewById(R.id.txtVar1);
        txtVar2 = findViewById(R.id.txtVar2);
        result = findViewById(R.id.lblResult);
        grpvar2 = findViewById(R.id.grpVar2);
        btnCalc = findViewById(R.id.btnCalc);

        if (op == 0 || op == 3) {
            title.setText(strTitle);
            var1.setText(strVar1);
            grpvar2.setVisibility(View.GONE);
            btnCalc.setOnClickListener(this);
        }
        if (op == 1 || op == 2){
                title.setText(strTitle);
                var1.setText(strVar1);
                var2.setText(strVar2);
                btnCalc.setOnClickListener(this);
        }

    }

    public static void setStrTitle(int s){
        Calculate.strTitle = s;
    }

    public static void setStrVar1(int strVar1) {
        Calculate.strVar1 = strVar1;
    }

    public static void setStrVar2(int strVar2) {
        Calculate.strVar2 = strVar2;
    }

    public static void setOp(int op) {
        Calculate.op = op;
    }

    @Override
    public void onClick(View v){
        switch (op){
            case 0:
                Log.i("Funcion:", "Area Cuadrado");
                break;
            case 1:
                Log.i("Funcion:", "Area Rectangulo");
                break;
            case 2:
                Log.i("Funcion:", "Area Triangulo");
                break;
            case 3:
                Log.i("Funcion:", "Area Circulo");
                break;
        }
    }
}