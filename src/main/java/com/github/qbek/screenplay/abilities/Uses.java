package com.github.qbek.screenplay.abilities;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.javafaker.Faker;
import com.github.qbek.screenplay.testdata.Account;
import com.github.qbek.screenplay.testdata.Card;
import org.mockserver.client.MockServerClient;
import org.mockserver.model.HttpRequest;
import org.mockserver.model.HttpResponse;

public class Uses {

    private static Faker faker = new Faker();
    private static MockServerClient mockClient = new MockServerClient("localhost", 8080);


    public static UseCard useCard() throws JsonProcessingException {
        Card card = new Card(
                faker.numerify("1100 01## #### ####"),
                faker.business().creditCardExpiry(),
                faker.number().randomDouble(2, 100, 2123)
        );
        createCardInSystem(card);
        return new UseCard(card);
    }

    public static UseAccount useAccount() throws JsonProcessingException {
        Account account = new Account(
                faker.dragonBall().character(),
                faker.superhero().power()
        );
        setAccountInSystem(account);
        return new UseAccount(account);
    }

    private static void createCardInSystem(Card card) throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        mockClient.when(HttpRequest.request("/card/" + card.getPan()))
                .respond(HttpResponse.response(mapper.writeValueAsString(card)).withStatusCode(200));
    }

    private static void setAccountInSystem(Account account) throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        mockClient.when(HttpRequest.request("/login").withBody(mapper.writeValueAsString(account)))
                .respond(HttpResponse.response().withStatusCode(200));
    }


}
