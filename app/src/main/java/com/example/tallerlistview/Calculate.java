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

    private static int strVar2, op;
    private double v1, v2;
    private Square square;
    private String base, height, slant_height, radius, rect_area, tri_area, cir_area, cube_area, cyl_area, cone_area, sphere_area;

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

        switch (op){
            case 0:
                square = new Square(this);
                title.setText(square.getTitle());
                var1.setText(square.getInput_lbl());
                break;
        }
        rect_area = getResources().getText(R.string.rect_area).toString();
        tri_area = getResources().getText(R.string.tri_area).toString();
        cir_area = getResources().getText(R.string.circle_area).toString();
        cube_area = getResources().getText(R.string.cube_area).toString();
        cyl_area = getResources().getText(R.string.cylinder_area).toString();
        cone_area = getResources().getText(R.string.cone_area).toString();
        sphere_area = getResources().getText(R.string.sphere_area).toString();

        base = getResources().getText(R.string.base).toString();
        height = getResources().getText(R.string.height).toString();
        slant_height = getResources().getText(R.string.slant_height).toString();
        radius = getResources().getText(R.string.radius).toString();

        if (op == 6){
            var2.setText(strVar2);
        }
        if (op == 0 || op == 3 || op == 4 || op == 7) {
            grpvar2.setVisibility(View.GONE);
            btnCalc.setOnClickListener(this);
        }
        else {
            btnCalc.setOnClickListener(this);
        }
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
                if (!isEmpty(txtVar1)){
                    v1 = Double.parseDouble(txtVar1.getText().toString());
                    if (!isZero(v1)){
                        square.setSide(v1);
                        square.Area();
                        result.setText(square.getArea_lbl()+": "+square.getResult());
                    }
                }
                break;
            case 1:
                Log.i("Funcion:", "Area Rectangulo");
                if (!isEmpty(txtVar1, txtVar2)){
                    o = new Operations();
                    v1 = Double.parseDouble(txtVar1.getText().toString());
                    v2 = Double.parseDouble(txtVar2.getText().toString());
                    if (!isZero(v1, v2)) {
                        o.setOp(rect_area);
                        o.setData(base + ": " + v1 + " " + height + ": " + v2);
                        result.setText(rect_area + ": " + o.getRectangleArea(v1, v2));
                    }
                }
                break;
            case 2:
                Log.i("Funcion:", "Area Triangulo");
                if (!isEmpty(txtVar1, txtVar2)){
                    o = new Operations();
                    v1 = Double.parseDouble(txtVar1.getText().toString());
                    v2 = Double.parseDouble(txtVar2.getText().toString());
                    if (!isZero(v1, v2)){
                        o.setOp(tri_area);
                        o.setData(base+ ": "+v1+" "+height+": "+v2);
                        result.setText(tri_area+": "+o.getTriangleArea(v1, v2));
                    }
                }
                break;
            case 3:
                Log.i("Funcion:", "Area Circulo");
                if (!isEmpty(txtVar1)){
                    o = new Operations();
                    v1 = Double.parseDouble(txtVar1.getText().toString());
                    if (!isZero(v1)) {
                        o.setOp(cir_area);
                        o.setData(radius + ": " + v1);
                        result.setText(cir_area + ": " + o.getCircleArea(v1));
                    }
                }
                break;
            case 4:
                Log.i("Funcion:", "Area Esfera");
                if (!isEmpty(txtVar1)){
                    //o = new Operations();
                    v1 = Double.parseDouble(txtVar1.getText().toString());
                    if (!isZero(v1)) {
                        o.setData(radius + ": " + v1);
                        result.setText(sphere_area + ": " + o.getSphereArea(v1));
                    }
                }
                break;
            case 5:
                Log.i("Funcion:", "Area Cilindro");
                if (!isEmpty(txtVar1, txtVar2)){
                    o = new Operations();
                    v1 = Double.parseDouble(txtVar1.getText().toString());
                    v2 = Double.parseDouble(txtVar2.getText().toString());
                    if (!isZero(v1, v2)) {
                        o.setOp(cyl_area);
                        o.setData(radius + ": " + v1 + " " + height + ": " + v2);
                        result.setText(cyl_area + ": " + o.getCylinderArea(v1, v2));
                    }
                }
                break;
            case 6:
                Log.i("Funcion:", "Area cono");
                if (!isEmpty(txtVar1, txtVar2)){
                    o = new Operations();
                    v1 = Double.parseDouble(txtVar1.getText().toString());
                    v2 = Double.parseDouble(txtVar2.getText().toString());
                    if (!isZero(v1, v2)){
                        o.setOp(cone_area);
                        o.setData(radius+ ": "+v1+"\n"+slant_height+": "+v2);
                        result.setText(cone_area+": "+o.getConeArea(v1, v2));
                    }
                }
                break;
            case 7:
                Log.i("Funcion:", "Area Cubo");
                if (!isEmpty(txtVar1)){
                    o = new Operations();
                    v1 = Double.parseDouble(txtVar1.getText().toString());
                    if (!isZero(v1)){
                        o.setOp(cube_area);
                        result.setText(cube_area+": "+o.getCubeArea(v1));
                    }
                }
                break;
        }
    }

    public void clear(View v){

        txtVar1.setText("");
        txtVar2.setText("");
        result.setText("");
        txtVar1.requestFocus();

        /*for (int i = 0; i < Data.getOperationsList().size(); i++) {
            Log.i("-----------", "-------------");
            Log.i("No.", ""+i);
            Log.i("Op", ""+Data.getOperationsList().get(i).getOp());
            Log.i("Datos", ""+Data.getOperationsList().get(i).getData());
            Log.i("area", ""+Data.getOperationsList().get(i).getArea());

        }
        Log.i("-----------", "-------------");*/
    }

    public boolean isEmpty(EditText e){
        if (e.getText().toString().isEmpty()){
            e.setError(getText(R.string.empty_error));
            e.requestFocus();
            return true;
        }
        return false;
    }
    public boolean isEmpty(EditText e, EditText e2){
        if (e.getText().toString().isEmpty()){
            e.setError(getText(R.string.empty_error));
            e.requestFocus();
            return true;
        } if (e2.getText().toString().isEmpty()){
            e2.setError(getText(R.string.empty_error));
            e2.requestFocus();
            return true;
        }
        return false;
    }

    public boolean isZero(double a){
        if (a==0){
            txtVar1.setError(getText(R.string.zero_value));
            return true;
        }
        return false;
    }
    public boolean isZero(double a, double b){
        if (a==0){
            txtVar1.setError(getText(R.string.zero_value));
            return true;
        } if (b==0){
            txtVar2.setError(getText(R.string.zero_value));
            return true;
        }
        return false;
    }
}