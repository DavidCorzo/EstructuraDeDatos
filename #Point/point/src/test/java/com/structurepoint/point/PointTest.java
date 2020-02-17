package com.structurepoint.point;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PointTest {

    @Test
    void submit() {
        Point obj = new Point();
        assertEquals("Succesfully added: 12, 10",obj.Submit("12,10"));
    }

    @Test
    void detect_cuadrant() {
        Point obj = new Point();
        obj.Submit("12,10");
       assertEquals("12, 10 is in 1st Cuadrant.", obj.detect_cuadrant());
    }
}