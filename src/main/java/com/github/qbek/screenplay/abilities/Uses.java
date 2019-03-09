package com.github.qbek.screenplay.abilities;

import com.github.javafaker.Faker;
import com.github.qbek.screenplay.testdata.Account;
import com.github.qbek.screenplay.testdata.Card;

public class Uses {

    private static Faker faker = new Faker();

    public static UseCard useCard() {
        Card card = new Card(
                faker.numerify("1100 01## #### ####"),
                faker.business().creditCardExpiry(),
                faker.number().randomDouble(2, 100, 2123)
        );
        return new UseCard(card);
    }

    public static UseAccount useAccount() {
        Account account = new Account(
                faker.dragonBall().character(),
                faker.superhero().power()
        );

        return new UseAccount(account);
    }
}
