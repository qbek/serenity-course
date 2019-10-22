package com.github.qbek.screenplay.data;

import com.github.javafaker.Faker;
import com.github.qbek.screenplay.data.account.UseAccount;
import com.github.qbek.screenplay.data.card.UseCards;
import net.serenitybdd.screenplay.facts.Fact;

import static com.github.qbek.screenplay.data.account.AccountAbilityFactory.useActiveAccount;
import static com.github.qbek.screenplay.data.card.CardAbilitiesFactory.useCreditCard;
import static com.github.qbek.screenplay.data.card.CardAbilitiesFactory.useDebitCard;

public class FactsFactory {
    public static Fact cardWithActiveAccount() {
        Faker faker = new Faker();
        if(faker.random().nextBoolean()) {
            return debitCardWithActiveAccount();
        } else {
            return creditCardWithActiveAccount();
        }
    }

    public static Fact creditCardWithActiveAccount() {
        return new CardAndAccount(
                (UseCards) useCreditCard(),
                (UseAccount) useActiveAccount()
        );
    }

    public static Fact debitCardWithActiveAccount() {
        return new CardAndAccount(
                (UseCards) useDebitCard(),
                (UseAccount) useActiveAccount()
        );
    }

    public static Fact activeAccount() {
        return new CardAndAccount((UseAccount) useActiveAccount());
    }

    public static Fact activeAccountWithAuthTokenAuthorization() {
        boolean useAuthToken = true;
        return new CardAndAccount((UseAccount) useActiveAccount(), useAuthToken);
    }
}
