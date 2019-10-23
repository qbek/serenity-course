package com.github.qbek.screenplay.questions;

import com.github.qbek.screenplay.data.card.Card;
import io.restassured.response.Response;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.rest.questions.LastResponse;

public class Questions {
    public static Question<Boolean> authorization() {
        return new AccountAuthorization();
    }


    public static Question<Card> card() {
        return new CardQuestion();
    }

    public static Question<Double> cardBalance() {
        return new CardBalanceQuestion();
    }

    public static Question<String> cardHolder() {
        return user -> {
            Response response = user.asksFor(LastResponse.received());
            return response.path("cardHolder").toString();
        };
    }

    public static Question getAuthorizationResponse() {
        return user -> {
            Response response = user.asksFor(LastResponse.received());
            return response.getStatusCode();
        };
    }
}
