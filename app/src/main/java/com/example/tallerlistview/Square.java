package com.example.tallerlistview;

import android.content.Context;

public class Square implements Area, Operation{

    private double side;
    private String title, input_lbl, area_lbl, side_lbl;

    public Square(Context context){
        title = context.getResources().getText(R.string.square).toString();
        input_lbl = context.getResources().getText(R.string.lbl_side_input).toString();
        area_lbl = context.getResources().getText(R.string.square_area).toString();
        side_lbl = context.getResources().getText(R.string.side).toString();
    }

    public double getSide() {
        return side;
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

    public String getSide_lbl() {
        return side_lbl;
    }

    @Override
    public double Area() {
        return side * side;
    }

    @Override
    public void saveOperation() {

    }

    @Override
    public String getOperation() {
        return area_lbl;
    }

    @Override
    public String getData() {
        String data = side_lbl + ": " + Double.toString(side);
        return data;
    }

    @Override
    public String getResult() {
        String result = Double.toString(Area());
        return result;
    }

}
