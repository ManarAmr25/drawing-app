package com.example.demo;

import com.fasterxml.jackson.databind.ObjectMapper;
import javax.xml.bind.JAXBContext;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class Drawing {

    private Integer id;
    private Stack<Shapes> undo;
    private Stack<Shapes> redo;
    private Map<Integer,Shapes> list;

    Drawing(boolean isNew){
        if(isNew){
            this.undo = new Stack<Shapes>();
            this.redo = new Stack<Shapes>();
            this.list = new HashMap<Integer, Shapes>();
            this.id = 0;
        }
    }

    public long generateId(){
        return id++;
    }

    public boolean Add(Shapes s){
        this.list.put(s.getId(),s);
        this.undo.add(s);
        return true;
    }

    public boolean Delete(Integer id){     //TODO handle undo and redo
        Shapes x = this.list.remove(id);
        if(x == null) {
            return false;
        }
        this.undo.push(x);
        return true;
    }

    public Shapes getShapeById(Integer id){
        return this.list.get(id);
    }

}
