package cucumberRunner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features = "@failedretry.txt", 
                 glue = "stepDefinition.AccountSteps", 
                 dryRun = false, 
                 monochrome = true, plugin = {
	                                        	"pretty", "rerun:failedretry.txt" 
	                                         })

public class CucumberRetryRunner extends AbstractTestNGCucumberTests {

}
