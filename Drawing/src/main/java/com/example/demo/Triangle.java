package com.example.demo;

import java.awt.*;
import java.util.Map;

public class Triangle extends Shapes{

    private int length;
    private Point center;

    Triangle(){

    }
    Triangle(Integer id, Map<String,String> p){
        super(id,p);
    }

    public void assignLength() {
        String length  = this.properties.get("length");
        if (length == null){
            throw new RuntimeException("length of Triangle missing");
        }
        this.length = Integer.parseInt(length);
    }

    public void assignCenter() {
        String center = this.properties.get("center");
        if(center == null){
            throw new RuntimeException("center of Triangle missing");
        }
        String[] centerArr = center.split(",");
        this.center = new Point(Integer.parseInt(centerArr[0]),Integer.parseInt(centerArr[1]));
    }


    @Override
    protected String Show() {
        this.assignCenter();
        this.assignLength();
        return "Base length: " + this.length + " ,center: ( " +this.center.x + "," +this.center.y + " )";
    }
}
