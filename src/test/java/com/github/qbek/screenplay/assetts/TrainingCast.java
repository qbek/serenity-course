package com.github.qbek.screenplay.assetts;

import net.serenitybdd.screenplay.Ability;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.actors.Cast;
import net.serenitybdd.screenplay.rest.abilities.CallAnApi;

public class TrainingCast extends Cast {

    @Override
    public Actor actorNamed(String actorName, Ability... abilities) {
        return super.actorNamed(actorName, CallAnApi.at(System.getProperty("sutAddress")));
    }
}
