package com.github.qbek.screenplay;

import com.github.javafaker.Faker;
import com.github.qbek.screenplay.data.UseAccount;
import com.github.qbek.screenplay.data.UseCards;
import com.github.qbek.screenplay.data.entitis.Card;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.actors.Cast;
import net.serenitybdd.screenplay.actors.OnStage;

import static net.serenitybdd.screenplay.actors.OnStage.theActorCalled;

public class CardBalanceSteps {

    @Before
    public void setup() {
        OnStage.setTheStage(new Cast());
    }

    @Given("^(\\w+) is a card user with active account$")
    public void carlIsACardUserWithActiveAccount(String actorName) throws Throwable {
        Actor user = theActorCalled(actorName);
        Faker faker = new Faker();
        Card testCard = new Card(
                faker.numerify("9876 98## #### ####"),
                faker.zelda().character(),
                faker.business().creditCardExpiry(),
                faker.number().randomDouble(2, 100, 1000)
        );
        UseCards useCard = new UseCards(testCard);
        String login = System.getProperty("login");
        String password = System.getProperty("pass");

        UseAccount useAccount = new UseAccount(login, password, true);
        user.can(useCard);
        user.can(useAccount);
    }

    @When("^(\\w+) checks his card balance$")
    public void carlChecksHisCardBalance(String actorName) {
        Actor user = theActorCalled(actorName);
        Card userCard = user.usingAbilityTo(UseCards.class).getCard();
        System.out.println(
                String.format("Holder: %s, pan: %s, card expDate: %s, balance: %f",
                        userCard.getCardHolder(), userCard.getPan(), userCard.getExpDate(), userCard.getBalance()
                )
        );
    }

    @Given("^Carl has a (card|account)$")
    public void carlHasACard(String asset) {

        if(asset.equals("card")) {
            //generate card
        } else if(asset.equals("account")) {
            //genrate accout
        } else if(asset.equals("card")) {

        }

    }
}
