package TestSuite;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.fail;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.TakesScreenshot;
import java.time.Duration;
import java.time.LocalDateTime;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.PageFactory;
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
import Pages.Login_page;
import TestDataProvider.AccountDataprovider;

public class Login_TC extends Base {

	WebDriverWait wait;

	@Test(dataProviderClass = AccountDataprovider.class, dataProvider = "AccAdd",priority = 1)
	public void LoginToSalesForce(String username, String pswd) throws IOException {

		driver.findElement(By.id("username")).sendKeys(username);
		driver.findElement(By.id("password")).sendKeys(pswd);

		driver.findElement(By.id("Login")).click();

		WebElement Login = driver.findElement(By.xpath("//span[@class='uiImage']"));

		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.visibilityOf(Login));

		if (driver.getTitle().contains("Home | Salesforce")) {
			System.out.println("Logged in successfully");
			//assertEquals("True", "false");
		} else {
			System.out.println("Login in Failed");
			

		}

	}

@Test(priority = 2)
public void Create_Accounts() {
	
	wait = new WebDriverWait(driver, Duration.ofSeconds(40));
	
	WebElement App_launcher=driver.findElement(By.xpath("//div[@class='slds-icon-waffle']"));
	//wait.until(ExpectedConditions.visibilityOf(App_launcher));
	App_launcher.click();
	

	WebElement ViewAll =driver.findElement(By.xpath("//Button[text()='View All']"));
	//wait.until(ExpectedConditions.visibilityOf(ViewAll));
	ViewAll.click();
	
	
	WebElement Sales_option=driver.findElement(By.xpath("//p[text()='Sales']"));
	//wait.until(ExpectedConditions.visibilityOf(Sales_option));
	Sales_option.click();
	
	WebElement Accounts_link = driver.findElement(By.xpath("//span[text()='Accounts']/parent::*"));
	JavascriptExecutor executor = (JavascriptExecutor)driver;
    executor.executeScript("arguments[0].click();", Accounts_link);
	
	WebElement NewAcccount_Btn =driver.findElement(By.xpath("//a[@title='New']"));
	wait.until(ExpectedConditions.visibilityOf(NewAcccount_Btn));
	NewAcccount_Btn.click();
	
	
	WebElement Account_name_Txt= driver.findElement(By.xpath("(//input[@class='slds-input'])[2]"));
	Account_name_Txt.sendKeys("Bharani");
	
	/*
	 * WebElement Ownership_DD=
	 * driver.findElement(By.xpath("//button[@id='combobox-button-580']"));
	 * Ownership_DD.click();
	 */
	
	WebElement Save_btn= driver.findElement(By.xpath("//button[@name='SaveEdit']"));
	Save_btn.click();
	
	
	WebElement Text_verification =driver.findElement(By.xpath("//div[@class='forceVisualMessageQueue']"));
	String text = Text_verification.getText();
	System.out.println("Text:"+ text);
	
}


}
