package com.github.qbek.screenplay.testdata;

public class Card {
    private String pan;
    private String expDate;
    private double balance;

    public Card (String pan, String expDate, double balance) {
        this.pan = pan;
        this.expDate = expDate;
        this.balance = balance;
    }

    public String getPan() {
        return pan;
    }

    public String getExpDate() {
        return expDate;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }
}
