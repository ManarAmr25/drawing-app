package com.example.demo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/draw")
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
        this.a.Load(path + name , extension.substring(1));
        return this.a.GetList();
    }

    // "/undo"
    @GetMapping("/undo")
    public Map<Integer,Shapes> Undo(){
        if (!a.Undo()){
            return null;
        }
        return a.GetList();
    }

    // "/redo"
    @GetMapping("/redo")
    public Map<Integer,Shapes> Redo(){
        if(!a.Redo()){
            return null;
        }
        return a.GetList();
    }

    // "/create"
    @GetMapping("/create")
    public Integer Create(@RequestParam(value = "type") String type){
        return this.a.Create(type);
    }

    // "/edit"
    @GetMapping("/edit")
    public void Edit(@RequestParam(value = "id") Integer id,@RequestParam(value = "m") Map<String, String> m){
         this.a.Edit(id,m);
    }

    // "/delete"
    @GetMapping("/delete")
    public void Delete(@RequestParam(value = "id") Integer id){
        this.a.Delete(id);
    }
}
