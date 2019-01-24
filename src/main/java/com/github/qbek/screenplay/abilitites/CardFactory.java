package com.github.qbek.screenplay.abilitites;

import com.github.javafaker.Faker;

public class CardFactory {

    private static Faker faker = new Faker();


    public static UseCard useValidCard() {
        return new UseCard(
                faker.numerify("1100 01## #### ####"),
                faker.business().creditCardExpiry(),
                faker.number().randomDouble(2, 100, 2123)
        );
    }

    //In case when we have a specialized class in creating card abilities
    //we can crate many types of cards... for example a expired one.
    public static UseCard useExpiredCard() {
        return new UseCard(
                faker.numerify("1100 01## #### ####"),
                "10/18",
                faker.number().randomDouble(2, 100, 2123)
        );
    }
}
