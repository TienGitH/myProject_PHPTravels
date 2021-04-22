package myTestNGPackage;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import com.relevantcodes.extentreports.LogStatus;

import Main.TestSuite;
import framework.WebDriverFactory;
import testCases.HomePageTCs;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

public class TestNG extends WebDriverFactory{

	public static  Logger logger = LogManager.getLogger(TestNG.class.getName());
	WebDriver driver;
	TestSuite testSuite = new TestSuite();
	WebDriverFactory initObj = new WebDriverFactory();

	@BeforeTest
	public void Init() {
		startReport();
//		// basic log4j configuration
//		BasicConfigurator.configure();
//		//name the report
//		report = new ExtentReports(System.getProperty("user.dir") + "\\ExtentReportResults.html");
//		test = report.startTest("PHP Report");
		//start the browser
		WebDriverFactory init = new WebDriverFactory();
		driver = init.initDriver();
		//navigate to the website
		String url = "https://www.phptravels.net/home";
		init.Navigation(driver, url);
	}

	@Test
	public void Booking() {
		logger.info("Proceeding for booking a hotel");
		// example
		logReport.log(LogStatus.PASS, "Start booking a hotel now.");
		HomePageTCs homePageTC = new HomePageTCs(driver);
		homePageTC.bookingHotel();
	}

	@AfterTest
	public void terminateBrowser() {
		endReport();
//		report.endTest(test);
//		report.flush();
		driver.close();
	}
}
