package wrapper.classes.methods;



import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import com.angel.Utilities.MyOwnException;
import com.angel.accelerators.Base;

public class MyWebElement extends Base {

	private static final Logger log = LogManager.getLogger(MyWebElement.class.getName());
	public static  boolean isElementExistwithid(String id) {

		List<WebElement> ele = webDriver.findElements(By.id(id));
		if (ele.size() > 0) {
			return true;
		} else
			return false;
	}
	public static  boolean isElementExist(String linkText) {

		List<WebElement> ele = webDriver.findElements(By.linkText(linkText));
		if (ele.size() > 0) {
			return true;
		} else
			return false;
	}
	public static boolean isCloseButtonExist(String xpath) {
		List<WebElement> ele = webDriver.findElements(By.xpath(xpath));
		if (ele.size() > 0) {
			return true;
		} else
			return false;
	}

	public static boolean isAlertPresent(String className) {
		List<WebElement> ele = webDriver.findElements(By.className(className));
		if (ele.size() > 0) {
			return true;
		} else
			return false;
	}
	public static boolean isButtonExist(String xpath) {
		List<WebElement> ele = webDriver.findElements(By.xpath(xpath));
		if (ele.size() > 0) {
			return true;
		} else
			return false;
	}
	public static boolean isDropdownExist(String name) {
		List<WebElement> ele = webDriver.findElements(By.name(name));
		if (ele.size() > 0) {
			return true;
		} else
			return false;
	}
	public static void clickOn(WebElement element) throws MyOwnException {

		log.info("INTEND TO CLICK SPECIFIED WEBELEMENT");
		try {
			if (element != null) {
				if (isDisplayedOrNot(element) == true) {
					if (isEnabledOrNot(element) == true) {
						element.click();
					} else {
						log.error("WEBELEMENT IS NOT ENABLED ON THE WEBPAGE");
						throwException("WEBELEMENT IS NOT ENABLED ON THE WEBPAGE" + "\n");
					}
				} else {
					log.error("WEBELEMENT IS NOT DISPLAYED ON THE WEBPAGE");
					throwException("WEBELEMENT IS NOT DISPLAYED ON THE WEBPAGE" + "\n");
				}
			} else {
				log.error("WEBELEMENT INSTANCE SEEMS TO BE NULL");
				throwException("WEBELEMENT INSTANCE SEEMS TO BE NULL" + "\n");
			}
		} catch (Exception e) {
			log.error("UNABLE TO CLICK ON SPECIFIED WEBELEMENT(" + element + ")\n" + e.getMessage());
			throwException("UNABLE TO CLICK ON SPECIFIED WEBELEMENT(" + element + ")\n" + e.getMessage() + "\n");
		}
		log.info("SUCCESSFULLY CLICKED THE SPECIFIED WEBELEMENT(" + element + ")");
	}

	public static void clearOut(WebElement element) throws MyOwnException {

		log.info("INTEND TO CLEAR SPECIFIED WEBELEMENT");
		try {
			if (element != null) {
				if (isDisplayedOrNot(element) == true) {
					if (isEnabledOrNot(element) == true) {
						element.click();
						element.clear();
					} else {
						log.error("WEBELEMENT IS NOT ENABLED ON THE WEBPAGE");
						throwException("WEBELEMENT IS NOT ENABLED ON THE WEBPAGE" + "\n");
					}
				} else {
					log.error("WEBELEMENT IS NOT DISPLAYED ON THE WEBPAGE");
					throwException("WEBELEMENT IS NOT DISPLAYED ON THE WEBPAGE" + "\n");
				}
			} else {
				log.error("WEBELEMENT INSTANCE SEEMS TO BE NULL");
				throwException("WEBELEMENT INSTANCE SEEMS TO BE NULL" + "\n");
			}
		} catch (Exception e) {
			log.error("UNABLE TO CLEAR SPECIFIED WEBELEMENT(" + element + ")\n" + e.getMessage());
			throwException("UNABLE TO CLEAR SPECIFIED WEBELEMENT(" + element + ")\n" + e.getMessage() + "\n");
		}
		log.info("SUCCESSFULLY CLEARED THE SPECIFIED WEBELEMENT(" + element + ")");
	}

