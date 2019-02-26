package com.github.qbek.screenplay.units;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.github.qbek.screenplay.abilitites.CardFactory;
import com.github.qbek.screenplay.abilitites.UseCard;
import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.greaterThan;
import static org.hamcrest.Matchers.lessThan;

public class CardFactoryTest {

    @Test
    public void can_generate_valid_card() throws JsonProcessingException {
        UseCard card = CardFactory.useCreditCard();
        String[] strDate = card.getExpDate().split("/");
        assertThat("Year is > 2019", Integer.valueOf(strDate[0]), greaterThan(19));
        assertThat("Month number between 1 - 12", Integer.valueOf(strDate[1]), greaterThan(0));
        assertThat("Month number between 1 - 12", Integer.valueOf(strDate[1]), lessThan(13));
    }

}
