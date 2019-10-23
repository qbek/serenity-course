package com.github.qbek.screenplay.data.card;

import com.github.javafaker.Faker;
import net.serenitybdd.screenplay.Ability;

import static com.github.qbek.screenplay.data.card.CardType.CREDIT;
import static com.github.qbek.screenplay.data.card.CardType.DEBIT;

public class CardAbilitiesFactory {
    public static Ability useDebitCard() {
        CardBuilder builder = getBasicCard();
        builder.setType(DEBIT);
        return new UseCards(builder.build());
    };

    public static Ability useCreditCard() {
        CardBuilder builder = getBasicCard();
        builder.setType(CREDIT);
        return new UseCards(builder.build());
    }

    private static CardBuilder getBasicCard() {
        Faker faker = new Faker();
        CardBuilder builder = new CardBuilder();
        builder.setPan(faker.numerify("987698##########"))
                .setBalance(faker.number().randomDouble(2, 100, 1000))
                .setCardHolder(faker.zelda().character())
                .setExpDate(faker.business().creditCardExpiry());
        return builder;
    }
}
