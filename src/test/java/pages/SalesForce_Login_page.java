package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SalesForce_Login_page {

	 WebDriver driver;

	public SalesForce_Login_page(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(id = "username")
	private WebElement username_Txt;

	@FindBy(id = "password")
	private WebElement Password_Txt;

	@FindBy(id = "Login")
	private WebElement login_Btn;

	public SalesForce_Login_page EnterUsername(String Username) {
		username_Txt.sendKeys(Username);
		return this;
	}
	
	public SalesForce_Login_page Enterpassword(String password) {
		Password_Txt.sendKeys(password);
		return this;
	}
	
	public SalesForce_Home_page clicklogin() {

		
		login_Btn.click();
		return new SalesForce_Home_page(driver);
	}	

}
