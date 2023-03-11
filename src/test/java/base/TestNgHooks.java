package base;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

import util.ConfigReader;

public class Base {

	protected WebDriver driver;

	@BeforeTest
	public void launch() {

		ChromeOptions ops = new ChromeOptions();
		ops.addArguments("--disable-notifications");
		ops.addArguments("start-maximized");
		driver = new ChromeDriver(ops);
		driver.get(ConfigReader.getProperty("Baseurl")); 
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(40));
	}

	

//@AfterMethod
public void afterMethod(ITestResult result)  {

 result = Reporter.getCurrentTestResult();

    switch (result.getStatus()) {
    case ITestResult.SUCCESS:
        System.out.println("======PASS=====");
        // my expected functionality here when passed
        break;

    case ITestResult.FAILURE:
        System.out.println("======FAIL=====");
        // my expected functionality here when passed
        break;

    case ITestResult.SKIP:
        System.out.println("======SKIP BLOCKED=====");
        // my expected functionality here when passed
        break;

    default:
        throw new RuntimeException("Invalid status");
    }
  }
		
	}
		
