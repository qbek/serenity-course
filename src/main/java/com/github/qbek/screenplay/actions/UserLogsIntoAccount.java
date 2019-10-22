package com.github.qbek.screenplay.actions;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.qbek.screenplay.data.account.UseAccount;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.rest.interactions.Get;


public class UserLogsIntoAccount implements Task {
    @Override
    public <T extends Actor> void performAs(T user) {
        UseAccount account = user.usingAbilityTo(UseAccount.class);
        ObjectMapper mapper = new ObjectMapper();
        try {
            String reqBody = mapper.writeValueAsString(account);
            user.wasAbleTo(
                    Get.resource("/login").with(req -> req.body(reqBody))
            );
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
