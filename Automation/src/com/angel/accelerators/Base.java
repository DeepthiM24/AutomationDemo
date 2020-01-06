package com.angel.accelerators;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.testng.ITestContext;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import com.angel.Utilities.ConfigProperties;
import com.angel.Utilities.MyOwnException;
import com.angel.PageObjects.AllPages;

public class Base {

	private static final Logger log = LogManager.getLogger(Base.class.getName());

	public static EventFiringWebDriver driver;

	public static String sBrowserType = "";
	public static WebDriver webDriver;
	public static String sBrowser;
	public static String quoteNumber;
	public static String testDataFilename;
	public static String ReferenceNumber = "";
	public static AllPages trackerspages;
	public static String revisedfilename = "";
	public static boolean result;
	public static Actions action;
	public static String fileFormat = "";
	public static File file;
	public static FileInputStream fs;
	public static FileOutputStream os;
	public static Properties properties;
	public static Properties configProps;
	public static String documentPath;

	public static HashMap<String, String> currentHash = new HashMap<String, String>();
	public static List<HashMap<String, String>> mydata = new ArrayList<HashMap<String, String>>();
	private static Workbook wb;
	private static Sheet sh;
	public static Map<String, String> IULoginMap = null;

	@BeforeClass
	@Parameters({ "testCaseId", "testDataFileName" })
	public void setup(String testCaseId, String testDataFileName) throws MyOwnException {

		log.info("BEFORE CLASS EXECUTION STARTED SUCCESSFULLY");
		try {
			configProps = ConfigProperties.loadFrom(System.getProperty("user.dir") + "\\", "config.properties");
			trackerspages = new AllPages(webDriver);

			System.out.println(testCaseId);
			testDataFilename = testDataFileName;
			readSpecificTestData(testCaseId, testDataFileName);

		} catch (Exception exp) {
			log.error(exp.getMessage());
			throwException("UNABLE TO EXECUTE BEFORE CLASS SECTION : \n" + exp.getMessage() + "\n");
		}
		log.info("BEFORE CLASS EXECUTED SUCCESSFULLY");
	}

	public static boolean fileFormatIs(String expectedExtension) {

		log.info("INTENDED TO CHECK IF THE FILE BELONGS TO THE GIVEN FORMAT");
		if (fileFormat.equalsIgnoreCase(expectedExtension)) {
			log.info("EXPECTED AND ACTUAL FILE FORMATS ARE THE SAME");
			result = true;
		} else {
			log.error("EXPECTED AND ACTUAL FILE FORMATS ARE DIFFERENT");
			result = false;
		}
		log.info("SUCCESSFULLY CHECKED IF THE FILE BELONGS TO THE GIVEN FORMAT");
		return result;
	}

	public static boolean notEmpty(String string) {

		log.info("INTENDED TO CHECK IF THE STRING IS EMPTY");
		if (string != "") {
			log.info("STRING IS NOT EMPTY");
			result = true;
		} else {
			log.error("STRING IS EMPTY");
			result = false;
		}
		log.info("SUCCESSFULLY CHECKED IF THE STRING IS EMPTY");
		return result;
	}

	public static boolean formatGiven(String fileName) {

		log.info("INTENDED TO CHECK IF THE FILE NAME HAS THE FILE EXTENSION");
		int position = fileName.indexOf(".");
		if (position >= 0) {
			log.info("FILE FORMAT IS PROVIDED WITH THE FILE NAME(" + fileName + ")");
			result = true;
		} else {
			log.error("FILE FORMAT IS NOT PROVIDED WITH THE FILE NAME(" + fileName + ")");
			result = false;
		}
		log.info("SUCCESSFULLY CHECKED IF THE FILE NAME HAS THE FILE EXTENSION");
		return result;
	}

