package com.github.qbek.screenplay.steps;

import com.github.javafaker.Faker;
import com.github.qbek.screenplay.abilitites.CardFactory;
import com.github.qbek.screenplay.abilitites.UseAccount;
import com.github.qbek.screenplay.abilitites.UseCard;
import com.github.qbek.screenplay.facts.CardAccountFact;
import cucumber.api.java.Before;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.actors.Cast;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.facts.Fact;

import static com.github.qbek.screenplay.abilitites.AccountFactory.useActiveAccount;
import static com.github.qbek.screenplay.abilitites.CardFactory.useValidCard;
import static com.github.qbek.screenplay.facts.CardAccountFact.accountWithCard;

public class PreconditionSteps {

    Faker faker = new Faker();

    @Before
    public void setup() {
        OnStage.setTheStage(new Cast());
    }

    @Given("^(\\w+) is a card user with active account$")
    public void carlIsACardUserWithActiveAccount(String name) throws Throwable {
        // Checks if actor was already created
        // If not - creates a new one and stores in Cast object
        Actor user = OnStage.theActorCalled(name);

        //now we can add two abilities (or even more)
        //using just one line...
        user.has(accountWithCard());
    }


    @Given("^(\\w+) is logged in his account$")
    public void heIsLoggedInHisAccount(String name) throws Throwable {
        // Last used actor has set spotlight on him
        // can be used in steps without actor name
//        Actor user = OnStage.theActorInTheSpotlight();

        // same result with using pronun: 'he', 'she'...
        Actor user = OnStage.theActorCalled(name);
        System.out.println("Actor in the spotlight is: " + user.getName());
        // Having a correct user allows you to access stored abilities
        System.out.println("User login: " + user.usingAbilityTo(UseAccount.class).getLogin());
        System.out.println("User password: " + user.usingAbilityTo(UseAccount.class).getPassword());
    }
}
