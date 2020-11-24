package com.example.tallerlistview;

import android.content.Context;

import java.text.DecimalFormat;

public class Square implements Area, Operation{

    private double side, area;
    private String title, input_lbl, op_lbl, area_lbl, side_lbl;

    public Square(Context context){
        title = context.getResources().getText(R.string.square).toString();
        input_lbl = context.getResources().getText(R.string.lbl_side_input).toString();
        op_lbl = context.getResources().getText(R.string.square_area).toString();
        area_lbl = context.getResources().getText(R.string.area).toString();
        side_lbl = context.getResources().getText(R.string.side).toString();
    }

    public void setSide(double side) {
        this.side = side;
    }

    public String getTitle() {
        return title;
    }

    public String getInput_lbl() {
        return input_lbl;
    }

    public String getArea_lbl() {
        return area_lbl;
    }

    @Override
    public void calculateArea() {
        area = side * side;
        Data.saveData(this);
    }

    @Override
    public String getOperation() {
        return op_lbl;
    }

    @Override
    public String getData() {
        String data = side_lbl + ": " +side;
        return data;
    }

    @Override
    public String getResult() {
        DecimalFormat df = new DecimalFormat("0.00");
        String result = df.format(area);
        return result;
    }

}