	public static String getFileFormat(String fileName) throws MyOwnException {

		log.info("INTENDED TO RETRIEVE THE FORMAT OF THE FILE");
		try {
			fileFormat = fileName.substring(fileName.indexOf("."));
			log.info(
					"SUCCESSFULLY GOT THE FILE FORMAT(" + fileFormat + ") FROM THE FILE NAME(" + fileName + ")" + "\n");
		} catch (Exception e) {
			log.error("UNABLE TO GET THE FILE FORMAT(" + fileFormat + ") FROM THE FILE NAME(" + fileName + ")");
			throwException(
					"UNABLE TO GET THE FILE FORMAT(" + fileFormat + ") FROM THE FILE NAME(" + fileName + ")" + "\n");
		}
		log.info("SUCCESSFULLY RETRIEVED THE FORMAT OF THE FILE");
		return fileFormat;
	}

	public static FileInputStream readFile(File file) throws MyOwnException {

		log.info("INTENDED TO READ THE GIVEN FILE");
		try {
			fs = new FileInputStream(file);
			log.info("SUCCESSFULLY READ THE FILE(" + file + ") SPECIFIED");
		} catch (FileNotFoundException e) {
			log.error("UNABLE TO READ THE FILE(" + file + ") SPECIFIED, PLEASE CHECK NAME OR LOCATION OR EXTENSION");
			throwException("UNABLE TO READ THE FILE(" + file + ") SPECIFIED, PLEASE CHECK NAME OR LOCATION OR EXTENSION"
					+ "\n");
		}
		log.info("READING THE FILE IS SUCCESSFUL");
		return fs;
	}

	public static File createFileInstance(String name) throws MyOwnException {

		log.info("INTENDED TO CREATE THE FILE INSTANCE");
		try {
			file = new File(name);
			log.info("FILE INSTANCE CREATED");
		} catch (Exception e) {
			log.error("UNABLE TO CREATE AN INSTANCE OF THE FILE(" + name + ")");
			throwException("UNABLE TO CREATE AN INSTANCE OF THE FILE(" + name + ")" + "\n");
		}
		log.info("SUCCESSFULLY CREATED THE FILE INSTANCE");
		return file;
	}

	public static List<HashMap<String, String>> readSpecificTestData(String testCaseId, String testDataFileName)
			throws Exception {
		String fileName = System.getProperty("user.dir") + "\\TestData\\" + testDataFileName + ".xlsx";
		String sheetName = configProps.getProperty("CompanyName");
		InputStream file = new FileInputStream(fileName);
		wb = WorkbookFactory.create(file);

		sh = wb.getSheet(sheetName);

		Row HeaderRow = sh.getRow(0);

		for (int i = 1; i < sh.getPhysicalNumberOfRows(); i++) {
			Row currentRow = sh.getRow(i);

			if (testCaseId.equalsIgnoreCase(currentRow.getCell(0).getStringCellValue())) {

				for (int j = 0; j < currentRow.getPhysicalNumberOfCells(); j++) {
					Cell currentCell = currentRow.getCell(j);
					switch (currentCell.getCellType()) {
					case Cell.CELL_TYPE_STRING:
						currentHash.put(HeaderRow.getCell(j).getStringCellValue(), currentCell.getStringCellValue());
						break;
					case Cell.CELL_TYPE_NUMERIC:
						currentHash.put(HeaderRow.getCell(j).getStringCellValue(), String.valueOf(currentCell.getNumericCellValue()));
						break;
					}

				}
				mydata.add(currentHash);
				System.out.println(mydata);
			}
		}
		return mydata;
	}



	public static void throwException(String message) throws MyOwnException {
		throw new MyOwnException(message);
	}

	public void screenShot(String fileName) throws MyOwnException, InterruptedException {
		Thread.sleep(1000);
		File scrFile = ((TakesScreenshot) webDriver).getScreenshotAs(OutputType.FILE);
		try {
			FileUtils.copyFile(scrFile, new File(fileName));
		} catch (IOException exp) {

			throwException("UNABLE TO TAKE THE SCREEN SHOT OF THE SCREEN FROM THE METHOD screenShot.\n"
					+ exp.getMessage() + "\n");
		}

	}

	@AfterClass(alwaysRun = true)
	public void close(ITestContext itx) throws Throwable {
		try {
			log.info("Start of Executing AfterClass method name: close() ");
			log.info("End of Executing after class stuff");
			//webDriver.quit();

		} catch (Exception e) {
			e.printStackTrace();
			log.error(e.getMessage());
		}
		log.info("End of Executing AfterClass method name: close() ");
	}

}
