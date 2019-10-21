package com.github.qbek.screenplay.data.account;

import net.serenitybdd.screenplay.Ability;

public class AccountAbilityFactory {
    public static Ability useActiveAccount() {
        String login = System.getProperty("login");
        String password = System.getProperty("pass");
        boolean active = true;
        return new UseAccount(login, password, active);
    }

    public static Ability useInactiveAccount() {
        String login = System.getProperty("login");
        String password = System.getProperty("pass");
        boolean inactive = false;
        return new UseAccount(login, password, inactive);
    }
}
