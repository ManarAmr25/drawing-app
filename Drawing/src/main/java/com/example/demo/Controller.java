package com.example.demo;

import org.springframework.web.bind.annotation.RequestMapping;
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

    // "/new"
    public void NewDrawing(){
        a.NewPage();
    }

    // "/save"
    public void Save(String name, String path, String extension){ // .json .xml
        this.a.Save(path + name + extension,extension.substring(1));
    }

    // "/load"
    public Map<Integer, Shapes> Load(String name, String path, String extension){
        this.a.Load(path + name , extension.substring(1));
        return this.a.GetList();
    }

    // "/change"
    public Map<Integer, Shapes> Change(){
        return this.a.GetList();
    }

    // "/create"
    public Integer Create(String type){
        return this.a.Create(type);
    }

    // "/edit"
    public void Edit(Integer id,Map<String, String> m){
         this.a.Edit(id,m);
    }

    // "/delete"
    public void Delete(Integer id){
        this.a.Delete(id);
    }
}
