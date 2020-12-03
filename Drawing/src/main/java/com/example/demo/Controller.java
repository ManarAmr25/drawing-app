package com.example.demo;

import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.web.bind.annotation.*;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.Map;

@RestController
@CrossOrigin
public class Controller {
    /*
    new drawing >> GET:"/new"
    save >> "/save", name, path, extension
    load >> "/load", name(extension), path , return: Map<Integer,Shapes>
    redo & undo >> "/change", return: Map
    create shape >> "/create", type, return: id
    edit >> "/edit", id, Map<property,newValue>
    delete shape >> "/delete", id
     */

     App a = App.Get();

    @GetMapping("/new")
    public void NewDrawing(){
        a.NewPage();
    }

    @GetMapping("/save")
    public void Save(@RequestParam(value = "name") String name,@RequestParam(value = "path") String path,@RequestParam(value = "extension") String extension){ // .json .xml
        this.a.Save(path + name + extension,extension.substring(1));
    }

    @GetMapping("/load")
    public Map<Integer, Shapes> Load(@RequestParam(value = "name")String name, @RequestParam(value = "path")String path, @RequestParam(value = "extension") String extension){
        this.a.Load(path + name + extension, extension.substring(1));
      //  System.out.print(this.a.GetList());
        return this.a.GetList();
    }

    // "/undo"
    @GetMapping("/undo")
    public Map<Integer,Shapes> Undo(){
        if (!a.Undo()){
            return null;
        }
        System.out.println("undo");
        System.out.println(a.GetList());
        return a.GetList();
    }

    // "/redo"
    @GetMapping("/redo")
    public Map<Integer,Shapes> Redo(){
        if(!a.Redo()){
            return null;
        }
        System.out.println("redo");
        System.out.println(a.GetList());
        return a.GetList();
    }

    // "/create"
    @GetMapping("/create")
    public Integer Create(@RequestParam(value = "type") String type){
       // System.out.println("type: "+type);
        return this.a.Create(type);
    }

    // "/edit"
    @PostMapping("/edit")
    public void Edit(@RequestBody String m){
        ObjectMapper mapper = new ObjectMapper();
        try {
            Map<String, String> map = mapper.readValue(m, Map.class);
            String json =map.get("m");
            Map<String, String> map2 = mapper.readValue(json, Map.class);
            System.out.println(map2);
           // System.out.println(map2.get("id"));
            Integer id = Integer.valueOf(map2.remove("id"));
            this.a.Edit(id,map2);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }

    }

    // "/delete"
    @GetMapping("/delete")
    public void Delete(@RequestParam(value = "id") Integer id){
        this.a.Delete(id);
    }
}
