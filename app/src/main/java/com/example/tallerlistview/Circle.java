package com.example.tallerlistview;

import android.content.Context;

import java.text.DecimalFormat;

public class Circle implements Area, Operation{

    private double radius, area;
    private String title,radius_input_lbl, area_lbl, radius_lbl;

    public Circle(Context context){
        title = context.getResources().getText(R.string.circle).toString();
        radius_input_lbl = context.getResources().getText(R.string.lbl_radius_input).toString();
        area_lbl = context.getResources().getText(R.string.circle_area).toString();
        radius_lbl = context.getResources().getText(R.string.radius).toString();
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    public String getTitle() {
        return title;
    }

    public String getRadius_input_lbl() {
        return radius_input_lbl;
    }

    public String getArea_lbl() {
        return area_lbl;
    }

    @Override
    public void Area() {
        area = Math.PI*Math.pow(radius, 2);
        Data.saveData(this);
    }

    @Override
    public String getOperation() {
        return area_lbl;
    }

    @Override
    public String getData() {
        String data = radius_lbl+": "+radius;
        return data;
    }

    @Override
    public String getResult() {
        DecimalFormat df = new DecimalFormat("0.00");
        String result = df.format(area);
        return result;
    }
}
