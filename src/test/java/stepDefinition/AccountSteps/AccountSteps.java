package stepDefinition.AccountSteps;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import base.TestNgHooks;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.SalesForce_Home_page;
import pages.SalesForce_Login_page;
import util.ConfigReader;

public class AccountSteps {
	TestNgHooks base;
	SalesForce_Login_page login;
	SalesForce_Home_page home;
	WebDriver driver = Cucumber_Hooks.driver;
	WebDriverWait wait;

	@Given("User Enter valid credentials")
	public void user_enter_valid_credentials() {

		driver.get(ConfigReader.getProperty("Baseurl"));

	}

	@When("User clicks on submit button")
	public void user_clicks_on_submit_button() {

		new SalesForce_Login_page(driver).EnterUsername(ConfigReader.getProperty("UserName"))
				.Enterpassword(ConfigReader.getProperty("UserPassword")).clicklogin();

	}

	@Then("User should be able to navigate to salesForce hoe page.")
	public void user_should_be_able_to_navigate_to_sales_force_hoe_page() {
		new SalesForce_Home_page(driver).login_img_verify();
	}

	@Given("User navigates to Accounts page")
	public void user_navigates_to_accounts_page() {
		System.out.println(driver);
		new SalesForce_Home_page(driver).AppLauncher().ViewAll().salesoption();
	}

	@When("User enters {string} and create account")
	public void user_enters_and_create_account(String accname) {
		Assert.assertEquals("1234", "2345");
	}

	@Then("User verifies if Account is displayed on Account table")
	public void user_verifies_if_account_is_displayed_on_account_table() {
		System.out.println("1234");
	}
	
	@When("User enter sampledata")
	public void user_enter_sampledata() {
	    System.out.println("Enter sample data");
	}
	@Then("User sample data printing")
	public void user_sample_data_printing() {
		 System.out.println("User sample data printing");
	}	
	
}
