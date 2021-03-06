package com.github.qbek.screenplay.actions;

import com.github.qbek.screenplay.abilitites.UseCard;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.rest.interactions.Get;

public class CheckCardBalance implements Task {

    @Override
    public <T extends Actor> void performAs(T user) {
        UseCard card = user.usingAbilityTo(UseCard.class);
        String path = String.format("/%s/", card.getType().toString().toLowerCase());
        user.wasAbleTo(Get.resource(path + card.getPan()));
    }
}
