package com.example.demo;

import java.awt.*;
import java.util.Map;

public class Triangle extends Shapes{

    private Point first;
    private Point second;
    private Point third;

    public Triangle(){

    }
    public Triangle(Integer id, Map<String,String> p){
        super(id,p);
    }

    private void assignPoints(){
        String first = this.getProperty("first");
        String second = this.getProperty("second");
        String third = this.getProperty("third");
        if( first ==null || second == null || third == null){
            throw new RuntimeException("point missing");
        }
        String[] fArr = first.split(",");
        String[] sArr = second.split(",");
        String[] tArr = third.split(",");
        this.first = new Point(Integer.parseInt(fArr[0]),Integer.parseInt(fArr[1]));
        this.second = new Point(Integer.parseInt(sArr[0]),Integer.parseInt(sArr[1]));
        this.third = new Point(Integer.parseInt(tArr[0]),Integer.parseInt(tArr[1]));
    }


    @Override
    protected String Show() {
        this.assignPoints();
        return "first: ( " +this.first.x + "," +this.first.y + " )"
                +" ,second: ( " +this.second.x + "," +this.second.y + " )"
                +" ,third: ( " +this.third.x + "," +this.third.y + " )";
    }
}
