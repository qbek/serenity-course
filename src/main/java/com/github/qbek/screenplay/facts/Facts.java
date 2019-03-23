package com.github.qbek.screenplay.facts;

import net.serenitybdd.screenplay.facts.Fact;

import static com.github.qbek.screenplay.facts.CardType.CREDIT;
import static com.github.qbek.screenplay.facts.CardType.DEBIT;

public class Facts {

    public static Fact accountWithDebitCard() throws Exception {
        return new AccountWithCard(DEBIT);
    }

    public static Fact accountWithCreditCard() throws Exception {
        return new  AccountWithCard(CREDIT);
    }
}
