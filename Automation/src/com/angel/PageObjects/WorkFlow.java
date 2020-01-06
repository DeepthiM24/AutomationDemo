package com.angel.PageObjects;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.angel.PageObjects.OpenSite;
import com.angel.Utilities.MyOwnException;
import com.angel.accelerators.Base;

public class WorkFlow extends Base {

	private static final Logger log = LogManager.getLogger(WorkFlow.class.getName());

	
	public void openSite() throws InterruptedException, MyOwnException {

		log.info("WORKFLOW(newTrackerListingProcess) EXECUTION STARTED SUCCESSFULLY");
		try {
			trackerspages.search().initiateTGQBrowser();
			driver.navigate().to(configProps.getProperty("URL"));
			OpenSite  m=new OpenSite(driver);
			m.searchCompany();
			
		} catch (Exception exp) {
			log.error(exp.getMessage());

		}
		log.info("WORKFLOW(newTrackerListingProcess) EXECUTED SUCCESSFULLY");
	}
	
}
