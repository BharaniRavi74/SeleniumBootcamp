package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import base.TestNgHooks;

public class SalesForce_Login_page extends TestNgHooks{

	public SalesForce_Login_page enterUsername(String Username) {
		type(getWebElement("id=username"),Username);
		return this;
	}
	
	public SalesForce_Login_page enterpassword(String password) {
		type(getWebElement("id=password"),password);
		return this;
	}
	
	public SalesForce_Home_page clicklogin() {

		click(getWebElement("id=Login"));

		return new SalesForce_Home_page();
	}	

}
