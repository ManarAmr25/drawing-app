package com.example.demo;

import com.fasterxml.jackson.core.util.DefaultPrettyPrinter;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;

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
