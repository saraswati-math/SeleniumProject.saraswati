package fdPack;

import static org.testng.Assert.assertTrue;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.Assert;
import org.testng.annotations.Test;

public class excelClassTest {
	
	@Test
	public void excel() throws IOException {
	
	FileInputStream fis=new FileInputStream("sample.xlsx");// fetching the file and providing as input
	XSSFWorkbook wb=new XSSFWorkbook(fis);//workbook level of access
	int sheetcount = wb.getNumberOfSheets();//No of sheets in workbook
	
	for(int i=0;i<=sheetcount-1;i++) {
		
		if(wb.getSheetName(i).equalsIgnoreCase("DATA")) {
			XSSFSheet sheet = wb.getSheetAt(i);
			Iterator<Row> rows = sheet.iterator();
			Row firstrow = rows.next();
			Iterator<Cell> rowdata = firstrow.iterator();
			//int C=0;
			
			while(rowdata.hasNext()) {
				Assert.assertTrue(rowdata.next().getStringCellValue().equalsIgnoreCase("register")); 
			}
			
		}
	}
	
	}	
	
}