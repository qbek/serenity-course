package com.github.qbek.screenplay;

import net.serenitybdd.screenplay.Ability;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.actors.Cast;
import net.serenitybdd.screenplay.rest.abilities.CallAnApi;

public class MySpecialCast extends Cast {
    @Override
    public Actor actorNamed(String actorName, Ability... abilities) {
        return super.actorNamed(actorName, CallAnApi.at("http://localhost:8080"));
    }
}
