package com.angel.PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import com.angel.accelerators.Base;

public class AllPages extends Base {

	static WebDriver ldriver;

	public AllPages(WebDriver driver) {
		ldriver = driver;
		PageFactory.initElements(driver, this);
	}


	// ========================= PAGE METHODS ============================

	
	  public OpenSite search() {  
		  return new OpenSite(ldriver); }
	 
	
	
}
