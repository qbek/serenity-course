package com.github.qbek.screenplay.steps;

import com.github.qbek.screenplay.actions.UserChecksCardBalance;
import com.github.qbek.screenplay.transforms.UserInStep;
import cucumber.api.Transform;
import cucumber.api.java.en.When;
import net.serenitybdd.screenplay.Actor;

public class CardSteps {
    @When("^(\\w+) checks his card balance$")
    public void carlChecksHisCardBalance(
            @Transform(UserInStep.class) Actor user
    ) {
        user.attemptsTo(new UserChecksCardBalance());
    }
}
