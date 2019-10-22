package com.github.qbek.screenplay.steps;

import com.github.qbek.screenplay.data.account.UseAccount;
import com.github.qbek.screenplay.transforms.UserInStep;
import cucumber.api.Transform;
import cucumber.api.java.en.Given;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.rest.interactions.Get;

public class AccountSteps {

    @Given("^(\\w+) is logged in his account$")
    public void heIsLoggedInHisAccount(
            @Transform(UserInStep.class) Actor user
    ) {
        UseAccount account = user.usingAbilityTo(UseAccount.class);
        String requestBody = String.format("{\"login\":\"%s\", \"pass\":\"%s\"}",
                account.getLogin(),
                account.getPassword()
        );
        user.wasAbleTo(
                Get.resource("/login").with(req -> req.body(requestBody))
        );
    }
}
