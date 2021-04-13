package myTestNGPackage;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import Main.TestSuite;
import testCases.HomePageTCs;
import testCases.Inittiation;

public class testNGFile {
	WebDriver driver;
	TestSuite testSuite = new TestSuite();
	
	@BeforeTest
	public void Init() {
		Inittiation init = new Inittiation();
		driver = init.initDriver();
		String url = "https://www.phptravels.net/home";
		init.Navigation(driver, url);
	}
	@Test
	public void Booking() {
		System.out.println("Proceeding for booking...");
		HomePageTCs homePageTC = new HomePageTCs(driver);
		homePageTC.bookingHotel();
	}
	@AfterTest
    public void terminateBrowser(){
        driver.close();
    }
}
