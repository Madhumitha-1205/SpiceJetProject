package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utils.selenium.Utils;

public class ValidationPage extends Utils {

	@FindBy(xpath = "(//div[contains(text(),'check-in')])[1]")
	WebElement checkin;

	@FindBy(xpath = "//div[contains(text(),'flight status')]")
	WebElement flightStatus;

	@FindBy(xpath = "//div[contains(text(),'manage booking')]")
	WebElement manageBooking;

	public ValidationPage() {

		PageFactory.initElements(driver, this);
	}

	public boolean ValidateCheckIn() {

		return checkin.isDisplayed();
	}

	public boolean ValidateFlightStatus() {

		return flightStatus.isDisplayed();
	}

	public boolean ValidateManageBooking() {

		return manageBooking.isDisplayed();
	}

}