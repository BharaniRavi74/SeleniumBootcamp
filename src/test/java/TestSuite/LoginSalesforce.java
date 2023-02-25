package TestSuite;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.TakesScreenshot;
import java.time.Duration;
import java.time.LocalDateTime;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import Base.Base;
import TestDataProvider.AccountDataprovider;

public class LoginSalesforce extends Base{

	//ChromeDriver driver;
	@Test(dataProviderClass = AccountDataprovider.class, dataProvider = "AccAdd")
	public void LoginToSalesForce(String username, String pswd) throws IOException {	

		driver.findElement(By.id("username")).sendKeys(username);
		driver.findElement(By.id("password")).sendKeys(pswd);

		driver.findElement(By.id("Login")).click();

		WebElement Login = driver.findElement(By.xpath("//span[@class='uiImage']"));
		
		  WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		  wait.until(ExpectedConditions.visibilityOf(Login));
		 
		if (driver.getTitle().contains("Home | Salesforce")) {
			System.out.println("Logged in successfully");
			
		} else {
			System.out.println("Login in Failed");
			
		}

	}

	
	@AfterMethod
	public void tearDown(ITestResult result) throws IOException {
	   String location = "/SalesForce/test-output/FailureScreenshot";  //location for images
	    String methodname = result.getName(); // fetching test method name
	    if(result.isSuccess())
	    try {
	        File screenshots = ((TakesScreenshot) driver)
	                               .getScreenshotAs(OutputType.FILE);
	        FileUtils.copyFile(
	            screenshots,
	            new File(location + methodname+ "_" + ".png"));
	    } catch (Exception e) {
	          e.printStackTrace();
	    } finally {
	          driver.quit();
	    }
	}
}
