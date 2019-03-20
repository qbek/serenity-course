package com.github.qbek.screenplay.abilities;

import net.serenitybdd.screenplay.Ability;

public class UseCards implements Ability {

    private Card card;

    UseCards (Card toUse) {
        this.card = toUse;
    }

    public Card getCard() {
        return card;
    }

    public String toString () {
        return "use following card: " + card.getPan();
    }
}
