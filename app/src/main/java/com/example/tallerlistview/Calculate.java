package com.example.tallerlistview;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

public class Calculate extends AppCompatActivity implements View.OnClickListener{

    private static int op;
    private double v1, v2;

    private Square s;
    private Rectangle r;
    private Triangle t;
    private Circle c;
    private Sphere sp;
    private Cylinder cy;
    private Cone co;
    private Cube cu;

    private TextView title, var1, var2;
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
        grpvar2 = findViewById(R.id.grpVar2);
        btnCalc = findViewById(R.id.btnCalc);

        switch (op){
            case 0:
                s = new Square(this);
                title.setText(s.getTitle());
                var1.setText(s.getInput_lbl());
                grpvar2.setVisibility(View.GONE);
                btnCalc.setOnClickListener(this);
                break;
            case 1:
                r = new Rectangle(this);
                title.setText(r.getTitle());
                var1.setText(r.getInput_lbl());
                btnCalc.setOnClickListener(this);
                break;
            case 2:
                t = new Triangle(this);
                title.setText(t.getTitle());
                var1.setText(t.getInput_lbl());
                btnCalc.setOnClickListener(this);
                break;
            case 3:
                c = new Circle(this);
                title.setText(c.getTitle());
                var1.setText(c.getInput_lbl());
                grpvar2.setVisibility(View.GONE);
                btnCalc.setOnClickListener(this);
                break;
            case 4:
                sp = new Sphere(this);
                title.setText(sp.getTitle());
                var1.setText(sp.getInput_lbl());
                grpvar2.setVisibility(View.GONE);
                btnCalc.setOnClickListener(this);
                break;
            case 5:
                cy = new Cylinder(this);
                title.setText(cy.getTitle());
                var1.setText(cy.getInput_lbl());
                btnCalc.setOnClickListener(this);
                break;
            case 6:
                co = new Cone(this);
                title.setText(co.getTitle());
                var1.setText(co.getInput_lbl());
                btnCalc.setOnClickListener(this);
                break;
            case 7:
                cu = new Cube(this);
                title.setText(cu.getTitle());
                var1.setText(cu.getInput_lbl());
                grpvar2.setVisibility(View.GONE);
                btnCalc.setOnClickListener(this);
                break;
        }
    }

    public static void setOp(int op) {
        Calculate.op = op;
    }

    @Override
    public void onClick(View v){
        switch (op){
            case 0:
                //Square
                if (!isEmpty(txtVar1)){
                    v1 = Double.parseDouble(txtVar1.getText().toString());
                    if (!isZero(v1)){
                        s = new Square(this);
                        s.setSide(v1);
                        s.calculateArea();
                        showMessage(s.getArea_lbl(), s.getResult());
                    }
                }
                break;
            case 1:
                //Rectangle
                if (!isEmpty(txtVar1, txtVar2)){
                    v1 = Double.parseDouble(txtVar1.getText().toString());
                    v2 = Double.parseDouble(txtVar2.getText().toString());
                    if (!isZero(v1, v2)) {
                        r = new Rectangle(this);
                        r.setBase(v1);
                        r.setHeight(v2);
                        r.calculateArea();
                        showMessage(r.getArea_lbl(), r.getResult());
                    }
                }
                break;
            case 2:
                //Triangle
                if (!isEmpty(txtVar1, txtVar2)){
                    v1 = Double.parseDouble(txtVar1.getText().toString());
                    v2 = Double.parseDouble(txtVar2.getText().toString());
                    if (!isZero(v1, v2)){
                        t = new Triangle(this);
                        t.setBase(v1);
                        t.setHeight(v2);
                        t.calculateArea();
                        showMessage(t.getArea_lbl(), t.getResult());
                    }
                }
                break;
            case 3:
                //Circle
                if (!isEmpty(txtVar1)){
                    v1 = Double.parseDouble(txtVar1.getText().toString());
                    if (!isZero(v1)) {
                        c = new Circle(this);
                        c.setRadius(v1);
                        c.calculateArea();
                        showMessage(c.getArea_lbl(), c.getResult());
                    }
                }
                break;
            case 4:
                //Sphere
                if (!isEmpty(txtVar1)){
                    v1 = Double.parseDouble(txtVar1.getText().toString());
                    if (!isZero(v1)) {
                        sp = new Sphere(this);
                        sp.setRadius(v1);
                        sp.calculateVolume();
                        showMessage(sp.getVolume_lbl(), sp.getResult());
                    }
                }
                break;
            case 5:
                //Cylinder
                if (!isEmpty(txtVar1, txtVar2)){
                    v1 = Double.parseDouble(txtVar1.getText().toString());
                    v2 = Double.parseDouble(txtVar2.getText().toString());
                    if (!isZero(v1, v2)) {
                        cy = new Cylinder(this);
                        cy.setRadius(v1);
                        cy.setHeight(v2);
                        cy.calculateVolume();
                        showMessage(cy.getVolume_lbl(), cy.getResult());
                    }
                }
                break;
            case 6:
                //Cone
                if (!isEmpty(txtVar1, txtVar2)){
                    v1 = Double.parseDouble(txtVar1.getText().toString());
                    v2 = Double.parseDouble(txtVar2.getText().toString());
                    if (!isZero(v1, v2)){
                        co = new Cone(this);
                        co.setRadius(v1);
                        co.setHeight(v2);
                        co.calculateVolume();
                        showMessage(co.getVolume_lbl(), co.getResult());
                    }
                }
                break;
            case 7:
                //Cube
                if (!isEmpty(txtVar1)){
                    v1 = Double.parseDouble(txtVar1.getText().toString());
                    if (!isZero(v1)){
                        cu = new Cube(this);
                        cu.setSide(v1);
                        cu.calculateVolume();
                        showMessage(cu.getVolume_lbl(), cu.getResult());
                    }
                }
                break;
        }
    }

    public void clear(View v) {
        clear();
    }
    public void clear(){

        txtVar1.setText("");
        txtVar2.setText("");
        txtVar1.requestFocus();

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

    public void showMessage(String operation, String result){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);

        builder.setTitle(R.string.result);
        builder.setMessage(operation+" "+result);
        builder.setPositiveButton(R.string.ok, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                clear();
            }
        });
        AlertDialog dialog = builder.create();
        dialog.show();
    }
}