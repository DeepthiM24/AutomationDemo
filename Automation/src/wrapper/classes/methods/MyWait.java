package wrapper.classes.methods;



import java.util.concurrent.TimeUnit;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import com.angel.accelerators.Base;
import com.angel.Utilities.MyOwnException;

public class MyWait extends Base {

	private static final Logger log = LogManager.getLogger(MyWait.class.getName());

	static WebDriverWait wait;

	public static void implicitlyFor(WebDriver ldriver, int duration, String durationType) throws MyOwnException {

		log.info("INTEND TO PAUSE THE EXECUTION IMPLICITLY");
		try {
			if (ldriver != null) {
				if (duration > 0) {
					if (durationType.equalsIgnoreCase("SECONDS")) {
						ldriver.manage().timeouts().implicitlyWait(duration, TimeUnit.SECONDS);
					} else if (durationType.equalsIgnoreCase("MILLISECONDS")) {
						ldriver.manage().timeouts().implicitlyWait(duration, TimeUnit.MILLISECONDS);
					} else if (durationType.equalsIgnoreCase("MINUTES")) {
						ldriver.manage().timeouts().implicitlyWait(duration, TimeUnit.MINUTES);
					} else {
						log.error("WAIT DURATION SHOULD BE IN MILLISECONDS (OR) SECONDS (OR) MINUTES ");
						throwException("WAIT DURATION SHOULD BE IN MILLISECONDS (OR) SECONDS (OR) MINUTES " + "\n");
					}
				} else {
					log.error("WAIT DURATION CANNOT BE IN NEGATIVE");
					throwException("WAIT DURATION CANNOT BE IN NEGATIVE" + "\n");
				}
			} else {
				log.error("WEBDRIVER INSTANCE EEMS TO BE NULL");
				throwException("WEBDRIVER INSTANCE EEMS TO BE NULL" + "\n");
			}
		} catch (Exception e) {
			log.error("UNABLE TO MAKE THE BROWSER SESSION WAIT IMPLICITLY FOR (" + duration + ") (" + durationType
					+ ")\n" + e.getMessage());
			throwException("UNABLE TO MAKE THE BROWSER SESSION WAIT IMPLICITLY FOR (" + duration + ") (" + durationType
					+ ")\n" + e.getMessage() + "\n");
		}
		log.info("PAUSED THE EXECUTION IMPLICITLY FOR (" + duration + ") (" + durationType + ")");
	}

	public static void tillPageLoads(WebDriver ldriver, int duration, String durationType) throws MyOwnException {

		log.info("INTEND TO PAUSE THE EXECUTION TILL PAGE LOAD");
		try {
			if (ldriver != null) {
				if (duration > 0) {
					if (durationType.equalsIgnoreCase("SECONDS")) {
						ldriver.manage().timeouts().pageLoadTimeout(duration, TimeUnit.SECONDS);
					} else if (durationType.equalsIgnoreCase("MILLISECONDS")) {
						ldriver.manage().timeouts().pageLoadTimeout(duration, TimeUnit.MILLISECONDS);
					} else if (durationType.equalsIgnoreCase("MINUTES")) {
						ldriver.manage().timeouts().pageLoadTimeout(duration, TimeUnit.MINUTES);
					} else {
						log.error("WAIT DURATION SHOULD BE IN MILLISECONDS (OR) SECONDS (OR) MINUTES");
						throwException("WAIT DURATION SHOULD BE IN MILLISECONDS (OR) SECONDS (OR) MINUTES" + "\n");
					}
				} else {
					log.error("WAIT DURATION CANNOT BE IN NEGATIVE");
					throwException("WAIT DURATION CANNOT BE IN NEGATIVE" + "\n");
				}
			} else {
				log.error("WEBDRIVER INSTANCE EEMS TO BE NULL");
				throwException("WEBDRIVER INSTANCE EEMS TO BE NULL" + "\n");
			}
		} catch (Exception e) {
			log.error(
					"UNABLE TO WAIT FOR (" + duration + ") (" + durationType + ") TILL PAGE LOADS\n" + e.getMessage());
			throwException("UNABLE TO WAIT FOR (" + duration + ") (" + durationType + ") TILL PAGE LOADS\n"
					+ e.getMessage() + "\n");
		}
		log.info("PAUSED THE EXECUTION TILL PAGE LOAD FOR (" + duration + ") (" + durationType + ")");
	}

