package cucumberRunner;

import org.testng.annotations.DataProvider;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features = "src/main/resources/AccountFeature/", 
                 glue = "stepDefinition.AccountSteps", 
                 dryRun = false, 
                 monochrome = true,
                 tags="@smoke or @reg",
                 plugin = {
                		 "rerun:failedretry.txt"
	
}
                 )
public class CucumberRunner extends AbstractTestNGCucumberTests {
	
	@DataProvider(parallel=true)
	public Object[][] scenarios(){
	
		return super.scenarios();
		
	}

}
