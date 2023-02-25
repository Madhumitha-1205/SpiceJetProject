package testcases;



import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import basedriver.BaseClass;
import pages.FlightSelectionPage;
import pages.OneWayPage;

public class FlightSelectionTest extends BaseClass {

	@Test
	public void BookFlight() throws Exception {

		try {

			test = extent.startTest("BookingFlight Test", "BookingFlight Test Results");

			OneWayPage sp = new OneWayPage();
			sp.EnterOrigin("Hy");
			sp.EnterDestination("Vis");
			sp.Date();
			sp.Searchflight();

			FlightSelectionPage fsp = new FlightSelectionPage();
			fsp.clickOnContinue();
			fsp.EnterFandMname("Madhumitha");
			fsp.EnterLname("Balasankar");
			fsp.EnterContactnumber("6380058258");
			fsp.EnterEmaiId("madhunila12500@gmail.com");
			fsp.Entercityfield("India");
			fsp.EnterCheckMark();
			fsp.ClickOnContinueButton();
			fsp.ClickOnContinueButton2();

			test.log(LogStatus.PASS, "BookingFlight is Successful");
		} catch (Exception e) {
			test.log(LogStatus.FAIL, "BookingFlight is Failed");
			 String screenShotPath =capture(driver, "screenShotName");
				test.addScreenCapture(addScreenShot(driver,screenShotPath));
		}

	}
}