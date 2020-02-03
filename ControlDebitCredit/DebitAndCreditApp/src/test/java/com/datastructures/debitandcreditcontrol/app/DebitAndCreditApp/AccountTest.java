package com.datastructures.debitandcreditcontrol.app.DebitAndCreditApp;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class AccountTest {

    @Test
    void a() {
        Account obj = new Account();
        assertEquals("Succesful in adding $45 debit to account.", obj.a("45"));
    }

    @Test
    void b() {
        Account obj = new Account();
        assertEquals("Succesful in adding $45 credit to account.",obj.b("45"));
    }

    @Test
    void c() {
        Account obj = new Account();
        obj.a("1");
        obj.a("2");
        obj.a("3");
        assertEquals("The debit total is: $12.0",obj.c());

    }

    @Test
    void d() {
        Account obj = new Account();
        obj.b("45");
        obj.b("45");
        assertEquals("The credit total is: $180.0",obj.d());
    }

    @Test
    void e() {
        Account obj = new Account();
        assertEquals("Current Balance: 0.0",obj.e());
    }

    @Test
    void f() {
        Account obj = new Account();
        obj.a("1");
        assertEquals("The average for 1 operations of debit is $1.0",obj.f());
    }

    @Test
    void g() {
        Account obj = new Account();
        obj.a("100");
        assertEquals("Largest value for credit operations were: 100.0", obj.g());
    }

    @Test
    void h() {
        Account obj = new Account();
        obj.a("2");
        obj.b("1");
        assertEquals("Operations: 2", obj.h());
    }

    @Test
    void i() {
        Account obj = new Account();
        obj.a("2");
        obj.b("1");
        assertEquals("\nCredits made: \n\t-\t[0]: 1.0\t\t\n\nTotal credit: $1.0\n----------" +
                "----------------------------\nDebits made: \n\t-\t[0]: 2.0\t\t\n\nTotal debit: $2.0\n--------------------------------------", obj.i());
    }

    @Test
    void j() {
        Account obj = new Account();
        assertEquals(
        "\n Credit total: 0.0\n\n"+
        " Debit total: 0.0\n\n"+
        " Total Balance: 0.0\n\n"+
        " Average Debits: 0.0\n\n"+
        " Largest Debit: 0.0\n"+
        " Largest Credit: 0.0\n"+
        " Total operations: 0\n"+
        " Credit total: 0.0\n\n"+
        " Debit total: 0.0\n\n"+
        " Total Balance: 0.0\n\n"+
        " Average Debits: 0.0\n\n"+
        " Largest Debit: 0.0\n"+
        " Largest Credit: 0.0\n"+
        " Total operations: 0\n"+
        " Credit total: 0.0\n\n"+
        " Debit total: 0.0\n\n"+
        " Total Balance: 0.0\n\n"+
        " Average Debits: 0.0\n\n"+
        " Largest Debit: 0.0\n"+
        " Largest Credit: 0.0\n"+
        " Total operations: 0",obj.j());
    }
}