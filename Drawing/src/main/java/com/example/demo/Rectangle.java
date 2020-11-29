package com.example.demo;

import java.awt.*;
import java.util.Map;

public class Rectangle extends Shapes{

    private int width;
    private int height;
    private Point center;

    Rectangle(){

    }
    Rectangle(Integer id, Map<String,String> p){
        super(id,p);
        this.assignW_H();
        this.assignCenter();
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

    public void assignCenter() {
        String center = this.properties.get("center");
        if(center == null){
            throw new RuntimeException("center of rectangle missing");
        }
        String[] centerArr = center.split(",");
        this.center = new Point(Integer.parseInt(centerArr[0]),Integer.parseInt(centerArr[1]));
    }

    @Override
    protected String Show() {
        return "Width: " + this.width + " ,height: " + this.height + " ,center: ( " + this.center.x + "," + this.center.y + " )";
    }
}
