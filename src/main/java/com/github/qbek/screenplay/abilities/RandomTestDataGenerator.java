package com.github.qbek.screenplay.abilities;

import com.github.javafaker.Faker;
import com.github.qbek.screenplay.facts.CardType;

public class RandomTestDataGenerator implements TestDataGenerator {

    private static Faker faker = new Faker();

    @Override
    public UseCards createDebitCard() {
        Card card = new Card(
                faker.numerify("110022##########"),
                faker.business().creditCardExpiry(),
                CardType.DEBIT,
                faker.number().numberBetween(10, 100)
        );
        UseCards useCards = new UseCards(card);
        System.out.println("Karta debetowa stworzona randomowo");
        return useCards;
    }

    @Override
    public UseCards createCreditCard() {
        Card card = new Card(
                faker.numerify("330022##########"),
                faker.business().creditCardExpiry(),
                CardType.CREDIT,
                faker.number().numberBetween(10, 100)
        );
        UseCards useCards = new UseCards(card);
        System.out.println("Karta kredytowa stworzona randomowo");
        return useCards;
    }

    @Override
    public UseAccount createAccount() {
        Credentials creds = new Credentials(
                faker.dragonBall().character(),
                faker.witcher().monster()
        );
        UseAccount useAccount = new UseAccount(creds);
        return useAccount;
    }
}
