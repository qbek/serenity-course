package com.github.qbek.screenplay.steps;

import com.github.qbek.screenplay.transforms.UserInStep;
import cucumber.api.Transform;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.actors.Cast;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.rest.abilities.CallAnApi;

import static com.github.qbek.screenplay.data.FactsFactory.cardWithActiveAccout;

public class PreconditionSteps {

    @Before
    public void setup() {
        OnStage.setTheStage(new Cast());
    }

    @Given("^(\\w+) is a card user with active account$")
    public void carlIsACardUserWithActiveAccount(
            @Transform(UserInStep.class) Actor user
    ) throws Throwable {
        user.has(cardWithActiveAccout());
        user.can(CallAnApi.at(System.getProperty("sutAddress")));
    }

}
