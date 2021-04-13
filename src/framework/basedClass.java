package framework;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class basedClass {
	public WebDriver driver;
	int timeout = 10;

	public basedClass(WebDriver driver) {
		this.driver = driver;
	}

	/***
	 * Check if a field exists?
	 * 
	 * @param locator
	 */
	public boolean checkLocatorExists(By locator, String locatorName) {
		try {
			WebDriverWait wait = new WebDriverWait(driver, timeout);
			wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
			System.out.println(locatorName + " exists!");
			return true;
		} catch (Exception e) {
			System.out.println(locatorName + " does not exist due to: " + e);
			return false;
		}
	}

	/***
	 * check if a field is clickable, then click it
	 * 
	 * @param locator
	 */
	public boolean clickLocator(By locator, String locatorName) {
		try {
			WebDriverWait wait = new WebDriverWait(driver, timeout);
			wait.until(ExpectedConditions.elementToBeClickable(locator));
			driver.findElement(locator).click();
			System.out.println(locatorName + " is clicked!");
			return true;
		} catch (Exception e) {
			System.out.println(locatorName + " is unable to click due to: " + e);
			return false;
		}
	}

	/***
	 * Click on a field if it is visible and clickable
	 * 
	 * @param locator
	 */
	public boolean checkAndClickLocator(By locator, String locatorName) {
		if (checkLocatorExists(locator, locatorName) == true && clickLocator(locator, locatorName) == true) {
			return true;
		} else {
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
		if (options==null && options.size() > 0) {
			for (WebElement e : options) {
				try {
					Actions actions = new Actions(driver);
					actions.moveToElement(e);
					actions.perform();
					if (e.getText().equalsIgnoreCase(itemName)) {
						e.click();
						break;
					}
					result = true;
				} catch (Exception ex) {
					System.out.println("error in scroll & loop: " + ex);
					result = false;
				}
			}
		}else {
			result=false;
		}
		return result;
	}

	/***
	 * Click on a field if it is visible and clickable
	 * 
	 * @param locator
	 */
	public boolean checkAndSendTextLocator(By locator, String locatorName, String text) {
		if (checkLocatorExists(locator, locatorName) == true && clickLocator(locator, locatorName) == true) {
			driver.findElement(locator).clear();
			driver.findElement(locator).sendKeys(text);
			System.out.println("Inputed '"+text+"' into " + locatorName + " successfully!");
			return true;
		} else {
			System.out.println("Cannot input '"+text+"' into " + locatorName);
			return false;
		}
	}

	/***
	 * In Hotel Panel: check if user can increase number of Adults or Children
	 * 
	 * @param locator
	 */
	public boolean increaseAdultsOrChild(By locator, String locatorName, int defaultChild, int times) {
		try {
			checkLocatorExists(locator, locatorName);
			// WebDriverWait wait = new WebDriverWait(driver, timeout);
			// wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
			// int defaultChild =
			// Integer.parseInt(driver.findElement(obj.childrenValue()).getAttribute("value"));
			int totalChild = 0;
			if (times > defaultChild) {
				totalChild = times - defaultChild;
			} else {
				totalChild = defaultChild - times;
			}
			for (int i = 0; i < totalChild; i++) {
				driver.findElement(locator).click();
			}
			System.out.println(locatorName + " is clicked!");
			return true;
		} catch (Exception e) {
			System.out.println(locatorName + " is not found: " + e);
			return false;
		}
	}

}
