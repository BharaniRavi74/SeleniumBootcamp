package Week1;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.poi.xssf.usermodel.helpers.XSSFRowShifter;
import org.testng.annotations.Test;
import java.util.Iterator;
public class ExcelRead {
	XSSFWorkbook workbook;
	XSSFSheet sheet;
	
@Test

public void getExcelData() throws IOException {

		FileInputStream fs = new FileInputStream("src/main/resources/Account.xlsx");
		workbook = new XSSFWorkbook(fs);
		sheet = workbook.getSheet("Sheet1");
        int totalNoOfRows = sheet.getPhysicalNumberOfRows();
        for(int i =0;i<totalNoOfRows;i++)
        { 
			XSSFRow row = sheet.getRow(i);
			int colCount = row.getLastCellNum();
        
            for( int j=0;j<colCount;j++)
            {
            	System.out.println(row.getCell(j).getStringCellValue());
            	//row.getCell(j).getStringCellValue();

            }
        }         
        
    
}
	public String[][] getExcelData(String fileName, String sheetName) {
		String[][] arrayExcelData = null;
		try {
			FileInputStream fs = new FileInputStream(fileName);
			workbook = new XSSFWorkbook();
			sheet = workbook.getSheetAt(0);

			
			int totalNoOfRows = sheet.getPhysicalNumberOfRows();
		
			

			for(int i =0;i<totalNoOfRows;i++)
	        { 
				XSSFRow row = sheet.getRow(i);
				int colCount = row.getLastCellNum();
	        
	            for( int j=0;j<colCount;j++)
	            {
	            	arrayExcelData[i][j]=row.getCell(j).getStringCellValue();

	            }
	        }

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
			e.printStackTrace();
		} 
		return arrayExcelData;
	}

}
