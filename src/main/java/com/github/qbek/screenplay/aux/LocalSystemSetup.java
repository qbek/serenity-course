package com.github.qbek.screenplay.aux;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.qbek.screenplay.abilities.Card;
import com.github.qbek.screenplay.abilities.Credentials;
import org.mockserver.client.MockServerClient;
import org.mockserver.model.HttpRequest;
import org.mockserver.model.HttpResponse;

public class LocalSystemSetup implements SystemSetup {

    private static MockServerClient client = new MockServerClient("localhost", 8080);
    private static ObjectMapper mapper = new ObjectMapper();

    @Override
    public void setupCredentials(Credentials credentials) throws JsonProcessingException {
        client.when(
                HttpRequest.request("/login").withMethod("POST").withBody(
                        mapper.writeValueAsString(credentials)
                )
        ).respond(
                HttpResponse.response().withStatusCode(200)
        );
        System.out.println("Test data injected to mock server");
    }

    @Override
    public void setupCard(Card card) throws JsonProcessingException {
        String path = "/card/" + card.getPan();
        String responseBody = mapper.writeValueAsString(card);
        System.out.println("CARD JSON: " + responseBody);

        client.when(
                HttpRequest.request().withMethod("GET").withPath(path)
        ).respond(
                HttpResponse.response().withStatusCode(200).withBody(responseBody)
        );
    }
}
