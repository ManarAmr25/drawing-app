package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;
import java.io.File;

@SpringBootApplication
public class DemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
        try{
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
        }
    }

}