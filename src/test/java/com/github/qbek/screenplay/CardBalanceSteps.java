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

import static com.github.qbek.screenplay.abilities.Uses.useAccount;
import static com.github.qbek.screenplay.abilities.Uses.useCard;

public class CardBalanceSteps {

    Faker faker = new Faker();

    @Before
    public void setup() {
        OnStage.setTheStage(new Cast());
    }

    @Given("^(\\w+) is a card user with active account$")
    public void carlIsACardUserWithActiveAccount(String name) throws Throwable {
        Actor user = OnStage.theActorCalled(name).describedAs("is a card user with active account");
        user.can(useCard());
        user.can(useAccount());
    }

    @And("^(\\w+) is logged in his account$")
    public void heIsLoggedInHisAccount(String name) throws Throwable {
        Actor user = OnStage.theActorCalled(name);

        Card card = user.usingAbilityTo(UseCard.class).getCard();
        System.out.println(String.format("%s has card: %s, %s PLN",
                user.getName(), card.getPan(), card.getBalance()));

        Account account = user.usingAbilityTo(UseAccount.class).getAccount();
        System.out.println(String.format("%s has account: %s / %s",
                user.getName(), account.getLogin(), account.getPassword()));

    }
}
