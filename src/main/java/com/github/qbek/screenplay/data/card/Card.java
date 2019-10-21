package com.github.qbek.screenplay.data.card;

public class Card {
    private String pan;
    private String cardHolder;
    private String expDate;
    private double balance;

    protected Card(String pan, String cardHolder, String expDate, double balance) {
        this.pan = pan;
        this.cardHolder = cardHolder;
        this.expDate = expDate;
        this.balance = balance;
    }

    public String getPan() { return pan;}
    public String getCardHolder() { return cardHolder;}
    public String getExpDate() {return expDate;}
    public double getBalance() {
        return balance;
    }
}
