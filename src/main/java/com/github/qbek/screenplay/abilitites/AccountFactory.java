package com.github.qbek.screenplay.abilitites;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.javafaker.Faker;
import org.mockserver.client.MockServerClient;
import org.mockserver.model.HttpRequest;
import org.mockserver.model.HttpResponse;

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
                faker.superhero().power()
        );
    }


}
