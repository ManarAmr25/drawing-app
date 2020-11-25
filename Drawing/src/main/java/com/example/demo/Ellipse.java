package com.example.demo;

import java.awt.*;

public class Ellipse extends Shapes{

    private double calcMajor(){

        return Math.abs(this.endPoint.x - this.startPoint.x)/2;
    }

    private double calcMinor(){
        return Math.abs(this.endPoint.y - this.startPoint.y)/2;
    }

    @Override
    protected String Show() {
        Point center = calcCenter();
        double major = calcMajor();
        double minor = calcMinor();
        return "major axis: " + major + " ,minor axis: " + minor + " ,center: ( " + center.x + "," + center.y + " )";
    }

}
