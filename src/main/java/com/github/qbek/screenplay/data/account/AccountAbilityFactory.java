package com.github.qbek.screenplay.data.account;

import net.serenitybdd.screenplay.Ability;

import static com.github.qbek.screenplay.data.account.AuthType.BASIC;
import static com.github.qbek.screenplay.data.account.AuthType.TOKEN;

public class AccountAbilityFactory {
    public static Ability useActiveAccountWithBasicAuth() {
        String login = System.getProperty("login");
        String password = System.getProperty("pass");
        boolean active = true;
        UseAccount activeAccount = new UseAccount(login, password, BASIC, active);
        return activeAccount;
    }

    public static Ability useActiveAccountWithTokenAuth() {
        String login = System.getProperty("login");
        String password = System.getProperty("pass");
        boolean active = true;
        UseAccount activeAccount = new UseAccount(login, password, TOKEN, active);
        return activeAccount;
    }

}
