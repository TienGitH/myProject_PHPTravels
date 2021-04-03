package Main;
import org.openqa.selenium.WebDriver;
import Testcases.HomePageTCs;
import Testcases.Inittiation;

public class TestSuite {
	WebDriver driver;

	public static void main(String[] args) {
		TestSuite testSuite = new TestSuite();
		testSuite.Init();
		testSuite.Booking();
	}

	public void Init() {
		Inittiation init = new Inittiation();
		driver = init.initDriver();
		String url = "https://www.phptravels.net/home";
		init.Navigation(driver, url);
	}

	public void Booking() {
		System.out.println("Proceeding to Booking...");
		HomePageTCs homePageTC = new HomePageTCs(driver);
		homePageTC.bookingHotel();
	}
}
