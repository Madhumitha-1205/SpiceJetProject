package testcases;



import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import basedriver.BaseClass;
import pages.Signuppage;

public class Signuptest extends BaseClass {

	@Test
	public void Signup() throws Exception {

		try {
			test = extent.startTest("SignUp Test", "SignUp Test Results");
			Signuppage signup = new Signuppage();
			signup.Signup();
			SwitchTab();
			signup.SelectTitle();
			signup.EnterFirstName("Madhumitha");
			signup.EnterLastName("Balasankar");
			signup.EnterCountry("India");
			signup.EnterDateob("12/05/2000");
			signup.EnterMobile("9944112585");
			signup.EnterEmaiId("madhunila12500@gmail.com");
			signup.EnterPassword("Madhu@123");
			signup.EnterConpassword("Madhu@123");
			test.log(LogStatus.PASS, "Signup is Successful");
		} catch (Exception e) {
			test.log(LogStatus.FAIL, "Signup is failed");
			 String screenShotPath =capture(driver, "screenShotName");
				test.addScreenCapture(addScreenShot(driver,screenShotPath));
		}

	}

}