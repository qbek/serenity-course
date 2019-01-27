package com.github.qbek.screenplay.abilitites;

import com.github.javafaker.Faker;

public class AccountFactory {

    private static Faker faker = new Faker();

    //for now both functions looks quite similar....
    public static UseAccount useActiveAccount() {
        return generateAccount();
    }

    //...well, they are the same to be honest
    //but it will change in a moment ;)
    public static UseAccount useInactiveAccount() {
        return generateAccount();
    }

    private static UseAccount generateAccount() {
        return new UseAccount(
                faker.dragonBall().character(),
                faker.superhero().power()
        );
    }
}
