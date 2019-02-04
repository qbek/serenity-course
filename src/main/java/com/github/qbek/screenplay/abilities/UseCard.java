package com.github.qbek.screenplay.abilities;

import com.github.qbek.screenplay.testdata.Card;
import net.serenitybdd.screenplay.Ability;

public class UseCard implements Ability {

    private Card card;

    public UseCard (Card card) {
        this.card = card;
    }

    public Card getCard() {
        return card;
    }
}
