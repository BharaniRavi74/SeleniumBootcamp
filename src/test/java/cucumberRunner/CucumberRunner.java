package cucumberRunner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features = "src/main/resources/AccountFeature", 
                 glue = "stepDefinition.AccountSteps", 
                 dryRun = false, 
                 monochrome = true)
public class CucumberRunner extends AbstractTestNGCucumberTests {

}
