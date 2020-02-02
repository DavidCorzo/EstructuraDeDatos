package com.datastructures.stack.StackApp;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class ObjectArray {
    String content;
    String date;
    ObjectArray(String param) {
        LocalDateTime requeriment1 = LocalDateTime.now();
        DateTimeFormatter requirement2 = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        this.date = requeriment1.format(requirement2).toString();
        this.content = param;
    }

    public String Date() {
        return this.date;
    }

    public String Content() {
        return this.content;
    }
}