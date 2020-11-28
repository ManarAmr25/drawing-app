package com.example.demo;

import java.awt.*;
import java.util.Map;

public  abstract class Shapes implements Cloneable {

    Integer id;
    Map<String,String> properties;


    Shapes(){

    }

    Shapes(Integer id, Map<String,String> p) {
        this.properties = p;
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Map<String, String> getProperties() {
        return properties;
    }

    public void setProperties(Map<String, String> properties) {
        this.properties = properties;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    protected abstract String Show();

    public boolean setProperty(String property , String value){
        if(this.properties.replace(property,value) == null){
           return false;
       }
        return true;
    }

    public String getProperty(String property){
        return this.properties.get(property);
    }

}
