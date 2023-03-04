package pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SalesForce_Home_page {

	WebDriver driver;
	WebDriverWait wait;

	public SalesForce_Home_page(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//div[@class='slds-icon-waffle']")
	WebElement App_launcher;

	@FindBy(xpath = "//Button[text()='View All']")
	WebElement ViewAll;

	@FindBy(xpath = "//p[text()='Sales']")
	WebElement Sales_option;

	@FindBy(xpath = "//span[text()='Accounts']/parent::*")
	WebElement Accounts_link;

	@FindBy(xpath= "//span[@class='uiImage']")
	WebElement Login_img;
	public SalesForce_Home_page AppLauncher() {

		App_launcher.click();
		return this;

	}

	public SalesForce_Home_page ViewAll() {

		ViewAll.click();
		return this;
	}

	public SalesForce_Home_page salesoption() {

		Sales_option.click();
		return this;
	}

	public SalesForce_Home_page Accounts_link() {

		JavascriptExecutor executor = (JavascriptExecutor) driver;
		executor.executeScript("arguments[0].click();", Accounts_link);
		return this;

	}
	
	public SalesForce_Home_page login_img_verify() {
	wait = new WebDriverWait(driver, Duration.ofSeconds(40));
	wait.until(ExpectedConditions.visibilityOf(Login_img));

	if (driver.getCurrentUrl().contains("/lightning/setup/SetupOneHome/home")) {
		System.out.println("Logged in successfully");
		// assertEquals("True", "false");
	} else {
		System.out.println("Login in Failed");

	}
	return this;
	}
}
