package com.datastructures.stack.StackApp;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StackTest {

    @Test
    void push() {
        Stack obj = new Stack();
        assertEquals("1234567",obj.push("1234567"));
        assertEquals("hello world",obj.push("hello world"));
    }

    @Test
    void print() {
        Stack obj = new Stack();
        obj.push("1234567");
        assertEquals("Index:\t[0] : \tContent: " + obj.info()[1] + "\tRecorded: " + obj.info()[0] + "\n", obj.print());
    }

    @Test
    void pop() {
        Stack obj = new Stack();
        obj.push("1234567");
        obj.push("Last Element");
        assertEquals("Last Element : " + obj.info()[0],obj.pop());
    }

    @Test
    void clear() {
        Stack obj = new Stack();
        obj.push("1234567");
        obj.clear();
        assertEquals(null,obj.Master[0]);
    }
}