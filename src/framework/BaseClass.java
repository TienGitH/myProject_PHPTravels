package framework;

import java.util.List;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.relevantcodes.extentreports.LogStatus;

/***
 * 
 * @author Tien Nguyen
 *
 */
public class BaseClass extends WebDriverFactory {
	public static Logger logger = LogManager.getLogger(BaseClass.class.getName());
	public WebDriver driver;
	int timeout = 10;

	public BaseClass(WebDriver driver) {
		this.driver = driver;
	}

	/***
	 * Check if a field exists on the UI?
	 * 
	 * @param locator
	 */
	public boolean locatorExist(By locator, String locatorName) {
		try {
			WebDriverWait wait = new WebDriverWait(driver, timeout);
			wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
			logger.info(locatorName + " exists!");
			logReport.log(LogStatus.PASS, locatorName + " exists!");
			return true;
		} catch (Exception e) {
			logger.error(locatorName + " is invisibility. Error: " + e);
			logReport.log(LogStatus.FAIL, locatorName + " does not exist!");
			return false;
		}
	}

	/***
	 * Return assert result if a field is visible and clickable
	 * 
	 * @param locator
	 */
	public boolean assertResultLocatorExist(By locator, String locatorName) {
		try {
			Assert.assertEquals(locatorExist(locator, locatorName), true);
			return true;
		} catch (AssertionError e) {
			logger.error(locatorName + " does not exist. Due to: " + e);
			return false;
		}
	}

	/***
	 * check if a field is clickable?
	 * 
	 * @param locator
	 */
	public boolean locatorClickable(By locator, String locatorName) {
		try {
			WebDriverWait wait = new WebDriverWait(driver, timeout);
			wait.until(ExpectedConditions.elementToBeClickable(locator));
			logger.info(locatorName + " is able to click!");
			logReport.log(LogStatus.PASS, locatorName + " is able to click!");
			return true;
		} catch (Exception e) {
			logger.error(locatorName + " is unable to click. Error: " + e);
			logReport.log(LogStatus.FAIL, locatorName + " is unable to click!");
			return false;
		}
	}

	/***
	 * Check if a field is clicked?
	 * 
	 * @param locator
	 */
	public boolean checkAndClickLocator(By locator, String locatorName) {
		if (locatorExist(locator, locatorName) == true && locatorClickable(locator, locatorName) == true) {
			try {
				driver.findElement(locator).click();
				logger.info(locatorName + " is clicked successfully!");
				return true;
			} catch (Exception e) {
				logger.error(locatorName + " is not clicked. Error: " + e);
				return false;
			}
		} else {
			return false;
		}
	}

	/***
	 * Assert a field is visible and clickable
	 * 
	 * @param locator
	 */
	public void assertCheckAndClickLocator(By locator, String locatorName) {
		try {
			Assert.assertEquals(checkAndClickLocator(locator, locatorName), true);
		} catch (AssertionError e) {
			logger.error(locatorName + " is failed cicking. Due to: " + e);
		}
	}

	/***
	 * Return assert result if a field is visible and clickable
	 * 
	 * @param locator
	 */
	public boolean assertResultCheckAndClickLocator(By locator, String locatorName) {
		try {
			Assert.assertEquals(checkAndClickLocator(locator, locatorName), true);
			return true;
		} catch (AssertionError e) {
			logger.error(locatorName + " is failed cicking. Due to: " + e);
			return false;
		}
	}

	/***
	 * Select a value in a list box
	 * 
	 * @param list_WebElement
	 */
	@SuppressWarnings("null")
	public boolean selectValueInListBox(List<WebElement> listWebElement, String itemName) {
		boolean result = false;
		List<WebElement> options = listWebElement;
		if (options == null && options.size() > 0) {
			for (WebElement e : options) {
				try {
					Actions actions = new Actions(driver);
					actions.moveToElement(e);
					actions.perform();
					if (e.getText().equalsIgnoreCase(itemName)) {
						e.click();
						logReport.log(LogStatus.PASS, itemName + " is selected!");
						break;
					}
					result = true;
				} catch (Exception ex) {
					logger.error("Can't find " + itemName + "in the list. Problem: " + ex);
					logReport.log(LogStatus.FAIL, itemName + " is not selected!");
					result = false;
				}
			}
		} else {
			result = false;
		}
		return result;
	}

