package browserFactory;

import org.openqa.selenium.WebDriver;

public interface BrowserFactory {
	
	public WebDriver launch(BrowserType browser);

}
