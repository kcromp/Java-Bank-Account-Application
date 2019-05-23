package com.company;

public class Savings extends Account{
    //
    // Properties specific to the Savings account
    private int safeDepositBoxId;
    private int safeDepositBoxKey;


    // Constructor to initialize settings for the Savings account properties
    public Savings(String name, String ssn, double initialDeposit) {
        super(name, ssn, initialDeposit);
        accountNumber = "1" + accountNumber;
        setSafetyDepositBox();

    }

    //Savings accounts use .25 points less the base rate
    @Override
    public void setRate() {
        rate = getBaseRate() - .25;
    }

    // Safe Deposit Box is a 3-digit number and accessed with a 4-digit code
    private void setSafetyDepositBox (){
        safeDepositBoxId = (int) (Math.random() * Math.pow(10, 3));
        safeDepositBoxKey = (int) (Math.random() * Math.pow(10, 4));
    }

    // Methods specific to SAV acct
    public void showInfo() {
        super.showInfo();
        System.out.println(
                " Your Savings Account Features" +
                        "\n Safe Deposit Box ID: " + safeDepositBoxId +
                        "\n Safe Deposit Box Key: " + safeDepositBoxKey
        );

    }
}
