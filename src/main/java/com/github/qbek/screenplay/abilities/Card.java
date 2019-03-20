package com.github.qbek.screenplay.abilities;

public class Card {

    private String pan;
    private String extDate;
    private int balance;

    Card(String pan, String expDate, int balance) {
        this.pan = pan;
        this.extDate = expDate;
        this.balance = balance;
    }

    public String getPan() {
        return pan;
    }

    public String getExtDate() {
        return extDate;
    }

    public int getBalance() {
        return balance;
    }

    public void setBalance (int newBalance) {
        this.balance = newBalance;
    }
}
