package com.datastructures.app.app;

public class Palindrome {
    String original_word;
    String reversed_word;
    boolean is_palindrome;

    Palindrome(String word) {
        this.reversed_word = new String();
        this.original_word = word;
        // This will split every char in the string and return an array of single character strings.
        String[] arr = word.split("|");
        int end = word.length() - 1;
        int stop  = (int) arr.length / 2;
        String temp = new String();
        for ( int i = 0 ; i < stop;) {
            temp = arr[i];
            arr[i] = arr[end];
            arr[end] = temp;
            i ++ ;
            end --;
        }
        for ( int i = 0 ; i < arr.length ; i ++ ) {
            this.reversed_word = this.reversed_word + arr[i];
        }

        if (this.reversed_word.equals(this.original_word)) {
            this.is_palindrome = true;
        } else {
            this.is_palindrome = false;
        }
    }

    public String get_Original_word(){
        return this.original_word;
    }

    public String get_Reversed_word() {
        return this.reversed_word;
    }

    public boolean get_is_palindrome() {
        return this.is_palindrome;
    }
}
