package com.github.qbek.screenplay.actions;

import net.serenitybdd.screenplay.Task;

import static net.serenitybdd.core.steps.Instrumented.instanceOf;

public class ActionsFactory {

    public static Task loginIntoAccount() {
        return instanceOf(UserLogsIntoAccount.class).newInstance();
    }

    public static Task loginIntoAccountUsingAuthToken() {
        boolean useAuthToken = true;
        return instanceOf(UserLogsIntoAccount.class).withProperties(useAuthToken);
    }

    public static Task checkCardBalance() {
        return instanceOf(UserChecksCardBalance.class).newInstance();
    }

}
