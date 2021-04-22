package pageMethods;

import org.openqa.selenium.WebDriver;

import framework.BaseClass;
import uiElements.HotelResultPageUIElements;

public class HotelResultPageMethod extends BaseClass {
	WebDriver driver;
	int timeout = 50;
	HotelResultPageUIElements hotelResultPageobj;

	public HotelResultPageMethod(WebDriver driver) {
		super(driver);
		hotelResultPageobj = new HotelResultPageUIElements(driver);
	}

	/*** check if the error page exists ***/
	public boolean checkErrorExist() {
		return assertResultLocatorExist(hotelResultPageobj.errorMsg(), "Error message");
	}

	public void getErrorMessage(Boolean result) {
		if (result == true) {
			logger.info(
					"Server is having problem as: " + getLocatorText(hotelResultPageobj.errorMsg(), "Error message"));
			logger.info("TC01 is passed testing!");
		} else {
			logger.info("TC01 is failed testing!");
		}
	}

	/*** check if search result exists ***/
	public boolean checkSearchResultExist(String resultName) {
		hotelResultPageobj.setSearchResultName(resultName);
		return assertResultLocatorExist(hotelResultPageobj.searchResultName(), "Search result");
	}

	public void checkSearchResult(Boolean result) {
		String totalResult = "";
		try {
			if (result == true) {
				if (assertResultLocatorExist(hotelResultPageobj.getTotalResult(), "Total Result") == true) {
					totalResult = getLocatorText(hotelResultPageobj.getTotalResult(), "Total Result");
					logger.info("There are " + totalResult);
					logger.info("TC01 is passed testing!");
				}
			} else {
				logger.info("There are " + totalResult);
				logger.error("TC01 is failed testing!");
			}
		} catch (AssertionError e) {
			logger.error("TC01 is failed testing! Due to: " + e);
		}
	}
}
