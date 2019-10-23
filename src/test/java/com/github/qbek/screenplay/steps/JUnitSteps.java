package com.github.qbek.screenplay.steps;

import com.github.qbek.screenplay.data.card.Card;
import net.thucydides.core.annotations.Step;

import static com.github.qbek.screenplay.actions.ActionsFactory.checkCardBalance;
import static com.github.qbek.screenplay.actions.ActionsFactory.loginIntoAccount;
import static com.github.qbek.screenplay.assertions.Assertions.receiveCorrectCardDetails;
import static com.github.qbek.screenplay.data.FactsFactory.cardWithActiveAccount;
import static com.github.qbek.screenplay.questions.Questions.card;
import static net.serenitybdd.screenplay.actors.OnStage.theActorCalled;

public class JUnitSteps {

    String actor;

    @Step("jUnitUser is a card user with active account ")
    public void setupTestData() {
        theActorCalled(actor).has(cardWithActiveAccount());
    }

    @Step
    public void logsIn() {
        theActorCalled(actor).wasAbleTo(loginIntoAccount());
    }

    @Step
    public void checksCardBalance() {
        theActorCalled(actor).attemptsTo(checkCardBalance());
    }

    @Step
    public void correctBalanceIsPresented() {
        Card testCard = theActorCalled(actor).asksFor(card());
        theActorCalled(actor).should(receiveCorrectCardDetails(testCard));
    }
}
