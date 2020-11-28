package com.example.demo;

import java.awt.*;
import java.util.Map;

public class Circle extends Shapes {

    private int radius;
    private Point center;

    Circle(){

    }
    Circle( Integer id, Map<String,String> p){
        super(id,p);
        this.assignRadius();
        this.assignCenter();
    }

    public void assignRadius() {
        String radius  = this.properties.get("radius");
        if (radius == null){
            throw new RuntimeException("radius missing");
        }
        this.radius = Integer.parseInt(radius);
    }

    public void assignCenter() {
        String center = this.properties.get("center");
        if(center == null){
            throw new RuntimeException("center missing");
        }
        String[] centerArr = center.split(",");
        this.center = new Point(Integer.parseInt(centerArr[0]),Integer.parseInt(centerArr[1]));
    }

    @Override
    protected String Show() {
        return "radius: " + this.radius + " ,center: ( " +this.center.x + "," +this.center.y + " )";
    }
}
