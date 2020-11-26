package com.example.demo;

import java.awt.*;
public  abstract class Shapes implements Cloneable {

    int borderThickness;
    Color borderColor;
    Integer id;

    Shapes(int borderThickness, Color borderColor, Integer id) {
        this.borderColor = borderColor;
        this.borderThickness = borderThickness;
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getBorderThickness() {
        return borderThickness;
    }

    public void setBorderThickness(int borderThickness) {
        this.borderThickness = borderThickness;
    }

    public Color getBorderColor() {
        return borderColor;
    }

    public void setBorderColor(Color borderColor) {
        this.borderColor = borderColor;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }


    protected abstract String Show();

}
