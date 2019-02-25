package com.github.qbek.screenplay.actions;

import net.serenitybdd.screenplay.Task;

import static com.github.qbek.screenplay.actions.data.AuthorizationType.CREDENTIALS;
import static com.github.qbek.screenplay.actions.data.CardType.CREDIT;

public class Account {

    public static Task loginToAccount() {

        //first option to create task with serenity reporting
//        return Instrumented.instanceOf(LoginToAccount.class).withProperties("credentials");

        LoginToAccount task = new LoginToAccount(CREDENTIALS);
        return Task.where("{0} login to account using credentials authorization", task);
    }

    public static Task checkCardBalance() {
        CheckCardBalance task = new CheckCardBalance(CREDIT);
        return Task.where("{0} checks credit card balance", task);
    }
}