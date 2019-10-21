package com.github.qbek.screenplay.transforms;

import cucumber.api.Transformer;
import net.serenitybdd.screenplay.Actor;

import static net.serenitybdd.screenplay.actors.OnStage.theActorCalled;

public class UserInStep extends Transformer<Actor> {
    @Override
    public Actor transform(String actorName) {
        return theActorCalled(actorName);
    }
}
