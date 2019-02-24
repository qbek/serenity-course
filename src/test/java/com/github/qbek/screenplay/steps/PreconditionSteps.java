package com.github.qbek.screenplay.steps;

import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.actors.Cast;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.rest.abilities.CallAnApi;

import static com.github.qbek.screenplay.actions.Account.loginToAccount;
import static com.github.qbek.screenplay.facts.CardAccountFact.accountWithCard;

public class PreconditionSteps {
    @Before
    public void setup() {
        OnStage.setTheStage(new Cast());
    }

    @Given("^(\\w+) is a card user with active account$")
    public void carlIsACardUserWithActiveAccount(String name) throws Throwable {
        Actor user = OnStage.theActorCalled(name);
        user.has(accountWithCard());
        user.can(CallAnApi.at("http://localhost:8080"));
    }
    


    @Given("^(\\w+) is logged in his account$")
    public void heIsLoggedInHisAccount(String name) throws Throwable {
        Actor user = OnStage.theActorCalled(name);
        user.wasAbleTo(loginToAccount());
    }
}
