package com.datastructures.quee.distributionofpropaganda.distributionofpropaganda;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RunnerTest {

    @Test
    void add() {
        Queue obj = new Queue();
        WorkerData object = new WorkerData("1234","entity","worker1",10);
        Node obje = new Node(object);
        assertEquals(obje.getData().getName(),obj.add(object).data.getName());
    }

    @Test
    void print() {
        Queue obj = new Queue();
        WorkerData object = new WorkerData("1234","entity","worker1",10);
        String s = obj.getData(object);
        String verify ="\nName: worker1\nEntity: entity\nSocial Security: 1234\nDays Worked: 10";
        assertEquals(verify,s);
    }
}