package com.example.demo;

import java.awt.*;
import java.util.Map;

public class Square extends Shapes{

   private int length;
   private Point center;

   Square(){

   }
    Square(Integer id, Map<String,String>p){
        super(id,p);
        this.assignLength();
        this.assignCenter();
    }

    public void assignLength() {
        String length  = this.properties.get("length");
        if (length == null){
            throw new RuntimeException("length of square missing");
        }
        this.length = Integer.parseInt(length);
    }

    public void assignCenter() {
        String center = this.properties.get("center");
        if(center == null){
            throw new RuntimeException("center of square missing");
        }
        String[] centerArr = center.split(",");
        this.center = new Point(Integer.parseInt(centerArr[0]),Integer.parseInt(centerArr[1]));
    }

    @Override
    protected String Show() {
        return "Length: " + this.length + " ,center: ( " + this.center.x + "," + this.center.y + " )";
    }
}
