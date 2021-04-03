package UIElements;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomePageUIElements {
	WebDriver driver;
	By location = By.xpath("//a[@class='select2-choice']");
	By inputlocation = By.xpath("//div[@id='select2-drop']//input");
	By optionsBy = By.xpath("//div[@class='select2-result-label']/span");
	By checkin = By.id("checkin");
	By checkout = By.id("checkout");
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
		this.driver=driver;
	}

	public WebElement returnLocationtxt() {
		return driver.findElement(location);
	}

	public WebElement returnInputLocationtxt() {
		return driver.findElement(inputlocation);
	}

	public List<WebElement> returnOptionsBy() {
		return driver.findElements(optionsBy);
	}

	public WebElement returnCheckintxt() {
		return driver.findElement(checkin);
	}

	public WebElement returnCheckOuttxt() {
		return driver.findElement(checkout);
	}

	public WebElement returnChildrenValue() {
		return driver.findElement(childrenValue);
	}

	public WebElement returnPlusChildrenbtn() {
		return driver.findElement(plusChildren);
	}

	public WebElement returnSearchbtn() {
		return driver.findElement(search);
	}

	public WebElement returnMinimizeLiveChat() {
		return driver.findElement(minimizeLiveChat);
	}

	public WebElement returnCloseNeedHelppopup() {
		return driver.findElement(closeNeedHelp);
	}
}
