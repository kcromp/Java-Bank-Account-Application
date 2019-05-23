package com.company;

import java.util.LinkedList;
import java.util.List;

public class Main {

    //Account number generated (1 or 2 depending on SAV or CHK, last 2 SSN, 5 digit #, random 3 digit #)
    //SAV holders given Safe Deposit Box, 5 digit #, random 3 digit #
    //CHK holders assigned Debit Card with 12 digit # and 4 digit PIN
    //Accounts determined base interest rate (SAV .25 points less than base rate, CHK 15% of base rate)

    public static void main(String[] args) {
        List<Account> accounts = new LinkedList<Account>();


	    // Read a CSV File then create new accounts based on data
        String file = "/Users/Kelsey/Desktop/JavaPrograms/BankApplication/NewAccounts.csv";
        List<String[]> newAccountHolders = utilities.CSV.read(file);
        for (String[] accountHolder : newAccountHolders) {
            String name = accountHolder[0];
            String ssn = accountHolder[1];
            String accountType = accountHolder[2];
            double initialDeposit = Double.parseDouble(accountHolder[3]);
            if (accountType.equals("Savings")) {
                accounts.add(new Savings(name, ssn, initialDeposit));
            } else if (accountType.equals("Checking")) {
                accounts.add(new Checking(name, ssn, initialDeposit));
            } else {
                System.out.println("Error reading account type");
            }
        }

        for (Account acc : accounts) {
            System.out.println("\n");
            acc.showInfo();
        }

    }
}
