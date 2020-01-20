package com.sumofn.datastructures.sumofn;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SumOfNTest {

    @Test
    void result_of_sum_n() {
        assertEquals( "325.0",SumOfN.result_of_sum_n( "25" ));
        assertEquals("5050.0", SumOfN.result_of_sum_n("100"));
        assertEquals("500500.0",SumOfN.result_of_sum_n("1000"));
    }
}