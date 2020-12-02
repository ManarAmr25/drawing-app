package com.example.demo;

import java.awt.*;
import java.util.Map;

public class Circle extends Shapes {

    private int radius;
    private Point topleft;

    public Circle(){

    }
    public Circle( Integer id, Map<String,String> p){
        super(id,p);
    }

    private void assignRadius() {
        String radius  = this.properties.get("radius");
        if (radius == null){
            throw new RuntimeException("radius missing");
        }
        this.radius = Integer.parseInt(radius);
    }

    private void assignTopleft() {
        String corner = this.properties.get("topleft");
        if(corner == null){
            throw new RuntimeException("the topleft point of circle missing");
        }
        String[] centerArr = corner.split(",");
        this.topleft = new Point(Integer.parseInt(centerArr[0]),Integer.parseInt(centerArr[1]));
    }

    @Override
    protected String Show() {
        this.assignRadius();
        this.assignTopleft();
        return "radius: " + this.radius + " ,center: ( " +this.topleft.x + "," +this.topleft.y + " )";
    }
}
