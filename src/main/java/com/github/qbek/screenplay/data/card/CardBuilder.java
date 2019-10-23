package com.github.qbek.screenplay.data.card;

public class CardBuilder {

    private String pan;
    private String cardHolder;
    private String expDate;
    private double balance;
    private CardType type;

    public CardBuilder setPan(String pan) {
        this.pan = pan;
        return this;
    }

    public CardBuilder setCardHolder(String cardHolder) {
        this.cardHolder = cardHolder;
        return this;
    }

    public CardBuilder setExpDate(String expDate) {
        this.expDate = expDate;
        return this;
    }

    public CardBuilder setBalance(double balance) {
        this.balance = balance;
        return this;
    }

    public CardBuilder setType(CardType type) {
        this.type = type;
        return this;
    }

    public Card build()
    {
        return new Card(pan, cardHolder, expDate, balance, type);
    }
}
