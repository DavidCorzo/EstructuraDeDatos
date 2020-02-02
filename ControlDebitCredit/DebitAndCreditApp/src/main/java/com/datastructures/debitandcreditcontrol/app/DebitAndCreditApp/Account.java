package com.datastructures.debitandcreditcontrol.app.DebitAndCreditApp;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

public class Account {
    double[] MasterDebit;
    double[] MasterCredit;
    int Counter;
    double DebitTotal;
    double CreditTotal;
    double Balance;
    double DebitAverage;
    double HighestDebit;
    int OperationsRecorded;


    Account() {
        this.MasterDebit = new double[10];
        this.MasterCredit = new double[10];
        this.Counter = 0;
    }

    @GetMapping("/print")
    @ResponseBody
    public String display_all_transactions() {
        boolean not_done_debit = true;
        boolean not_done_credit = true;
        int i = 0;
        String s = new String();
        while (not_done_debit && not_done_credit) {
            try {
                s = s + "\t\tDebit: " + this.MasterDebit[i];
            } catch (Exception e) {
                not_done_debit = false;
            }
            try {
                s = s + "\t\tCredit: " + this.MasterCredit[i];
            } catch (Exception e) {
                not_done_credit = false;
            }

        return s;
    }



//    public String add_debit( String amount) {
//        String status;
//        try {
//            double debit_amount = Double.valueOf(amount);
//            this.DebitTotal = this.DebitTotal + debit_amount;
//            this.MasterDebit[this.Counter] = debit_amount;
//            status = "Succesful in adding " + amount + " to account";
//        } catch (Exception e) {
//            status = "Unsuccesful, error dgcm in process.";
//        }
//        return status;
//    }
}