	public static void byDefaultFor(long duration) throws MyOwnException {

		log.info("INTEND TO PAUSE THE EXECUTION BY DEFAULT");
		try {
			if (duration > 0) {
				Thread.sleep(duration);
			} else {
				log.error("WAIT DURATION CANNOT BE IN NEGATIVE");
				throwException("WAIT DURATION CANNOT BE IN NEGATIVE" + "\n");
			}
		} catch (Exception e) {
			log.error("UNABLE TO WAIT BY DEFAULT FOR (" + duration + ") MILLISECONDS\n" + e.getMessage());
			throwException("UNABLE TO WAIT BY DEFAULT FOR (" + duration + ") MILLISECONDS\n" + e.getMessage() + "\n");
		}
		log.info("PAUSED THE EXECUTION BY DEFAULT FOR (" + duration + ") MILLISECONDS");
	}

	public static void until(WebDriver ldriver, String expectedCondition, int duration, WebElement element)
			throws MyOwnException {

		log.info("INTEND TO PAUSE THE EXECUTION EXPLICITLY");
		try {
			if (ldriver != null) {
				wait = new WebDriverWait(ldriver, duration);
				if (notEmpty(expectedCondition)) {
					if (duration > 0) {
						if (expectedCondition.equalsIgnoreCase("ELEMENT_CLICKABLE")) {
							wait.until(ExpectedConditions.elementToBeClickable(element));
						} else if (expectedCondition.equalsIgnoreCase("ELEMENT_SELECTED")) {
							wait.until(ExpectedConditions.elementToBeSelected(element));
						} else if (expectedCondition.equalsIgnoreCase("FRAME_AVAILABLE")) {
							wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(element));
						} else if (expectedCondition.equalsIgnoreCase("ELEMENT_INVISIBLE")) {
							wait.until(ExpectedConditions.invisibilityOf(element));
						} else if (expectedCondition.equalsIgnoreCase("ELEMENT_STALENESS")) {
							wait.until(ExpectedConditions.stalenessOf(element));
						} else if (expectedCondition.equalsIgnoreCase("ELEMENT_VISIBLE")) {
							wait.until(ExpectedConditions.visibilityOf(element));
						} else {
							log.error("EXPECTED CONDITION SEEMS TO BE INCORRECT");
							throwException("EXPECTED CONDITION SEEMS TO BE INCORRECT" + "\n");
						}
					} else {
						log.error("WAIT DURATION CANNOT BE IN NEGATIVE");
						throwException("WAIT DURATION CANNOT BE IN NEGATIVE" + "\n");
					}
				} else {
					log.error("EXPECTED CONDITION SEEMS TO BE EMPTY");
					throwException("EXPECTED CONDITION SEEMS TO BE EMPTY" + "\n");
				}
			} else {
				log.error("WEBDRIVER INSTANCE EEMS TO BE NULL");
				throwException("WEBDRIVER INSTANCE EEMS TO BE NULL" + "\n");
			}
		} catch (Exception e) {
			log.error("UNABLE TO WAIT FOR (" + duration + ") SECONDS UNTIL EXPECTED CONDITION(" + expectedCondition
					+ ") \n" + e.getMessage());
			throwException("UNABLE TO WAIT FOR (" + duration + ") SECONDS UNTIL EXPECTED CONDITION(" + expectedCondition
					+ ") \n" + e.getMessage() + "\n");
		}
		log.info("PAUSED THE EXECUTION EXPLICITLY UNTIL (" + expectedCondition + ") FOR (" + duration + ") SECONDS");
	}

	public static void until(WebDriver ldriver, String expectedCondition, int duration, String text)
			throws MyOwnException {

		log.info("INTEND TO PAUSE THE EXECUTION EXPLICITLY");
		try {
			if (ldriver != null) {
				wait = new WebDriverWait(ldriver, duration);
				if (notEmpty(expectedCondition)) {
					if (duration > 0) {
						if (expectedCondition.equalsIgnoreCase("URL_CONTAINS")) {
							wait.until(ExpectedConditions.urlContains(text));
						} else if (expectedCondition.equalsIgnoreCase("URL_BE")) {
							wait.until(ExpectedConditions.urlToBe(text));
						} else if (expectedCondition.equalsIgnoreCase("URL_MATCHES")) {
							wait.until(ExpectedConditions.urlMatches(text));
						} else if (expectedCondition.equalsIgnoreCase("TITLE_IS")) {
							wait.until(ExpectedConditions.titleIs(text));
						} else if (expectedCondition.equalsIgnoreCase("TITLE_CONTAINS")) {
							wait.until(ExpectedConditions.titleContains(text));
						} else {
							log.error("EXPECTED CONDITION SEEMS TO BE INCORRECT");
							throwException("EXPECTED CONDITION SEEMS TO BE INCORRECT" + "\n");
						}
					} else {
						log.error("WAIT DURATION CANNOT BE IN NEGATIVE");
						throwException("WAIT DURATION CANNOT BE IN NEGATIVE" + "\n");
					}
				} else {
					log.error("EXPECTED CONDITION SEEMS TO BE EMPTY");
					throwException("EXPECTED CONDITION SEEMS TO BE EMPTY" + "\n");
				}
			} else {
				log.error("WEBDRIVER INSTANCE EEMS TO BE NULL");
				throwException("WEBDRIVER INSTANCE EEMS TO BE NULL" + "\n");
			}
		} catch (Exception e) {
			log.error("UNABLE TO WAIT FOR (" + duration + ") SECONDS UNTIL EXPECTED CONDITION(" + expectedCondition
					+ ") \n" + e.getMessage());
			throwException("UNABLE TO WAIT FOR (" + duration + ") SECONDS UNTIL EXPECTED CONDITION(" + expectedCondition
					+ ") \n" + e.getMessage() + "\n");
		}
		log.info("PAUSED THE EXECUTION EXPLICITLY UNTIL (" + expectedCondition + ") FOR (" + duration + ") SECONDS");
	}

	public static void untilAlertIsPresent(WebDriver ldriver, int duration) throws MyOwnException {

		log.info("INTEND TO PAUSE THE EXECUTION UNTIL ALERT IS PRESENT");
		try {
			if (ldriver != null) {
				wait = new WebDriverWait(ldriver, duration);
				if (duration > 0) {
					wait.until(ExpectedConditions.alertIsPresent());
				} else {
					log.error("WAIT DURATION CANNOT BE IN NEGATIVE");
					throwException("WAIT DURATION CANNOT BE IN NEGATIVE" + "\n");
				}
			} else {
				log.error("WEBDRIVER INSTANCE SEEMS TO BE NULL");
				throwException("WEBDRIVER INSTANCE SEEMS TO BE NULL" + "\n");
			}
		} catch (Exception e) {
			log.error(
					"UNABLE TO WAIT FOR (" + duration + ") SECONDS UNTIL ALERT WINDOW IS PRESENT \n" + e.getMessage());
			throwException("UNABLE TO WAIT FOR (" + duration + ") SECONDS UNTIL ALERT WINDOW IS PRESENT \n"
					+ e.getMessage() + "\n");
		}
		log.info("PAUSED THE EXECUTION UNTIL ALERT IS PRESENT FOR (" + duration + ") SECONDS");
	}

}