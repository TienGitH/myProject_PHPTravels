package Main;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;

import framework.BaseClass;
import framework.WebDriverFactory;
import testCases.HomePageTCs;

public class TestSuite {
	public static  Logger logger = LogManager.getLogger(BaseClass.class.getName());
	WebDriver driver;
	public static void main(String[] args) {
		
		TestSuite testSuite = new TestSuite();
		testSuite.Init();
		testSuite.Booking();
	}

	public void Init() {
		WebDriverFactory init = new WebDriverFactory();
		driver = init.initDriver();
		String url = "https://www.phptravels.net/home";
		init.Navigation(driver, url);
	}

	public void Booking() {
		logger.info("Proceeding to Booking in Main class...");
		HomePageTCs homePageTC = new HomePageTCs(driver);
		homePageTC.bookingHotel();
	}
}
