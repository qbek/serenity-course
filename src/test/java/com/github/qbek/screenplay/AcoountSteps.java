package com.github.qbek.screenplay;

import com.github.qbek.screenplay.data.account.UseAccount;
import cucumber.api.java.en.And;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.actors.OnStage;

public class AcoountSteps {

    @And("^(\\w+) is logged in his account$")
    public void heIsLoggedInHisAccount(String actorName) {
//        Actor user = OnStage.theActorCalled(actorName);
        Actor user = OnStage.theActorInTheSpotlight();

        System.out.println(
                String.format("This is our actor %s ", user.getName())
        );
        UseAccount account = user.usingAbilityTo(UseAccount.class);
        System.out.println(
                String.format("UseAccount login: %s, password: %s",
                        account.getLogin(), account.getPassword())
        );
    }
}
