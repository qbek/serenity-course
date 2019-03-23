package com.github.qbek.screenplay.facts;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.github.qbek.screenplay.abilities.*;
import com.github.qbek.screenplay.aux.LocalSystemSetup;
import com.github.qbek.screenplay.aux.SystemSetup;
import com.github.qbek.screenplay.aux.UatSystemSetup;
import net.serenitybdd.screenplay.Ability;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.facts.Fact;
import net.thucydides.core.steps.StepEventBus;

public class AccountWithCard implements Fact {

    private CardType cardType;
    private TestDataGenerator data;
    private SystemSetup sysSetup;

    public AccountWithCard (CardType cardType) throws Exception {
        this.cardType = cardType;
        data = getTestDataGenerator();
        sysSetup = getSystemSetup();
    }

    @Override
    public void setup(Actor actor) {
        try {
            actor.can(useCard());
            actor.can(useAccount());
        } catch (Exception e) {
            StepEventBus.getEventBus().testFailed(e);
        }
    }

    private TestDataGenerator getTestDataGenerator() throws Exception {
        System.out.println("Testy odpalimy na: " + System.getProperty("env"));
        switch (System.getProperty("env")) {
            case "local":
                return new RandomTestDataGenerator();

            case "uat":
                return new CsvTestDataGenerator();
        }
        throw new Exception("Niewspierane środowisko");
    }

    private SystemSetup getSystemSetup() throws Exception {
        switch (System.getProperty("env")) {
            case "local":
                return new LocalSystemSetup();

            case "uat":
                return new UatSystemSetup();
        }
        throw new Exception("Niewspierane środowisko");
    }


    private Ability useAccount() throws JsonProcessingException {
        UseAccount account = data.createAccount();
        sysSetup.setupCredentials(account.getCredentials());
        return account;
    }

    private Ability useCard() throws Exception {
        UseCards useCard;

        switch (cardType) {
            case DEBIT:
                useCard = data.createDebitCard();
                break;

            case CREDIT:

                useCard =  data.createCreditCard();
                break;

            default:
                throw new Exception("Unknown card type");
        }
        sysSetup.setupCard(useCard.getCard());
        return useCard;
    };

    @Override
    public String toString() {
        return "Account with " + cardType + " card";
    }
}
