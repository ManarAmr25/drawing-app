package com.example.demo;

import java.awt.*;
import java.util.Map;

public class Rectangle extends Shapes{

    private int width;
    private int height;
    private Point corner;

    Rectangle(){

    }
    Rectangle(Integer id, Map<String,String> p){
        super(id,p);
    }

    public void assignW_H() {
        String width  = this.properties.get("width");
        String height  = this.properties.get("height");

        if (width == null || height == null ){
            throw new RuntimeException("Width or Height missing");
        }
        this.width = Integer.parseInt(width);
        this.height = Integer.parseInt(height);
    }

    public void assignCorner() {
        String corner = this.properties.get("corner");
        if(corner == null){
            throw new RuntimeException("center of rectangle missing");
        }
        String[] centerArr = corner.split(",");
        this.corner = new Point(Integer.parseInt(centerArr[0]),Integer.parseInt(centerArr[1]));
    }

    @Override
    protected String Show() {
        this.assignW_H();
        this.assignCorner();
        return "Width: " + this.width + " ,height: " + this.height + " ,center: ( " + this.corner.x + "," + this.corner.y + " )";
    }
}
