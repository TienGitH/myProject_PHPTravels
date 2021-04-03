package Testcases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Inittiation {

	By bookingpanel = By.xpath("//div[contains(@class,'menu-horizontal-wrapper-02')]");
	
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
		// close Fire fox
		// driver.close();
		return driver;
	}
}
