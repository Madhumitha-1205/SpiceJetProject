package utils.selenium;

import java.util.Date;
import java.util.Properties;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

import org.apache.commons.codec.binary.Base64;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestListener;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Utils implements ITestListener{

	public static WebDriver driver;
	public static String dateandtime;
	public static ExtentReports extent;
	public static ExtentTest test;
	

	public static void getpropvalue() throws Exception {

		Properties prop = new Properties();
		FileInputStream fs = new FileInputStream(System.getProperty("user.dir") + "//config.properties");
		prop.load(fs);
		String url = prop.getProperty("url");
		String browser = prop.getProperty("browser");
		browserLauncher(browser);

	
		driver.get(url);
         

		
	}
	
	public static void browserLauncher(String browserName) {

		switch (browserName) {
		case "Chrome":
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			ChromeOptions options = new ChromeOptions();
			options.addArguments("disable-notifications");
			break;
		case "FireFox":
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
			FirefoxOptions opt = new FirefoxOptions();
			opt.addArguments("disable-notifications");
			break;
		default:
			System.out.println("No valid options given choosing the default browser");
			driver = new ChromeDriver();
			ChromeOptions opts = new ChromeOptions();
			opts.addArguments("disable-notifications");
		}
		driver.manage().timeouts().implicitlyWait(7, TimeUnit.SECONDS);
		driver.manage().window().maximize();
	}

	public String takeScreenshot(String testName, WebDriver driver) throws Exception {

		File srcScreenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		String screenshotFilePath = System.getProperty("user.dir") + "\\Screenshots\\" + testName + ".png";
		FileUtils.copyFile(srcScreenshot, new File(screenshotFilePath));
		return screenshotFilePath;
	}

	public static void SwitchTab() {
		String parentwindow = driver.getWindowHandle();
		Set<String> windowhandles = driver.getWindowHandles();
		windowhandles.size();

		for (String childwindow : windowhandles) {
			if (!childwindow.contentEquals(parentwindow)) {
				driver.switchTo().window(childwindow);
				break;

			}
		}
	}
	

	public void extentreportStarter() {
		try {
			dateandtime = GetDateandTime();

			extent = new ExtentReports("SpiceJetReport.html", true);
			
			

		} catch (Exception e) {
			System.out.println("Error in ExtentReportStarter : " + e.getMessage());
		}
	}

	private String GetDateandTime() {
		DateFormat dateFormat = null;
		Date date = null;
		try {
			dateFormat = new SimpleDateFormat("yyyyMMddHHmmss");
			date = new Date();
		} catch (Exception e) {
			System.out.println("Error in Getdateandtime : " + e.getMessage());
		}

		return dateFormat.format(date);
	}

	public static boolean jstypetext(WebElement element, String Text, String id) {
		boolean flag = false;
		try {
			try {
				if (waitforme(element, id)) {
					((JavascriptExecutor) driver).executeScript("arguments[0].value='" + Text + "'", element);
					test.log(LogStatus.PASS, id + " creation " + Text);
					flag = true;
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		} catch (Exception e) {

			System.out.println("Error in Typetext : " + e.getMessage());
			test.log(LogStatus.FAIL, "Error in GetUrl : " + e.getMessage());

		}
		return flag;

	}

	public static boolean waitforme(WebElement element, String id) {
		boolean flag = false;

		try {

			WebDriverWait wait = new WebDriverWait(driver, 15);
			wait.until(ExpectedConditions.visibilityOf(element));
		
			
		} catch (Exception e) {
	

		}
		return flag;
	}

	public static void extentReportFinisher() {

		try {
			extent.flush();
		} catch (Exception e) {
			System.out.println("Error in ExtentReportFinisher : " + e.getMessage());
		}
	}
	
	public String addScreenShot(WebDriver d, String imgpath) throws Exception
	{
		String image = "";
		FileInputStream imageFile;
		try
		{
			String dest = System.getProperty("user.dir") +"\\ErrorScreenshots\\"+imgpath+".png";
			File imgfile = new File(capture(d, dest));
			imageFile = new FileInputStream(dest);
            byte imageData[] = new byte[(int) imgfile.length()];
            imageFile.read(imageData);
            byte[] base64EncodedByteArray = Base64.encodeBase64(imageData);
            image = new String(base64EncodedByteArray);
	    }
		catch(Exception e)
		{
			e.printStackTrace();
		}
			return "data:image/png;base64,"+image;
	}
	
	 public static String capture(WebDriver driver,String dest) throws IOException
	    {
	        TakesScreenshot ts = (TakesScreenshot)driver;
	        File source = ts.getScreenshotAs(OutputType.FILE);
	       
	        File destination = new File(dest);
	        FileUtils.copyFile(source, destination);        
	                     
	        return dest;
	    }
	
	
	
	}
	
