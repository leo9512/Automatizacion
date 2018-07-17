package ninjaStore;
import cucumber.api.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(features = {"src/test/resources/Login.feature"})
/**
 * La clase RunTest permite realizar las pruebas automáticas, para ello se utilizó Cucumber, Serenity, Selenium y Maven
 * @author Neyder Leoncio Daza Cardona
 *
 */
public class RunTest {

}
