package com.example.demo;

import java.awt.*;

public class Square extends Shapes{

    int length;
    Point center;
    Color color;

    Square(int borderThickness , Color borderColor , Integer id, int length, Point center, Color color){
        super(borderThickness, borderColor, id);
        this.length = length;
        this.center = center;
        this.color = color;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
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
        return "Length: " + this.length + " ,center: ( " + this.center.x + "," + this.center.y + " )";
    }
}
