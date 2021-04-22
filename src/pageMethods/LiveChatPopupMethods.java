package pageMethods;
import org.openqa.selenium.WebDriver;
import framework.BaseClass;

import uiElements.LiveChatUIElements;

public class LiveChatPopupMethods extends BaseClass {
	WebDriver driver;
	LiveChatUIElements liveChatObj;
	public LiveChatPopupMethods(WebDriver driver) {
		super(driver);
		liveChatObj=new LiveChatUIElements(driver);
	}
	
	/*** check if the Live Chat exists ***/
	public boolean minimizeLiveChat() {
		return assertResultCheckAndClickLocator(liveChatObj.minimizeLiveChat(), "Live Chat Popup");
	}
	
//	public void clickMinimize() {
//		WebElement minimize=obj.getMinimizeButton();
//		minimize.click();
//	}
//	
//	public void minimizeLiveChatPopup() {		
//		boolean popupExists=obj.checkLiveChatPopupExists();
//		if(popupExists==true) {
//			System.out.println("Minimize the LiveChat popup");
//			clickMinimize();
//		}
//	}
}
