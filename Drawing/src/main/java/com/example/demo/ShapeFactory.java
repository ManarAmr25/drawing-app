package com.example.demo;

import org.w3c.dom.css.Rect;

import java.awt.*;
import java.util.HashMap;
import java.util.Map;

public class ShapeFactory {

    private Line l;
    private Circle c;
    private Ellipse e;
    private Square s;
    private Rectangle r;
    private Triangle t;

    ShapeFactory(){
        //create line
        Map<String,String> lmap = new HashMap<>();
        lmap.put("first","500,200");
        lmap.put("second","700,400");
        lmap.put("width","7");
        lmap.put("color","0000ff");
        lmap.put("type","line");
        lmap.put("borderwidth","0");
        lmap.put("bordercolor","0000ff");
        this.l = new Line(-1,lmap);
        //create circle
        Map<String,String> cmap = new HashMap<>();
        cmap.put("topleft","500,200");
        cmap.put("radius","100");
        cmap.put("color","0000ff");
        cmap.put("type","circle");
        cmap.put("borderwidth","0");
        cmap.put("bordercolor","0000ff");
        this.c = new Circle(-1,cmap);
        //create ellipse
        Map<String,String> emap = new HashMap<>();
        emap.put("topleft","500,200");
        emap.put("radius_x","80");
        emap.put("radius_y","50");
        emap.put("color","0000ff");
        emap.put("borderwidth","0");
        emap.put("bordercolor","0000ff");
        this.e = new Ellipse(-1,emap);
        //create square
        Map<String,String> smap = new HashMap<>();
        smap.put("width","100");
        smap.put("height","100");
        smap.put("topleft","500,200");
        smap.put("color","0000ff");
        smap.put("type","square");
        smap.put("borderwidth","0");
        smap.put("bordercolor","0000ff");
        this.s = new Square(-1,smap);
        //create rectangle
        Map<String,String> rmap = new HashMap<>();
        rmap.put("width","150");
        rmap.put("height","100");
        rmap.put("topleft","500,200");
        rmap.put("color","0000ff");
        rmap.put("type","rectangle");
        rmap.put("borderwidth","0");
        rmap.put("bordercolor","0000ff");
        this.r = new Rectangle(-1,rmap);
        //create triangle
        Map<String,String> tmap = new HashMap<>();
        tmap.put("first","500,200");
        tmap.put("second","400,400");
        tmap.put("third","600,400");
        tmap.put("color","0000ff");
        tmap.put("type","triangle");
        tmap.put("borderwidth","0");
        tmap.put("bordercolor","0000ff");
        this.t = new Triangle(-1,tmap);
    }

    //initializes the shapes with default values
    public Shapes getShape(String type, int id) {
        Map<String, String> props = new HashMap<>();

        if (type == null) {
            return null;
        }
        if (type.equalsIgnoreCase("Line")) {
            try {
                Line copy = (Line) this.l.clone();
                copy.setId(id);
                return copy;
            } catch (CloneNotSupportedException cloneNotSupportedException) {
                cloneNotSupportedException.printStackTrace();
                return null;
            }
        } else if (type.equalsIgnoreCase("Circle")) {
            try {
                Circle copy = (Circle) this.c.clone();
                copy.setId(id);
                return copy;
            } catch (CloneNotSupportedException cloneNotSupportedException) {
                cloneNotSupportedException.printStackTrace();
                return null;
            }
        } else if (type.equalsIgnoreCase("Ellipse")) {
            try {
                Ellipse copy = (Ellipse) this.e.clone();
                copy.setId(id);
                return copy;
            } catch (CloneNotSupportedException cloneNotSupportedException) {
                cloneNotSupportedException.printStackTrace();
                return null;
            }
        } else if (type.equalsIgnoreCase("Square")) {
            try {
                Square copy = (Square) this.s.clone();
                copy.setId(id);
                return copy;
            } catch (CloneNotSupportedException cloneNotSupportedException) {
                cloneNotSupportedException.printStackTrace();
                return null;
            }
        } else if (type.equalsIgnoreCase("Rectangle")) {
            try {
                Rectangle copy = (Rectangle) this.r.clone();
                copy.setId(id);
                return copy;
            } catch (CloneNotSupportedException cloneNotSupportedException) {
                cloneNotSupportedException.printStackTrace();
                return null;
            }
        } else if (type.equalsIgnoreCase("Triangle")) { // first , second , third
            try {
                Triangle copy = (Triangle) this.t.clone();
                copy.setId(id);
                return copy;
            } catch (CloneNotSupportedException cloneNotSupportedException) {
                cloneNotSupportedException.printStackTrace();
                return null;
            }
        }
        return null;
    }
}
