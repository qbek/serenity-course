package com.github.qbek.screenplay.actions;

import com.github.qbek.screenplay.data.card.Card;
import com.github.qbek.screenplay.data.card.UseCards;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.rest.interactions.Get;
import net.thucydides.core.annotations.Step;

public class UserChecksCardBalance implements Task {

    @Override
    @Step("{0} checks card balance: #tajneCos")
    public <T extends Actor> void performAs(T user) {
        Card userCard = user.usingAbilityTo(UseCards.class).getCard();
        String path = String.format("/card/%s", userCard.getPan());
        user.attemptsTo(Get.resource(path));
    }

}
