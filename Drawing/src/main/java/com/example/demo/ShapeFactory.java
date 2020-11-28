package com.example.demo;

import org.w3c.dom.css.Rect;

import java.awt.*;
import java.util.HashMap;
import java.util.Map;

public class ShapeFactory {

    //initializes the shapes with default values
    public static Shapes getShape(String type, int id) {
        Map<String, String> props = new HashMap<>();
        props.put("borderthickness","1");
        props.put("bordercolor","0 0 0 1"); //black
        if (type == null) {
            return null;
        }
        if (type.equalsIgnoreCase("Line")) {
            props.put("startpoint","100,100");
            props.put("endpoint","100,200");
            return new Line(id,props);
        } else if (type.equalsIgnoreCase("Circle")) {
            props.put("center","100,100");
            props.put("radius","100");
            props.put("color","255 255 255 0");
            return new Circle(id, props);
        } else if (type.equalsIgnoreCase("Ellipse")) {
            props.put("center","100,100");
            props.put("major","200");
            props.put("minor","100");
            props.put("color","255 255 255 0");
            return new Ellipse(id, props);
        } else if (type.equalsIgnoreCase("Square")) {
            props.put("length","100");
            props.put("TopLeftCorner","100,100");
            props.put("color","255 255 255 0");
            return new Square(id, props);
        } else if (type.equalsIgnoreCase("Rectangle")) {
            props.put("width","150");
            props.put("height","100");
            props.put("TopLeftCorner","100,100");
            props.put("color","255 255 255 0");
            return new Rectangle(id, props);
        } else if (type.equalsIgnoreCase("Triangle")) {
            props.put("color","255 255 255 0");
            props.put("base","150");
            //add missing properties for triangle
            return new Triangle(id, props);
        }
        return null;
    }
}
