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

    public double getSquareArea(double side){
        setArea(Double.parseDouble(d.format(side*side)));
        Data.saveData(this);
        return this.area;
    }

    public double getRectangleArea(double base, double height){
        setArea(Double.parseDouble(d.format(base*height)));
        Data.saveData(this);
        return this.area;
    }

    public double getTriangleArea(double base, double height){
        setArea(Double.parseDouble(d.format(0.5*base*height)));
        Data.saveData(this);
        return this.area;
    }

    public double getCircleArea(double radius){
        setArea(Double.parseDouble(d.format(Math.PI*Math.pow(radius, 2))));
        Data.saveData(this);
        return this.area;
    }
}
