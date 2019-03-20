package com.github.qbek.screenplay.units;

import com.github.qbek.screenplay.abilities.Card;
import com.github.qbek.screenplay.abilities.Uses;
import org.hamcrest.Matchers;
import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;

public class UsesTest {

    @Test
    public void canGenerateCreditCard() throws Exception {
        Card card = Uses.useCreditCard().getCard();
        assertThat("Karta kredytowa bin: 330022", card.getPan(), Matchers.containsString("330022"));
    }

    @Test
    public void canGenerateDebitCard() throws Exception {
        Card card = Uses.useDebitCard().getCard();
        assertThat("Karta kredytowa bin: 110022", card.getPan(), Matchers.containsString("110022"));
    }
}
