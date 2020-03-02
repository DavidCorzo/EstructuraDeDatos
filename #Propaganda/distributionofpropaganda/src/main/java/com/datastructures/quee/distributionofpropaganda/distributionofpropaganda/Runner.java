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

    @RequestMapping("/clear")
    public String clear() {
        String s = DataBase.print();
        DataBase.dequeue_clear();
        return s;
    }

    @RequestMapping("/choose")
    public String choose(@RequestParam String name) {
        String s = new String("nothing");
        Node searched = DataBase.find(name);
        boolean check = DataBase.removed(searched.data);
        if (searched != null && check == true) {
            s = s + "hello";
        }
        //        if ((searched != null) && (check)) {
//            s = s + "\nDispaching: " + DataBase.getData(searched.data);
//        }
        return s;
    }
}



