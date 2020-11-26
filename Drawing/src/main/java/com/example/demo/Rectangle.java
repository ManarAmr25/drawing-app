package com.example.demo;

import java.awt.*;

public class Rectangle extends Shapes{

    int width;
    int height;
    Point center;
    Color color;


    Rectangle(int borderThickness , Color borderColor , Integer id, int width, int height, Point center, Color color){
        super(borderThickness, borderColor, id);
        this.width = width;
        this.height = height;
        this.center = center;
        this.color = color;
    }


    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
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
        return "Width: " + this.width + " ,height: " + this.height + " ,center: ( " + this.center.x + "," + this.center.y + " )";
    }
}
