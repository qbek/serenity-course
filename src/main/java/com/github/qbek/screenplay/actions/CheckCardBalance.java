package com.github.qbek.screenplay.actions;

import com.github.qbek.screenplay.abilitites.UseCard;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.rest.interactions.Get;
import net.thucydides.core.steps.StepEventBus;

public class CheckCardBalance implements Task {


    private final String cardType;

    CheckCardBalance(String cardType) {
        this.cardType = cardType;
    }

    @Override
    public <T extends Actor> void performAs(T user) {
        switch (cardType) {
            case "credit":
                user.attemptsTo(performCreditCardCheck());
                break;

            case "debit":
                user.attemptsTo(performDebitCardCheck());
                break;

            default:
                StepEventBus.getEventBus().testFailed(new Exception("Not supported card type: " + cardType));
        }
    }

    private Performable performDebitCardCheck() {
        return new Performable() {
            @Override
            public <T extends Actor> void performAs(T user) {
                UseCard card = user.usingAbilityTo(UseCard.class);
                user.wasAbleTo(Get.resource("/debit/" + card.getPan()));
            }
        };
    }

    private Performable performCreditCardCheck() {
        return new Performable() {
            @Override
            public <T extends Actor> void performAs(T user) {
                UseCard card = user.usingAbilityTo(UseCard.class);
                user.wasAbleTo(Get.resource("/credit/" + card.getPan()));
            }
        };
    }
}
