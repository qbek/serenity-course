package com.github.qbek.screenplay;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.github.qbek.screenplay.cast.SuperHeroCast;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.actors.OnStage;

import static com.github.qbek.screenplay.facts.Facts.accountWithCreditCard;
import static com.github.qbek.screenplay.facts.Facts.accountWithDebitCard;
import static com.github.qbek.screenplay.tasks.Tasks.userLogsIntoAccount;

public class CardBalanceSteps {

    @Before
    public void setup() {
        OnStage.setTheStage(new SuperHeroCast());
    }

    @Given("^(\\w+) is a debit card user with active account$")
    public void carlIsACardUserWithActiveAccount(String name) throws Throwable {
        Actor user = OnStage.theActorCalled(name).describedAs("is a card user with active account");
        user.has(accountWithDebitCard());
    }

    @Given("^(\\w+) is a user with active account and credit card$")
    public void adamIsAUserWithActiveAccountAndCreditCard(String name) throws Exception {
        Actor user = OnStage.theActorCalled(name).describedAs("is a user with active account and credit card");
        user.has(accountWithCreditCard());
    }

    @Given("^(\\w+) is logged in his account$")
    public void heIsLoggedInHisAccount(String name) throws JsonProcessingException {
        Actor user = OnStage.theActorCalled(name);
        user.attemptsTo(userLogsIntoAccount());
    }
}
