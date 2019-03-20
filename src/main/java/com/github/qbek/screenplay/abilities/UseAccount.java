package com.github.qbek.screenplay.abilities;

import net.serenitybdd.screenplay.Ability;

public class UseAccount implements Ability {

    private Credentials creds;

    public UseAccount (Credentials creds) {
        this.creds = creds;
    }

    public Credentials getCredentials() {
        return creds;
    }

    public String toString() {
        return "Credentials: " + creds.getLogin() +"\\" + creds.getPassword();
    }
}
