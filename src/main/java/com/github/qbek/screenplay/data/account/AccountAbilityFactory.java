package com.github.qbek.screenplay.data.account;

import net.serenitybdd.screenplay.Ability;

public class AccountAbilityFactory {
    public static Ability useActiveAccount() {
        String login = System.getProperty("login");
        String password = System.getProperty("pass");
        boolean active = true;
        UseAccount activeAccount = new UseAccount(login, password, active);
        return activeAccount;
    }

    public static Ability useInactiveAccount() {
        String login = System.getProperty("login");
        String password = System.getProperty("pass");
        boolean inactive = false;
        UseAccount inacativeAccount = new UseAccount(login, password, inactive);
        return inacativeAccount;
    }


}
