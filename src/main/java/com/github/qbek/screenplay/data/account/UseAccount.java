package com.github.qbek.screenplay.data.account;

import net.serenitybdd.screenplay.Ability;

public class UseAccount implements Ability {

    private String login;
    private String password;
    private boolean isActive;
    private AuthType type;

    protected UseAccount(String login, String password, AuthType type, boolean isActive) {
        this.login = login;
        this.password = password;
        this.isActive = isActive;
        this.type = type;
    }

    public String getLogin() { return login; };
    public String getPassword() { return password; }
    public void setPassword(String password) { this.password = password; }
    public boolean isActive() { return isActive; }

    public String toString() {
       return "use his account";
    }

    public AuthType getAuthType() {
        return type;
    }
}
