package com.github.qbek.screenplay.facts;

import com.fasterxml.jackson.core.JsonProcessingException;
import net.serenitybdd.core.Serenity;
import net.serenitybdd.core.exceptions.SerenityManagedException;
import net.serenitybdd.reports.model.FailingScenario;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.QuestionConsequence;
import net.serenitybdd.screenplay.facts.Fact;
import org.hamcrest.Matchers;

import static com.github.qbek.screenplay.abilitites.AccountFactory.useActiveAccount;
import static com.github.qbek.screenplay.abilitites.AccountFactory.useInactiveAccount;
import static com.github.qbek.screenplay.abilitites.CardFactory.useValidCard;

public class CardAccountFact {
    public static Fact accountWithCard() {
        return new Fact() {
            @Override
            public void setup(Actor actor) {
                // Now we are creating our card ability using static CardFactory function.
                try {
                    actor.can(useValidCard());
                    actor.can(useActiveAccount());
                } catch (JsonProcessingException e) {
                    e.printStackTrace();
                }
            }

            public String toString() {
                return "active account and valid card";
            }
        };
    }

    public static Fact inactiveAccount() {
        return new Fact() {
            @Override
            public void setup(Actor actor) {
                try {
                    actor.can(useInactiveAccount());
                } catch (JsonProcessingException e) {
                    e.printStackTrace();
                }
            }
        };
    }
}
