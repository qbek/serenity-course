package com.github.qbek.screenplay.tasks;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.qbek.screenplay.abilities.Credentials;
import com.github.qbek.screenplay.abilities.UseAccount;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.rest.interactions.Post;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.steps.StepEventBus;

public class UserLogsIntoAccount implements Task {

    @Override
    @Step("{0} logs into account")
    public <T extends Actor> void performAs(T actor) {
        try {
            Credentials creds =
                    actor.usingAbilityTo(UseAccount.class).getCredentials();
            ObjectMapper mapper = new ObjectMapper();
            String credentials = mapper.writeValueAsString(creds);
            actor.attemptsTo(Post.to("/login").with(req -> req.body(credentials)));
        } catch (JsonProcessingException e) {
            StepEventBus.getEventBus().testFailed(e);
        }
    }
}
