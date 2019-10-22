package com.github.qbek.screenplay.data;

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

import static org.mockserver.model.HttpRequest.request;
import static org.mockserver.model.HttpResponse.response;

public class CardAndAccount implements Fact {

    private UseCards useCard;
    private UseAccount useAccount;

    private MockServerClient mcClient = new MockServerClient("localhost", 8080);

    private Actor user;

    public CardAndAccount (Ability useCards, Ability useAccount) {
        this.useCard = (UseCards) useCards;
        this.useAccount = (UseAccount) useAccount;
    }

    @Override
    public void setup(Actor user) {
        this.user = user;
        injectCardToSystem(useCard.getCard());
        user.can(useCard);
        injectUserIntoSystem(useAccount);
        user.can(useAccount);

//        useCard = (UseCards) useCard();
//        useAccount = (UseAccount) useActiveAccount();
//        user.can(useCard);
//        user.can(useAccount);
    }

    public String toString() {
        Card userCard = user.usingAbilityTo(UseCards.class).getCard();
        UseAccount account = user.usingAbilityTo(UseAccount.class);

        String reportLog = String.format("plastic card: %s<br/>" +
                " active account: %s/%s",
                userCard.getPan(),
                account.getLogin(), account.getPassword());

        return reportLog;
    }

    private void injectCardToSystem(Card cardToInject) {

        mcClient.when(
                        HttpRequest.request()
                                .withMethod("GET")
                                .withPath("/card/" + cardToInject.getPan())
                ).respond(
                HttpResponse.response()
                        .withBody(String.valueOf(cardToInject.getBalance())
                        ));
    }

    private void injectUserIntoSystem(UseAccount account) {
        int statusCode;

        if(account.isActive()) {
            statusCode = 200;
        } else {
            statusCode = 401;
        }

        String reqBody =
                String.format("{\"login\":\"%s\", \"pass\":\"%s\"}",
                        account.getLogin(),
                        account.getPassword()
                );
        mcClient.when(request()
                    .withMethod("GET")
                    .withPath("/login")
                    .withBody(reqBody),
                    Times.exactly(1)
                )
                .respond(response().withStatusCode(statusCode));
    }
}
