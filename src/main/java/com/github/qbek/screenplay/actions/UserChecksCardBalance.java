package com.github.qbek.screenplay.actions;

import com.github.qbek.screenplay.data.card.Card;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.rest.interactions.Get;
import net.thucydides.core.annotations.Step;

import static com.github.qbek.screenplay.questions.Questions.card;

public class UserChecksCardBalance implements Task {

    @Override
    @Step("{0} checks card balance")
    public <T extends Actor> void performAs(T user) {
        Card userCard = user.asksFor(card());
        String path = getPath(userCard);
        user.attemptsTo(Get.resource(path));
    }

    private String getPath(Card card) {
        return String.format("/card/%s/%s", card.getType(), card.getPan());
    }

}
