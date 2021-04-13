package uiElements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class liveChatUIElements {
	WebDriver driver;
	int timeout = 10;
	By liveChatTitle = By.xpath("//h1[contains(text(),'Welcome to LiveChat')]");
	By minimizeButton = By.xpath("//button[@aria-label='Minimize window']");

	public liveChatUIElements(WebDriver driver) {
		this.driver = driver;
	}
	
	public boolean checkLiveChatPopupExists() {
		boolean result = false;
		WebDriverWait wait = new WebDriverWait(driver, timeout);
		try {
			wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(liveChatTitle));
			result = true;
		} catch (Exception e) {
			System.out.println("Lucky! There is no LiveChat popup.");
		}
		return result;
	}

	public WebElement getMinimizeButton() {
		WebElement minimize = null;
		WebDriverWait wait = new WebDriverWait(driver, timeout);
		try {
			wait.until(ExpectedConditions.elementToBeClickable(minimizeButton));
			minimize = driver.findElement(minimizeButton);
			Assert.assertTrue(minimize.isDisplayed(), "Minimize button is displayed");
		} catch (AssertionError  e) {
			System.out.println("Minimize button does not exist");
		}
		return minimize;
	}
}
