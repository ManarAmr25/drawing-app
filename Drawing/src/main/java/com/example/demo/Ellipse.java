package com.example.demo;

import java.awt.*;
import java.util.Map;

public class Ellipse extends Shapes{

    private int radius_x;
    private int radius_y;
    private Point topleft;

    Ellipse(){

    }

    Ellipse(Integer id, Map<String,String> p) {
        super(id, p);
    }

    public void assignAxes() {
        String major = this.properties.get("radius_x");
        String minor = this.properties.get("radius_y");
        if(major == null || minor == null){
            throw new RuntimeException("major or minor missing");
        }
        this.radius_x = Integer.parseInt(major);
        this.radius_y = Integer.parseInt(minor);
    }

    public void assignTopleft() {
        String corner = this.properties.get("topleft");
        if(corner == null){
            throw new RuntimeException("the topleft point of ellipse missing");
        }
        String[] centerArr = corner.split(",");
        this.topleft = new Point(Integer.parseInt(centerArr[0]),Integer.parseInt(centerArr[1]));
    }

    @Override
    protected String Show() {
        this.assignAxes();
        this.assignTopleft();
        return "major axis: " + this.radius_x + " ,minor axis: " + this.radius_y + " ,center: ( " +this.topleft.x + "," +this.topleft.y + " )";
    }

}
