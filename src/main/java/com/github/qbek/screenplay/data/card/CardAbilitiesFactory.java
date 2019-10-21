package com.github.qbek.screenplay.data.card;

import com.github.javafaker.Faker;
import net.serenitybdd.screenplay.Ability;
import org.mockserver.client.server.MockServerClient;
import org.mockserver.model.HttpRequest;
import org.mockserver.model.HttpResponse;

public class CardAbilitiesFactory {
    public static Ability useCard() {
        Faker faker = new Faker();
        Card testCard = new Card(
                faker.numerify("987698##########"),
                faker.zelda().character(),
                faker.business().creditCardExpiry(),
                faker.number().randomDouble(2, 100, 1000)
        );
        injectCardToSystem(testCard);
        return new UseCards(testCard);
    };

    public static Ability useExpiredCard() {
        Faker faker = new Faker();
        Card expiredCard = new Card(
                faker.numerify("987698##########"),
                faker.zelda().character(),
                "01/18",
                faker.number().randomDouble(2, 100, 1000)
        );
        injectCardToSystem(expiredCard);
        return new UseCards(expiredCard);
    }

    private static void injectCardToSystem(Card cardToInject) {
        new MockServerClient("localhost", 8080)
                .when(
                        HttpRequest.request()
                        .withMethod("GET")
                        .withPath("/card/" + cardToInject.getPan())
                ).respond(
                        HttpResponse.response()
                        .withBody(String.valueOf(cardToInject.getBalance())
                ));
    }

}
