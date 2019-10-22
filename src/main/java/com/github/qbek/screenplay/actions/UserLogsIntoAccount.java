package com.github.qbek.screenplay.actions;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.qbek.screenplay.data.account.UseAccount;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.rest.interactions.Get;


public class UserLogsIntoAccount implements Task {

    private final boolean useAuthToken;

    public UserLogsIntoAccount(boolean useAuthToken) {
        this.useAuthToken = useAuthToken;
    }

    public UserLogsIntoAccount() {
        useAuthToken = false;
    }

    @Override
    public <T extends Actor> void performAs(T user) {
        UseAccount account = user.usingAbilityTo(UseAccount.class);
        try {
            String reqBody = getRequestBody(account);
            user.wasAbleTo(
                    Get.resource("/login").with(req -> req.body(reqBody))
            );
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
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
