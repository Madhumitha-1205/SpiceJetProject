package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utils.selenium.Utils;

public class LoginPage extends Utils {

	@FindBy(xpath = "//div[contains(text(),'Login')]")
	WebElement login;

	@FindBy(xpath = "(//div[@class='css-1dbjc4n r-zso239'])[4]")
	WebElement emailRadioBtn;

	@FindBy(xpath = "(//input[@autocapitalize='sentences'])[3]")
	WebElement enterEmailId;

	@FindBy(xpath = "(//input[@autocapitalize='sentences'])[4]")
	WebElement enterpass;

	@FindBy(xpath = "(//input[@autocapitalize='sentences'])[4]")
	WebElement enterInvPass;

	@FindBy(xpath = "//div[@data-testid='login-cta']")
	WebElement loginbtn;

	@FindBy(xpath = "(//div[@class='css-76zvg2 r-jwli3a r-ubezar r-1ozqkpa'])[1]")
	WebElement accname;

	public LoginPage() {

		PageFactory.initElements(driver, this);
	}

	public void clickonLoginOption() {
		login.click();
	}

	public void clickonEmailRadiobutton() {
		emailRadioBtn.click();
	}

	public void enterEmailId(String Emailtype) {
		enterEmailId.sendKeys(Emailtype);
	}

	public void enterPassword(String PasswordType) {
		enterpass.sendKeys(PasswordType);
	}

	public void enterInvalidPassword(String PasswordType) {
		enterInvPass.sendKeys(PasswordType);
	}

	public void clickonLoginButton() {
		loginbtn.click();
	}

	public void Accountname() {
		accname.click();
	}
}