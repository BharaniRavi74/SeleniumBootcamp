package base;

import java.io.File;
import java.time.Duration;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.support.ui.Select;

import com.graphbuilder.curve.CatmullRomSpline;

public class seleniumBase implements ISeleniumBaseDesign {
	protected WebDriver driver;

	@Override
	public WebDriver browser(String browserName) {
		Browsertype browsers = Browsertype.valueOf(browserName);
		switch (browsers) {
		case CHROME:
			ChromeOptions ops = new ChromeOptions();
			ops.addArguments("--disable-notifications");
			ops.addArguments("--start-maximized"); 
			ops.addArguments("disable-infobars"); 
			System.setProperty("webdriver.chrome.driver", "./chromeDriver/chromedriver.exe");
			driver = new ChromeDriver(ops);
			driver.manage().timeouts().implicitlyWait(Duration.ofMillis(2000));
		case FIREFOX:
			FirefoxOptions option = new FirefoxOptions();
			option.addArguments("--disable-notifications");
			driver = new FirefoxDriver();
			driver.manage().timeouts().implicitlyWait(Duration.ofMillis(2000));
		case EDGE:
			EdgeOptions opti = new EdgeOptions();
			opti.addArguments("--disable-notifications");
			driver = new EdgeDriver();
			driver.manage().timeouts().implicitlyWait(Duration.ofMillis(2000));
		default:
			driver = null;
			break;
		}

		return driver;
	}

	@Override
	public void closeBrowser() {
		driver.close();
	}

	@Override
	public void quitBrowser() {
		driver.quit();

	}

	@Override
	public void open(String aut) {
		driver.get(aut);

	}

	@Override
	public WebElement getWebElement(String locator) {
		WebElement element = null;
		String[] spilt =locator.split("=",2);
		LocatorType locatorType = LocatorType.valueOf(spilt[0].toUpperCase());

		switch (locatorType) {

		case ID:
			element = driver.findElement(By.id(spilt[1]));
			break;
		case NAME:
			element = driver.findElement(By.name(spilt[1]));
			break;
		case CLASSNAME:
			element = driver.findElement(By.className(spilt[1]));
			break;
		case TAGNAME:
			element = driver.findElement(By.tagName(spilt[1]));
			break;
		case PARTIALLINKTEXT:
			element = driver.findElement(By.partialLinkText(spilt[1]));
			break;
		case LINKTEXT:
			element = driver.findElement(By.linkText(spilt[1]));
			break;
		case CSSSELECTOR:
			element = driver.findElement(By.cssSelector(spilt[1]));
			break;
		case XPATHSELECTOR:
			element = driver.findElement(By.xpath(spilt[1]));
			break;
		default:
			break;

		}

		return element;
	}

	@Override
	public List<WebElement> getWebElements(String locator) {
		List<WebElement>  element = null;
		String[] spilt =locator.split("=",2);
		LocatorType locatorType = LocatorType.valueOf(spilt[0].toUpperCase());

		switch (locatorType) {

		case ID:
			element = driver.findElements(By.id(spilt[1]));
			break;
		case NAME:
			element = driver.findElements(By.name(spilt[1]));
			break;
		case CLASSNAME:
			element = driver.findElements(By.className(spilt[1]));
			break;
		case TAGNAME:
			element = driver.findElements(By.tagName(spilt[1]));
			break;
		case PARTIALLINKTEXT:
			element = driver.findElements(By.partialLinkText(spilt[1]));
			break;
		case LINKTEXT:
			element = driver.findElements(By.linkText(spilt[1]));
			break;
		case CSSSELECTOR:
			element = driver.findElements(By.cssSelector(spilt[1]));
			break;
		case XPATHSELECTOR:
			element = driver.findElements(By.xpath(spilt[1]));
			break;
		default:
			break;

		}

		return element;

	}

	@Override
	public void type(WebElement ele, String data) {
		ele.sendKeys(data);

	}

	@Override
	public void click(WebElement ele) {
		ele.click();

	}

	@Override
	public String getText(WebElement ele) {
		String text = ele.getText();
		return text;
	}

	@Override
	public void selectValueInDropdown(WebElement ele, String text) {
		Select sel = new Select(ele);
		sel.selectByVisibleText(text);

	}

	@Override
	public void moveToParticularElement(WebElement ele) {
		// TODO Auto-generated method stub

	}

	@Override
	public void switchToWindow(int index) {
		 String mainWindowHandle = driver.getWindowHandle();
	        Set<String> allWindowHandles = driver.getWindowHandles();
	        Iterator<String> iterator = allWindowHandles.iterator();

	        // Here we will check if child window has other child windows and will fetch the heading of the child window
	        while (iterator.hasNext()) {
	            String ChildWindow = iterator.next();
	                if (!mainWindowHandle.equalsIgnoreCase(ChildWindow)) {
	                driver.switchTo().window(ChildWindow);
	                }
	        }
	            

	}

	@Override
	public void switchToFrame(WebElement ele) {
		// TODO Auto-generated method stub

	}

	@Override
	public byte[] takeSnap() {

     return ((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES);

              
	}

	@Override
	public void JSEClick(WebElement ele) {

		JavascriptExecutor executor = (JavascriptExecutor) driver;
		executor.executeScript("arguments[0].click();", ele);
		
		
	}

}
