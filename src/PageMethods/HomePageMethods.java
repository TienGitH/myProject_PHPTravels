package PageMethods;

import java.util.List;

//import org.openqa.selenium.By;
//import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import UIElements.HomePageUIElements;
import Utility.log;

public class HomePageMethods {
	WebDriver homePageMethodDriver;
	HomePageUIElements obj;
	int timeout = 50;

	public HomePageMethods(WebDriver driver) {
		homePageMethodDriver = driver;
		obj = new HomePageUIElements(homePageMethodDriver);
	}

	/*** In Hotel panel: select Hotel Name in the Search textbox ***/
	public void inputLocation(String text) {
		WebDriverWait wait = new WebDriverWait(homePageMethodDriver, timeout);
		WebElement location;
		WebElement LocationTxt;

		try {
			wait.until(ExpectedConditions.elementToBeClickable(obj.returnLocationtxt()));
			obj.returnLocationtxt().click();
		} catch (Exception e) {
			System.out.println("locationTxt error: " + e);
		}

		try {
			wait.until(ExpectedConditions.elementToBeClickable(obj.returnInputLocationtxt()));
			obj.returnInputLocationtxt().sendKeys(text);
			wait.until(ExpectedConditions.invisibilityOfAllElements(obj.returnOptionsBy()));
			List<WebElement> options = obj.returnOptionsBy();
			for (WebElement e : options) {
				try {
					Actions actions = new Actions(homePageMethodDriver);
					actions.moveToElement(e);
					actions.perform();

					if (e.getText().equalsIgnoreCase(text)) {
						e.click();
						// System.out.println("Text: " + text + " is selected successfully!");
						break;
					}
				} catch (Exception ex) {
					System.out.println("error in scroll & loop: " + ex);
				}

			}
		} catch (Exception e) {
			System.out.println("locationTxt error: " + e);
		}
	}

	/***
	 * In Hotel Panel: input Check In date
	 * 
	 * @param date
	 */
	public void inputCheckInDate(String date) {
		WebDriverWait wait = new WebDriverWait(homePageMethodDriver, timeout);
		try {
			wait.until(ExpectedConditions.elementToBeClickable(obj.returnCheckintxt()));
			obj.returnCheckintxt().clear();
			obj.returnCheckintxt().sendKeys(date);
		} catch (Exception e) {
			System.out.println("Function to input check in date has error:" + e);
		}

	}

	/***
	 * In Hotel Panel: input Check Out date
	 * 
	 * @param date
	 */
	public void inputCheckOutDate(String date) {
		WebDriverWait wait = new WebDriverWait(homePageMethodDriver, timeout);
		try {
			wait.until(ExpectedConditions.elementToBeClickable(obj.returnCheckOuttxt()));
			obj.returnCheckOuttxt().clear();
			obj.returnCheckOuttxt().sendKeys(date);
		} catch (Exception e) {
			System.out.println("Function to input check out date has error:" + e);
		}
	}

	/***
	 * In Hotel Panel: select number of children
	 * 
	 * @param number
	 */
	public void increaseChildren(int no) {
		WebDriverWait wait = new WebDriverWait(homePageMethodDriver, timeout);
		try {
			wait.until(ExpectedConditions.elementToBeClickable(obj.returnPlusChildrenbtn()));
			//WebElement plusChild = homePageMethodDriver.findElement(obj.returnPlusChildrenbtn());
			// String name = (String) ((JavascriptExecutor)
			// homePageMethodDriver).executeScript("document.getElementsByName('children')[0].value;");
			int defaultChild = Integer.parseInt(obj.returnChildrenValue().getAttribute("value"));
			// System.out.print(defaultChild);
			int totalChild = 0;
			if (no > defaultChild) {
				totalChild = no - defaultChild;
			} else {
				totalChild = defaultChild - no;
			}
			for (int i = 0; i < totalChild; i++) {
				obj.returnPlusChildrenbtn().click();
			}
		} catch (Exception e) {
			System.out.println("Function to input check in date has error:" + e);
		}
	}

	/***
	 * In Hotel Panel: click on Search button
	 * 
	 * @param date
	 */
	public void clickSearch() {
		WebDriverWait wait = new WebDriverWait(homePageMethodDriver, timeout);
		try {
			wait.until(ExpectedConditions.elementToBeClickable(obj.returnSearchbtn()));
			obj.returnSearchbtn().click();
		} catch (Exception e) {
			System.out.println("Function to input check in date has error:" + e);
		}
	}

	/***
	 * In Live Chat popup: click minimize the window
	 * 
	 * @param date
	 */
	public void clickMinimizeLiveChat() {
		WebDriverWait wait = new WebDriverWait(homePageMethodDriver, timeout);
		try {

			// wait.until(ExpectedConditions.invisibilityOf(homePageMethodDriver.findElement(obj.returnMinimizeLiveChat())));
			wait.until(ExpectedConditions.visibilityOf(obj.returnMinimizeLiveChat()));
			wait.until(ExpectedConditions.elementToBeClickable(obj.returnMinimizeLiveChat()));
			if (obj.returnMinimizeLiveChat().isDisplayed()) {
				obj.returnMinimizeLiveChat().click();
			}
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	/***
	 * In Need Help popup: click on "x" button to close the popup
	 * 
	 * @param date
	 */
	public void closeNeedHelp() {
		WebDriverWait wait = new WebDriverWait(homePageMethodDriver, timeout);
		try {

			wait.until(ExpectedConditions.visibilityOf(obj.returnCloseNeedHelppopup()));
			wait.until(ExpectedConditions.elementToBeClickable(obj.returnCloseNeedHelppopup()));
			if (obj.returnCloseNeedHelppopup().isDisplayed()) {
				obj.returnCloseNeedHelppopup().click();
			}
		} catch (Exception e) {
			System.out.println(e);
		}
	}
}