	public static String getTextFrom(WebElement element) throws MyOwnException {

		log.info("INTEND TO GET TEXT FROM SPECIFIED WEBELEMENT");
		String text = "";
		try {
			if (element != null) {
				if (isDisplayedOrNot(element) == true) {
					if (isEnabledOrNot(element) == true) {
						text = element.getText();
					} else {
						log.error("WEBELEMENT IS NOT ENABLED ON THE WEBPAGE");
						throwException("WEBELEMENT IS NOT ENABLED ON THE WEBPAGE" + "\n");
					}
				} else {
					log.error("WEBELEMENT IS NOT DISPLAYED ON THE WEBPAGE");
					throwException("WEBELEMENT IS NOT DISPLAYED ON THE WEBPAGE" + "\n");
				}
			} else {
				log.error("WEBELEMENT INSTANCE SEEMS TO BE NULL");
				throwException("WEBELEMENT INSTANCE SEEMS TO BE NULL" + "\n");
			}
		} catch (Exception e) {
			log.error("UNABLE TO GET TEXT FROM SPECIFIED WEBELEMENT(" + element + ")\n" + e.getMessage());
			throwException("UNABLE TO GET TEXT FROM SPECIFIED WEBELEMENT(" + element + ")\n" + e.getMessage() + "\n");
		}
		log.info("SUCCESSFULLY GOT TEXT(" + text + ") FROM SPECIFIED WEBELEMENT(" + element + ")");
		return text;
	}

	public static void enterText(WebElement element, String textToType) throws MyOwnException {

		log.info("INTEND TO ENTER TEXT INSIDE SPECIFIED WEBELEMENT");
		try {
			if (element != null) {
				if (isDisplayedOrNot(element) == true) {
					if (isEnabledOrNot(element) == true) {
						if (notEmpty(textToType)) {
							element.click();
							element.sendKeys(textToType);
						} else {
							log.error("TEXT TO BE ENTERED SEEMS TO BE EMPTY");
							throwException("TEXT TO BE ENTERED SEEMS TO BE EMPTY" + "\n");
						}
					} else {
						log.error("WEBELEMENT IS NOT ENABLED ON THE WEBPAGE");
						throwException("WEBELEMENT IS NOT ENABLED ON THE WEBPAGE" + "\n");
					}
				} else {
					log.error("WEBELEMENT IS NOT DISPLAYED ON THE WEBPAGE");
					throwException("WEBELEMENT IS NOT DISPLAYED ON THE WEBPAGE" + "\n");
				}
			} else {
				log.error("WEBELEMENT INSTANCE SEEMS TO BE NULL");
				throwException("WEBELEMENT INSTANCE SEEMS TO BE NULL" + "\n");
			}
		} catch (Exception e) {
			log.error("UNABLE TO ENTER THE TEXT(" + textToType + ") INSIDE SPECIFIED WEBELEMENT(" + element + ")\n"
					+ e.getMessage());
			throwException("UNABLE TO ENTER THE TEXT(" + textToType + ") INSIDE SPECIFIED WEBELEMENT(" + element + ")\n"
					+ e.getMessage() + "\n");
		}
		log.info("SUCCESSFULLY ENTERED THE TEXT(" + textToType + ") INSIDE SPECIFIED WEBELEMENT(" + element + ")");
	}

	public static void mouseOverAndEnterText(String textToType, WebElement element, WebDriver ldriver)
			throws MyOwnException {

		log.info("INTEND TO MOUSEOVER AND ENTER TEXT INSIDE SPECIFIED WEBELEMENT");
		try {
			if (ldriver != null) {
				action = new Actions(ldriver);
				if (element != null) {
					if (isDisplayedOrNot(element) == true) {
						if (isEnabledOrNot(element) == true) {
							action.moveToElement(element).click().sendKeys(textToType).build().perform();
						} else {
							log.error("WEBELEMENT IS NOT ENABLED ON THE WEBPAGE");
							throwException("WEBELEMENT IS NOT ENABLED ON THE WEBPAGE" + "\n");
						}
					} else {
						log.error("WEBELEMENT IS NOT DISPLAYED ON THE WEBPAGE");
						throwException("WEBELEMENT IS NOT DISPLAYED ON THE WEBPAGE" + "\n");
					}
				} else {
					log.error("WEBELEMENT INSTANCE SEEMS TO BE NULL");
					throwException("WEBELEMENT INSTANCE SEEMS TO BE NULL" + "\n");
				}
			} else {
				log.error("WEBDRIVER INSTANCE SEEMS TO BE NULL");
				throwException("WEBDRIVER INSTANCE SEEMS TO BE NULL" + "\n");
			}
		} catch (Exception e) {
			log.error("UNABLE TO MOUSE OVER AND ENTER TEXT(" + textToType + ") INSIDE SPECIFIED WEBELEMENT(" + element
					+ ")\n" + e.getMessage());
			throwException("UNABLE TO MOUSE OVER AND ENTER TEXT(" + textToType + ") INSIDE SPECIFIED WEBELEMENT("
					+ element + ")\n" + e.getMessage() + "\n");
		}
		log.info("SUCCESSFULLY MOUSE OVERED AND ENTERED TEXT(" + textToType + ") INSIDE SPECIFIED WEBELEMENT(" + element
				+ ")");
	}

