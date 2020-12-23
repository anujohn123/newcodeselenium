package com.qa.hubspot.util;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelUTil {
	public static Workbook book;
	public static Sheet sheet;
	
	public static String Test_data_Sheet ="C:\\Users\\anujo\\OneDrive\\Desktop\\All framework\\Basic_selenium_2020\\src\\main\\java\\com\\qa\\hubspot\\testdata\\newContact_contactsPage.xlsx";
 
	public static Object[][] getTestData(String sheetname) 

	{
		Object data[][] =null;
		try {
			FileInputStream op = new FileInputStream(Test_data_Sheet);
			
			book =	WorkbookFactory.create(op);
			sheet = book.getSheet(sheetname);
			 
			data   = new Object[sheet.getLastRowNum()][sheet.getRow(0).getLastCellNum()];
		for(int i=0;i<sheet.getLastRowNum();i++)	
		{
			for(int j=0; j<sheet.getRow(0).getLastCellNum();j++)
			{
				data[i][j] = sheet.getRow(i+1).getCell(j).toString();
			}
		}
		
		}	 catch (InvalidFormatException e) {
				
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
			
		return data;
	}
	
}
