package com.angel.Utilities;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.sql.Timestamp;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.regex.Pattern;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.FormulaEvaluator;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

import com.angel.accelerators.Base;

public class Excel extends Base {

	private static final Logger log = LogManager.getLogger(Excel.class.getName());

	private static Workbook wb;
	private static Sheet sh;
	private static Row row;

	public static boolean writeToExcelSheet(String jobtype, String jobtitle,String joblocation) throws Exception {
		String fileName = System.getProperty("user.dir") + "\\TestData\\" + configProps.getProperty("TestCaseFileName")
				+ ".xlsx";
		String sheetName = configProps.getProperty("JobDetails");
		FileInputStream file = new FileInputStream(fileName);
		wb = WorkbookFactory.create(file);
		sh = wb.getSheet(sheetName);
		int rowCount = sh.getLastRowNum() + 1;
		row = sh.createRow(rowCount);
		Cell c1 = row.createCell(0);
		c1.setCellValue(jobtype);
		Cell c2 = row.createCell(1);
		c2.setCellValue(jobtitle);
		Cell c3 = row.createCell(2);
		c3.setCellValue(joblocation);
		
		file.close();

		FileOutputStream outFile = new FileOutputStream(fileName);
		wb.write(outFile);
		outFile.close();
		return true;

	}

}