	public static WebElement locateElementBy(String findBy, String usingValue, WebElement parentElement)
			throws MyOwnException {

		log.info("INTEND TO FIND CHILD WEBELEMENT FROM PARENT IN CURRENT BROWSER SESSION");
		WebElement childElement = null;
		try {
			if (parentElement != null) {
				if (isDisplayedOrNot(parentElement) == true) {
					if (notEmpty(findBy)) {
						if (notEmpty(usingValue)) {
							if (findBy.equalsIgnoreCase("ID")) {
								childElement = parentElement.findElement(By.id(usingValue));
							} else if (findBy.equalsIgnoreCase("NAME")) {
								childElement = parentElement.findElement(By.name(usingValue));
							} else if (findBy.equalsIgnoreCase("CLASS NAME")) {
								childElement = parentElement.findElement(By.className(usingValue));
							} else if (findBy.equalsIgnoreCase("LINK TEXT")) {
								childElement = parentElement.findElement(By.linkText(usingValue));
							} else if (findBy.equalsIgnoreCase("PARTIAL LINK TEXT")) {
								childElement = parentElement.findElement(By.partialLinkText(usingValue));
							} else if (findBy.equalsIgnoreCase("TAG NAME")) {
								childElement = parentElement.findElement(By.tagName(usingValue));
							} else if (findBy.equalsIgnoreCase("XPATH")) {
								childElement = parentElement.findElement(By.xpath(usingValue));
							} else if (findBy.equalsIgnoreCase("CSS")) {
								childElement = parentElement.findElement(By.cssSelector(usingValue));
							} else {
								log.error("LOCATOR TYPE(" + findBy + ") SEEMS TO BE INCORRECT");
								throwException("LOCATOR TYPE(" + findBy + ") SEEMS TO BE INCORRECT" + "\n");
							}
						} else {
							log.error("LOCATOR VALUE SEEMS TO BE EMPTY");
							throwException("LOCATOR VALUE SEEMS TO BE EMPTY" + "\n");
						}
					} else {
						log.error("LOCATOR TYPE SEEMS TO BE EMPTY");
						throwException("LOCATOR TYPE SEEMS TO BE EMPTY" + "\n");
					}
				} else {
					log.error("PARENT WEBELEMENT IS NOT DISPLAYED ON THE WEBPAGE");
					throwException("PARENT WEBELEMENT IS NOT DISPLAYED ON THE WEBPAGE" + "\n");
				}
			} else {
				log.error("WEBELEMENT INSTANCE SEEMS TO BE NULL");
				throwException("WEBELEMENT INSTANCE SEEMS TO BE NULL" + "\n");
			}
		} catch (Exception e) {
			log.error("UNABLE TO LOCATE CHILD WEBELEMENT USING ATTRIBUTE(" + findBy + ") AND VALUE(" + usingValue
					+ ") FROM THE SPECIFIED PARENT WEBELEMENT(" + parentElement + ")\n" + e.getMessage());
			throwException("UNABLE TO LOCATE CHILD WEBELEMENT USING ATTRIBUTE(" + findBy + ") AND VALUE(" + usingValue
					+ ") FROM THE SPECIFIED PARENT WEBELEMENT(" + parentElement + ")\n" + e.getMessage() + "\n");
		}
		log.info("SUCCESSFULLY LOCATED CHILD WEBELEMENT USING ATTRIBUTE(" + findBy + ") AND VALUE(" + usingValue
				+ ") FROM THE SPECIFIED PARENT WEBELEMENT(" + parentElement + ")");
		return childElement;
	}

