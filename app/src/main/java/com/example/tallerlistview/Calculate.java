package com.example.tallerlistview;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.DeadObjectException;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

public class Calculate extends AppCompatActivity implements View.OnClickListener{

    private static int strTitle, strVar1, strVar2, op;
    private double v1, v2;
    private String side, base, height, radius, sqr_area, rect_area, tri_area, cir_area;

    private TextView title, var1, var2, result;
    private EditText txtVar1, txtVar2;
    private Button btnCalc;
    private static LinearLayout grpvar2;
    private Operations o;

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

        sqr_area = getResources().getText(R.string.square_area).toString();
        rect_area = getResources().getText(R.string.rect_area).toString();
        tri_area = getResources().getText(R.string.tri_area).toString();
        cir_area = getResources().getText(R.string.circle_area).toString();

        side = getResources().getText(R.string.side).toString();
        base = getResources().getText(R.string.base).toString();
        height = getResources().getText(R.string.height).toString();
        radius = getResources().getText(R.string.radius).toString();

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
                o = new Operations();
                v1 = Double.parseDouble(txtVar1.getText().toString());
                o.setOp(sqr_area);
                o.setData(side+": "+v1);
                result.setText(sqr_area+": "+o.getSquareArea(v1));
                break;
            case 1:
                Log.i("Funcion:", "Area Rectangulo");
                o = new Operations();
                v1 = Double.parseDouble(txtVar1.getText().toString());
                v2 = Double.parseDouble(txtVar2.getText().toString());
                o.setOp(rect_area);
                o.setData(base+ ": "+v1+" "+height+": "+v2);
                result.setText(rect_area+": "+o.getRectangleArea(v1, v2));
                break;
            case 2:
                Log.i("Funcion:", "Area Triangulo");
                o = new Operations();
                v1 = Double.parseDouble(txtVar1.getText().toString());
                v2 = Double.parseDouble(txtVar2.getText().toString());
                o.setOp(tri_area);
                o.setData(base+ ": "+v1+" "+height+": "+v2);
                result.setText(tri_area+": "+o.getTriangleArea(v1, v2));
                break;
            case 3:
                Log.i("Funcion:", "Area Circulo");
                o = new Operations();
                v1 = Double.parseDouble(txtVar1.getText().toString());
                o.setOp(cir_area);
                o.setData(radius+ ": "+v1);
                result.setText(cir_area+": "+o.getCircleArea(v1));
                break;
        }
    }

    public void clear(View v){
        if (op == 0 || op == 3) {
            txtVar1.setText("");
            result.setText("");
            txtVar1.requestFocus();
        }
        if (op == 1 || op == 2){
            txtVar1.setText("");
            txtVar2.setText("");
            result.setText("");
            txtVar1.requestFocus();
        }
        for (int i = 0; i < Data.getOperationsList().size(); i++) {
            Log.i("-----------", "-------------");
            Log.i("No.", ""+i);
            Log.i("Op", ""+Data.getOperationsList().get(i).getOp());
            Log.i("Datos", ""+Data.getOperationsList().get(i).getData());
            Log.i("area", ""+Data.getOperationsList().get(i).getArea());

        }
        Log.i("-----------", "-------------");
    }
}