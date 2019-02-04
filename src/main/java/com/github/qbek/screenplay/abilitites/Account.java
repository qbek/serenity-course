package com.github.qbek.screenplay.abilitites;

import net.serenitybdd.screenplay.Ability;

public class Account implements Ability {

    private String login;

    public String getLogin() {
        return login;
    }

    public String getPassword() {
        return password;
    }

    private String password;

    public Account (String login, String password) {
        this.login = login;
        this.password = password;
    }
}
