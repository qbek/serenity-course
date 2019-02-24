package com.github.qbek.screenplay.actions;

import net.serenitybdd.screenplay.*;
import org.hamcrest.Matchers;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;

public class Account {

    public static Task loginToAccount() {
        return new LoginToAccount();
    }
}