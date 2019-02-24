package com.github.qbek.screenplay.actions;

import net.serenitybdd.core.steps.Instrumented;
import net.serenitybdd.screenplay.*;
import org.hamcrest.Matchers;

import static net.serenitybdd.screenplay.GivenWhenThen.returnsAValueThat;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;

public class Account {

    public static Task loginToAccount() {

        //first option to create task with serenity reporting
//        return Instrumented.instanceOf(LoginToAccount.class).withProperties("credentials");

        LoginToAccount task = new LoginToAccount("credentials");
        return Task.where("{0} login to account using credentials authorization", task);
    }

    public static Task checkCardBalance() {
        CheckCardBalance task = new CheckCardBalance("credit");
        return Task.where("{0} checks credit card balance", task);
    }
}