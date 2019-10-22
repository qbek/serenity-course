package com.github.qbek.screenplay.data;

import com.github.qbek.screenplay.data.account.UseAccount;
import com.github.qbek.screenplay.data.card.CardAbilitiesFactory;
import net.serenitybdd.screenplay.facts.Fact;

import static com.github.qbek.screenplay.data.account.AccountAbilityFactory.useActiveAccount;

public class FactsFactory {

    public static Fact cardWithActiveAccout() {
        return new CardAndAccount(
                CardAbilitiesFactory.useCard(),
                useActiveAccount()
        );
    }

    public static Fact expiredCardWithActiveAccount() {
        return null;
    }

    public static Fact expiredCard() {
        return null;
    }

    public static Fact activeAccount() {
        return new CardAndAccount((UseAccount) useActiveAccount());
    }
}
