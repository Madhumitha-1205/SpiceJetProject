package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utils.selenium.Utils;

public class RoundtripPage extends Utils {

	@FindBy(xpath = "(//div[@class='css-1dbjc4n r-zso239'])[2]")
	WebElement roundTrip;

	@FindBy(xpath = "(//input[@autocapitalize='sentences'])[1]")
	WebElement from;

	@FindBy(xpath = "(//input[@autocapitalize='sentences'])[2]")
	WebElement todest;

	@FindBy(xpath = "(//div[@style='font-family: inherit;'])[121]")
	WebElement departuredate;

	@FindBy(xpath = "(//div[@class='css-1dbjc4n r-1awozwy r-18u37iz r-1wtj0ep'])[4]")
	WebElement dateselection;

	@FindBy(xpath = "(//div[@style='font-family: inherit;'])[152]")
	WebElement returndate;

	@FindBy(xpath = "//div[@data-testid='home-page-flight-cta']")
	WebElement searchflight;

	public RoundtripPage() {

		PageFactory.initElements(driver, this);
	}

	public void ClickonRoundTrip() {
		roundTrip.click();
	}

	public void EnterFromOrigin(String Text) {
		from.sendKeys(Text);
	}

	public void EnterToDestination(String Text) {
		todest.sendKeys(Text);
	}

	public void DepartureDate() {

		Actions act = new Actions(driver);
		act.doubleClick(departuredate).perform();

	}

	public void ClickonDate() {
		dateselection.click();
	}

	public void ReturnDate() {
		returndate.click();
	}

	public void Searchflight() {
		searchflight.click();
	}
}