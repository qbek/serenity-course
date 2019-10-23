package com.github.qbek.screenplay.questions;

import io.restassured.response.Response;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.rest.questions.LastResponse;

public class CardBalanceQuestion implements Question<Double> {

    @Override
    public Double answeredBy(Actor user) {
        Response response = user.asksFor(LastResponse.received());
        return Double.parseDouble(response.path("balance").toString());
    }
}
