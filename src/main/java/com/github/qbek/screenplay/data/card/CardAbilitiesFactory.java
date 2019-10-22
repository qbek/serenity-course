package com.github.qbek.screenplay.data.card;

import com.github.javafaker.Faker;
import net.serenitybdd.screenplay.Ability;

public class CardAbilitiesFactory {
    public static Ability useCard() {
        Faker faker = new Faker();
        Card testCard = new Card(
                faker.numerify("987698##########"),
                faker.zelda().character(),
                faker.business().creditCardExpiry(),
                faker.number().randomDouble(2, 100, 1000)
        );
        return new UseCards(testCard);
    };

    public static Ability useExpiredCard() {
        Faker faker = new Faker();
        Card expiredCard = new Card(
                faker.numerify("987698##########"),
                faker.zelda().character(),
                "01/18",
                faker.number().randomDouble(2, 100, 1000)
        );
        return new UseCards(expiredCard);
    }
}
