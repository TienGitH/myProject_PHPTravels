package framework;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;

public class WebDriverFactory {
	public static Logger logger = LogManager.getLogger(BaseClass.class.getName());
	WebDriver driver;
	int timeout = 10;
	public ExtentReports report = new ExtentReports(System.getProperty("user.dir") + "\\ExtentReportResults.html");
	public static ExtentTest logReport;

	public ExtentTest getLogger() {
		return logReport;
	}

	public static void setLogger(ExtentTest logReports) {
		logReport = logReports;
	}

	public ExtentReports getReport() {
		return report;
	}

	public void setReport(ExtentReports report) {
		this.report = report;
	}

	public void startReport() {
		// basic log4j configuration
		BasicConfigurator.configure();
		// name the report
		report = new ExtentReports(System.getProperty("user.dir") + "\\ExtentReportResults1.html");
		logReport = report.startTest("PHP Report");
	}

	public void endReport() {
		report.endTest(logReport);
		report.flush();
	}

	public WebDriver initDriver() {
		System.setProperty("webdriver.gecko.driver", "C:\\geckodriver.exe");
		WebDriver driver = new FirefoxDriver();
		return driver;
	}

	public WebDriver Navigation(WebDriver driver, String url) {
		driver.get(url);
		return driver;
	}

	public void terminateDriver() {
		initDriver().close();
	}
}
