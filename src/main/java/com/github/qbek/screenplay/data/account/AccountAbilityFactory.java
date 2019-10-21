package com.github.qbek.screenplay.data.account;

import net.serenitybdd.screenplay.Ability;
import org.mockserver.client.server.MockServerClient;
import org.mockserver.matchers.Times;

import static org.mockserver.model.HttpRequest.request;
import static org.mockserver.model.HttpResponse.response;

public class AccountAbilityFactory {
    public static Ability useActiveAccount() {
        String login = System.getProperty("login");
        String password = System.getProperty("pass");
        boolean active = true;
        UseAccount activeAccount = new UseAccount(login, password, active);
        injectUserIntoSystem(activeAccount);
        return activeAccount;
    }

    public static Ability useInactiveAccount() {
        String login = System.getProperty("login");
        String password = System.getProperty("pass");
        boolean inactive = false;
        UseAccount inacativeAccount = new UseAccount(login, password, inactive);
        injectUserIntoSystem(inacativeAccount);
        return inacativeAccount;
    }

    private static void injectUserIntoSystem(UseAccount account) {
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
        new MockServerClient("localhost", 8080)
                .when(request()
                                .withMethod("GET")
                                .withPath("/login")
                                .withBody(reqBody),
                        Times.exactly(1)
                )
                .respond(response().withStatusCode(statusCode));
    }
}
