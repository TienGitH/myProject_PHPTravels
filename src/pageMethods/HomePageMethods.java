package pageMethods;

import framework.basedClass;
import java.util.List;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import uiElements.HomePageUIElements;

public class HomePageMethods extends basedClass {
	HomePageUIElements homePageObj;
	int timeout = 50;

	public HomePageMethods(WebDriver driver) {
		super(driver);
		homePageObj = new HomePageUIElements(driver);
	}

	/*** Click on Hotel tab ***/
	public void clickHotelTab() {
		Assert.assertEquals(checkAndClickLocator(homePageObj.hotelTab(), "Hotel tab"), true);
	}

	/*** Click on Hotel search box ***/
	public void clickHotelSearchBox() {
		Assert.assertEquals(checkAndClickLocator(homePageObj.location(), "Hotel search box"), true);
	}

	/*** Click on Hotel list box ***/
	public void clickHotelListBox() {
		Assert.assertEquals(checkAndClickLocator(homePageObj.inputLocation(), "Hotel text box"), true);
	}

	/***
	 * Select an item in a List box
	 * 
	 * @param listWebElement
	 */
	public void selectAValueInListBox(List<WebElement> listWebElement, String itemName) {
		Assert.assertEquals(selectValueInListBox(listWebElement, itemName), true);
	}

	/***
	 * In Hotel panel: select Hotel Name in the Search textbox
	 ***/
	public void inputLocation2(String itemName) {
		clickHotelSearchBox();
		checkAndSendTextLocator(homePageObj.inputLocation(), "Hotel text box", itemName);
		List<WebElement> options=homePageObj.listHotel();
		selectAValueInListBox(options, itemName);
	}
	
	/*** In Hotel panel: select Hotel Name in the Search textbox ***/
	public void inputLocation(String text) {		
		clickHotelSearchBox();
		checkAndSendTextLocator(homePageObj.inputLocation(), "Hotel text box", text);
		try {
			WebDriverWait wait = new WebDriverWait(driver, timeout);
			wait.until(ExpectedConditions.invisibilityOfAllElements(driver.findElements(homePageObj.optionsBy())));
			List<WebElement> options=driver.findElements(homePageObj.optionsBy());
			for (WebElement e : options) {
				try {
					Actions actions = new Actions(driver);
					actions.moveToElement(e);
					actions.perform();

					if (e.getText().equalsIgnoreCase(text)) {
						e.click();
						System.out.println("Selected "+text+" in the Hotel list successfully!");
						break;
					}
				} catch (Exception ex) {
					System.out.println("Can't select "+text+" in the Hotel list due to: " + ex);
				}

			}
		} catch (Exception e) {
			System.out.println("locationTxt error: " + e);
		}
	}

	/***
	 * In Hotel Panel: input Check In date
	 */
	public void inputCheckInDate(String date) {
		Assert.assertEquals(checkAndSendTextLocator(homePageObj.checkIn(), "Check In textbox", date), true);
	}

	/***
	 * In Hotel Panel: input Check Out date
	 */
	public void inputCheckOutDate(String date) {
		Assert.assertEquals(checkAndSendTextLocator(homePageObj.checkOut(), "Check Out textbox", date), true);
	}

	/***
	 * In Hotel Panel: select number of children
	 */
	public void increaseChildren(int no) {
		Assert.assertEquals(increaseAdultsOrChild(homePageObj.plusChildren(), "'+' Children", homePageObj.defaultChild(), no),true);
	}

	/***
	 * In Hotel Panel: click on Search button
	 * 
	 * @param date
	 */
	public void clickSearch() {
		Assert.assertEquals(checkAndClickLocator(homePageObj.search(), "Search button"),true);
	}

	/***
	 * In Live Chat popup: click minimize the window
	 */
	public void clickMinimizeLiveChat() {
		Assert.assertEquals(checkAndClickLocator(homePageObj.minimizeLiveChat(), "Live Chat's Minize button"),true);
	}

	/***
	 * In Need Help popup: click on "x" button to close the popup
	 */
	public void closeNeedHelp() {
		Assert.assertEquals(checkAndClickLocator(homePageObj.closeNeedHelp(), "Live Chat's Minize button"),true);
	}
}
