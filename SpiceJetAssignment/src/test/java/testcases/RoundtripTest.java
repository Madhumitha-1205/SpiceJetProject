package testcases;



import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import basedriver.BaseClass;
import pages.RoundtripPage;

public class RoundtripTest extends BaseClass {

	@Test
	public void FlightSearch() throws Exception {

		try {

			test = extent.startTest("Flight Search Test", "Flight Search Test Results");

			RoundtripPage sp = new RoundtripPage();
			sp.ClickonRoundTrip();
			sp.EnterFromOrigin("Che");
			sp.EnterToDestination("Mum");
			sp.DepartureDate();
			sp.ClickonDate();
			sp.ReturnDate();
			sp.Searchflight();
			test.log(LogStatus.PASS, "FlightSearch is Successful");
		} catch (Exception e) {
			test.log(LogStatus.FAIL, "FlightSearch is Failed");
			 String screenShotPath =capture(driver, "screenShotName");
				test.addScreenCapture(addScreenShot(driver,screenShotPath));
		}
	}
}