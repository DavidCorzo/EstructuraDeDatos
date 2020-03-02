package com.datastructures.quee.distributionofpropaganda.distributionofpropaganda;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Runner {
    Queue DataBase = new Queue();

    @RequestMapping("/add")
    public String add(@RequestParam String social, String entity, String name, int days) {
        WorkerData temp = new WorkerData(social, entity, name, days);
        DataBase.add(temp);
        return "Succesfully added: " + name + " to the list.";
    }

    @RequestMapping("/print")
    public String print() {
        return DataBase.print();
    }

    @RequestMapping("/del")
    public String del(@RequestParam String name) {
        String s = new String("");
        boolean check = DataBase.removed(name);
        s = "Removed " + name + " successfully.";
        return s;
    }
}



