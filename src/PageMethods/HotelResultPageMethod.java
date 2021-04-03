package PageMethods;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import UIElements.HotelResultPageUIElements;

public class HotelResultPageMethod {
	WebDriver driver;
	int timeout = 50;
	HotelResultPageUIElements obj;

	public HotelResultPageMethod(WebDriver newdriver) {
		this.driver = newdriver;		
		obj = new HotelResultPageUIElements(driver);
	}

	public WebElement getMsg() {
		WebElement msg = driver.findElement(obj.getErrorMsg());
		return msg;
	}

	public Boolean checkErrorExist() {
		Boolean result;
		try {
			WebDriverWait wait = new WebDriverWait(driver, timeout);
			System.out.println("checking element");
			wait.until(ExpectedConditions.visibilityOfElementLocated(obj.getErrorMsg()));
			result = getMsg().isDisplayed();
		} catch (Exception e) {
			result = false;
			System.out.println("Error message does not display due to " + e);
		}
		return result;
	}

	public void getErrorMessage(Boolean result) {
		try {
			if (result == true) {
				System.out.println("No search result found! Reason is: " + getMsg().getText());
				System.out.println("TC01 is passed testing!");
			} else {
				System.out.println("TC01 is failed testing!");
			}
		} catch (Exception e) {
			System.out.println("Some unexpected error happens. TC01 is failed testing!" + e);
		}
	}

	public Boolean checkSearchResultExist(String resultName) {
		Boolean result;
		WebDriverWait wait = new WebDriverWait(driver, timeout);
		try {
			obj.setSearchResultName(resultName);
			wait.until(ExpectedConditions.visibilityOf(obj.getSearchResultName()));
			result = obj.getSearchResultName().isDisplayed();
		} catch (Exception e) {
			result = false;
			System.out.println("The searched hotel is not found! Error: " + e);
		}
		return result;
	}
	
	public String getTotalSearchResult()
	{
		String totalSearchResult="";
		WebDriverWait wait = new WebDriverWait(driver,timeout);
		try {
			wait.until(ExpectedConditions.visibilityOf(obj.getTotalResult()));
			totalSearchResult=obj.getTotalResult().getText();
		}catch(Exception e) {
			System.out.println("Cannot get the total of search result found due to " + e);
		}
		return totalSearchResult;
	}

	public void checkSearchResult(Boolean result) {
		try {
			if (result == true) {
				System.out.println(getTotalSearchResult());
				System.out.println("TC01 is passed testing!");
			} else {
				System.out.println("TC01 is failed testing!");
			}
		} catch (Exception e) {
			System.out.println("Some unexpected error happens. TC01 is failed testing!" + e);
		}
	}
}
