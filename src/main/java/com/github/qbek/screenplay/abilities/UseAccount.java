package com.github.qbek.screenplay.abilities;

import com.github.qbek.screenplay.testdata.Account;
import net.serenitybdd.screenplay.Ability;

public class UseAccount implements Ability {

    private Account account;

    public UseAccount(Account account) {
        this.account = account;
    }

    public Account getAccount() {
        return account;
    }
}
