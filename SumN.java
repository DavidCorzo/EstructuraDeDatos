package com.sumn.sumnwithrest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SumN {
//    @PostMapping("/")
//    public double n(int N) {
//        // int N = 10;
//        double S;
//        S = N * (N + 1) / 2;
//        return S;
//    }
    @GetMapping("/{name}")
    public double n(@PathVariable("name") String D)
    {
        try {
            double d = Double.parseDouble(D);
            return d * (d + 1) / 2 ;
        } catch(Exception e) {
            System.out.println("Error, input is not operable, dgcm.");
            return 0;
        }
    }
}
