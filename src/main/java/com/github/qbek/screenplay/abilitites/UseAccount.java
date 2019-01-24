package com.github.qbek.screenplay.abilitites;

import net.serenitybdd.screenplay.Ability;

public class UseAccount implements Ability {

    private String login;

    public String getLogin() {
        return login;
    }

    public String getPassword() {
        return password;
    }

    private String password;

    public UseAccount(String login, String password) {
        this.login = login;
        this.password = password;
    }

    public String toString() {
        return "can log in with credentials: " + login + " / " + password;
    }
}
