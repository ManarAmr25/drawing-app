package com.example.demo;

import java.awt.*;

public class Triangle extends Shapes{

    private int calcBaseLen(){
        return Math.abs(this.endPoint.x - this.startPoint.x);
    }

    private int calcHeight(){
        return Math.abs(this.endPoint.y - this.startPoint.y);
    }

    @Override
    protected String Show() {
        Point center = calcCenter();
        return "Base length: " + Integer.toString(calcBaseLen()) + " ,Height: "+ Integer.toString(calcHeight()) + " ,center: ( " + center.x + "," + center.y + " )";
    }
}
