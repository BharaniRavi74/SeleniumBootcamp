package Base;

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
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

public class Base {

	protected WebDriver driver;

	@BeforeTest
	public void launch() {

		ChromeOptions ops = new ChromeOptions();
		ops.addArguments("--disable-notifications");
		ops.addArguments("start-maximized");
		driver = new ChromeDriver(ops);
		driver.get("https://login.salesforce.com"); //
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(40));
	}

	@AfterClass
	public void tearDown() throws IOException {
		
		driver.quit();
		
	}
		/*String location = "/SalesForce/test-output/FailureScreenshot/"; // location for images
		String methodname = result.getName(); // fetching test method name
		if (!result.isSuccess())
			try {
				File screenshots = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
				FileUtils.copyFile(screenshots, new File(location + methodname + "_" + ".png"));
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				driver.quit();
			}
	}*/
}
