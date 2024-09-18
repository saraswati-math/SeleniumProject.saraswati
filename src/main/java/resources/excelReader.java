package resources;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.util.NumberToTextConverter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class excelReader {
	
public String[][] excelRead() throws IOException {
			FileInputStream fis = new FileInputStream("userdetails.xlsx");
			XSSFWorkbook wb = new XSSFWorkbook(fis);
			XSSFSheet sheet = wb.getSheet("data");
			int rowcount = sheet.getPhysicalNumberOfRows();// we are getting row count
			XSSFRow row = sheet.getRow(0);// we are getting first row
			int cellcount = row.getPhysicalNumberOfCells();// we are getting cell count present in first row
			
			String[][] data=new String [rowcount-1][cellcount-1];//two dimensional array is created
			String value=null;
			XSSFCell cell;
			
			for(int i=1;i<rowcount;i++) 
			{
				
				for (int j=1;j<cellcount;j++)
				{
					cell=sheet.getRow(i).getCell(j);
					if (cell.getCellType()== CellType.STRING) 
					{
						value= cell.getStringCellValue();
					}
					else if(cell.getCellType()== CellType.NUMERIC)
					{
						double cellvalue= cell.getNumericCellValue();
						value=NumberToTextConverter.toText(cellvalue);
					}
					data[i-1][j-1]=value;
				}
			}
			return data;
	}

}

