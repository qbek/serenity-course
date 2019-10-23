package com.github.qbek.screenplay.questions;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.qbek.screenplay.data.account.UseAccount;
import io.restassured.response.Response;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.rest.interactions.Get;
import net.serenitybdd.screenplay.rest.questions.LastResponse;

import static com.github.qbek.screenplay.data.auxiliary.NoteTypes.TOKEN;

public class AccountAuthorization implements Question<Boolean> {

    private static int SUCCESS_RESPONSE = 200;

    @Override
    public Boolean answeredBy(Actor user) {
        UseAccount account = user.usingAbilityTo(UseAccount.class);
        try {
            String reqBody = getRequestBody(account);
            user.wasAbleTo(
                    Get.resource("/login").with(req -> req.body(reqBody))
            );
            Response response = user.asksFor(LastResponse.received());
            String token = response.getBody().asString();
            user.remember(TOKEN.toString(), token);
            return response.getStatusCode() == SUCCESS_RESPONSE;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    private String getRequestBody(UseAccount account) throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        switch (account.getAuthType()) {
            case BASIC:
                return mapper.writeValueAsString(account);
            case TOKEN:
                return account.getPassword();
            default:
                throw new RuntimeException("Not supported account auth type");
        }
    }
}
