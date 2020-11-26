package com.example.demo;

import java.awt.*;

public class Ellipse extends Shapes{

    int major;
    int minor;
    Point center;
    Color color;

    Ellipse(int borderThickness, Color borderColor, Integer id, int major, int minor, Point center, Color color) {
        super(borderThickness, borderColor, id);
        this.major = major;
        this.minor = minor;
        this.color = color;
        this.center = center;
    }


    public int getMajor() {
        return major;
    }

    public void setMajor(int major) {
        this.major = major;
    }

    public int getMinor() {
        return minor;
    }

    public void setMinor(int minor) {
        this.minor = minor;
    }

    public Point getCenter() {
        return center;
    }

    public void setCenter(Point center) {
        this.center = center;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    @Override
    protected String Show() {

        return "major axis: " + this.major + " ,minor axis: " + this.minor + " ,center: ( " +this.center.x + "," +this.center.y + " )";
    }

}
