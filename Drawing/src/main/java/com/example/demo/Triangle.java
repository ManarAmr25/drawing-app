package com.example.demo;

import java.awt.*;

public class Triangle extends Shapes{

    int Length;
    Point center;
    Color color;

    Triangle(int borderThickness , Color borderColor , Integer id, int Length, Point center, Color color){
        super(borderThickness, borderColor, id);
        this.Length = Length;
        this.center = center;
        this.color = color;
    }

    public int getLength() {
        return Length;
    }

    public void setLength(int length) {
        Length = length;
    }

    public Point getCenter() {
        return center;
    }

    public void setCenter(Point center) {
        this.center = center;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    @Override
    protected String Show() {
        return "Base length: " + this.Length + " ,center: ( " +this.center.x + "," +this.center.y + " )";
    }
}
