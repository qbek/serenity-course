package com.github.qbek.screenplay.actions;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.qbek.screenplay.abilitites.UseAccount;
import com.github.qbek.screenplay.actions.data.AuthorizationType;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.rest.interactions.Post;
import net.thucydides.core.steps.StepEventBus;

public class LoginToAccount implements Task {


    @Override
    // needed when object created by Instrumented.instacneOf()
    // @Step("{0} login to account using #authType authorization")
    public <T extends Actor> void performAs(T actor) {
       AuthorizationType authType = actor.usingAbilityTo(UseAccount.class).getAuthorizationType();
       switch (authType) {
           case CREDENTIALS:
               actor.attemptsTo(performCredentialsAuthorization());
               break;

           case AUTH_TOKEN:
               actor.attemptsTo(performAuthTokenAuthorization());
               break;

               default:
                   StepEventBus.getEventBus().testFailed(new Exception("Authorization by " + authType + " not supported"));
       }
    }


    private Task performCredentialsAuthorization() {
        return new Task() {
            @Override
            public <T extends Actor> void performAs(T actor) {
                try {
                    ObjectMapper mapper = new ObjectMapper();
                    UseAccount credentials = actor.usingAbilityTo(UseAccount.class);
                    String reqBody = mapper.writeValueAsString(credentials);
                    actor.wasAbleTo(Post.to("/login").with(req -> req.body(reqBody)));
                } catch (Exception e) {
                    StepEventBus.getEventBus().testFailed(e);
                }
            }
        };
    }

    private Task performAuthTokenAuthorization() {
        return new Task() {
            @Override
            public <T extends Actor> void performAs(T actor) {
                UseAccount credentials = actor.usingAbilityTo(UseAccount.class);
                actor.wasAbleTo(Post.to("/login").with(req -> req.body(credentials.getPassword())));
            }
        };
    }
}
