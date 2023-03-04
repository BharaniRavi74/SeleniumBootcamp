package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Accounts_page {

	@FindBy(xpath="//a[@title='New']")
	WebElement NewAcccount_Btn;
	
	@FindBy(xpath="(//input[@class='slds-input'])[2]")
	WebElement Account_name_Txt;
	
	
	wait.until(ExpectedConditions.visibilityOf(NewAcccount_Btn));
	NewAcccount_Btn.click();

	
	Account_name_Txt.sendKeys("Bharani");

	/*
	 * WebElement Ownership_DD=
	 * driver.findElement(By.xpath("//button[@id='combobox-button-580']"));
	 * Ownership_DD.click();
	 */

	WebElement Save_btn = driver.findElement(By.xpath("//button[@name='SaveEdit']"));
	Save_btn.click();

	WebElement Text_verification = driver.findElement(By.xpath("//div[@class='forceVisualMessageQueue']"));
	String text = Text_verification.getText();
	System.out.println("Text:" + text);


}
