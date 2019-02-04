package com.github.qbek.screenplay;

import com.github.javafaker.Faker;
import com.github.qbek.screenplay.abilities.UseAccount;
import com.github.qbek.screenplay.abilities.UseCard;
import com.github.qbek.screenplay.testdata.Account;
import com.github.qbek.screenplay.testdata.Card;
import cucumber.api.java.Before;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.actors.Cast;
import net.serenitybdd.screenplay.actors.OnStage;

public class CardBalanceSteps {

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

        Card card = new Card(
                faker.numerify("1100 01## #### ####"),
                faker.business().creditCardExpiry(),
                faker.number().randomDouble(2, 100, 2123)
        );

        UseCard useCard = new UseCard(card);

        Account account = new Account(
                faker.dragonBall().character(),
                faker.superhero().power()
        );

        UseAccount useAccount = new UseAccount(account);
    }

    @And("^(\\w+) is logged in his account$")
    public void heIsLoggedInHisAccount(String name) throws Throwable {
        // Last used actor has set spotlight on him
        // can be used in steps without actor name
        Actor user = OnStage.theActorInTheSpotlight();

        // same result with using pronun: 'he', 'she'...
        // Actor user = OnStage.theActorCalled(name)
        System.out.println("Actor in the spotlight is: " + user.getName());
    }
}
