package com.github.qbek.screenplay.data;

import com.github.qbek.screenplay.data.entitis.Card;
import net.serenitybdd.screenplay.Ability;

public class UseCards implements Ability {

    private Card card;

    public UseCards (Card card) {
        this.card = card;
    }

    public Card getCard() {
        return card;
    }

    public String toString() {
        return String.format("use following card: %s", card.getPan());
    }
}