	public static List<WebElement> locateElementsBy(String findBy, String usingValue, WebElement parentElement)
			throws MyOwnException {

		log.info("INTEND TO FIND CHILD WEBELEMENTS FROM PARENT IN CURRENT BROWSER SESSION");
		List<WebElement> childElements = null;
		try {
			if (parentElement != null) {
				if (isDisplayedOrNot(parentElement) == true) {
					if (notEmpty(findBy)) {
						if (notEmpty(usingValue)) {
							if (findBy.equalsIgnoreCase("ID")) {
								childElements = parentElement.findElements(By.id(usingValue));
							} else if (findBy.equalsIgnoreCase("NAME")) {
								childElements = parentElement.findElements(By.name(usingValue));
							} else if (findBy.equalsIgnoreCase("CLASS NAME")) {
								childElements = parentElement.findElements(By.className(usingValue));
							} else if (findBy.equalsIgnoreCase("LINK TEXT")) {
								childElements = parentElement.findElements(By.linkText(usingValue));
							} else if (findBy.equalsIgnoreCase("PARTIAL LINK TEXT")) {
								childElements = parentElement.findElements(By.partialLinkText(usingValue));
							} else if (findBy.equalsIgnoreCase("TAG NAME")) {
								childElements = parentElement.findElements(By.tagName(usingValue));
							} else if (findBy.equalsIgnoreCase("XPATH")) {
								childElements = parentElement.findElements(By.xpath(usingValue));
							} else if (findBy.equalsIgnoreCase("CSS")) {
								childElements = parentElement.findElements(By.cssSelector(usingValue));
							} else {
								log.error("LOCATOR TYPE(" + findBy + ") SEEMS TO BE INCORRECT");
								throwException("LOCATOR TYPE(" + findBy + ") SEEMS TO BE INCORRECT" + "\n");
							}
						} else {
							log.error("LOCATOR VALUE SEEMS TO BE EMPTY");
							throwException("LOCATOR VALUE SEEMS TO BE EMPTY" + "\n");
						}
					} else {
						log.error("LOCATOR TYPE SEEMS TO BE EMPTY");
						throwException("LOCATOR TYPE SEEMS TO BE EMPTY" + "\n");
					}
				} else {
					log.error("PARENT WEBELEMENT IS NOT DISPLAYED ON THE WEBPAGE");
					throwException("PARENT WEBELEMENT IS NOT DISPLAYED ON THE WEBPAGE" + "\n");
				}
			} else {
				log.error("WEBELEMENT INSTANCE SEEMS TO BE NULL");
				throwException("WEBELEMENT INSTANCE SEEMS TO BE NULL" + "\n");
			}
		} catch (Exception e) {
			log.error("UNABLE TO LOCATE LIST OF CHILD WEBELEMENTS USING ATTRIBUTE(" + findBy + ") AND VALUE("
					+ usingValue + ") FROM THE SPECIFIED PARENT WEBELEMENT(" + parentElement + ")\n" + e.getMessage());
			throwException("UNABLE TO LOCATE LIST OF CHILD WEBELEMENTS USING ATTRIBUTE(" + findBy + ") AND VALUE("
					+ usingValue + ") FROM THE SPECIFIED PARENT WEBELEMENT(" + parentElement + ")\n" + e.getMessage()
					+ "\n");
		}
		log.info("SUCCESSFULLY LOCATED LIST OF CHILD WEBELEMENTS USING ATTRIBUTE(" + findBy + ") AND VALUE("
				+ usingValue + ") FROM THE SPECIFIED PARENT WEBELEMENT(" + parentElement + ")");
		return childElements;
	}

