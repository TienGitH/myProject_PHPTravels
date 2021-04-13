package testCases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class Inittiation {

	By bookingpanel = By.xpath("//div[contains(@class,'menu-horizontal-wrapper-02')]");
	WebDriver driver;
	int timeout=10;
	
//	public Inittiation(WebDriver driver) {
//		this.driver=driver;
//	}
	public WebDriver initDriver() {
		System.setProperty("webdriver.gecko.driver", "C:\\geckodriver.exe");
		WebDriver driver = new FirefoxDriver();
		return driver;
	}

	public WebDriver Navigation(WebDriver driver, String url) {
		driver.get(url);
		WebElement Thepanel = driver.findElement(bookingpanel);
		if (Thepanel.isDisplayed()) {
			System.out.println("Home page is lauched successfully!");
		} else {
			System.out.println("Oops! Home page is not reached.");
		}
		return driver;
	}
	
	public void terminateDriver() {
		initDriver().close();
	}
	
	public void assertIsDisplayed(WebElement element, By locator, String msgTrue, String msgFalse) { 
		try {
			element = driver.findElement(locator);
			Assert.assertTrue(element.isDisplayed(), msgTrue);
		} catch (AssertionError e) {
			System.out.println(msgFalse + e);
		}
	}
	
	public WebElement returnElement(By locator, String msgTrue, String msgFalse, String msgException) {
		WebElement element = null;
		try {
			WebDriverWait wait = new WebDriverWait(driver, timeout);
			wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
			element = driver.findElement(locator);
			assertIsDisplayed(element, locator, msgTrue, msgTrue);
		} catch (Exception e) {
			System.out.println(msgException + e);
		}
		return element;
	}
}
