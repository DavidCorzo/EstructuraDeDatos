package com.datastructures.stack.StackApp;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StackTest {
    Stack TestList = new Stack();

    StackTest(){
        this.TestList.push("First Element");
        this.TestList.push("Second Element");
        this.TestList.push("Third Element");
        this.TestList.push("Fourth Element");
        this.TestList.push("Last Element"); // This should be the pop
    }

    @Test
    void push() {
        this.TestList.push("THIS IS NOT SUPOSE TO BE IN THE STACK");
        assertEquals(6, this.TestList.Stack.size());
        assertEquals("Last Element", this.TestList.Stack.get(4).toString());
        // The array incremented in size every step of the way
    }

    @Test
    void pop() {
        assertEquals("Last Element", this.TestList.pop());
        assertEquals(4, this.TestList.Stack.size());
    }

    @Test
    void print() {
        assertEquals(" [0]: First Element, \n [1]: Second Element, \n [2]: Third Element, \n [3]: Fourth Element, \n [4]: Last Element\n", this.TestList.print());
    }

    @Test
    void clear() {
        this.TestList.clear();
        assertEquals(0,this.TestList.Stack.size());
    }
} // el código pasó las pruebas unitarias ahora las profiling