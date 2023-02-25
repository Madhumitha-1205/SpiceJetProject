package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utils.selenium.Utils;

public class FlightSelectionPage extends Utils {

	@FindBy(xpath = "//div[@data-testid='continue-search-page-cta']")
	WebElement continuebn;

	@FindBy(xpath = "//input[@data-testid='first-inputbox-contact-details']")
	WebElement fandMname;

	@FindBy(xpath = "//input[@data-testid='last-inputbox-contact-details']")
	WebElement lName;

	@FindBy(xpath = "//input[@data-testid='contact-number-input-box']")
	WebElement contactNum;

	@FindBy(xpath = "//input[@data-testid='emailAddress-inputbox-contact-details']")
	WebElement emailIdField;

	@FindBy(xpath = "//input[@data-testid='city-inputbox-contact-details']")
	WebElement cityfield;

	@FindBy(xpath = "(//div[@class='css-1dbjc4n r-zso239'])[5]")
	WebElement primaryPassengercheck;

	@FindBy(xpath = "//div[@data-testid='traveller-info-continue-cta']")
	WebElement continueButton;

	@FindBy(xpath = "(//div[@data-testid='add-ons-continue-footer-button'])[3]")
	WebElement continueButton2;

	public FlightSelectionPage() {

		PageFactory.initElements(driver, this);
	}

	public void clickOnContinue() {
		continuebn.click();
	}

	public void EnterFandMname(String FandMText) {
		fandMname.sendKeys(FandMText);
	}

	public void EnterLname(String LnameText) {
		lName.sendKeys(LnameText);
	}

	public void EnterContactnumber(String CnumberText) {
		contactNum.sendKeys(CnumberText);
	}

	public void EnterEmaiId(String EmailText) {
		emailIdField.sendKeys(EmailText);
	}

	public void Entercityfield(String cityText) {
		cityfield.sendKeys(cityText);
	}

	public void EnterCheckMark() {
		primaryPassengercheck.click();
	}

	public void ClickOnContinueButton() {
		continueButton.click();
	}

	public void ClickOnContinueButton2() {
		continueButton2.click();
	}

}