	public static Boolean isDisplayedOrNot(WebElement element) throws MyOwnException {

		log.info("INTEND TO VERIFY WHETHER SPECIFIED WEBELEMENT IS DISPLAYED OR NOT");
		try {
			if (element != null) {
				if (element.isDisplayed()) {
					log.info("WEBELEMENT(" + element + ") IS DISPLAYED");
					result = true;
				} else {
					log.error("WEBELEMENT(" + element + ") IS NOT DISPLAYED");
					result = false;
				}
			} else {
				log.error("WEBELEMENT INSTANCE SEEMS TO BE NULL");
				throwException("WEBELEMENT INSTANCE SEEMS TO BE NULL" + "\n");
			}
		} catch (Exception e) {
			log.error("UNABLE TO CHECK WHETHER THE SPECIFIED WEBELEMENT(" + element + ") IS DISPLAYED OR NOT\n"
					+ e.getMessage());
			throwException("UNABLE TO CHECK WHETHER THE SPECIFIED WEBELEMENT(" + element + ") IS DISPLAYED OR NOT\n"
					+ e.getMessage() + "\n");
		}
		log.info("SUCCESSFULLY VERIFIED WETHER THE SPECIFIED WEBELEMENT(" + element + ") IS DISPLAYED OR NOT");
		return result;
	}

	public static Boolean isEnabledOrNot(WebElement element) throws MyOwnException {

		log.info("INTEND TO VERIFY WHETHER SPECIFIED WEBELEMENT IS ENABLED OR NOT");
		try {
			if (element != null) {
				if (element.isEnabled()) {
					log.info("WEBELEMENT(" + element + ") IS ENABLED");
					result = true;
				} else {
					log.error("WEBELEMENT(" + element + ") IS NOT ENABLED");
					result = false;
				}
			} else {
				log.error("WEBELEMENT INSTANCE SEEMS TO BE NULL");
				throwException("WEBELEMENT INSTANCE SEEMS TO BE NULL" + "\n");
			}
		} catch (Exception e) {
			log.error("UNABLE TO CHECK WHETHER THE SPECIFIED WEBELEMENT(" + element + ") IS ENABLED OR NOT\n"
					+ e.getMessage());
			throwException("UNABLE TO CHECK WHETHER THE SPECIFIED WEBELEMENT(" + element + ") IS ENABLED OR NOT\n"
					+ e.getMessage() + "\n");
		}
		log.info("SUCCESSFULLY VERIFIED WETHER THE SPECIFIED WEBELEMENT(" + element + ") IS ENABLED OR NOT");
		return result;
	}

	public static Boolean isSelectedOrNot(WebElement element) throws MyOwnException {

		log.info("INTEND TO VERIFY WHETHER SPECIFIED WEBELEMENT IS SELECTED OR NOT");
		try {
			if (element != null) {
				if (element.isSelected()) {
					log.info("WEBELEMENT(" + element + ") IS SELECTED");
					result = true;
				} else {
					log.error("WEBELEMENT(" + element + ") IS NOT SELECTED");
					result = false;
				}
			} else {
				log.error("WEBELEMENT INSTANCE SEEMS TO BE NULL");
				throwException("WEBELEMENT INSTANCE SEEMS TO BE NULL" + "\n");
			}
		} catch (Exception e) {
			log.error("UNABLE TO CHECK WHETHER THE SPECIFIED WEBELEMENT(" + element + ") IS SELECTED OR NOT\n"
					+ e.getMessage());
			throwException("UNABLE TO CHECK WHETHER THE SPECIFIED WEBELEMENT(" + element + ") IS SELECTED OR NOT\n"
					+ e.getMessage() + "\n");
		}
		log.info("SUCCESSFULLY VERIFIED WETHER THE SPECIFIED WEBELEMENT(" + element + ") IS SELECTED OR NOT");
		return result;
	}

