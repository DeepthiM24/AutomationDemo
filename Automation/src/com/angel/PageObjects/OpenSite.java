package com.angel.PageObjects;

import java.awt.AWTException;
import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import com.angel.Utilities.Excel;
import com.angel.Utilities.MyOwnException;
import com.angel.accelerators.Base;

import wrapper.classes.methods.MyWait;
import wrapper.classes.methods.MyWebElement;

public class OpenSite extends CommonPage {

	private static final Logger log = LogManager.getLogger(OpenSite.class.getName());

	// Page Factory

	@FindBy(how = How.CLASS_NAME, using = "OrangeGradientButton")
	public WebElement signin_button;

	@FindBy(how = How.ID, using = "search")
	public WebElement searchCompany;

	@FindBy(how = How.CLASS_NAME, using = "container_25a85")
	public WebElement list;
	@FindBy(how = How.XPATH, using = "//*[@id=\"main\"]/div[1]/div[4]/div/div/div[1]/div/section/div[2]/div[2]")
	public WebElement jobslist;
	@FindBy(how = How.XPATH, using = "//*[@id=\"main\"]/div[1]/div[4]/div/div/nav/ul/li[5]/a/span[2]")
	public WebElement numberOfJobs;

	WebDriver ldriver;

	public OpenSite(WebDriver dr) {
		super(dr);
		this.ldriver = dr;
		PageFactory.initElements(dr, this);
	}

	public void searchCompany() throws Exception {
		log.info("METHOD(login) STARTED SUCCESSFULLY");

		try {
			MyWait.implicitlyFor(ldriver, 3, "SECONDS");
			MyWebElement.enterText(searchCompany, currentHash.get("CompanyName"));
			Thread.sleep(2000);

			Base base = new Base();
			base.screenShot("./Results/ Companies " + ".png");

			if (list.isDisplayed()) {
				List<WebElement> list1 = list.findElements(By.tagName("a"));
				for (WebElement webElement : list1) {

					if (webElement.getText().contains(currentHash.get("CompanyName")))
						webElement.click();
					break;

				}
			}

			ldriver.findElement(By.partialLinkText("Jobs")).click();
			int num = Integer.parseInt(numberOfJobs.getText());
			for (int i = 2; i <= num; i++) {

				String jobtype = ldriver.findElement(
						By.xpath("//*[@id=\"main\"]/div[1]/div[4]/div/div/div[1]/div/section/div[2]/div[2]/div[" + i
								+ "]/div/a/div[1]/h6"))
						.getText();
				String jobtitle = ldriver.findElement(
						By.xpath("//*[@id=\"main\"]/div[1]/div[4]/div/div/div[1]/div/section/div[2]/div[2]/div[" + i
								+ "]/div/a/div[1]/div/h4"))
						.getText();
				String joblocation = ldriver.findElement(
						By.xpath("//*[@id=\"main\"]/div[1]/div[4]/div/div/div[1]/div/section/div[2]/div[2]/div[" + i
								+ "]/div/div/div/div/span"))
						.getText();
				Excel.writeToExcelSheet(jobtype, jobtitle, joblocation);

			}
		} catch (MyOwnException e) {

			e.printStackTrace();
		}

	}

}
