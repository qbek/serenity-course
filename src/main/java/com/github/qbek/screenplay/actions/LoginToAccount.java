package com.github.qbek.screenplay.actions;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.qbek.screenplay.abilitites.UseAccount;
import com.github.qbek.screenplay.actions.data.AuthorizationType;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.rest.interactions.Post;
import net.serenitybdd.screenplay.rest.questions.TheResponse;
import net.thucydides.core.steps.StepEventBus;
import org.hamcrest.Matchers;

import static org.hamcrest.MatcherAssert.assertThat;

public class LoginToAccount implements Task {


    @Override
    // needed when object created by Instrumented.instacneOf()
    // @Step("{0} login to account using #authType authorization")
    public <T extends Actor> void performAs(T actor) {
       AuthorizationType authType = actor.usingAbilityTo(UseAccount.class).getAuthorizationType();
       boolean isAuthorized = false;
       switch (authType) {
           case CREDENTIALS:
               isAuthorized = actor.asksFor(credentialsAuthorization());
               break;

           case AUTH_TOKEN:
               actor.attemptsTo(performAuthTokenAuthorization());
               break;

               default:
                   StepEventBus.getEventBus().testFailed(new Exception("Authorization by " + authType + " not supported"));
       }

       assertThat("User not authorized", isAuthorized, Matchers.equalTo(true));
    }


    private Question<Boolean> credentialsAuthorization() {
        return new Question<Boolean>() {
            @Override
            public Boolean answeredBy(Actor actor) {
                try {
                    ObjectMapper mapper = new ObjectMapper();
                    UseAccount credentials = actor.usingAbilityTo(UseAccount.class);
                    String reqBody = mapper.writeValueAsString(credentials);
                    actor.wasAbleTo(Post.to("/login").with(req -> req.body(reqBody)));
                } catch (Exception e) {
                    StepEventBus.getEventBus().testFailed(e);
                }

                return actor.asksFor(TheResponse.statusCode()) == 200;
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