	public static String getValueOfLocatorType(String locatorType, WebElement element) throws MyOwnException {

		log.info("INTEND TO GET THE VALUE OF THE ATTRIBUTE FROM SPECIFIED WEBELEMENT");
		String attributeValue = "";
		try {
			if (element != null) {
				if (isDisplayedOrNot(element) == true) {
					if (isEnabledOrNot(element) == true) {
						if (notEmpty(locatorType)) {
							attributeValue = element.getAttribute(locatorType);
						} else {
							log.error("LOCATOR TYPE SEEMS TO BE EMPTY");
							throwException("LOCATOR TYPE SEEMS TO BE EMPTY" + "\n");
						}
					} else {
						log.error("WEBELEMENT IS NOT ENABLED ON THE WEBPAGE");
						throwException("WEBELEMENT IS NOT ENABLED ON THE WEBPAGE" + "\n");
					}
				} else {
					log.error("WEBELEMENT IS NOT DISPLAYED ON THE WEBPAGE");
					throwException("WEBELEMENT IS NOT DISPLAYED ON THE WEBPAGE" + "\n");
				}
			} else {
				log.error("WEBELEMENT INSTANCE SEEMS TO BE NULL");
				throwException("WEBELEMENT INSTANCE SEEMS TO BE NULL" + "\n");
			}
		} catch (Exception e) {
			log.error("UNABLE TO GET THE VALUE OF ATTRIBUTE " + locatorType + " FROM SPECIFIED WEBELEMENT\n"
					+ e.getMessage());
			throwException("UNABLE TO GET THE VALUE OF ATTRIBUTE " + locatorType + " FROM SPECIFIED WEBELEMENT\n"
					+ e.getMessage() + "\n");
		}
		log.info("SUCCESSFULLY GOT THE VALUE OF ATTRIBUTE( " + locatorType + ") FROM SPECIFIED WEBELEMENT");
		return attributeValue;
	}

	public static void submitIt(WebElement element) throws MyOwnException {

		log.info("INTEND TO SUBMIT SPECIFIED WEBELEMENT");
		try {
			if (element != null) {
				if (isDisplayedOrNot(element) == true) {
					if (isEnabledOrNot(element) == true) {
						element.submit();
					} else {
						log.error("WEBELEMENT IS NOT ENABLED ON THE WEBPAGE");
						throwException("WEBELEMENT IS NOT ENABLED ON THE WEBPAGE" + "\n");
					}
				} else {
					log.error("WEBELEMENT IS NOT DISPLAYED ON THE WEBPAGE");
					throwException("WEBELEMENT IS NOT DISPLAYED ON THE WEBPAGE" + "\n");
				}
			} else {
				log.error("WEBELEMENT INSTANCE SEEMS TO BE NULL");
				throwException("WEBELEMENT INSTANCE SEEMS TO BE NULL" + "\n");
			}
		} catch (Exception e) {
			log.error("UNABLE TO SUBMIT SPECIFIED WEBELEMENT(" + element + ")\n" + e.getMessage());
			throwException("UNABLE TO SUBMIT SPECIFIED WEBELEMENT(" + element + ")\n" + e.getMessage() + "\n");
		}
		log.info("SUCCESSFULLY SUBMITTED SPECIFIED WEBELEMENT(" + element + ")");
	}

	public static void setDropDownBy(String setMethodType, String value, WebElement dropDownElement)
			throws MyOwnException {

		log.info("INTEND TO SELECT SPECIFIED DROP DOWN VALUE IN A WEBELEMENT");
		Select action;
		try {
			if (dropDownElement != null) {
				action = new Select(dropDownElement);
				if (isDisplayedOrNot(dropDownElement) == true) {
					if (isEnabledOrNot(dropDownElement) == true) {
						if (notEmpty(setMethodType)) {
							if (notEmpty(value)) {
								if (setMethodType.equalsIgnoreCase("VISIBLE TEXT")) {
									action.selectByVisibleText(value);
								} else if (setMethodType.equalsIgnoreCase("VALUE")) {
									action.selectByValue(value);
								} else if (setMethodType.equalsIgnoreCase("INDEX")) {
									int index = Integer.valueOf(value);
									action.selectByIndex(index);
								} else {
									log.error("SELECT BY METHOD TYPE SEEMS TO BE INCORRECT");
									throwException("SELECT BY METHOD TYPE SEEMS TO BE INCORRECT" + "\n");
								}
							} else {
								log.error("VALUE TO BE SELECTED SEEMS TO BE EMPTY");
								throwException("VALUE TO BE SELECTED SEEMS TO BE EMPTY" + "\n");
							}
						} else {
							log.error("SELECT BY METHOD TYPE SEEMS TO BE EMPTY");
							throwException("SELECT BY METHOD TYPE SEEMS TO BE EMPTY" + "\n");
						}
					} else {
						log.error("WEBELEMENT IS NOT ENABLED ON THE WEBPAGE");
						throwException("WEBELEMENT IS NOT ENABLED ON THE WEBPAGE" + "\n");
					}
				} else {
					log.error("WEBELEMENT IS NOT DISPLAYED ON THE WEBPAGE");
					throwException("WEBELEMENT IS NOT DISPLAYED ON THE WEBPAGE" + "\n");
				}
			} else {
				log.error("WEBELEMENT INSTANCE SEEMS TO BE NULL");
				throwException("WEBELEMENT INSTANCE SEEMS TO BE NULL" + "\n");
			}
		} catch (Exception e) {
			log.error("UNABLE TO SET SPECIFIED DROP DOWN VALUE(" + value + ") USING : " + setMethodType
					+ " METHOD TYPE\n" + e.getMessage());
			throwException("UNABLE TO SET SPECIFIED DROP DOWN VALUE(" + value + ") USING : " + setMethodType
					+ " METHOD TYPE\n" + e.getMessage() + "\n");
		}
		log.info("SUCCESSFULLY SELECTED SPECIFIED DROP DOWN VALUE(" + value + ") USING : " + setMethodType
				+ " METHOD TYPE");
	}

