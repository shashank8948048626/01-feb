package com.crm.GenericLibrary;

import java.io.FileInputStream;
import java.io.FileOutputStream;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

/**
 * this class contains generic methods that
 * @author shashank
 */

public class ExcelUtility {
/**
 * This method will read data
 * @param sheet
 * @param rowNo
 * @param cellNo
 * @return data
 * @throws Trowable
 */
	public String getDataFromExcel(String sheetName , int rowNum, int celNum) throws Throwable {
		FileInputStream fis  = new FileInputStream("./data/TestScriptData.xlsx");
		Workbook wb = WorkbookFactory.create(fis);
		String data = wb.getSheet(sheetName).getRow(rowNum).getCell(celNum).getStringCellValue();
		wb.close();
		return data;
	}
	/**
	 * it is used to get the last used row number on specified sheet
	 * @param sheetName
	 * @param rowNum
	 * @return
	 * @throws Throwable 
	 * @throws throwable
	 */
	public int getRowCount(String sheetName , int rowNum) throws Throwable {
		FileInputStream fis = new FileInputStream(IPathConstants.ExcelPath);
		Workbook wb = WorkbookFactory.create(fis);
		int lastRow = wb.getSheet(sheetName).getLastRowNum();
		return lastRow;
		
	}
	public void setDataExcel(String sheetName, int rowNum, int cellNum, String data) throws Throwable {
		FileInputStream fis = new FileInputStream(IPathConstants.ExcelPath);
		Workbook wb = WorkbookFactory.create(fis);
		wb.getSheet(sheetName).getRow(rowNum).createCell(cellNum).setCellValue(data);
		FileOutputStream fos = new FileOutputStream(IPathConstants.ExcelPath);
		wb.write(fos);
		wb.close();
		
		
		
		
		
	}
		
	}



	