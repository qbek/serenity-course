package com.github.qbek.screenplay.abilities;

import com.github.qbek.screenplay.facts.CardType;

public class Card {

    private String pan;
    private String extDate;
    private int balance;
    private CardType type;

    Card(String pan, String expDate, CardType type, int balance) {
        this.pan = pan;
        this.extDate = expDate;
        this.balance = balance;
        this.type = type;
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

    public CardType getType () { return type; }

    public void setBalance (int newBalance) {
        this.balance = newBalance;
    }
}
