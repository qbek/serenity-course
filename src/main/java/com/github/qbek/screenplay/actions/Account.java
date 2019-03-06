package com.github.qbek.screenplay.actions;

import net.serenitybdd.screenplay.Task;

public class Account {

    public static Task loginToAccount() {

        //first option to create task with serenity reporting
//        return Instrumented.instanceOf(LoginToAccount.class).withProperties("credentials");
        return Task.where("{0} login to account using credentials authorization", new LoginToAccount());
    }

    public static Task checkCardBalance() {
        return Task.where("{0} checks credit card balance", new CheckCardBalance());
    }
}