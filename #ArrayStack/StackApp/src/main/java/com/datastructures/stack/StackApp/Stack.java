package com.datastructures.stack.StackApp;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class Stack {
    // predefined array size for simplicity
    public ObjectArray[] Master;
    public int Counter;

    Stack() {
        this.Master = new ObjectArray[50];
        this.Counter = 0;
    }

    @GetMapping("/push")
    @ResponseBody
    public String push (@RequestParam String p) {
        if (this.Counter < this.Master.length) {
            ObjectArray InsertTemporary = new ObjectArray(p);
            this.Master[this.Counter] = InsertTemporary;
            this.Counter += 1;
        } else {
            p = "Error: array was initialized with a fixed size.";
        }
        return p;
    }

    @GetMapping("/print")
    @ResponseBody
    public String print () {
        String s = new String();
        boolean not_done = true;
        int i = 0;
        while (not_done) {
            if (this.Master[i] != null){
            s = s + "Index:\t[" + i + "] : " + "\tContent: " + this.Master[i].Content() + "\tRecorded: " + this.Master[i].Date() + "\n";
            i ++ ;
        } else {
                not_done = false;
            }
        }

        return s;
    }

    @GetMapping("/pop")
    @ResponseBody
    public String pop() {
        int index_of_last_element = this.Counter - 1;
        String Pop = this.Master[index_of_last_element].Content() + " : " + this.Master[index_of_last_element].Date();
        this.Master[index_of_last_element] = null;
        this.Counter -= 1;
        return Pop;
    }

    @GetMapping("/clear")
    @ResponseBody
    public String clear() {
        for ( int i = 0 ; i < this.Master.length ; i ++ ) {
            this.Master[i] = null;
        }
        this.Counter = 0;
        return "Succesfully removed every element from array";
    }

    public String[] info(){
        String[] obj = new String[2];
        obj[0] = this.Master[0].Date();
        obj[1] = this.Master[0].Content();
        return obj;
    }
}


