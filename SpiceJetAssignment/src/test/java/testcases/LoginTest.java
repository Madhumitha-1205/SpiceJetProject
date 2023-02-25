package testcases;

import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import basedriver.BaseClass;
import pages.LoginPage;

public class LoginTest extends BaseClass {

	@Test(priority = 1)
	public void LoginwithValidCredentails() throws Exception {

		try {

			test = extent.startTest("ValidCredentials Test", "ValidCredentials Test Results");

			LoginPage lpg = new LoginPage();
			Thread.sleep(3000);
			lpg.clickonLoginOption();
			Thread.sleep(3000);
			lpg.clickonEmailRadiobutton();
			Thread.sleep(3000);
			lpg.enterEmailId("madhunila12500@gmail.com");
			Thread.sleep(3000);
			lpg.enterPassword("Madhu@123");
			Thread.sleep(3000);
			lpg.clickonLoginButton();

			test.log(LogStatus.PASS, "ValidCredentials is Successful");
		} catch (Exception e) {
			test.log(LogStatus.FAIL, "ValidCredentials is Failed");
			 String screenShotPath =capture(driver, "screenShotName");
				test.addScreenCapture(addScreenShot(driver,screenShotPath));
		}

	}

	@Test(priority = 2)
	public void LoginwithInvalidCredentials() throws Exception {

		try {

			test = extent.startTest("InValidCredentials Test", "InValidCredentials Test Results");

			LoginPage lpg = new LoginPage();
			Thread.sleep(3000);
			lpg.clickonLoginOption();
			Thread.sleep(3000);
			lpg.clickonEmailRadiobutton();
			Thread.sleep(3000);
			lpg.enterEmailId("madhunila12500@gmail.com");
			Thread.sleep(3000);
			lpg.enterPassword("Madhu@12345");
			Thread.sleep(3000);
			lpg.clickonLoginButton();
			Thread.sleep(3000);
			lpg.Accountname();

			test.log(LogStatus.PASS, "InValidCredentials is Successful");
		} catch (Exception e) {
			test.log(LogStatus.FAIL, "InValidCredentials is Failed");
			 String screenShotPath =capture(driver, "screenShotName");
				test.addScreenCapture(addScreenShot(driver,screenShotPath));
		}

	}
}