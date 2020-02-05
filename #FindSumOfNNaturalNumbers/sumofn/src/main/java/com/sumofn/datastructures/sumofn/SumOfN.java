package com.sumofn.datastructures.sumofn;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SumOfN {

    @RequestMapping("/") // Video de funcionamiento y profiling con jmeter
    public static String result_of_sum_n( String number) {
        String indication = "";
        try {
            double actual_number = Double.parseDouble(number);
            // Check for the number in question to be in the natural numbers set.
            if (actual_number > 0 && Math.floor(actual_number) == actual_number )  {
                double result = actual_number * (actual_number + 1) / 2;
                indication =  String.valueOf(result);
            } else {
                indication = "MATH ERROR dgcm: number is not an intiger, is less than or equal to zero. ";
            }
        } catch (Exception e) {
            indication = "ERROR dgcm: Please review the inputed number.";
        }
        return indication;
    }
}
