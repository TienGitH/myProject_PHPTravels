package UIElements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HotelResultPageUIElements {
	WebDriver driver;
	String resultName;
	By errorMsg = By.xpath("//p[contains(text(),'Oops!! Page not found')]");
	By hotelResultName = By.xpath("//span[contains(text()," + resultName + ")]");
	By totalResult = By.xpath("//p[@class='text-muted post-heading']");

	public HotelResultPageUIElements(WebDriver driver) {
		this.driver = driver;
	}

	public By getErrorMsg() {
		return By.xpath("//p[contains(text(),'Oops!! Page not found')]");
	}

	public void setSearchResultName(String resultName) {
		this.resultName = resultName;
	}

	public WebElement getSearchResultName() {
		return driver.findElement(hotelResultName);
	}

	public WebElement getTotalResult() {
		return driver.findElement(totalResult);
	}
}
