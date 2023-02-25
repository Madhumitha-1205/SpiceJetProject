package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utils.selenium.Utils;

public class OneWayPage extends Utils {

	@FindBy(xpath = "(//input[@autocapitalize='sentences'])[1]")
	WebElement origin;

	@FindBy(xpath = "(//input[@autocapitalize='sentences'])[2]")
	WebElement destination;

	@FindBy(xpath = "//div[@class='css-76zvg2 css-bfa6kz r-homxoj r-ubezar'][1]")
	WebElement departuredate;

	@FindBy(xpath = "(//div[@class='css-1dbjc4n r-1awozwy r-1pi2tsx r-1777fci r-13qz1uu'])[70]")
	WebElement currentmonth;

	@FindBy(xpath = "//div[@data-testid='home-page-flight-cta']")
	WebElement searchflight;

	public OneWayPage() {

		PageFactory.initElements(driver, this);
	}

	public void EnterOrigin(String town) {
		origin.sendKeys(town);
	}

	public void EnterDestination(String city) {
		destination.sendKeys(city);

	}

	public void Date() {
		departuredate.click();
		currentmonth.click();

	}

	public void Searchflight() {
		searchflight.click();
	}
}