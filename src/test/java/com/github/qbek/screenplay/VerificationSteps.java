package com.github.qbek.screenplay;

import com.github.qbek.screenplay.abilities.Card;
import com.github.qbek.screenplay.abilities.UseCards;
import cucumber.api.java.en.When;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.actors.OnStage;

public class VerificationSteps {
    @When("^(\\w+) checks his card balance$")
    public void carlChecksHisCardBalance(String name) {
        Actor user = OnStage.theActorCalled(name);
        Card card = user.usingAbilityTo(UseCards.class).getCard();
        System.out.println("Karty pan: " + card.getPan());

        // REST GET //localhost:8080/card/<pan>
    }

}
