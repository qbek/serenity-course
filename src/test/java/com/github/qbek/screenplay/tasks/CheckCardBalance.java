package com.github.qbek.screenplay.tasks;

import com.github.qbek.screenplay.abilities.Card;
import com.github.qbek.screenplay.abilities.UseCards;
import com.github.qbek.screenplay.facts.CardType;
import net.serenitybdd.rest.SerenityRest;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;

public class CheckCardBalance implements Task {

    @Override
    public <T extends Actor> void performAs(T actor) {

        Card card = actor.usingAbilityTo(UseCards.class).getCard();
        System.out.println("Karty pan: " + card.getPan());
        CardType type = card.getType();
        SerenityRest.when().get(
                String.format("/%s/%s", type.toString().toLowerCase(), card.getPan())
        );
    }
}