package com.example.demo;

import org.w3c.dom.css.Rect;

import java.awt.*;
import java.util.HashMap;
import java.util.Map;

public class ShapeFactory {

    //initializes the shapes with default values
    public static Shapes getShape(String type, int id) {
        Map<String, String> props = new HashMap<>();

        if (type == null) {
            return null;
        }
        if (type.equalsIgnoreCase("Line")) { //color
            props.put("first","500,200");
            props.put("second","700,400");
            props.put("width","7");
            return new Line(id,props);
        } else if (type.equalsIgnoreCase("Circle")) {
            props.put("topleft","500,200");
            props.put("radius","100");
            props.put("color","0000ff");
            return new Circle(id, props);
        } else if (type.equalsIgnoreCase("Ellipse")) {
            props.put("topleft","500,200");
            props.put("radius_x","80");
            props.put("radius_y","50");
            props.put("color","0000ff");
            return new Ellipse(id, props);
        } else if (type.equalsIgnoreCase("Square")) {
            props.put("width","100");
            props.put("height","100");
            props.put("topleft","500,200");
            props.put("color","0000ff");
            return new Square(id, props);
        } else if (type.equalsIgnoreCase("Rectangle")) {
            props.put("width","150");
            props.put("height","100");
            props.put("topleft","500,200");
            props.put("color","0000ff");
            return new Rectangle(id, props);
        } else if (type.equalsIgnoreCase("Triangle")) { // first , second , third
            props.put("first","500,200");
            props.put("second","400,400");
            props.put("third","600,400");
            props.put("color","0000ff");
            return new Triangle(id, props);
        }
        return null;
    }
}