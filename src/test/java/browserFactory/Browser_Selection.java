package browserFactory;

import java.time.Duration;

import org.apache.poi.ss.formula.atp.Switch;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

public  class Browser_Selection {
	
	public WebDriver driver;
	private String BrowserType;

	@SuppressWarnings("static-access")
	public WebDriver launch(String browserName) {
		switch (browserName) {
		case "CHROME":
			driver = new ChromeDriver();
			driver.manage().window().maximize();
			break;
		case "FIREFOX":
			driver = new FirefoxDriver();
			driver.manage().window().maximize();
			break;	
		case "EDGE":
			driver = new EdgeDriver();
			driver.manage().window().maximize();
			break;
		default:
			driver = null;
			break;
		}
		return driver;
	}



	
}
