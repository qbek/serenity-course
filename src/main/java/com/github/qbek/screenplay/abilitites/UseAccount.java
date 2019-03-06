package com.github.qbek.screenplay.abilitites;

import com.github.qbek.screenplay.actions.data.AuthorizationType;
import net.serenitybdd.screenplay.Ability;

public class UseAccount implements Ability {

    private String login;
    private String password;
    private AuthorizationType authType;

    public String getLogin() {
        return login;
    }

    public String getPassword() {
        return password;
    }

    public AuthorizationType getAuthorizationType() { return authType; }

    public UseAccount(String login, String password, AuthorizationType authType) {
        this.login = login;
        this.password = password;
        this.authType = authType;

    }

    public String toString() {
        return "can log in with credentials: " + login + " / " + password;
    }
}
