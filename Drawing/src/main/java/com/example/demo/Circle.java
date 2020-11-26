package com.example.demo;

import java.awt.*;

public class Circle extends Shapes {

    int radius;
    Point center;
    Color color;

    Circle(int borderThickness, Color borderColor, Integer id, Point center, Color color, int radius) {
        super(borderThickness, borderColor, id);
        this.color = color;
        this.center = center;
        this.radius = radius;
    }

    public int getRadius() {
        return radius;
    }

    public void setRadius(int radius) {
        this.radius = radius;
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
        return "radius: " + this.radius + " ,center: ( " +this.center.x + "," +this.center.y + " )";
    }
}
