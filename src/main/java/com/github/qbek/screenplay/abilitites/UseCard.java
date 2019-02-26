package com.github.qbek.screenplay.abilitites;

import com.github.qbek.screenplay.actions.data.CardType;
import net.serenitybdd.screenplay.Ability;

public class UseCard implements Ability {
    private String pan;
    private String expDate;
    private double balance;
    private CardType type;

    public UseCard(String pan, String expDate, double balance, CardType type) {
        this.pan = pan;
        this.expDate = expDate;
        this.balance = balance;
        this.type = type;
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

    public CardType getType() {
        return type;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public String toString() {
        return "use following " + type + " card: " + pan + ", with balance: " + balance;
    }
}
