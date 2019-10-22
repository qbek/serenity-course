package com.github.qbek.screenplay.data.card;

import com.github.javafaker.Faker;
import net.serenitybdd.screenplay.Ability;

import static com.github.qbek.screenplay.data.card.CardType.CREDIT;
import static com.github.qbek.screenplay.data.card.CardType.DEBIT;

public class CardAbilitiesFactory {
    public static Ability useDebitCard() {
        Faker faker = new Faker();
        Card testCard = new Card(
                faker.numerify("987698##########"),
                faker.zelda().character(),
                faker.business().creditCardExpiry(),
                faker.number().randomDouble(2, 100, 1000),
                DEBIT
        );
        return new UseCards(testCard);
    };

    public static Ability useCreditCard() {
        Faker faker = new Faker();
        Card expiredCard = new Card(
                faker.numerify("987698##########"),
                faker.zelda().character(),
                "01/18",
                faker.number().randomDouble(2, 100, 1000),
                CREDIT
        );
        return new UseCards(expiredCard);
    }
}
