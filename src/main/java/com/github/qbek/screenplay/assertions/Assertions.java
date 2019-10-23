package com.github.qbek.screenplay.assertions;

import com.github.qbek.screenplay.data.card.Card;
import net.serenitybdd.screenplay.Consequence;
import net.serenitybdd.screenplay.QuestionConsequence;

import static com.github.qbek.screenplay.questions.Questions.*;
import static org.hamcrest.Matchers.equalTo;

public class Assertions {
    public static Consequence[] receiveCorrectCardDetails(Card expected) {
        return new Consequence[] {
                new QuestionConsequence(
                        "card holder",
                        cardHolder(),
                        equalTo(expected.getCardHolder())
                ),
                new QuestionConsequence(
                        "card balance",
                        cardBalance(),
                        equalTo(expected.getBalance())
                )
        };
    }

    public static Consequence[] beLoggedIn() {
        return new Consequence[] {
                new QuestionConsequence(
                    "authorization response is",
                    getAuthorizationResponse(),
                    equalTo(200))
        };
    }
}
