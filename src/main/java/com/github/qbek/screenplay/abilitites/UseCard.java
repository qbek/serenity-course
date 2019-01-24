package com.github.qbek.screenplay.abilitites;

import net.serenitybdd.screenplay.Ability;

public class UseCard implements Ability {
    private String pan;
    private String expDate;
    private double balance;

    public UseCard(String pan, String expDate, double balance) {
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

    public String toString() {
        return "use following card: " + pan + ", with balance: " + balance;
    }
}
