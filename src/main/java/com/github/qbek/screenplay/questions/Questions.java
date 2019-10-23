package com.github.qbek.screenplay.questions;

import com.github.qbek.screenplay.data.card.Card;
import net.serenitybdd.screenplay.Question;

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
}
