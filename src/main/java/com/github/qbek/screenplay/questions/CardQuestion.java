package com.github.qbek.screenplay.questions;

import com.github.qbek.screenplay.data.card.Card;
import com.github.qbek.screenplay.data.card.UseCards;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

public class CardQuestion implements Question<Card> {
    @Override
    public Card answeredBy(Actor user) {
        return user.usingAbilityTo(UseCards.class).getCard();
    }
}
