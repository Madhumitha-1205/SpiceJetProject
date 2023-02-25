package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utils.selenium.Utils;

public class Signuppage extends Utils {

	@FindBy(xpath = "(//a[@to='https://spiceclub.spicejet.com/signup'])[1]")
	WebElement signupButton;

	@FindBy(xpath = "//select[@class='form-control form-select ']")
	WebElement title;

	@FindBy(xpath = "//input[@id='first_name']")
	WebElement fname;

	@FindBy(xpath = "//input[@id='last_name']")
	WebElement lname;

	@FindBy(xpath = "//select[@class='form-control form-select']")
	WebElement country;

	@FindBy(xpath = "//input[@id='dobDate']")
	WebElement dob;

	@FindBy(xpath = "//input[@placeholder='+91 01234 56789']")
	WebElement cell;

	@FindBy(xpath = "//input[@id='email_id']")
	WebElement mail;

	@FindBy(xpath = "//input[@id='new-password']")
	WebElement pass;

	@FindBy(xpath = "//input[@id='c-password']")
	WebElement cpass;

	public Signuppage() {

		PageFactory.initElements(driver, this);
	}

	public void Signup() {
		signupButton.click();
	//	test = extent.startTest("Bottom Link", "Validating Bottom Link");
	}

	public void SelectTitle() {
		title.click();
	}

	public void EnterFirstName(String FirstName) {
		fname.sendKeys(FirstName);
	}

	public void EnterLastName(String LastName) {
		lname.sendKeys(LastName);
	}

	public void EnterCountry(String Country) {
		country.sendKeys(Country);
	}

	public void EnterDateob(String Dateob) {
		dob.sendKeys(Dateob);
	}

	public void EnterMobile(String Mobile) {
		cell.sendKeys(Mobile);
	}

	public void EnterEmaiId(String EmailId) {
		mail.sendKeys(EmailId);
	}

	public void EnterPassword(String Pass) {
		pass.sendKeys(Pass);
	}

	public void EnterConpassword(String Cpass) {
		cpass.sendKeys(Cpass);
	}

}
