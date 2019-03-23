package com.github.qbek.screenplay.units;

import com.github.qbek.screenplay.abilities.Card;
import com.github.qbek.screenplay.abilities.TestDataGenerator;
import com.github.qbek.screenplay.abilities.RandomTestDataGenerator;
import org.hamcrest.Matchers;
import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;

public class RandomDataGenerationTest {

    private TestDataGenerator data = new RandomTestDataGenerator();

    @Test
    public void canGenerateCreditCard() throws Exception {
        Card card = data.createCreditCard().getCard();
        assertThat("Karta kredytowa bin: 330022", card.getPan(), Matchers.containsString("330022"));
    }

    @Test
    public void canGenerateDebitCard() throws Exception {
        Card card = data.createDebitCard().getCard();
        assertThat("Karta kredytowa bin: 110022", card.getPan(), Matchers.containsString("110022"));
    }
}
