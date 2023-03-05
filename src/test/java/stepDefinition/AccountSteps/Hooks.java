package stepDefinition.AccountSteps;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

public class Hooks {
public static WebDriver driver;
		@Before(order=1)
	    public void beforeScenario(){
			ChromeOptions ops = new ChromeOptions();
			ops.addArguments("--disable-notifications");
			ops.addArguments("start-maximized");
			driver = new ChromeDriver(ops);
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(40));
	    }	
		@Before(order=0)
	    public void beforeScenarioStart(){
	        System.out.println("-----------------Start of Scenario-----------------");
	    }	
		
		@After(order=1)
	    public void afterScenario(){
			System.out.println("End with after order 1");
	    }	
		@After(order=0)
	    public void afterScenarioFinish(Scenario scenario) throws IOException{
			System.out.println("End with after order 0");
			if(scenario.isFailed()) {
				TakesScreenshot screenshot=(TakesScreenshot)driver;
				File src = screenshot.getScreenshotAs(OutputType.FILE);
				FileUtils.copyFile(src, new File("./test-output/FailureScreenshot/"+scenario.getName()+".png"));
				
			}
			driver.quit();
	    }	
		

	}


