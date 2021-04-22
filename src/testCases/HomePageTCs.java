package testCases;

import pageMethods.HomePageMethods;
import pageMethods.HotelResultPageMethod;
import pageMethods.LiveChatPopupMethods;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;

import framework.BaseClass;
import framework.WebDriverFactory;

public class HomePageTCs {
	public static Logger logger = LogManager.getLogger(BaseClass.class.getName());
	//static ExtentTest test;
	WebDriver homeDriver;
	HomePageMethods homePageMethod;
	HotelResultPageMethod resultPageMethod;
	LiveChatPopupMethods liveChatMethod;
	WebDriverFactory initObj;

	public HomePageTCs(WebDriver driver) {
		this.homeDriver = driver;
		homePageMethod = new HomePageMethods(homeDriver);
		resultPageMethod = new HotelResultPageMethod(homeDriver);
		liveChatMethod = new LiveChatPopupMethods(driver);
		initObj = new WebDriverFactory();
		//test=initObj.initReport();
	}

	public void bookingHotel() {
		logger.info("TC01: Verify user can book a hotel successfully");
		logger.info("Step 1: Minimize the Live Chat if it exists");
		liveChatMethod.minimizeLiveChat();
		logger.info("Step 2: Check if Booking Panel exist.");
		if (homePageMethod.clickBookingPanel() == true) {
			//test.log(LogStatus.PASS, "Booking Panel exists");
			logger.info("Step 3: Select Hotel tab");
			if (homePageMethod.clickHotelTab() == true) {
				logger.info("Step 4: Select Hotel is 'Alzer Hotel Istanbul'");
				String location = "Alzer Hotel Istanbul";
				homePageMethod.inputLocation(location);
				logger.info("Step 5: Input Check In Date is 22/4/2021");
				homePageMethod.inputCheckInDate("22/4/2021");
				logger.info("Step 6: Input Check Out Date is 29/4/2021");
				String checkoutdate = "29/4/2021";
				homePageMethod.inputCheckOutDate(checkoutdate);
				logger.info("Step 7: Minize the Live Chat if it does display");
				liveChatMethod.minimizeLiveChat();
				logger.info("Step 8: Input the number of children is 2");
				int totalChildren = 2;
				homePageMethod.increaseChildren(totalChildren);
				logger.info("Step 9: Click on Search button");
				homePageMethod.clickSearch();
				boolean result = resultPageMethod.checkErrorExist();
				if (result == true) {
					resultPageMethod.getErrorMessage(result);
				} else {
					String hotelName = "alzer-hotel-istanbuls";
					resultPageMethod.checkSearchResult(resultPageMethod.checkSearchResultExist(hotelName));
				}
			} else {
				//test.log(LogStatus.FAIL, "Hotel Tab does not exist. Can't perform booking a hotel.");
			}
		} else {
			//test.log(LogStatus.FAIL, "Booking Panel does not exist. Can't perform any kind of booking.");
		}
	}
}
