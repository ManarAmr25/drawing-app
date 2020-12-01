package com.example.demo;

import java.awt.*;
import java.util.Map;

public class Line extends Shapes{

    private Point first;
    private Point second;
    private int width;

    Line(){

    }

    Line( Integer id, Map<String,String>p){
        super(id,p);
    }

    private void assignPoints(){
        String sp = this.getProperty("first");
        String ep = this.getProperty("second");
        if( sp ==null || ep == null){
            throw new RuntimeException("first or second point missing");
        }
        String[] spArr = sp.split(",");
        String[] epArr = ep.split(",");
        this.first = new Point(Integer.parseInt(spArr[0]),Integer.parseInt(spArr[1]));
        this.second = new Point(Integer.parseInt(epArr[0]),Integer.parseInt(epArr[1]));
    }

    private void assignWidth(){
        String width  = this.properties.get("width");
        if (width == null){
            throw new RuntimeException("Width missing");
        }
        this.width = Integer.parseInt(width);
    }

    private double calcLen(){
        double x = Math.sqrt(Math.pow(this.first.x-this.second.x,2) + Math.pow(this.first.y-this.second.y,2));
        return x;
    }

    //not used yet
    protected Point getSize() {
        int x = Math.abs(first.x-second.x);
        int y = Math.abs(first.y-second.y);
        return new Point(x,y);
    }

    @Override
    protected String Show() {
        this.assignPoints();
        this.assignWidth();
        return "Length: " + Double.toString(calcLen())+ " ,wigth: "+ this.width + ",start: (" + this.first.x + "," + this.first.y + "), End: ("+ this.second.x + "," + this.second.y + ")";
    }

}