package com.github.qbek.screenplay.tasks;

import net.serenitybdd.screenplay.Task;

public class Tasks {
    public static Task userLogsIntoAccount() {
        return new UserLogsIntoAccount();
    }

    public static Task checkCardBalance() {
        return new CheckCardBalance();
    }

}
