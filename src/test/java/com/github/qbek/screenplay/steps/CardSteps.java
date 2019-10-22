package com.github.qbek.screenplay.steps;

import com.github.qbek.screenplay.data.card.Card;
import com.github.qbek.screenplay.data.card.UseCards;
import com.github.qbek.screenplay.transforms.UserInStep;
import cucumber.api.Transform;
import cucumber.api.java.en.When;
import net.serenitybdd.screenplay.Actor;

public class CardSteps {
    @When("^(\\w+) checks his card balance$")
    public void carlChecksHisCardBalance(@Transform(UserInStep.class) Actor user) {
        Card userCard = user.usingAbilityTo(UseCards.class).getCard();
        System.out.println(
            String.format("Holder: %s, pan: %s, card expDate: %s, balance: %f",
                userCard.getCardHolder(), userCard.getPan(),
                    userCard.getExpDate(), userCard.getBalance()
            )
        );
    }
}
