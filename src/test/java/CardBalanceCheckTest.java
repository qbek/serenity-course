import com.github.qbek.screenplay.assetts.TrainingCast;
import com.github.qbek.screenplay.steps.JUnitSteps;
import net.serenitybdd.junit.runners.SerenityRunner;
import net.serenitybdd.screenplay.actors.OnStage;
import net.thucydides.core.annotations.Steps;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(SerenityRunner.class)
public class CardBalanceCheckTest {

    @Steps(actor = "TestUser")
    JUnitSteps steps;


    @Before
    public void setup() {
        OnStage.setTheStage(new TrainingCast());
    }



    @Test
    public void cardBalanceCheck() {
        steps.setupTestData();
        steps.logsIn();
        steps.checksCardBalance();
        steps.correctBalanceIsPresented();
    }

}
