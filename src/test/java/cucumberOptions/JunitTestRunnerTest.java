package cucumberOptions;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions
(features=".\\src\\test\\java\\Features\\Presentation.feature",
glue="stepDefinitions",dryRun = false,stepNotifications = true,
plugin = {"pretty","html:target/PRMS Test Execution Report.html"}
,tags= "@Regression12"
)

public class JunitTestRunnerTest {

	
}
