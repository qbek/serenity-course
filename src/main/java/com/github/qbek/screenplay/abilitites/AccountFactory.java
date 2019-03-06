package com.github.qbek.screenplay.abilitites;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.github.javafaker.Faker;
import com.github.qbek.screenplay.actions.data.AuthorizationType;

import static com.github.qbek.screenplay.actions.data.AuthorizationType.AUTH_TOKEN;
import static com.github.qbek.screenplay.actions.data.AuthorizationType.CREDENTIALS;

public class AccountFactory {

    private static Faker faker = new Faker();

    //for now both functions looks quite similar....
    public static UseAccount useActiveAccount() throws JsonProcessingException {
        return generateAccount();
    }

    //...well, they are the same to be honest
    //but it will change in a moment ;)
    public static UseAccount useInactiveAccount() throws JsonProcessingException {
        return generateAccount();
    }

    private static UseAccount generateAccount() {
        return new UseAccount(
                faker.dragonBall().character(),
                faker.superhero().power(),
                getRandomAuthType()
        );
    }

    private static AuthorizationType getRandomAuthType() {
        if (faker.random().nextBoolean()) {
            return CREDENTIALS;
        } else {
            return AUTH_TOKEN;
        }
    }


}
