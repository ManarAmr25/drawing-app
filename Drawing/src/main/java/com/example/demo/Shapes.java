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
        property = property.toLowerCase();
        if(this.properties.containsKey(property)) {
            this.properties.put(property,value);
            System.out.println(this.properties.get(property));
            return true;
        }
        return false;
    }

    public String getProperty(String property){
        return this.properties.get(property);
    }

    @Override
    public String toString() {
        return "Shapes{" +
                "id=" + id +
                ", properties=" + properties +
                '}';
    }
}