	/***
	 * Return assert result if a specific value can be selected in a list
	 * 
	 * @param locator
	 */
	public void assertResultSelectValueInListBox(List<WebElement> listWebElement, String itemName) {
		try {
			Assert.assertEquals(selectValueInListBox(listWebElement, itemName), true);
		} catch (AssertionError e) {
			logger.error("Hotel Tab is failed cicking. Due to: " + e);
			logReport.log(LogStatus.FAIL, "Hotel Tab is failed cicking");
		}
	}

	/***
	 * get text from a Locator
	 * 
	 * @param locator
	 */
	public String getLocatorText(By locator, String locatorName) {
		try {
			String locatorText = driver.findElement(locator).getText();
			logger.info("Text from " + locatorName + " is: " + locatorText);
			logReport.log(LogStatus.PASS,
					"Able to get the text: " + locatorText + " from " + locatorName + " successfully!");
			return locatorText;
		} catch (Exception e) {
			logger.error("Unable to get text from " + locatorName + " .Due to: " + e);
			logReport.log(LogStatus.FAIL, "Unable to get the text from " + locatorName);
			return "";
		}
	}

	/***
	 * Click on a field if it is visible and clickable
	 * 
	 * @param locator
	 */
	public boolean checkAndSendTextLocator(By locator, String locatorName, String text) {
		if (locatorExist(locator, locatorName) == true && locatorClickable(locator, locatorName) == true) {
			driver.findElement(locator).clear();
			driver.findElement(locator).sendKeys(text);
			logger.info("Set the text '" + text + "' into " + locatorName + " successfully!");
			logReport.log(LogStatus.PASS, "Set the text '" + text + "' into " + locatorName + " successfully!");
			return true;
		} else {
			logger.error("Cannot input '" + text + "' into " + locatorName);
			logReport.log(LogStatus.FAIL, "Cannot input '" + text + "' into " + locatorName);
			return false;
		}
	}

	/***
	 * Assert if a locator is able to be sent text
	 * 
	 * @param locator
	 */
	public void assertCheckAndSendTextLocator(By locator, String locatorName, String date) {
		try {
			Assert.assertEquals(checkAndSendTextLocator(locator, locatorName, date), true);
		} catch (AssertionError e) {
			System.out.println("Unable to send text to " + locatorName + ". Due to: " + e);
			// test.log(LogStatus.FAIL, "Hotel Tab is failed cicking. Due to: " + e);
		}
	}

	/***
	 * In Hotel Panel: check if user can increase number of Adults or Children
	 * 
	 * @param locator
	 */
	public boolean increaseAdultsOrChild(By locator, String locatorName, int defaultChild, int times) {
		try {
			locatorExist(locator, locatorName);
			int totalChild = 0;
			if (times > defaultChild) {
				totalChild = times - defaultChild;
			} else {
				totalChild = defaultChild - times;
			}
			for (int i = 0; i < totalChild; i++) {
				driver.findElement(locator).click();
			}
			logger.info(locatorName + " is clicked!");
			return true;
		} catch (Exception e) {
			logger.error(locatorName + " is not found: " + e);
			return false;
		}
	}

	public void assertIncreaseAdultsOrChild(By locator, String locatorName, int defaultChild, int times) {
		try {
			Assert.assertEquals(increaseAdultsOrChild(locator, locatorName, defaultChild, times), true);
		} catch (AssertionError e) {
			logger.info("Unable to increate " + locatorName + ". Due to: " + e);
			// test.log(LogStatus.FAIL, "Hotel Tab is failed cicking. Due to: " + e);
		}
	}

}
