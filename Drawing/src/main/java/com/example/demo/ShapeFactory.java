package com.example.demo;

import org.w3c.dom.css.Rect;

import java.awt.*;

public class ShapeFactory {

    public static Shapes getShape(String type, int id) {
        if (type == null) {
            return null;
        }
        if (type.equalsIgnoreCase("Line")) {
            return new Line(1, new Color(0, 0, 0, 0), id, new Point(0, 0), new Point(100, 100));
        } else if (type.equalsIgnoreCase("Circle")) {
            return new Circle(1, new Color(0, 0, 0, 0), id, new Point(0, 0), new Color(255, 255, 255, 0), 100);
        } else if (type.equalsIgnoreCase("Ellipse")) {
            return new Ellipse(1, new Color(0, 0, 0, 0), id, 150, 100, new Point(0, 0), new Color(255, 255, 255, 0));
        } else if (type.equalsIgnoreCase("Square")) {
            return new Square(1, new Color(0, 0, 0, 0), id, 100, new Point(100, 100), new Color(0, 0, 0, 0));
        } else if (type.equalsIgnoreCase("Rectangle")) {
            return new Rectangle(1, new Color(0, 0, 0, 0), id, 100, 50, new Point(0, 0), new Color(255, 255, 255, 0));
        } else if (type.equalsIgnoreCase("Triangle")) {
            return new Triangle(1, new Color(0, 0, 0, 0), id, 100, new Point(0, 0), new Color(255, 255, 255, 0));
        }
        return null;
    }
}
