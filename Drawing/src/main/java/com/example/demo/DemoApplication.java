package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.configurationprocessor.json.JSONObject;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;
import java.awt.*;
import java.io.File;
import java.util.HashMap;
import java.util.Map;

@SpringBootApplication
public class DemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
        /*
        /*try{
            File file = new File("user2.xml");

            // create an instance of `JAXBContext`
            JAXBContext context = JAXBContext.newInstance(String.class);

            // create an instance of `Marshaller`
            Marshaller marshaller = context.createMarshaller();

            // enable pretty-print XML output
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
            String x = new String("Hello");
            marshaller.marshal(x, file);
        }catch (Exception e){
            System.out.println(e);
        }*/
        //--------------------------------------------------------------------------
        /*Drawing d = new Drawing(true);
        Integer c1 = d.Add("circle");
        Integer sq1 = d.Add("square");
        Integer t1 = d.Add("triangle");
        System.out.println(d.Delete(0));
        Integer re1 = d.Add("rectangle");
        System.out.println(d.Update(1,"corner","20,30"));
        System.out.println(d.Delete(1));
        System.out.println(d.Update(3,"corner","10,40"));
        System.out.println(d.Update(1,"color","10 10 10 0.5"));

        System.out.println("list of shapes");
        for (Integer id : d.getList().keySet()){
            String key = Integer.toString(id);
            String value = d.getList().get(id).toString();
            System.out.println(key + " " + value);
        }

        System.out.println("trash");
        for (Integer id : d.getTrash().keySet()){
            String key = Integer.toString(id);
            String value = d.getTrash().get(id).toString();
            System.out.println(key + " " + value);
        }

        System.out.println("undo stack");
        for (action x : d.getUndo()){
            System.out.println(x);
        }

        System.out.println("redo stack");
        for (action x : d.getRedo()){
            System.out.println(x);
        }
System.out.println("-----------------------------------------------");
        d.Undo();
        d.Undo();
        d.Undo();
        d.Undo();
        d.Undo();
        d.Undo();

        System.out.println("list of shapes");
        for (Integer id : d.getList().keySet()){
            String key = Integer.toString(id);
            String value = d.getList().get(id).toString();
            System.out.println(key + " " + value);
        }

        System.out.println("trash");
        for (Integer id : d.getTrash().keySet()){
            String key = Integer.toString(id);
            String value = d.getTrash().get(id).toString();
            System.out.println(key + " " + value);
        }

        System.out.println("undo stack");
        for (action x : d.getUndo()){
            System.out.println(x);
        }

        System.out.println("redo stack");
        for (action x : d.getRedo()){
            System.out.println(x);
        }
        System.out.println("-----------------------------------------------");
        d.Redo();
        d.Redo();
        d.Redo();
        d.Redo();
        d.Redo();
        d.Redo();

        System.out.println("list of shapes");
        for (Integer id : d.getList().keySet()){
            String key = Integer.toString(id);
            String value = d.getList().get(id).toString();
            System.out.println(key + " " + value);
        }

        System.out.println("trash");
        for (Integer id : d.getTrash().keySet()){
            String key = Integer.toString(id);
            String value = d.getTrash().get(id).toString();
            System.out.println(key + " " + value);
        }

        System.out.println("undo stack");
        for (action x : d.getUndo()){
            System.out.println(x);
        }

        System.out.println("redo stack");
        for (action x : d.getRedo()){
            System.out.println(x);
        }
        System.out.println("-----------------------------------------------");
        */

    /*    App a = App.Get();
        System.out.println(a);

        a.NewPage();
        Map<Integer,Shapes> m = a.GetList();
        Integer tempID = a.Create("Line");
        System.out.println(tempID);
        Integer tempID1 = a.Create("circle");
        System.out.println(tempID1);
        System.out.println(a.Create("Line"));

        for (Integer x : m.keySet()){
            System.out.println(m.get(x));
        }

        a.Delete(tempID);
        Map<String,String> props = new HashMap<>();
        props.put("radius","410");
        props.put("color","000000");
        a.Edit(tempID1,props);

        m = a.GetList();
        for (Integer x : m.keySet()){
            System.out.println(m.get(x));
        }

        //a.Save("myJsonFile.json","json");
     //   a.Save("myXmlFile.xml","XML");
*/
    }


}