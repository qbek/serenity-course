package com.github.qbek.screenplay.steps;

import com.github.qbek.screenplay.data.card.Card;
import com.github.qbek.screenplay.transforms.UserInStep;
import cucumber.api.Transform;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.serenitybdd.screenplay.Actor;

import static com.github.qbek.screenplay.actions.ActionsFactory.checkCardBalance;
import static com.github.qbek.screenplay.questions.Questions.card;
import static com.github.qbek.screenplay.questions.Questions.cardBalance;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;
import static org.junit.Assert.assertEquals;

public class CardSteps {
    @When("^(\\w+) checks his card balance$")
    public void carlChecksHisCardBalance(
            @Transform(UserInStep.class) Actor user
    ) {
        user.attemptsTo(checkCardBalance());
    }

    @Then("^correct balance is presented$")
    public void correctBalanceIsPresented() {
        Actor user = theActorInTheSpotlight();
        double cardBalance = user.asksFor(cardBalance());
        Card testCard = user.asksFor(card());
        assertEquals(testCard.getBalance(), cardBalance, 0);
    }
}
