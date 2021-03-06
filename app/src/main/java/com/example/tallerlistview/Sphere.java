package com.example.tallerlistview;

import android.content.Context;

import java.text.DecimalFormat;

public class Sphere implements Volume, Operation{

    private double radius, volume;
    private String title,input_lbl, op_lbl, volume_lbl, radius_lbl;

    public Sphere(Context context){
        title = context.getResources().getText(R.string.sphere).toString();
        input_lbl = context.getResources().getText(R.string.lbl_radius_input).toString();
        op_lbl = context.getResources().getText(R.string.sphere_volume).toString();
        volume_lbl = context.getResources().getText(R.string.volume).toString();
        radius_lbl = context.getResources().getText(R.string.radius).toString();
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    public String getTitle() {
        return title;
    }

    public String getInput_lbl() {
        return input_lbl;
    }

    public String getVolume_lbl() {
        return volume_lbl;
    }

    @Override
    public String getOperation() {
        return op_lbl;
    }

    @Override
    public String getData() {
        String data = radius_lbl+": "+radius;
        return data;
    }

    @Override
    public String getResult() {
        DecimalFormat df = new DecimalFormat("0.00");
        String result = df.format(volume);
        return result;
    }

    @Override
    public void calculateVolume() {
        volume = (4 * Math.PI * Math.pow(radius, 3))/3;
        Data.saveData(this);
    }
}
