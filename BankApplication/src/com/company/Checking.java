package com.company;

public class Checking extends Account {
    // Properties specific to a Checking account
    private int debitCardNumber;
    private int debitCardPin;


    // Constructor to initialize checking account properties
    public Checking(String name, String ssn, double initialDeposit) {
        super(name, ssn, initialDeposit);
        accountNumber = "2" + accountNumber;
        setDebitCard();
    }

    //Checking uses 15% of the base rate
    @Override
    public void setRate() {
        rate = getBaseRate() * .15;
    }

    // Methods to the CHK acct
    // Debit Card is a 12 digit number and has a 4-digit pin
    private void setDebitCard() {
        debitCardNumber = (int) (Math.random() * Math.pow(10, 12));
        debitCardPin = (int) (Math.random() * Math.pow(10, 4));
    }

    public void showInfo() {
        super.showInfo();
        System.out.println(
                " Your Checking Account Features" +
                        "\n Debit Card Number: " + debitCardNumber +
                        "\n Debit Card PIN: " + debitCardPin
        );
    }
}
