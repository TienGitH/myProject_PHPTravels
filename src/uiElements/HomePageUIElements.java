package uiElements;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import testCases.Inittiation;

public class HomePageUIElements {
	WebDriver driver;
	Inittiation init;
	int timeout = 50;
	By hotelTab = By.xpath("//a[@href='#hotels']");
	By location = By.xpath("//a[@class='select2-choice']");
	By inputLocation = By.xpath("//div[@id='select2-drop']//input");
	By optionsBy = By.xpath("//div[@class='select2-result-label']/span");
	By checkIn = By.id("checkin");
	By checkOut = By.id("checkout");
	By plusAdult = By.xpath("//div[@class='col o2']//button[@class='btn btn-white bootstrap-touchspin-up ']");
	By minorAdult = By.xpath("//div[@class='col o2']//button[@class='btn btn-white bootstrap-touchspin-up ']");
	By childrenValue = By.name("children");
	By plusChildren = By.xpath("//div[@class='col 01']//button[@class='btn btn-white bootstrap-touchspin-up ']");
	By minorChildren = By.xpath("//div[@class='col 01']//button[@class='btn btn-white bootstrap-touchspin-up ']");
	By search = By.xpath("//div[@id='hotels']//button[@type='submit']");
	By minimizeLiveChat = By.xpath(
			"//div[@id='overlay_portal_container']/following-sibling::div//button[@aria-label='Minimize window']");
	By closeNeedHelp = By.xpath("//div[@id='livechat-eye-catcher']/div");

	public HomePageUIElements(WebDriver driver) {
		this.driver = driver;
	}

	public By hotelTab() {

		return hotelTab;
	}

	public By location() {

		return location;
	}

	public By optionsBy() {

		return optionsBy;
	}

	public By inputLocation() {

		return inputLocation;
	}

	public By checkIn() {

		return checkIn;
	}

	public By checkOut() {

		return checkOut;
	}

	public List<WebElement> listHotel() {
		List<WebElement> listHotel;
		try {
			listHotel = driver.findElements(optionsBy());
		} catch (Exception e) {
			System.out.println("Can't find the hotel list due to: "+e);
			listHotel=null;
		}
		return listHotel;
	}

	public By childrenValue() {

		return childrenValue;
	}

	public int defaultChild() {
		int defaultChild = Integer.parseInt(driver.findElement(childrenValue).getAttribute("value"));
		return defaultChild;
	}

	public By plusChildren() {

		return plusChildren;
	}

	public By search() {
		return search;
	}

	public By minimizeLiveChat() {
		return minimizeLiveChat;
	}

	public By closeNeedHelp() {
		return closeNeedHelp;
	}
}
