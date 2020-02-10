package com.datastructures.app.app;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class IteratorTest {

    @Test
    void submit() {
        Iterator obj = new Iterator();
        assertEquals("Succesfully added:\n89",obj.Submit("89"));
    }

    @Test
    void palindromes() {
        Iterator obj = new Iterator();
        obj.Submit("abba,hello,12321,lol,hey"); // palindrome
        assertEquals("Palindrome words: \nabba,12321,lol,",obj.Palindromes());
    }

    @Test
    void notPalindromes() {
        Iterator obj = new Iterator();
        obj.Submit("abba,hello,12321,lol,hey"); // palindrome
        assertEquals("Non-palindrome words: \nhello,hey,",obj.NotPalindromes());
    }

    @Test
    void all() {
        Iterator obj = new Iterator();
        obj.Submit("abba,hello,12321,lol,hey"); // palindrome
        assertEquals("All the palindromes: \n ==> abba,12321,lol,\nAll the non-palindromes: \n ==> hello,hey,\n",obj.All());
    }
}