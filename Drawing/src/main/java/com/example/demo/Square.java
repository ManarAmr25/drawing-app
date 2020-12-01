package com.example.demo;

import java.awt.*;
import java.util.Map;

public class Square extends Shapes{

    private int width;
    private  int height;
    private Point topleft;

    Square(){

    }

    Square(Integer id, Map<String,String> p){
        super(id,p);
    }

    public void assignW_H() {
        String width  = this.properties.get("width");
        String height  = this.properties.get("height");

        if (width == null || height == null ){
            throw new RuntimeException("Width or Height missing");
        }
        this.width = Integer.parseInt(width);
        this.height = Integer.parseInt(height);
    }

    public void assignTopleft() {
        String corner = this.properties.get("topleft");
        if(corner == null){
            throw new RuntimeException("the topleft point of square missing");
        }
        String[] centerArr = corner.split(",");
        this.topleft = new Point(Integer.parseInt(centerArr[0]),Integer.parseInt(centerArr[1]));
    }

    @Override
    protected String Show() {
        this.assignW_H();
        this.assignTopleft();
        return "Width: " + this.width + " ,height: " + this.height + " ,center: ( " + this.topleft.x + "," + this.topleft.y + " )";
    }

}