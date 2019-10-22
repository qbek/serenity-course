package com.github.qbek.screenplay.data.card;

public class Card {
    private String pan;
    private String cardHolder;
    private String expDate;
    private double balance;
    private CardType type;

    protected Card(String pan, String cardHolder, String expDate, double balance, CardType type) {
        this.pan = pan;
        this.cardHolder = cardHolder;
        this.expDate = expDate;
        this.balance = balance;
        this.type = type;
    }

    public String getPan() { return pan;}
    public String getCardHolder() { return cardHolder;}
    public String getExpDate() {return expDate;}
    public double getBalance() {
        return balance;
    }

    public CardType getType() {
        return type;
    }
}
