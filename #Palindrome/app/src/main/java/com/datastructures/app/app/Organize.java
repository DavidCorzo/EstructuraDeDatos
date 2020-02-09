package com.datastructures.app.app;


public class Organize {
    Palindrome[] Objects;
    String[] Palindromes;
    int PalindromeCounter;
    String[] NotPalindromes;
    int NotPalindromeCounter;
    String[] Content;


    Organize(String wp){
        this.Content = wp.split(",");
        this.PalindromeCounter = 0;
        this.NotPalindromeCounter = 0;
        this.Palindromes = new String[this.Content.length];
        this.NotPalindromes = new String[this.Content.length];
//        String WordParagraph = new String();
//        WordParagraph = "NANNAN, NAURRUAN, NBN, NEN, NEVEN, NGN, NIN, NISIN, NMN, NN, NON, NOON, NRN, NSN, NUN, O, OBO, OGO, OGOPOOGO, OHO, ONO, OO, OOO, OPPO, OSO, OTO, OTTO, OWO, OXO, P, PAP, PBP, PCP, PDP, PEEP, PEP, PGP, PHP, PIP, PIPIPIP, PNP, POOP, POP, PP, PPP, PRP, PSP, PULLUP, PUP, PVP, PWP, PZP, Q, QAANAAQ, QAZAQ, QOQ, QQ, R, RACECARS, RADAR, RAR, REDDER, REDIVIDER, REER, REFER";
        for ( int i = 0 ; i < this.Content.length ; i ++ ) {
            this.Content[i] = this.Content[i].replaceAll("\\s","");
        }

        // Initialize array of n palindrome objects.
        this.Objects = new Palindrome[this.Content.length];
        for ( int i = 0 ; i < this.Content.length ; i ++ ) {
            Palindrome Temporary = new Palindrome(this.Content[i]);
            if (Temporary.get_is_palindrome()) {
                this.Palindromes[this.PalindromeCounter] = this.Content[i];
                this.PalindromeCounter += 1;
            } else {
                this.NotPalindromes[this.NotPalindromeCounter] = this.Content[i];
                this.NotPalindromeCounter += 1;
            }
        }
    }

    public String get_Palindromes() {
        String s = new String();
        for ( int i = 0 ; i < this.Content.length ; i ++ ) {
            if (this.Palindromes[i] == null){
                break;
            } else {
                s = s + this.Palindromes[i] + ",";
            }
        }
        return s;
    }

    public String get_NotPalindromes() {
        String s = new String();
        for ( int i = 0 ; i < this.Content.length ; i ++ ) {
            if (this.NotPalindromes[i] == null){
                break;
            } else {
                s = s + this.NotPalindromes[i] + ",";
            }
        }
        return s;
    }

    public String get_All() {
        String s = new String();
        s = s + "All the palindromes: \n";
        s = s + " ==> " + get_Palindromes() + "\n";
        s = s + "All the non-palindromes: \n";
        s = s + " ==> " + get_NotPalindromes() + "\n";
        return s;
    }

}