package com.example.demo;

import java.awt.*;
public  abstract class Shapes implements Cloneable{

    Point endPoint;
    Point startPoint;
    int borderThickness;
    String borderColor;
    String color;
    int id;
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Point getEndPoint() {
        return endPoint;
    }

    public void setEndPoint(Point endPoint) {
        this.endPoint = endPoint;
    }

    public Point getStartPoint() {
        return startPoint;
    }

    public void setStartPoint(Point startPoint) {
        this.startPoint = startPoint;
    }

    public int getBorderThickness() {
        return borderThickness;
    }

    public void setBorderThickness(int borderThickness) {
        this.borderThickness = borderThickness;
    }

    public String getBorderColor() {
        return borderColor;
    }

    public void setBorderColor(String borderColor) {
        this.borderColor = borderColor;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

   public Point getSize() {
        int x = Math.abs(startPoint.x-endPoint.x);
        int y = Math.abs(startPoint.y-endPoint.y);
        return new Point(x,y);
    }

    public Point calcCenter(){
        int x = Math.abs(this.startPoint.x-this.endPoint.x)/2;
        int y = Math.abs(this.startPoint.y-this.endPoint.y)/2;
        return new Point(x,y);
    }

    protected abstract String Show();

}
