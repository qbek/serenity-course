package com.github.qbek.screenplay.abilitites;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.javafaker.Faker;
import org.mockserver.client.MockServerClient;
import org.mockserver.model.HttpRequest;
import org.mockserver.model.HttpResponse;

public class AccountFactory {

    private static Faker faker = new Faker();
    private static MockServerClient mockClient = new MockServerClient("localhost", 8080);

    //for now both functions looks quite similar....
    public static UseAccount useActiveAccount() throws JsonProcessingException {
        UseAccount account = generateAccount();
        boolean active = true;
        setAccountInSystem(account, active);
        return account;
    };

    //...well, they are the same to be honest
    //but it will change in a moment ;)
    public static UseAccount useInactiveAccount() throws JsonProcessingException {
        UseAccount account = generateAccount();
        boolean inactive = false;
        setAccountInSystem(account, inactive);
        return account;
    }

    private static UseAccount generateAccount() {
        return new UseAccount(
                faker.dragonBall().character(),
                faker.superhero().power()
        );
    }

    private static void setAccountInSystem(UseAccount account, boolean isActive) throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        int responseCode;
        if (isActive) {
            responseCode = 200;
        } else {
            responseCode = 404;
        }

        mockClient.when(HttpRequest.request("/login").withBody(mapper.writeValueAsString(account)))
                .respond(HttpResponse.response().withStatusCode(responseCode));
    }
}
