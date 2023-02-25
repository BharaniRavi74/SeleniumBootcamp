package Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;

public class Login_page {

	final ChromeDriver driver;

	public Login_page(ChromeDriver driver) {
		this.driver = driver;
	}

	@FindBy(id = "username")
	WebElement username_Txt;

	@FindBy(id = "password")
	WebElement Password_Txt;

	@FindBy(id = "Login")
	WebElement login_Btn;

	public void login(String username, String password) {

		username_Txt.sendKeys(username);
		Password_Txt.sendKeys(password);
		login_Btn.click();
	}

}
