package com.example.tallerlistview;

import java.text.DecimalFormat;

public class Operations {
    private double area;
    private String op, data;
    private DecimalFormat d = new DecimalFormat("0.00");

    public void setArea(double area) {
        this.area = area;
    }

    public double getArea() {
        return area;
    }

    public String getOp() {
        return op;
    }

    public void setOp(String op) {
        this.op = op;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }


    public double getCubeArea(double side){
        setArea(Double.parseDouble(d.format(6 * side * side)));
        Data.saveData(this);
        return getArea();
    }

    public double getCylinderArea(double radius, double height){
        setArea(Double.parseDouble(d.format(2 * Math.PI * radius * (radius + height))));
        Data.saveData(this);
        return getArea();
    }

    public double getConeArea(double radius, double slant_height){
        setArea(Double.parseDouble(d.format(Math.PI * radius * (radius + slant_height))));
        Data.saveData(this);
        return getArea();
    }

    public double getSphereArea(double radius){
        setArea(Double.parseDouble(d.format(4 * Math.PI * Math.pow(radius, 2))));
        Data.saveData(this);
        return getArea();
    }
}
