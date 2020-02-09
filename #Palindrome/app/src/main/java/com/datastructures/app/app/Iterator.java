package com.datastructures.app.app;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Iterator {
    boolean SomethingSubmited;
    Organize Current;
    int CurrentCounter;

    Iterator() {
        this.SomethingSubmited = false;
        this.CurrentCounter = 0;
    }

    @GetMapping("/")
    @ResponseBody
    public String Submit(@RequestParam String wp ) {
        this.SomethingSubmited = true;
        Organize New = new Organize(wp);
        this.Current = New;
        this.CurrentCounter += 1;
        return "Succesfully added:\n" + wp /*+ " + " + this.Current.get_Palindromes()*/;
    }

    @GetMapping("/pal")
    @ResponseBody
    public String Palindromes() {
        String palindromes = new String("Palindrome words: \n");
        if (this.SomethingSubmited == true) {
            palindromes = palindromes + this.Current.get_Palindromes();
        } else {
            palindromes = palindromes + "No Palindromes in submision.";
        }
        return palindromes;
    }

    @GetMapping("/npal")
    @ResponseBody
    public String NotPalindromes() {
        String non_palindromes = new String("Non-palindrome words: \n");
        if (this.SomethingSubmited == true) {
            non_palindromes = non_palindromes + this.Current.get_NotPalindromes();
        } else {
            non_palindromes = non_palindromes + "No Non-Palindromes in submision.";
        }
        return non_palindromes;
    }

    @GetMapping("/all")
    @ResponseBody
    public String All() {
        String All = new String("All words: \n");
        if (this.SomethingSubmited == true) {
            All = this.Current.get_All();
        } else {
            All = All + "No words in submision.";
        }
        return All;
    }
}
