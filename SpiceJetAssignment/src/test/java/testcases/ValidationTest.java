package testcases;


import org.testng.Assert;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import basedriver.BaseClass;
import pages.ValidationPage;

public class ValidationTest extends BaseClass {

	@Test(priority = 1)
	public void ValidationOnElement1() throws Exception {

		try {

			test = extent.startTest("Validation of First Element", "Validating 1st Element Test Result");

			ValidationPage vp = new ValidationPage();
			Assert.assertTrue(vp.ValidateCheckIn());
			test.log(LogStatus.PASS, "Validation is Successful");
		} catch (Exception e) {
			test.log(LogStatus.FAIL, "Validation is Failed");
			 String screenShotPath =capture(driver, "screenShotName");
				test.addScreenCapture(addScreenShot(driver,screenShotPath));
		}
	}

	@Test(priority = 2)
	public void ValidationOnElement2() throws Exception {

		try {

			test = extent.startTest("Validation of Second Element", "Validating 2nd Element Test Result");

			ValidationPage vp = new ValidationPage();
			Assert.assertTrue(vp.ValidateFlightStatus());

			test.log(LogStatus.PASS, "Validation is Successful");
		} catch (Exception e) {
			test.log(LogStatus.FAIL, "Validation is Failed");
			 String screenShotPath =capture(driver, "screenShotName");
				test.addScreenCapture(addScreenShot(driver,screenShotPath));
		}
	}

	@Test(priority = 3)
	public void ValidationOnElement3() throws Exception {

		try {

			test = extent.startTest("Validation of Third Element", "Validating 3rd Element Test Result");

			ValidationPage vp = new ValidationPage();
			Assert.assertTrue(vp.ValidateManageBooking());

			test.log(LogStatus.PASS, "Validation is Successful");
		} catch (Exception e) {
			test.log(LogStatus.FAIL, "Validation is Failed");
			 String screenShotPath =capture(driver, "screenShotName");
				test.addScreenCapture(addScreenShot(driver,screenShotPath));
		}
	}
}