package com.github.qbek.screenplay.steps;

import com.github.qbek.screenplay.MySpecialCast;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.actors.OnStage;

import static com.github.qbek.screenplay.actions.Account.loginToAccount;
import static com.github.qbek.screenplay.facts.CardAccountFact.accountWithCreditCard;

public class PreconditionSteps {
    @Before
    public void setup() {
        OnStage.setTheStage(new MySpecialCast());
    }

    @Given("^(\\w+) is a card user with active account$")
    public void carlIsACardUserWithActiveAccount(String name) throws Throwable {
        Actor user = OnStage.theActorCalled(name);
        user.has(accountWithCreditCard());
    }



    @Given("^(\\w+) is logged in his account$")
    public void heIsLoggedInHisAccount(String name) throws Throwable {
        Actor user = OnStage.theActorCalled(name);
        user.wasAbleTo(loginToAccount());
    }
}
