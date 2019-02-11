package com.github.qbek.screenplay.steps;

import com.github.qbek.screenplay.abilitites.UseCard;
import cucumber.api.PendingException;
import cucumber.api.Transform;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.rest.interactions.Get;
import net.serenitybdd.screenplay.rest.interactions.Post;

public class CardActionsSteps {
    @When("^(\\w+) checks his card balance$")
    public void carlChecksHisCardBalance(String userName) throws Throwable {
        // OnStage is a global object. You can access it form anywhere ;)
        Actor user = OnStage.theActorCalled(userName);
        UseCard card = user.usingAbilityTo(UseCard.class);
        user.wasAbleTo(Get.resource("/card/" + card.getPan()));
    }
}
