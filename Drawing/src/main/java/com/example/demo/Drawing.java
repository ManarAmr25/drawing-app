package com.example.demo;

import com.fasterxml.jackson.databind.ObjectMapper;

import javax.swing.Action;
import javax.xml.bind.JAXBContext;
import java.awt.*;
import java.util.*;

public class Drawing {
    /*
     * NOTE: a trash is needed to restore deleted shapes
     * Undo & redo stacks >> dequeue of actions
     * Actions types:
     * -create new shape
     * -delete existing shape
     * -modify a property
     * When an action occur >> new action is added to the undo stack (added by backend methods not frontend)
     *                      >> redo stack is cleared
     * When undo is clicked >> move the last action to the redo stack
     *                      >> reverse the action ( delete X restore, create X delete, modify X reverse)
     * When redo is clicked >> move the last action back to the undo stack
     * How to represent an action:
     * -create >> Type of action: CREATE, id, type of shape: line, circle .. etc
     * -delete >> Type of action: DELETE, id
     * -modify >> Type of action: MODIFY, id, property: center, color .. etc, old value, new value
     * How to reverse an action:
     * -create >> delete (move it to trash)
     * -delete >> restore element from trash by id
     * -modify >> also modify in the same way with old and new values reversed
     * SHOULD WE CREATE AN ACTION CLASS OR JUST KEEP IT AS A STRING ???
     * */

    private Integer id;
    private Deque<action> undo;
    private Deque<action> redo;
    private Map<Integer,Shapes> list;
    private Map<Integer,Shapes> trash;

    Drawing(){

    }

    Drawing(boolean isNew){
        if(isNew){
            this.undo = new ArrayDeque<action>();
            this.redo = new ArrayDeque<action>();
            this.list = new HashMap<Integer, Shapes>();
            this.trash = new HashMap<Integer, Shapes>();
            this.id = 0;
        }
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Deque<action> getUndo() {
        return undo;
    }

    public void setUndo(Deque<action> undo) {
        this.undo = undo;
    }

    public Deque<action> getRedo() {
        return redo;
    }

    public void setRedo(Deque<action> redo) {
        this.redo = redo;
    }

    public Map<Integer, Shapes> getList() {
        return list;
    }

    public void setList(Map<Integer, Shapes> list) {
        this.list = list;
    }

    public Map<Integer, Shapes> getTrash() {
        return trash;
    }

    public void setTrash(Map<Integer, Shapes> trash) {
        this.trash = trash;
    }

    public Integer generateId(){
        return id++;
    }

    public Integer Add(String type){
        Integer id = generateId();
        Shapes s = ShapeFactory.getShape(type, id);

        action a = new action("create",id);
        this.list.put(id,s);
        this.undo.add(a);
        this.redo.clear();
        if(this.undo.size() > 20) {
            this.undo.removeFirst();
        }
        return id;
    }

    public boolean Delete(Integer id){
        Shapes x = this.list.remove(id);
        if(x == null) {
            return false;
        }
        action a = new action("delete",id);
        this.trash.put(x.getId(),x);
        this.undo.add(a);
        this.redo.clear();
        if(this.undo.size() > 20) {
            this.undo.removeFirst();
        }
        return true;
    }

    public Shapes getShapeById(Integer id){
        return this.list.get(id);
    }
    public void Redo(){
        if(this.redo.size() != 0){
            action a = this.redo.removeLast();
            this.undo.add(a);
            if(a.getActionType().equals("create")){
                Shapes x = this.trash.remove(id);
                this.list.put(x.getId(),x);
            }
            else if(a.getActionType().equals("delete")){
                Shapes x = this.list.remove(id);
                this.trash.put(x.getId(),x);
            }
            else if(a.getActionType().equals("modify")){
                Shapes s = getShapeById(id);
                s.setProperty(a.getProperty(), a.getNewValue());
            }
        }
    }

    public void Undo(){
        if(this.undo.size() != 0) {
            action a = this.undo.removeLast();
            this.redo.add(a);
            if(a.getActionType().equals("create")){
                Shapes x = this.list.remove(id);
                this.trash.put(x.getId(),x);
            }
            else if(a.getActionType().equals("delete")){
                Shapes x = this.trash.remove(id);
                this.list.put(x.getId(),x);
            }
            else if(a.getActionType().equals("modify")){
                Shapes s = getShapeById(id);
                s.setProperty(a.getProperty(), a.getOldValue());
            }
        }
    }

    public boolean Update(Integer id, String property, String newValue){
        Shapes s = getShapeById(id);
        if(s == null) {
            return  false;
        }
        String oldValue = s.getProperty(property);
        if(oldValue == null){
            return  false;
        }
        s.setProperty(property, newValue);
        action a = new action(property,oldValue,newValue);
        this.list.put(id,s);
        this.undo.add(a);
        this.redo.clear();
        if(this.undo.size() > 20) {
            this.undo.removeFirst();
        }
        return true;
    }

}
