package com.example.demo;


@Entity
public class RestApiSumN {
    private int result;
    private int n;

    public int getResult() {
        return result;
    }

    public int getN() {
        return n;
    }
    // Setter
    public void setResult(int result) {
        this.result = result;
    }

    public void setN(int n) {
        this.n = n;
    }
}