	public static void mouseOverAndPerform(String actionType, WebElement element, WebDriver ldriver)
			throws MyOwnException {

		log.info("INTEND TO MOUSE OVER AND PERFORM SPECIFIED ACTION ON A WEBELEMENT");
		try {
			if (ldriver != null) {
				action = new Actions(ldriver);
				if (isDisplayedOrNot(element) == true) {
					if (isEnabledOrNot(element) == true) {
						if (actionType.equalsIgnoreCase("CLICK")) {
							action.moveToElement(element).click().perform();
						} else if (actionType.equalsIgnoreCase("RIGHT CLICK")) {
							action.moveToElement(element).contextClick().perform();
						} else if (actionType.equalsIgnoreCase("CLICK AND HOLD")) {
							action.moveToElement(element).clickAndHold().perform();
						} else if (actionType.equalsIgnoreCase("DOUBLE CLICK")) {
							action.moveToElement(element).doubleClick().perform();
						} else if (actionType.equalsIgnoreCase("RELEASE")) {
							action.moveToElement(element).release().perform();
						} else {
							log.error("ACTION METHOD TYPE SEEMS TO BE INCORRECT");
							throwException("ACTION METHOD TYPE SEEMS TO BE INCORRECT" + "\n");
						}
					} else {
						log.error("WEBELEMENT IS NOT ENABLED ON THE WEBPAGE");
						throwException("WEBELEMENT IS NOT ENABLED ON THE WEBPAGE" + "\n");
					}
				} else {
					log.error("WEBELEMENT IS NOT DISPLAYED ON THE WEBPAGE");
					throwException("WEBELEMENT IS NOT DISPLAYED ON THE WEBPAGE" + "\n");
				}
			} else {
				log.error("WEBDRIVER INSTANCE SEEMS TO BE NULL");
				throwException("WEBDRIVER INSTANCE SEEMS TO BE NULL" + "\n");
			}
		} catch (Exception e) {
			log.error("UNABLE TO MOUSE OVER SPECIFIED WEBELEMENT(" + element + ") AND PERFROM : " + actionType
					+ " ACTION\n" + e.getMessage());
			throwException("UNABLE TO MOUSE OVER SPECIFIED WEBELEMENT(" + element + ") AND PERFROM : " + actionType
					+ " ACTION\n" + e.getMessage() + "\n");
		}
		log.info("SUCCESSFULLY MOUSE OVERED SPECIFIED WEBELEMENT(" + element + ") AND PERFROMED : " + actionType
				+ " ACTION");
	}

