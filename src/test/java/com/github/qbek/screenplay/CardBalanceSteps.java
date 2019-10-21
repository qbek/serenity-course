package com.github.qbek.screenplay;

import com.github.qbek.screenplay.data.card.Card;
import com.github.qbek.screenplay.data.card.UseCards;
import com.github.qbek.screenplay.transforms.UserInStep;
import cucumber.api.Transform;
import cucumber.api.java.Before;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.actors.Cast;
import net.serenitybdd.screenplay.actors.OnStage;

import static com.github.qbek.screenplay.data.account.AccountAbilityFactory.useActiveAccount;
import static com.github.qbek.screenplay.data.card.CardAbilitiesFactory.useCard;

public class CardBalanceSteps {

    @Before
    public void setup() {
        OnStage.setTheStage(new Cast());
    }

    @Given("^(\\w+) is a card user with active account$")
    public void carlIsACardUserWithActiveAccount(
            @Transform(UserInStep.class) Actor user
    ) throws Throwable {
        user.can(useCard());
        user.can(useActiveAccount());
    }

    @When("^(\\w+) checks his card balance$")
    public void carlChecksHisCardBalance(@Transform(UserInStep.class) Actor user) {
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

    @Given("^Adam has (\\d+) apples$")
    public void adamHasApples(String value) {

        Integer.getInteger(value);

    }

    @And("^he is (true) or false$")
    public void heIsTrueOrFalse(boolean value) {
    }
}
