package com.example.demo;

import java.awt.*;
import java.util.Map;

public class Square extends Shapes{

    private int length;
    private Point corner;

    Square(){

    }

    Square(Integer id, Map<String,String> p){
        super(id,p);
    }

    public void assignLength() {
        String length  = this.properties.get("length");
        if (length == null){
            throw new RuntimeException("length of square missing");
        }
        this.length = Integer.parseInt(length);
    }

    public void assignCorner() {
        String corner = this.properties.get("corner");
        if(corner == null){
            throw new RuntimeException("corner of square missing");
        }
        String[] centerArr = corner.split(",");
        this.corner = new Point(Integer.parseInt(centerArr[0]),Integer.parseInt(centerArr[1]));
    }

    @Override
    protected String Show() {
        this.assignLength();
        this.assignCorner();
        return "Length: " + this.length + " ,center: ( " + this.corner.x + "," + this.corner.y + " )";
    }

}
