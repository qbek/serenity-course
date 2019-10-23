package com.github.qbek.screenplay.steps;

import com.github.qbek.screenplay.assertions.Assertions;
import com.github.qbek.screenplay.transforms.UserInStep;
import cucumber.api.Transform;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.serenitybdd.screenplay.Actor;

import static com.github.qbek.screenplay.actions.ActionsFactory.loginIntoAccount;
import static com.github.qbek.screenplay.actions.ActionsFactory.loginIntoAccountUsingAuthToken;

public class AccountSteps {

    @Given("^(\\w+) is logged in his account$")
    public void heIsLoggedInHisAccount(
            @Transform(UserInStep.class) Actor user
    ) {
        user.wasAbleTo(loginIntoAccount());
    }

    @When("^(\\w+) sends his credentials$")
    public void heSendsHisCredentials(
            @Transform(UserInStep.class) Actor user
    ) {
        user.wasAbleTo(loginIntoAccount());
    }

    @When("^(\\w+) sends authToken$")
    public void heSendsAuthToken(
       @Transform(UserInStep.class) Actor user
    ) {
        user.wasAbleTo(loginIntoAccountUsingAuthToken());
    }

    @Then("^(\\w+) is logged in$")
    public void heIsLoggedIn(
            @Transform(UserInStep.class) Actor user
    ) {
        user.should(Assertions.beLoggedIn());
    }
}
