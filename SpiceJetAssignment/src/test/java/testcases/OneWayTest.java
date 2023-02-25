package testcases;



import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import basedriver.BaseClass;
import pages.OneWayPage;

public class OneWayTest extends BaseClass {

	@Test
	public void FlightSearch() throws InterruptedException, Exception {

		try {

			test = extent.startTest("OneWay Test", "OneWay Test Results");

			OneWayPage op = new OneWayPage();
			op.EnterOrigin("Hy");
			op.EnterDestination("Pune");
			Thread.sleep(3000);
			op.Date();
			Thread.sleep(3000);
			op.Searchflight();
			Thread.sleep(3000);
			test.log(LogStatus.PASS, "OneWay is Successful");
		} catch (Exception e) {
			test.log(LogStatus.FAIL, "OneWay is Failed");
			 String screenShotPath =capture(driver, "screenShotName");
				test.addScreenCapture(addScreenShot(driver,screenShotPath));
		}
	}
}