package Util;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class ExcelRead {
	static XSSFWorkbook workbook;
	static XSSFSheet sheet;
	static DataFormatter formatter = new DataFormatter();
	ChromeDriver driver = new ChromeDriver();



 public static Object[][] getExcelData(String path,String sheetname) throws IOException
 {
 FileInputStream fileInputStream= new FileInputStream(path); //Excel sheet file location get mentioned here
 //get my workbook 
 workbook=new XSSFWorkbook(fileInputStream);
 sheet=workbook.getSheet(sheetname);// get my sheet from workbook
       XSSFRow Row=sheet.getRow(0);   //get my Row which start from 0   
   
    	int RowNum = sheet.getPhysicalNumberOfRows();// count my number of Rows
    	int ColNum= Row.getLastCellNum(); // get last ColNum 
    	
    	Object Data[][]= new Object[RowNum-1][ColNum]; // pass my  count data in array
    	
     for(int i=0; i<RowNum-1; i++) //Loop work for Rows
     {  
     XSSFRow row= sheet.getRow(i+1);
     
     for (int j=0; j<ColNum; j++) //Loop work for colNum
     {
     if(row==null)
     Data[i][j]= "";
     else 
     {
     XSSFCell cell= row.getCell(j);
     if(cell==null)
     Data[i][j]= ""; //if it get Null value it pass no data 
     else
     {
     String value=formatter.formatCellValue(cell);
     Data[i][j]=value; //This formatter get my all values as string i.e integer, float all type data value
     }
     }
     }
     }
 
    	return Data;
    }


@Test(dataProvider="1234")
public void LoginToSalesForce(String user,String pswd) {

	ChromeOptions ops = new ChromeOptions();
	ops.addArguments("--disable-notifications");
	ops.addArguments("start-maximized");
    driver = new ChromeDriver(ops);
	driver.get("https://login.salesforce.com");
	//driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

	//driver.findElement(By.id("username")).sendKeys("hari.radhakrishnan@qeagle.com");
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

}

