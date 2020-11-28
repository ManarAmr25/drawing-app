package com.example.demo;

import com.fasterxml.jackson.core.util.DefaultPrettyPrinter;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;

import java.nio.file.Paths;

public class App {

    static volatile App app;

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

    Drawing current;

    public void Redo(){ }
    public void Undo(){ }

    public boolean Save(String path, String type){
        if(type.equalsIgnoreCase("XML")){

        }else if(type.equalsIgnoreCase("JSON")){
            try {
                ObjectMapper mapper = new ObjectMapper();
                ObjectWriter writer = mapper.writer(new DefaultPrettyPrinter());
                writer.writeValue(Paths.get(path).toFile(), current);
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

        }else if(type.equalsIgnoreCase("JSON")){
            try {
                ObjectMapper mapper = new ObjectMapper();
                current = mapper.readValue(Paths.get(path).toFile(), Drawing.class);
                return true;
            } catch (Exception ex) {
                ex.printStackTrace();
                return false;
            }
        }
        return  false;
    }

    public void NewPage(){
        current = new Drawing(true);
    }

    public Integer NewShape(String type){return 0;}
    public void DeleteShape(Integer id){}

    public void Update(Shapes oldS , Shapes newS){}//TODO


}
