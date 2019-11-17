package SberHomeWork;


import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(features = {"src/test/features"}, glue = {"src/main/java/steps"}, plugin = {"util.AllureListener"})
public class CucuRunnerTest {
}
