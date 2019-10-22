package com.github.qbek.screenplay.steps;

import com.github.qbek.screenplay.actions.UserLogsIntoAccount;
import com.github.qbek.screenplay.transforms.UserInStep;
import cucumber.api.Transform;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import net.serenitybdd.core.steps.Instrumented;
import net.serenitybdd.screenplay.Actor;

public class AccountSteps {

    @Given("^(\\w+) is logged in his account$")
    public void heIsLoggedInHisAccount(
            @Transform(UserInStep.class) Actor user
    ) {
        user.wasAbleTo(Instrumented.instanceOf(UserLogsIntoAccount.class).newInstance());
    }

    @When("^(\\w+) sends his credentials$")
    public void heSendsHisCredentials(
            @Transform(UserInStep.class) Actor user
    ) {
        user.wasAbleTo(Instrumented.instanceOf(UserLogsIntoAccount.class).newInstance());
    }
}
