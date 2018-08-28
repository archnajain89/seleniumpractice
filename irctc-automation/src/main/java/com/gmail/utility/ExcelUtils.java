package com.gmail.utility;

import java.io.FileInputStream;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtils {
	public static XSSFWorkbook workbook;
	public static XSSFSheet xsheet;
	public static XSSFCell xcell;

	public static void setExcelFile(String filepath, String sheetName) throws Exception {
		try {
			FileInputStream fs = new FileInputStream(filepath);
			workbook = new XSSFWorkbook(fs);
			xsheet = workbook.getSheet(sheetName);
		} catch (Exception e) {
			throw (e);
		}

	}

	public static String getCelldata(int rownum, int cellnum) throws Exception {
		try {
			xcell = xsheet.getRow(rownum).getCell(cellnum);
			String cellvalue = xcell.getStringCellValue();
			return cellvalue;
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return "";
		}

	}

}
