package com.github.qbek.screenplay.abilitites;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.javafaker.Faker;
import org.mockserver.client.MockServerClient;
import org.mockserver.model.HttpRequest;
import org.mockserver.model.HttpResponse;

public class CardFactory {

    private static Faker faker = new Faker();

    private static MockServerClient mockClient = new MockServerClient("localhost", 8080);


    public static UseCard useValidCard() throws JsonProcessingException {
        UseCard card =  new UseCard(
                generatePan(),
                "20/12",
                faker.number().randomDouble(2, 100, 2123)
        );
        return card;
    }

    //In case when we have a specialized class in creating card abilities
    //we can crate many types of cards... for example a expired one.
    public static UseCard useExpiredCard() {
        return new UseCard(
                generatePan(),
                "10/18",
                faker.number().randomDouble(2, 100, 2123)
        );
    }

    private static String generatePan() {
        return faker.numerify("110001##########");
    }


}
