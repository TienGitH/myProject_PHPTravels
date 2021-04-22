package pageMethods;

import framework.BaseClass;
import java.util.List;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import uiElements.HomePageUIElements;

public class HomePageMethods extends BaseClass {
	HomePageUIElements homePageObj;
	int timeout = 50;
	// static ExtentTest test;

	public HomePageMethods(WebDriver driver) {
		super(driver);
		homePageObj = new HomePageUIElements(driver);
	}

	/*** check if the booking panel exists ***/
	public boolean clickBookingPanel() {
		return assertResultCheckAndClickLocator(homePageObj.bookingPanel(), "Booking Panel");
	}

	/*** Click on Hotel tab ***/
	public boolean clickHotelTab() {
		return assertResultCheckAndClickLocator(homePageObj.hotelTab(), "Hotel tab");
	}

	/*** Click on Hotel search box ***/
	public void clickHotelSearchBox() {
		assertCheckAndClickLocator(homePageObj.location(), "Hotel search box");
	}

	/*** Click on Hotel list box ***/
	public void clickHotelListBox() {
		assertCheckAndClickLocator(homePageObj.inputLocation(), "Hotel text box");
	}

	/***
	 * Select an item in a List box
	 * 
	 * @param listWebElement
	 */
	public void selectAValueInListBox(List<WebElement> listWebElement, String itemName) {
		assertResultSelectValueInListBox(listWebElement, itemName);
	}

	/***
	 * In Hotel panel: select Hotel Name in the Search textbox
	 ***/
	public void inputLocation2(String itemName) {
		clickHotelSearchBox();
		checkAndSendTextLocator(homePageObj.inputLocation(), "Hotel text box", itemName);
		List<WebElement> options = homePageObj.listHotel();
		selectAValueInListBox(options, itemName);
	}

	/*** In Hotel panel: select Hotel Name in the Search textbox ***/
	public void inputLocation(String text) {
		clickHotelSearchBox();
		checkAndSendTextLocator(homePageObj.inputLocation(), "Hotel text box", text);
		try {
			if(assertResultLocatorExist(homePageObj.optionsBy(),"Hotel list")==true) {
			//WebDriverWait wait = new WebDriverWait(driver, timeout);
			//wait.until(ExpectedConditions.invisibilityOfAllElements(driver.findElements(homePageObj.optionsBy())));
			List<WebElement> options = driver.findElements(homePageObj.optionsBy());
			for (WebElement e : options) {
				try {
					Actions actions = new Actions(driver);
					actions.moveToElement(e);
					actions.perform();

					if (e.getText().equalsIgnoreCase(text)) {
						e.click();
						System.out.println("Selected " + text + " in the Hotel list successfully!");
						break;
					}
				} catch (Exception ex) {
					System.out.println("Can't select " + text + " in the Hotel list due to: " + ex);
				}
			}
			}else {
				logger.info("Hotel list does not exist");
			}
		} catch (Exception e) {
			System.out.println("locationTxt error: " + e);
		}
	}

	/***
	 * In Hotel Panel: input Check In date
	 */
	public void inputCheckInDate(String date) {
		assertCheckAndSendTextLocator(homePageObj.checkIn(), "Check In textbox", date);
	}

	/***
	 * In Hotel Panel: input Check Out date
	 */
	public void inputCheckOutDate(String date) {
		assertCheckAndSendTextLocator(homePageObj.checkOut(), "Check Out textbox", date);
	}

	/***
	 * In Hotel Panel: select number of children
	 */
	public void increaseChildren(int no) {
		assertIncreaseAdultsOrChild(homePageObj.plusChildren(), "'+' Children", homePageObj.defaultChild(), no);
	}

	/***
	 * In Hotel Panel: click on Search button
	 * 
	 * @param date
	 */
	public void clickSearch() {
		assertCheckAndClickLocator(homePageObj.search(), "Search button");
	}

	/***
	 * In Live Chat popup: click minimize the window
	 */
	public void clickMinimizeLiveChat() {
		assertCheckAndClickLocator(homePageObj.minimizeLiveChat(), "Live Chat's Minize button");
	}

	/***
	 * In Need Help popup: click on "x" button to close the popup
	 */
	public void closeNeedHelp() {
		assertCheckAndClickLocator(homePageObj.closeNeedHelp(), "Close button on Need Help popup");
	}
}
