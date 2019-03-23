package com.github.qbek.screenplay;

import com.github.qbek.screenplay.abilities.Credentials;
import com.github.qbek.screenplay.abilities.UseAccount;
import com.github.qbek.screenplay.facts.Facts;
import cucumber.api.java.Before;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.actors.Cast;
import net.serenitybdd.screenplay.actors.OnStage;

public class CardBalanceSteps {

    @Before
    public void setup() {
        OnStage.setTheStage(new Cast());
    }

    @Given("^(\\w+) is a debit card user with active account$")
    public void carlIsACardUserWithActiveAccount(String name) throws Throwable {
        Actor user = OnStage.theActorCalled(name).describedAs("is a card user with active account");
        user.has(Facts.accountWithDebitCard());
    }

    @Given("^(\\w+) is a user with active account and credit card$")
    public void adamIsAUserWithActiveAccountAndCreditCard(String name) throws Exception {
        Actor user = OnStage.theActorCalled(name).describedAs("is a user with active account and credit card");
        user.has(Facts.accountWithCreditCard());
    }

    @And("^(\\w+) is logged in his account$")
    public void heIsLoggedInHisAccount(String name) {
        Actor user = OnStage.theActorCalled(name);

        Credentials creds =
                user.usingAbilityTo(UseAccount.class).getCredentials();

        System.out.println("Nasz aktor nazywa się: " + user.getName());
        System.out.println("Login: " + creds.getLogin() + ", password: " + creds.getPassword());
    }
}
