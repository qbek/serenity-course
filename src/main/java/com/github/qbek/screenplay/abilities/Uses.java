package com.github.qbek.screenplay.abilities;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.javafaker.Faker;
import org.mockserver.client.MockServerClient;
import org.mockserver.model.HttpRequest;
import org.mockserver.model.HttpResponse;

public class Uses {

    private static Faker faker = new Faker();
    private static MockServerClient client = new MockServerClient("localhost", 8080);
    private static ObjectMapper mapper = new ObjectMapper();

    public static UseCards useDebitCard() throws Exception {
        Card card = new Card(
                faker.numerify("110022##########"),
                faker.business().creditCardExpiry(),
                faker.number().numberBetween(10, 100)
        );
        injectTestCard(card);
        UseCards useCards = new UseCards(card);
        return useCards;
    }

    private static void injectTestCard(Card card) throws JsonProcessingException {
        String path = "/card/" + card.getPan();
        String responseBody = mapper.writeValueAsString(card);
        System.out.println("CARD JSON: " + responseBody);

        client.when(
                HttpRequest.request().withMethod("GET").withPath(path)
        ).respond(
                HttpResponse.response().withStatusCode(200).withBody(responseBody)
        );
    }

    public static UseCards useCreditCard() throws Exception {
        Card card = new Card(
                faker.numerify("330022##########"),
                faker.business().creditCardExpiry(),
                faker.number().numberBetween(10, 100)
        );
        injectTestCard(card);
        UseCards useCards = new UseCards(card);
        return useCards;
    }

    public static UseAccount useAccount() throws JsonProcessingException {
        Credentials creds = new Credentials(
                faker.dragonBall().character(),
                faker.witcher().monster()
        );
        injectTestCredentials(creds);
        UseAccount useAccount = new UseAccount(creds);
        return useAccount;
    }

    private static void injectTestCredentials(Credentials creds) throws JsonProcessingException {
        client.when(
                HttpRequest.request("/login").withMethod("POST").withBody(
                        mapper.writeValueAsString(creds)
                )
        ).respond(
                HttpResponse.response().withStatusCode(200)
        );
    }

}
