package com.datastructures.debitandcreditcontrol.app.DebitAndCreditApp;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class Account {
    double[] MasterCredit;
    double[] MasterDebit;
    int CounterCredit;
    int CounterDebit;
    double DebitTotal;
    double CreditTotal;
    double Balance;
    double DebitAverage;
    double HighestDebit;
    int OperationsRecorded;
    double LargestCurrentCredit;
    double LargestCurrentDebit;
    int DebitOperationsRecorded;



    Account() {
        this.MasterDebit = new double[10];
        this.MasterCredit = new double[10];
        this.CounterDebit = 0;
        this.CounterCredit = 0;
        this.DebitAverage = 0;
        this.DebitTotal = 0;
        this.CreditTotal = 0;
        this.DebitOperationsRecorded = 0;
    }


    @GetMapping("/a")
    @ResponseBody
    public String a (@RequestParam String q) {
        String status = new String();
        try {
            double debit_amount = Double.valueOf(q);
            if (this.CounterDebit != 0) {
                if (this.MasterDebit[this.CounterDebit - 1] < debit_amount){
                    this.LargestCurrentDebit = debit_amount;
                } else {
                    this.LargestCurrentDebit = this.MasterDebit[this.CounterDebit - 1];
                }
            } else if (this.CounterDebit == 0) {
                this.LargestCurrentDebit = debit_amount;
            }
            this.DebitTotal = this.DebitTotal + debit_amount;
            this.MasterDebit[this.CounterDebit] = debit_amount;
//            System.out.println(this.MasterDebit[this.CounterDebit]);
            this.CounterDebit += 1;
            this.OperationsRecorded += 1;
            this.DebitOperationsRecorded += 1;
            status = "Succesful in adding $" + q + " debit to account.";
        } catch (Exception e) {
            status = "Unsuccesful, error dgcm in process.";
        }
        return status;
    }

    @GetMapping("/b")
    @ResponseBody
    public String b (@RequestParam String q ) {
        String status = new String();
        try {
            double credit_amount = Double.valueOf(q);
            if (this.CounterCredit != 0) {
                if (this.MasterCredit[this.CounterCredit - 1] < credit_amount){
                    this.LargestCurrentCredit = credit_amount;
                } else {
                    this.LargestCurrentCredit = this.MasterCredit[this.CounterCredit - 1];
                }
            } else if (this.CounterCredit == 0) {
                this.LargestCurrentCredit = credit_amount;
            }
            this.CreditTotal = this.CreditTotal + credit_amount;
            this.MasterCredit[this.CounterCredit] = credit_amount;
//            System.out.println(this.MasterCredit[this.CounterCredit]);
            this.CounterCredit += 1;
            this.OperationsRecorded += 1;
            status = "Succesful in adding $" + q + " credit to account.";
        } catch (Exception e) {
            status = "Unsuccesful, error dgcm in process.";
        }
        return status;
    }

    @GetMapping("/c")
    @ResponseBody
    public String c () {
        String s = new String();
        for ( int i = 0 ; i < this.MasterDebit.length ; i ++ ) {
            this.DebitTotal = this.DebitTotal + this.MasterDebit[i];
        }
        s = s + "The debit total is: $" + this.DebitTotal;
        return s;
    }

    @GetMapping("/d")
    @ResponseBody
    public String d () {
        String s = new String();
        for ( int i = 0 ; i < this.MasterCredit.length ; i ++ ) {
            this.CreditTotal = this.CreditTotal + this.MasterCredit[i];
        }
        s = s + "The credit total is: $" + this.CreditTotal;
        return s;
    }


    @GetMapping("/e")
    @ResponseBody
    public String e() {
        double tot_cre = 0;
        double tot_deb = 0;
        for ( int i = 0 ; i < this.MasterCredit.length ; i ++ ){
            tot_cre = tot_cre + this.MasterCredit[i];
        }
        for ( int i = 0 ; i < this.MasterDebit.length ; i ++ ) {
            tot_deb = tot_deb + this.MasterDebit[i];
        }
        this.Balance = tot_deb - tot_cre;
        return "Current Balance: " + this.Balance;
    }


    @GetMapping("/f")
    @ResponseBody
    public String f () {
        String s = new String();
        double current = 0;
        for ( int i = 0 ; i < this.MasterDebit.length ; i ++ ) {
            current = current + this.MasterDebit[i];
        }
        if (this.OperationsRecorded != 0) { // no puede ser 0 por que tendriamos una división por 0
            this.DebitAverage = current / this.DebitOperationsRecorded;
        }
        s = s + "The average for " + this.DebitOperationsRecorded + " operations of debit is $" + this.DebitAverage;
        return s;
    }

    @GetMapping("/g")
    @ResponseBody
    public String g(){
        double current = 0;
        for ( int i = 0 ; i < this.MasterDebit.length ; i ++ ) {
            if (current < this.MasterDebit[i]){
                current = this.MasterDebit[i];
            }
            this.LargestCurrentDebit = current;
        }
        return "Largest value for credit operations were: " + this.LargestCurrentDebit;
    }

    @GetMapping("/h")
    @ResponseBody
    public String h () {
        return "Operations: " + this.OperationsRecorded;
    }

    @GetMapping("/i")
    @ResponseBody // no existe tal cosa como debitar una cantidad de 0.0 a una cuenta
    public String i() {
        boolean not_done_debit = true;
        boolean not_done_credit = true;
        String c = new String();
        c = "\nCredits made: \n";
        double sum_c = 0;
        for ( int i = 0 ; i < this.MasterCredit.length ; i ++ ) {
            if (this.MasterCredit[i] != 0.0){
                sum_c = sum_c + this.MasterCredit[i];
                c = c + "\t-\t[" + i + "]: " + this.MasterCredit[i] + "\t\t\n";
            }
        }
        if (c.equals("\nCredits made: \n")){
            c = c + "\t- No transactions made. \n";
        } else {
            c = c + "\nTotal credit: $" + sum_c + "\n" + "--------------------------------------";
        }
        String d = new String();
        d = d + "\nDebits made: \n";
        double sum_d = 0;
        for ( int i = 0 ; i < this.MasterDebit.length ; i ++ ) {
            if (this.MasterDebit[i] != 0.0) {
                sum_d = sum_d + this.MasterDebit[i];
                d = d + "\t-\t[" + i + "]: " + this.MasterDebit[i] + "\t\t\n";
            }
        }
        if (d.equals("\nDebits made: \n")){
            d = d + "\t- No transactions made. \n";
        } else {
            d = d + "\nTotal debit: $" + sum_d + "\n" + "--------------------------------------";
        }
        String consolidate = new String();
        consolidate = c + d;
        return consolidate;
    }

    public double prom() {
        for ( int i = 0 ; i < this.MasterDebit.length ; i ++ ) {
            this.DebitAverage = this.DebitAverage + this.MasterDebit[i];
        }
        return this.DebitAverage;
    }

    public double[] largest_op() {
        double[] deb_cre = new double[2];
        for ( int i = 0 ; i < this.MasterDebit.length ; i ++ ) {
            if (this.LargestCurrentDebit < this.MasterDebit[i]) {
                this.LargestCurrentDebit = this.MasterDebit[i];
            }
        }

        for ( int i = 0 ; i < this.MasterCredit.length ; i ++ ) {
            if (this.LargestCurrentCredit < this.MasterCredit[i]) {
                this.LargestCurrentCredit = this.MasterCredit[i];
            }
        }
        deb_cre[0] = this.LargestCurrentDebit;
        deb_cre[1] = this.LargestCurrentCredit;
        return deb_cre;
    }


    @GetMapping("/j")
    @ResponseBody
    public String j() {
        String s = new String();
        for ( int i = 0 ; i < this.MasterCredit.length ; i ++) {
            if (i == 3 || i == 5 || i == 7 ) {
                double temp = this.MasterCredit[i];
                this.MasterCredit[i] = 0.0;
                s = s + "\n Credit total: " + this.CreditTotal + "\n";
                s = s + "\n Debit total: " + this.DebitTotal + "\n";
                this.Balance = this.DebitTotal + this.CreditTotal;
                s = s + "\n Total Balance: " + this.Balance + "\n";
                s = s + "\n Average Debits: " + prom() + "\n";
                double[] obj = new double[2];
                obj = largest_op();
                s = s + "\n Largest Debit: " + obj[0];
                s = s + "\n Largest Credit: " + obj[1];
                s = s + "\n Total operations: " + this.OperationsRecorded;
                }
            }
        return s;
        }
    }




