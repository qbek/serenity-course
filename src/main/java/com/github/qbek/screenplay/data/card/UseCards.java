package com.github.qbek.screenplay.data.card;

import net.serenitybdd.screenplay.Ability;

public class UseCards implements Ability {

    private Card card;

    protected UseCards (Card card) {
        this.card = card;
    }

    public Card getCard() {
        return card;
    }

    public String toString() {
        return "use card";
    }
}