	public static void mouseOverAndPerform(String actionType, WebElement sourceElement, WebElement targetElement,
			WebDriver ldriver) throws MyOwnException {

		log.info("INTEND TO MOUSE OVER SOURCE WEBELEMENT AND PERFORM SPECIFIED ACTION ON TARGET WEBELEMENT");
		try {
			if (ldriver != null) {
				action = new Actions(ldriver);
				if (isDisplayedOrNot(sourceElement) == true) {
					if (isEnabledOrNot(sourceElement) == true) {
						if (actionType.equalsIgnoreCase("CLICK")) {
							action.moveToElement(sourceElement).click(targetElement).build().perform();
						} else if (actionType.equalsIgnoreCase("RIGHT CLICK")) {
							action.moveToElement(sourceElement).contextClick(targetElement).build().perform();
						} else if (actionType.equalsIgnoreCase("MOUSE OVER")) {
							action.moveToElement(sourceElement).moveToElement(targetElement).build().perform();
						} else if (actionType.equalsIgnoreCase("CLICK AND HOLD")) {
							action.moveToElement(sourceElement).clickAndHold(targetElement).build().perform();
						} else if (actionType.equalsIgnoreCase("DOUBLE CLICK")) {
							action.moveToElement(sourceElement).doubleClick(targetElement).build().perform();
						} else if (actionType.equalsIgnoreCase("DRAG AND DROP")) {
							action.dragAndDrop(sourceElement, targetElement).build().perform();
						} else if (actionType.equalsIgnoreCase("RELEASE")) {
							action.moveToElement(sourceElement).release(targetElement).build().perform();
						} else {
							log.error("ACTION METHOD TYPE SEEMS TO BE INCORRECT");
							throwException("ACTION METHOD TYPE SEEMS TO BE INCORRECT" + "\n");
						}
					} else {
						log.error("WEBELEMENT IS NOT ENABLED ON THE WEBPAGE");
						throwException("WEBELEMENT IS NOT ENABLED ON THE WEBPAGE" + "\n");
					}
				} else {
					log.error("WEBELEMENT IS NOT DISPLAYED ON THE WEBPAGE");
					throwException("WEBELEMENT IS NOT DISPLAYED ON THE WEBPAGE" + "\n");
				}
			} else {
				log.error("WEBDRIVER INSTANCE SEEMS TO BE NULL");
				throwException("WEBDRIVER INSTANCE SEEMS TO BE NULL" + "\n");
			}
		} catch (Exception e) {
			log.error("UNABLE TO MOUSE OVER SOURCE WEBELEMENT(" + sourceElement + ") AND PERFROMED : " + actionType
					+ " ACTION ON TARGET WEBELEMENT(" + targetElement + ")\n" + e.getMessage());
			throwException("UNABLE TO MOUSE OVER SOURCE WEBELEMENT(" + sourceElement + ") AND PERFROMED : " + actionType
					+ " ACTION ON TARGET WEBELEMENT(" + targetElement + ")\n" + e.getMessage() + "\n");
		}
		log.info("SUCCESSFULLY MOUSE OVERED SOURCE WEBELEMENT(" + sourceElement + ") AND PERFROMED : " + actionType
				+ " ACTION ON TARGET WEBELEMENT(" + targetElement + ")");
	}

	public static void selectradioButtonOrCheckBox(String checkOrUncheck, WebElement element) throws MyOwnException {

		log.info("INTEND TO (" + checkOrUncheck + ") THE SPECIFIED WEBELEMENT");
		try {
			if (checkOrUncheck.equalsIgnoreCase("check")) {
				if (!isSelectedOrNot(element)) {
					clickOn(element);
				}
			} else if (checkOrUncheck.equalsIgnoreCase("uncheck")) {
				if (isSelectedOrNot(element)) {
					clickOn(element);
				}
			}
		} catch (NoSuchElementException nseexp) {
			log.error("UNABLE TO (" + checkOrUncheck + ") THE WEBELEMENT(" + element + ")\n" + nseexp.getMessage());
			throwException("UNABLE TO (" + checkOrUncheck + ") THE WEBELEMENT(" + element
					+ ") FROM THE METHOD selectradioButtonOrCheckBox/n" + nseexp.getMessage() + "/n");
		} catch (StaleElementReferenceException serexp) {
			log.error("UNABLE TO (" + checkOrUncheck + ") THE WEBELEMENT(" + element + ")\n" + serexp.getMessage());
			throwException("UNABLE TO (" + checkOrUncheck + ") THE WEBELEMENT(" + element
					+ ") FROM THE METHOD selectradioButtonOrCheckBox/n" + serexp.getMessage() + "/n");
		} catch (Exception e) {
			log.error("UNABLE TO (" + checkOrUncheck + ") THE WEBELEMENT(" + element + ")\n" + e.getMessage());
			throwException("UNABLE TO (" + checkOrUncheck + ") THE WEBELEMENT(" + element
					+ ") FROM THE METHOD selectradioButtonOrCheckBox/n" + e.getMessage() + "/n");
		}
		log.info("SUCCESSFULLY (" + checkOrUncheck + ") THE WEBELEMENT(" + element + ")");
	}

}