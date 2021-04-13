package pageMethods;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import uiElements.liveChatUIElements;

public class liveChatPopupMethods {
	WebDriver driver;
	liveChatUIElements obj;
	public liveChatPopupMethods(WebDriver driver) {
		this.driver=driver;
		obj=new liveChatUIElements(driver);
	}
	
	public void clickMinimize() {
		WebElement minimize=obj.getMinimizeButton();
		minimize.click();
	}
	
	public void minimizeLiveChatPopup() {		
		boolean popupExists=obj.checkLiveChatPopupExists();
		if(popupExists==true) {
			System.out.println("Minimize the LiveChat popup");
			clickMinimize();
		}
	}
}
