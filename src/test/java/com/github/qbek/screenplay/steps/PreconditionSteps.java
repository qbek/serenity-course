package com.github.qbek.screenplay.steps;

import com.github.qbek.screenplay.assetts.TrainingCast;
import com.github.qbek.screenplay.data.FactsFactory;
import com.github.qbek.screenplay.transforms.UserInStep;
import cucumber.api.Transform;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.actors.OnStage;

import static com.github.qbek.screenplay.data.FactsFactory.activeAccount;
import static com.github.qbek.screenplay.data.FactsFactory.cardWithActiveAccount;

public class PreconditionSteps {

    @Before
    public void setup() {
        OnStage.setTheStage(new TrainingCast());
    }


    @Given("^(\\w+) is a card user with active account$")
    public void carlIsACardUserWithActiveAccount(
            @Transform(UserInStep.class) Actor user
    ) throws Throwable {
        user.has(cardWithActiveAccount());
    }

    @Given("^(\\w+) has an active account$")
    public void helmutHasAnActiveAccount(
            @Transform(UserInStep.class)Actor user
            ) {
        user.has(activeAccount());
    }

    @Given("^(\\w+) has active account with authToken authentication$")
    public void markHasActiveAccountWithAuthTokenAuthentication(
            @Transform(UserInStep.class) Actor user
    ) {
        user.has(FactsFactory.activeAccountWithAuthTokenAuthorization());
    }
}
