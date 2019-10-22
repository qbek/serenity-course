import com.github.qbek.screenplay.data.card.Card;
import com.github.qbek.screenplay.data.card.CardAbilitiesFactory;
import com.github.qbek.screenplay.data.card.UseCards;
import org.junit.Test;

import static java.util.Objects.nonNull;
import static org.junit.Assert.assertTrue;

public class CardAbilitiesdFactoryTest {

    @Test
    public void validCardCreationTest() {
        UseCards useCard = (UseCards) CardAbilitiesFactory.useCard();
        Card card =  useCard.getCard();
        assertTrue(nonNull(card.getPan()));
    }

}
