package Runner;

import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;


@RunWith(Cucumber.class)
@CucumberOptions(features= "src/test/java/features", 
                 plugin="json:target/jsonReports/cucumber-report.json",
                 glue= {"stepDefinitions"})
public class TestRunner {

}
// maven commands:
//mvn test------->to run all the scenarios
//mvn test -Dcucumber.options="--tags @AddPlace"------------>to run based on tags
// Three phases in maven---compile---test---verify
//verify phase starts after all the tests are run. Its inside maven cucumber reporting plug in