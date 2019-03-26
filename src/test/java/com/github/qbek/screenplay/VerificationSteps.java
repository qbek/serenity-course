package com.github.qbek.screenplay;

import cucumber.api.java.en.When;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.actors.OnStage;

import static com.github.qbek.screenplay.tasks.Tasks.checkCardBalance;

public class VerificationSteps {
    @When("^(\\w+) checks his card balance$")
    public void carlChecksHisCardBalance(String name) {
        Actor user = OnStage.theActorCalled(name);
        user.attemptsTo(checkCardBalance());
    }

}
