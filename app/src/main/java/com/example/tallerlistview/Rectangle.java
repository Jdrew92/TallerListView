package com.example.tallerlistview;

import android.content.Context;

import java.text.DecimalFormat;

public class Rectangle implements Area, Operation{
    private double base, height, area;
    private String title, input_lbl, op_lbl, area_lbl, base_lbl, height_lbl;

    public Rectangle(Context context){
        title = context.getResources().getText(R.string.rectangle).toString();
        input_lbl = context.getResources().getText(R.string.lbl_base_input).toString();
        op_lbl = context.getResources().getText(R.string.rect_area).toString();
        area_lbl = context.getResources().getText(R.string.area).toString();
        base_lbl = context.getResources().getText(R.string.base).toString();
        height_lbl = context.getResources().getText(R.string.height).toString();
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

    public void setBase(double base) {
        this.base = base;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    @Override
    public void calculateArea() {
        area = base * height;
        Data.saveData(this);
    }

    @Override
    public String getOperation() {
        return op_lbl;
    }

    @Override
    public String getData() {
        String data = base_lbl+": "+base+"\n"+height_lbl+": "+height;
        return data;
    }

    @Override
    public String getResult() {
        DecimalFormat df = new DecimalFormat("0.00");
        String result = df.format(area);
        return result;
    }
}
