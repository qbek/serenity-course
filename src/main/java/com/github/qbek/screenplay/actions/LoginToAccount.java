package com.github.qbek.screenplay.actions;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.qbek.screenplay.abilitites.UseAccount;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.rest.interactions.Post;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.steps.ExecutedStepDescription;
import net.thucydides.core.steps.StepEventBus;
import net.thucydides.core.steps.StepFailure;
import net.thucydides.core.steps.StepFailureException;

public class LoginToAccount implements Task {
    @Override
    @Step("Login to account using his credentials")
    public <T extends Actor> void performAs(T actor) {
       try {
           ObjectMapper mapper = new ObjectMapper();
           UseAccount credentials = actor.usingAbilityTo(UseAccount.class);
           String reqBody = mapper.writeValueAsString(credentials);
           actor.wasAbleTo(Post.to("/login").with(req -> req.body(reqBody)));
       } catch (Exception e) {
           StepEventBus.getEventBus().stepFailed(
                   new StepFailure(ExecutedStepDescription.withTitle("test"), e)
           );
       }
    }
}
