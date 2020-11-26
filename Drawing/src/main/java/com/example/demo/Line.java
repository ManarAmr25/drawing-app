package com.example.demo;

import java.awt.*;

public class Line extends Shapes{

    Point StartPoint;
    Point EndPoint;

    Line(int borderThickness, Color borderColor, Integer id, Point StartPoint, Point EndPoint){
        super(borderThickness, borderColor, id);
        this.StartPoint = StartPoint;
        this.EndPoint = EndPoint;
    }

    public void setStartPoint(Point startPoint) {
        StartPoint = startPoint;
    }

    public Point getEndPoint() {
        return EndPoint;
    }

    public void setEndPoint(Point endPoint) {
        EndPoint = endPoint;
    }

    public Point getStartPoint(){
        return this.StartPoint;
    }



    private double calcLen(){
        double x = Math.sqrt(Math.pow(this.StartPoint.x-this.EndPoint.x,2) + Math.pow(this.StartPoint.y-this.EndPoint.y,2));
        return x;
    }

    protected Point getSize() {
        int x = Math.abs(StartPoint.x-EndPoint.x);
        int y = Math.abs(StartPoint.y-EndPoint.y);
        return new Point(x,y);
    }

    @Override
    protected String Show() {
        return "Length: " + Double.toString(calcLen()) + ",start: (" + this.StartPoint.x + this.StartPoint.y + "), End: ("+ this.EndPoint.x + this.EndPoint.y + ")";
    }
}