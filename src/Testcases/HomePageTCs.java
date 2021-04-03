package Testcases;

import org.openqa.selenium.WebDriver;
import PageMethods.HomePageMethods;
import PageMethods.HotelResultPageMethod;

public class HomePageTCs {
	WebDriver homeDriver;
	HomePageMethods homePageMethod;
	HotelResultPageMethod resultPageMethod;

	public HomePageTCs(WebDriver driver) {
		this.homeDriver = driver;
		homePageMethod = new HomePageMethods(homeDriver);
		resultPageMethod = new HotelResultPageMethod(homeDriver);
	}

	public void bookingHotel() {
		System.out.println("TC01: Verify user can book a hotel successfully");
		System.out.println("Step1: Select Hotel is 'Alzer Hotel Istanbul'");
		String location = "Alzer Hotel Istanbul";
		homePageMethod.inputLocation(location);
		System.out.println("Step 2: Input Check In Date is 25/3/2021");
		String checkindate = "25/3/2021";
		homePageMethod.inputCheckInDate(checkindate);
		System.out.println("Step 3: Input Check Out Date is 29/3/2021");
		String checkoutdate = "29/3/2021";
		homePageMethod.inputCheckOutDate(checkoutdate);
		// homePageMethod.clickMinimizeLiveChat();
		// homePageMethod.closeNeedHelp();
		System.out.println("Step 4: Input the number of children is 2");
		int totalChildren = 2;
		homePageMethod.increaseChildren(totalChildren);
		System.out.println("Step 5: Click on Search button");
		homePageMethod.clickSearch();
		Boolean result = resultPageMethod.checkErrorExist();
		if (result == true) {
			resultPageMethod.getErrorMessage(result);
		} else {
			String hotelName = "alzer-hotel-istanbuls";
			resultPageMethod.checkSearchResult(resultPageMethod.checkSearchResultExist(hotelName));
		}
		// System.out.println("Step 6: There is no result and error message displays.");
		// resultPageMethod.errorMessageDisplay();
		// System.setOut(new PrintStream(new
		// FileOutputStream("FirstTCconsoleoutput.txt")));
		// printConsoleLog();
	}

	/*
	 * public void printConsoleLog() { try { // Save original out stream.
	 * PrintStream originalOut = System.out; // Save original err stream.
	 * PrintStream originalErr = System.err; // Create a new file output stream.
	 * PrintStream fileOut = new PrintStream("./out.txt"); // Create a new file
	 * error stream. PrintStream fileErr = new PrintStream("./err.txt"); // Redirect
	 * standard out to file. System.setOut(fileOut); // Redirect standard err to
	 * file. System.setErr(fileErr); // Wrapped Scanner to get user input. Scanner
	 * scanner = new Scanner(System.in); // Print data in command console.
	 * originalOut.println("Please input your email. "); // Read string line. String
	 * line = scanner.nextLine(); while (true) { // If user input 'quit' then break
	 * the loop. if ("quit".equalsIgnoreCase(line)) { break; } if
	 * (!isValidEmail(line)) { // If user input is not a valid email then write log
	 * data to ./err.txt file and // console. originalErr.println("Email " + line +
	 * " is not a valid email. Please input again."); System.err.println("Email " +
	 * line + " is not a valid email. "); } else { // If user input a valid email
	 * then write the email to ./out.txt and console. originalOut.println("Email " +
	 * line + " is valid. Please input another one."); System.out.println("Email " +
	 * line + " is valid. Please input another one."); } // Get next user input line
	 * text. line = scanner.nextLine(); } originalOut.println("Program exit. ");
	 * System.out.println("Program exit. "); // Do not forget set original output
	 * and error stream back again. System.setOut(originalOut);
	 * System.setErr(originalErr); } catch (FileNotFoundException ex) {
	 * ex.printStackTrace(); } }
	 */

	/* Check whether the string is an email address or not. */
	/*
	 * private static boolean isValidEmail(String email) { boolean ret = true; if
	 * (email == null || email.trim().length() == 0) { ret = false; } else { int
	 * index = email.indexOf("@"); if (index == -1) { ret = false; } } return ret; }
	 */
}
