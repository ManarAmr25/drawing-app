package com.example.demo;

import java.awt.*;
import java.util.Map;

public class Ellipse extends Shapes{

    private int major;
    private int minor;
    private Point center;

    Ellipse(){

    }

    Ellipse(Integer id, Map<String,String> p) {
        super(id, p);
        this.assignAxes();
        this.assignCenter();
    }

    public void assignAxes() {
        String major = this.properties.get("major");
        String minor = this.properties.get("minor");
        if(major == null || minor == null){
            throw new RuntimeException("major or minor missing");
        }
        this.major = Integer.parseInt(major);
        this.minor = Integer.parseInt(minor);
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
        return "major axis: " + this.major + " ,minor axis: " + this.minor + " ,center: ( " +this.center.x + "," +this.center.y + " )";
    }

}
