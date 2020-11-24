package com.example.tallerlistview;

import android.content.Context;

import java.text.DecimalFormat;

public class Cube implements Volume, Operation{
    private double side, volume;
    private String title, input_lbl, op_lbl, volume_lbl, side_lbl;

    public Cube(Context context){
        title = context.getResources().getText(R.string.cube).toString();
        input_lbl = context.getResources().getText(R.string.lbl_side_input).toString();
        op_lbl = context.getResources().getText(R.string.cube_volume).toString();
        volume_lbl = context.getResources().getText(R.string.volume).toString();
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

    public String getVolume_lbl() {
        return volume_lbl;
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
        String result = df.format(volume);
        return result;
    }

    @Override
    public void calculateVolume() {
        volume = Math.pow(side,3);
        Data.saveData(this);
    }
}
