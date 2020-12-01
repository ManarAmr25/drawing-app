package com.example.demo;

import com.fasterxml.jackson.core.util.DefaultPrettyPrinter;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;

import java.beans.XMLDecoder;
import java.beans.XMLEncoder;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.Map;

public class App {

    static volatile App app;
    private Drawing current;

    private App() {}

    public static App Get() {
        if(app == null) {
            synchronized(App.class) { // Lock
                if(app == null)
                    app = new App(); // first creation
                else {
                    return app;
                }
            }
        }
        return app;
    }

    public boolean Save(String path, String type){
        //TODO handle files overwriting??
        if(type.equalsIgnoreCase("XML")){
            try {
                FileOutputStream file = new FileOutputStream(path);
                XMLEncoder encoder = new XMLEncoder(file);
                encoder.writeObject(this.current);
                encoder.close();
                file.close();
            } catch (IOException e) {
                e.printStackTrace();
                return false;
            }
        }else if(type.equalsIgnoreCase("JSON")){
            try {
                ObjectMapper mapper = new ObjectMapper();
                ObjectWriter writer = mapper.writer(new DefaultPrettyPrinter());
                writer.writeValue(Paths.get(path).toFile(), this.current);
                return true;
            } catch (Exception ex) {
                ex.printStackTrace();
                return false;
            }
        }
        return false;
    }
    public boolean Load(String path, String type){
        if(type.equalsIgnoreCase("XML")){
            try {
                FileInputStream file = new FileInputStream(path);
                XMLDecoder decoder = new XMLDecoder(file);
                this.current = (Drawing) decoder.readObject();
                decoder.close();
                file.close();
            } catch (IOException e) {
                e.printStackTrace();
                return false;
            }
        }else if(type.equalsIgnoreCase("JSON")){
            try {
                ObjectMapper mapper = new ObjectMapper();
                this.current = mapper.readValue(Paths.get(path).toFile(), Drawing.class);
                return true;
            } catch (Exception ex) {
                ex.printStackTrace();
                return false;
            }
        }
        return  false;
    }

    public void NewPage(){
        this.current = new Drawing(true);
    }

    public Map<Integer, Shapes> GetList(){ // undo & redo
        if (this.current != null){
            return this.current.getList();
        }
        return null;
    }

    public Integer Create(String type){
        return this.current.Add(type);
    }

    public void Edit(Integer id,Map<String, String> m) { //Map<property,value>
        for (String property : m.keySet()) {
            this.current.Update(id, property, m.get(property));
        }
    }

    public void Delete(Integer id){
        this.current.Delete(id);
    }
}
