package basedriver;

import java.util.concurrent.TimeUnit;

import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import com.relevantcodes.extentreports.LogStatus;

import utils.selenium.Utils;



public class BaseClass extends Utils {
	
	@BeforeSuite
	public void TestInitializer() {
		extentreportStarter();
		
	}

	@BeforeMethod
	public void startup() throws Exception  {

		getpropvalue();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		

	}

	@AfterMethod()
	public void testCloserIT(ITestResult result) throws Exception {

		if (result.getStatus() == ITestResult.FAILURE) {
			 String screenShotPath =capture(driver, "screenShotName");
			test.log(LogStatus.FAIL, result.getThrowable());
			test.addScreenCapture(addScreenShot(driver,screenShotPath));
			System.out.println("Completed");
			
			
		}

		driver.close();
		driver.quit();

	}

	@AfterSuite
	public void FinalTest() {
		extentReportFinisher();
		
	}


}