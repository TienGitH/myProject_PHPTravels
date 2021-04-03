package Main;
import org.openqa.selenium.WebDriver;
import Testcases.HomePageTCs;
import Testcases.Inittiation;

public class TestSuite {
	WebDriver driver;
	//public static final Logger log = Logger.getLogger(TestSuite.class.getName());

	public static void main(String[] args) {
		TestSuite testSuite = new TestSuite();
		testSuite.Init();
		testSuite.Booking();
	}

	public void Init() {
		/*String log4jConfPath = "log4j.properties";
		PropertyConfigurator.configure(log4jConfPath);

		log.info("Tien test!");
		log.error("Error");*/
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
