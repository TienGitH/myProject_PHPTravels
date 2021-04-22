package uiElements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HotelResultPageUIElements {
	WebDriver driver;
	String resultName;
	By errorMsg = By.xpath("//p[contains(text(),'Oops!! Page not found')]");
	By hotelResultName = By.xpath("//span[contains(text()," + resultName + ")]");
	By totalResult = By.xpath("//p[@class='text-muted post-heading']");
	By errorMessage = By.xpath("//p[contains(text(),'Oops!! Page not found')]");

	public HotelResultPageUIElements(WebDriver driver) {
		this.driver = driver;
	}

	public By errorMsg() {
		return errorMessage;
	}

	public void setSearchResultName(String resultName) {
		this.resultName = resultName;
	}

	public By searchResultName() {
		return hotelResultName;
	}

	public By getTotalResult() {
		return totalResult;
	}
}
