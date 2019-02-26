package com.github.qbek.screenplay.abilitites;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.github.javafaker.Faker;

import static com.github.qbek.screenplay.actions.data.CardType.CREDIT;
import static com.github.qbek.screenplay.actions.data.CardType.DEBIT;

public class CardFactory {

    private static Faker faker = new Faker();

    public static UseCard useCreditCard() throws JsonProcessingException {
        UseCard card =  new UseCard(
                generatePan(),
                "20/12",
                faker.number().randomDouble(2, 100, 2123),
                CREDIT
        );
        return card;
    }

    //In case when we have a specialized class in creating card abilities
    //we can crate many types of cards... for example a expired one.
    public static UseCard useDebitCard() {
        return new UseCard(
                generatePan(),
                "10/18",
                faker.number().randomDouble(2, 100, 2123),
                DEBIT
        );
    }

    public static UseCard useRandomCard() throws JsonProcessingException {
        if (faker.random().nextBoolean()) {
            return useCreditCard();
        } else {
            return useDebitCard();
        }
    }

    private static String generatePan() {
        return faker.numerify("110001##########");
    }


}
