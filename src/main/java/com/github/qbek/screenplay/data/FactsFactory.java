package com.github.qbek.screenplay.data;

import com.github.qbek.screenplay.data.account.AccountAbilityFactory;
import com.github.qbek.screenplay.data.card.CardAbilitiesFactory;
import net.serenitybdd.screenplay.facts.Fact;

public class FactsFactory {

    public static Fact cardWithActiveAccout() {
        return new CardAndAccount(
                CardAbilitiesFactory.useCard(),
                AccountAbilityFactory.useActiveAccount()
        );
    }

    public static Fact expiredCardWithActiveAccount() {
        return null;
    }

    public static Fact expiredCard() {
        return null;
    }
}
