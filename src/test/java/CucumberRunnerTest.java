
import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(glue = {"steps"},
                    features = {"src/test/resources/features"},
                    plugin = {"util.AllureReporter"})

public class CucumberRunnerTest {
}
