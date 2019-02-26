package com.github.qbek.screenplay.facts;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.qbek.screenplay.abilitites.UseAccount;
import com.github.qbek.screenplay.abilitites.UseCard;
import com.github.qbek.screenplay.actions.data.AuthorizationType;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.facts.Fact;
import org.mockserver.client.MockServerClient;
import org.mockserver.model.HttpRequest;
import org.mockserver.model.HttpResponse;

import static com.github.qbek.screenplay.abilitites.AccountFactory.useActiveAccount;
import static com.github.qbek.screenplay.abilitites.CardFactory.useRandomCard;
import static com.github.qbek.screenplay.actions.data.AuthorizationType.CREDENTIALS;

public class CardAccountFact {

    public static Fact accountWithCreditCard() {
        return new Fact() {
            @Override
            public void setup(Actor actor) {
                // Now we are creating our card ability using static CardFactory function.
                try {
                    UseCard useValidCard = useRandomCard();
                    actor.can(useValidCard);
                    createCardInSystem(useValidCard);

                    UseAccount useActiveAccount = useActiveAccount();
                    actor.can(useActiveAccount);
                    boolean active = true;
                    setAccountInSystem(useActiveAccount, active, CREDENTIALS);

                } catch (JsonProcessingException e) {
                    e.printStackTrace();
                }
            }

            public String toString() {
                return "active account and valid card";
            }
        };
    }

    public static Fact inactiveAccount() {
        return new Fact() {
            @Override
            public void setup(Actor actor) {
                try {
                    UseAccount useInactiveAccount = useActiveAccount();
                    actor.can(useInactiveAccount);
                    boolean inactive = false;
                    setAccountInSystem(useInactiveAccount, inactive, CREDENTIALS);
                } catch (JsonProcessingException e) {
                    e.printStackTrace();
                }
            }
        };
    }

    private static MockServerClient mockClient = new MockServerClient("localhost", 8080);

    private static void setAccountInSystem(UseAccount account, boolean isActive, AuthorizationType authType) throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        int responseCode;
        if (isActive) {
            responseCode = 200;
        } else {
            responseCode = 404;
        }

        String body = "";

        switch (authType) {
            case CREDENTIALS:
                body = mapper.writeValueAsString(account);
                break;

            case AUTH_TOKEN:
                body = account.getPassword();
                break;
        }

        mockClient.when(HttpRequest.request("/login").withBody(body))
                .respond(HttpResponse.response().withStatusCode(responseCode));
    }

    private static void createCardInSystem(UseCard card) throws JsonProcessingException {

        ObjectMapper mapper = new ObjectMapper();
        String path = String.format("/%s/", card.getType().toString().toLowerCase());
        mockClient.when(HttpRequest.request(path + card.getPan()))
                .respond(HttpResponse.response().withBody(mapper.writeValueAsString(card)).withStatusCode(200).withHeader("Content-Type", "application/json"));
    }
}
