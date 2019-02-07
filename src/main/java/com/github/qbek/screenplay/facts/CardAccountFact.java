package com.github.qbek.screenplay.facts;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.qbek.screenplay.abilitites.UseAccount;
import com.github.qbek.screenplay.abilitites.UseCard;
import net.serenitybdd.core.Serenity;
import net.serenitybdd.core.exceptions.SerenityManagedException;
import net.serenitybdd.reports.model.FailingScenario;
import net.serenitybdd.screenplay.Ability;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.QuestionConsequence;
import net.serenitybdd.screenplay.facts.Fact;
import org.hamcrest.Matchers;
import org.mockserver.client.MockServerClient;
import org.mockserver.model.HttpRequest;
import org.mockserver.model.HttpResponse;

import static com.github.qbek.screenplay.abilitites.AccountFactory.useActiveAccount;
import static com.github.qbek.screenplay.abilitites.AccountFactory.useInactiveAccount;
import static com.github.qbek.screenplay.abilitites.CardFactory.useValidCard;

public class CardAccountFact {

    public static Fact accountWithCard() {
        return new Fact() {
            @Override
            public void setup(Actor actor) {
                // Now we are creating our card ability using static CardFactory function.
                try {
                    UseCard useValidCard = useValidCard();
                    actor.can(useValidCard);
                    createCardInSystem(useValidCard);

                    UseAccount useActiveAccount = useActiveAccount();
                    actor.can(useActiveAccount);
                    boolean active = true;
                    setAccountInSystem(useActiveAccount, active);

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
                    setAccountInSystem(useInactiveAccount, inactive);
                } catch (JsonProcessingException e) {
                    e.printStackTrace();
                }
            }
        };
    }

    private static MockServerClient mockClient = new MockServerClient("localhost", 8080);

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

    private static void createCardInSystem(UseCard card) throws JsonProcessingException {

        ObjectMapper mapper = new ObjectMapper();
        mockClient.when(HttpRequest.request("/card/" + card.getPan()))
                .respond(HttpResponse.response(mapper.writeValueAsString(card)).withStatusCode(200));
    }
}
