package com.datastructures.stack.StackApp;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;

@Controller // Este es el código fuente
public class Stack {

    ArrayList<String> Stack = new ArrayList<>();
    String FinalStringToPrint;

    Stack(){
        // Empty constructor
    }

    @RequestMapping("/push")
    @ResponseBody
    public ArrayList<String> push (@RequestParam String la) {
        this.Stack.add(la);
//        for (int i = 0 ; i < 10 ; i ++ ) {
//            String s = String.valueOf(i);
//            this.Stack.add(s);
//        }
        return this.Stack;
    }

    @RequestMapping("/pop")
    @ResponseBody
    public String pop (){
        StringBuffer LastElement = new StringBuffer();
        int index = this.Stack.size() - 1;
        if (index < 0){
            index = 0;
        }
        System.out.println(index);
        String Last;
        if (this.Stack.size() != 0) {
            LastElement.append(this.Stack.get(index));
            Last = LastElement.toString();
            this.Stack.remove(index);
        } else {
            Last = "Empty array";
        }
        return Last;
    }

    @RequestMapping("/print")
    @ResponseBody
    public String print () {
        StringBuffer all_array_joined = new StringBuffer();
        int counter = 0;
        if (this.Stack.size() != 0) {
            for (String s : this.Stack) {
                String index = Integer.toString(counter);
                all_array_joined.append(" [" + index + "]: ");
                 all_array_joined.append(s);
                 if (counter != this.Stack.size() - 1) {
                     all_array_joined.append(", \n");
                 } else {
                     all_array_joined.append("\n");
                }

                 counter += 1;
            }
            this.FinalStringToPrint = all_array_joined.toString();
        } else {
            this.FinalStringToPrint = "";
        }
        return this.FinalStringToPrint;
    }

    @RequestMapping("/clear")
    @ResponseBody
    public String clear () {
        this.Stack.clear();
//        int index = this.Stack.size();
//        StringBuffer status = new StringBuffer();
//        for (int i = 0 ; i < this.Stack.size() ; i ++ ) {
//            // Just iterate the amount of times that the array has elements
//            status.append(this.Stack.get(index) + "Succesfully Removed...");
//            this.Stack.remove(index);
//            index -= 1;
//        }
      return "Status: Succesfully removed all elements of array";
    }

}
