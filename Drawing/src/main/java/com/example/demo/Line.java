package com.example.demo;

import java.awt.*;
import java.util.Map;

public class Line extends Shapes{

    private Point StartPoint;
    private Point EndPoint;

    Line(){

    }

   Line( Integer id, Map<String,String>p){
        super(id,p);
 }

    private void setPoints(){
        String sp = this.getProperty("startpoint");
        String ep = this.getProperty("endpoint");
        if( sp ==null || ep == null){
            throw new RuntimeException("start or end point missing");
        }
        String[] spArr = sp.split(",");
        String[] epArr = ep.split(",");
        this.StartPoint = new Point(Integer.parseInt(spArr[0]),Integer.parseInt(spArr[1]));
        this.EndPoint = new Point(Integer.parseInt(epArr[0]),Integer.parseInt(epArr[1]));
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
       String sp = this.getProperty("startpoint");
        String ep = this.getProperty("endpoint");
        if( sp ==null || ep == null){
            throw new RuntimeException("start or end point missing");
        }
        return "Length: " + Double.toString(calcLen()) + ",start: (" + this.StartPoint.x + this.StartPoint.y + "), End: ("+ this.EndPoint.x + this.EndPoint.y + ")";
    }

}