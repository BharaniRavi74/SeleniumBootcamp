package Week1;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class DataProviderimple{
	ChromeDriver driver ;

	@DataProvider(name = "creden")
	public Object[][] credentials() {
		return new Object[][] {
			
			{"hari.radhakrishnan@qeagle.com","Leaf@123"},
					
		};		
		
	}
	
	@Test(dataProvider = "creden")
	public void LoginToSalesForce(String user, String pswd) {

		ChromeOptions ops = new ChromeOptions();
		ops.addArguments("--disable-notifications");
		ops.addArguments("start-maximized");
	    driver = new ChromeDriver(ops);
		driver.get("https://login.salesforce.com");
		//driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		driver.findElement(By.id("username")).sendKeys(user);
		driver.findElement(By.id("password")).sendKeys(pswd);

		driver.findElement(By.id("Login")).click();
		
		WebElement Login =driver.findElement(By.xpath("//span[@class='uiImage']"));
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(30));
		wait.until(ExpectedConditions.visibilityOf(Login));
		
		if(driver.getTitle().contains("Home | Salesforce")) {
			System.out.println("Logged in successfully");
		}
		else {
			System.out.println("Login in Failed");
		}

	}

	@Test(priority = 2)
	public void CreateAccount() {
		
		System.out.println("1234");
		
	}
	
		
		
	@AfterClass
	public void driverclose() {
		
		driver.close();
	}
}
