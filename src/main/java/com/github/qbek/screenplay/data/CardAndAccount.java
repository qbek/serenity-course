package com.github.qbek.screenplay.data;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.qbek.screenplay.data.account.UseAccount;
import com.github.qbek.screenplay.data.card.Card;
import com.github.qbek.screenplay.data.card.UseCards;
import net.serenitybdd.screenplay.Ability;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.facts.Fact;
import org.mockserver.client.server.MockServerClient;
import org.mockserver.matchers.Times;
import org.mockserver.model.HttpRequest;
import org.mockserver.model.HttpResponse;

import static java.util.Objects.nonNull;
import static org.mockserver.model.HttpRequest.request;
import static org.mockserver.model.HttpResponse.response;

public class CardAndAccount implements Fact {

    private final boolean useAuthToken;
    private UseCards useCard;
    private UseAccount useAccount;

    private MockServerClient mcClient = new MockServerClient("localhost", 8080);


    public CardAndAccount(UseAccount account) {
        this.useAuthToken = false;
        this.useAccount = account;
    }

    public CardAndAccount (Ability useCards, Ability useAccount) {
        this.useAuthToken = false;
        this.useCard = (UseCards) useCards;
        this.useAccount = (UseAccount) useAccount;
    }

    public CardAndAccount(UseAccount account, boolean useAuthToken) {
        this.useAccount = account;
        this.useAuthToken = useAuthToken;
    }

    @Override
    public void setup(Actor user) {

        try {
            if (nonNull(useAccount)) {
                injectUserIntoSystem(useAccount);
                user.can(useAccount);
            }

            if (nonNull(useCard)) {
                injectCardToSystem(useCard.getCard());
                user.can(useCard);
            }
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }


//        useCard = (UseCards) useCard();
//        useAccount = (UseAccount) useActiveAccount();
//        user.can(useCard);
//        user.can(useAccount);
    }

    public String toString() {

        String cardReport ="";
        String accountReport ="";

        if(nonNull(useCard)) {
            cardReport = String.format("plastic card: %s<br/>", useCard.getCard().getPan());
        }

        if(nonNull(useAccount)) {
            accountReport = String.format(" active account: %s/%s",
                    useAccount.getLogin(), useAccount.getPassword());
        }

        return cardReport + accountReport;
    }

    private void injectCardToSystem(Card cardToInject) throws JsonProcessingException {

        ObjectMapper mapper = new ObjectMapper();
        String reqBody = mapper.writeValueAsString(cardToInject);
        mcClient.when(
                    HttpRequest.request()
                            .withMethod("GET")
                            .withPath("/card/" + cardToInject.getPan())
                ).respond(
                HttpResponse.response()
                        .withHeader("Content-Type", "application/json")
                        .withBody(reqBody)
                        );
    }

    private void injectUserIntoSystem(UseAccount account) throws JsonProcessingException {
        int statusCode;
        if(account.isActive()) {
            statusCode = 200;
        } else {
            statusCode = 401;
        }
        String reqBody = getRequestBody(account);
        mcClient.when(request()
                    .withMethod("GET")
                    .withPath("/login")
                    .withBody(reqBody),
                    Times.exactly(1)
                )
                .respond(response().withStatusCode(statusCode));
    }

    private String getRequestBody(UseAccount account) throws JsonProcessingException {
        if(useAuthToken) {
            return account.getPassword();
        } else {
            ObjectMapper mapper = new ObjectMapper();
            return mapper.writeValueAsString(account);
        }
    }
}
