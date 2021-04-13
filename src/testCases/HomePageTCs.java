package testCases;
import pageMethods.HomePageMethods;
import pageMethods.HotelResultPageMethod;
import pageMethods.liveChatPopupMethods;
import org.openqa.selenium.WebDriver;

public class HomePageTCs {
	WebDriver homeDriver;
	HomePageMethods homePageMethod;
	HotelResultPageMethod resultPageMethod;
	liveChatPopupMethods liveChatMethod;

	public HomePageTCs(WebDriver driver) {
		this.homeDriver = driver;
		homePageMethod = new HomePageMethods(homeDriver);
		resultPageMethod = new HotelResultPageMethod(homeDriver);
		liveChatMethod = new liveChatPopupMethods(driver);
	}

	public void bookingHotel() {
		System.out.println("TC01: Verify user can book a hotel successfully");
		System.out.println("Step 1: Minize the Live Chat if it does display");
		liveChatMethod.minimizeLiveChatPopup();		
		System.out.println("Step 2: Select Hotel tab");
		homePageMethod.clickHotelTab();
		System.out.println("Step 3: Select Hotel is 'Alzer Hotel Istanbul'");
		String location = "Alzer Hotel Istanbul";
		homePageMethod.inputLocation(location);
		System.out.println("Step 4: Input Check In Date is 22/4/2021");
		homePageMethod.inputCheckInDate("22/4/2021");
		System.out.println("Step 5: Input Check Out Date is 29/4/2021");
		String checkoutdate = "29/4/2021";
		homePageMethod.inputCheckOutDate(checkoutdate);
		System.out.println("Step 6: Minize the Live Chat if it does display");
		liveChatMethod.minimizeLiveChatPopup();
		System.out.println("Step 7: Input the number of children is 2");
		int totalChildren = 2;
		homePageMethod.increaseChildren(totalChildren);
		System.out.println("Step 8: Click on Search button");
		homePageMethod.clickSearch();
		Boolean result = resultPageMethod.checkErrorExist();
		if (result == true) {
			resultPageMethod.getErrorMessage(result);
		} else {
			String hotelName = "alzer-hotel-istanbuls";
			resultPageMethod.checkSearchResult(resultPageMethod.checkSearchResultExist(hotelName));
		}
	}
}
