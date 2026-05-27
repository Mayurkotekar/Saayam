package pageObjects;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CreateAccount extends BasePage {
	
	public CreateAccount(WebDriver driver)
	{
		super(driver);
	}
	
	@FindBy(xpath="//input[@id='user-displayname']")
	WebElement txtDisplayName;
	
	@FindBy(xpath="//input[@id='user-first-name']")
	WebElement txtFirstName;
	
	@FindBy(xpath="//input[@id='user-last-name']")
	WebElement txtLastName;

	@FindBy(xpath="//input[@id='user-email']")
	WebElement txtEmail;
	
	@FindBy(xpath="//div[@id = 'user-phone']//input[@placeholder='Enter your number']")
	WebElement txtPhoneNumber;
	
	@FindBy(xpath="//textarea[@id='google-map-demo']")
	WebElement txtLocation;
	
	@FindBy(xpath="//p[text()='Telangana, India']")
	WebElement txtlocation;
	
	@FindBy(xpath="//div[@id='user-country']")
	WebElement clickCitizenship;
	
	@FindBy(xpath="//li[@data-value='IN']")
	WebElement selectCitizenship;
	
	@FindBy(xpath="//*[@id = 'signup-user-save']")
	WebElement btnSave;
		
	@FindBy(xpath="//input[@aria-label='Please enter OTP character 1']")
	WebElement otpBoxes;
	
	@FindBy(xpath="(//input[@aria-label='Please enter OTP character 1'])[2]")
	WebElement txtEmailOTP;
	
	@FindBy(xpath="//button[@id=\"user-verify-otp\"]")
	WebElement btnVerify;
	
	
	
	public void setDisplayName(String dname) {
		txtDisplayName.sendKeys(dname);
	}
	
	public void setFirstName(String fname) {
		txtFirstName.sendKeys(fname);
	}
	
	public void setLastName(String lname) {
		txtLastName.sendKeys(lname);
	}
	
	public void setEmail(String email) {
		txtEmail.sendKeys(email);
	}
	
	public void setPhoneNumber(String pno) {
		txtPhoneNumber.sendKeys(pno);
	}
	
	public void setlocation(String clclocation) {
		txtLocation.sendKeys(clclocation);
	}
	
	public void txtlocation() {
		txtlocation.click();
	}
	
	public void clickcitiz() {
		clickCitizenship.click();
	}
	
	public void selectcitiz() {
		selectCitizenship.click();
	}
	
	public void clickSave() {
		btnSave.click();
	}
		
	public void enterOTP(String otp) {
		otpBoxes.sendKeys(otp);
	}
	  
	public void setEmailOTP(String emailotp) {
		txtEmailOTP.sendKeys(emailotp);
	}
	
	public void clickVerify() {
	    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	    wait.until(ExpectedConditions.elementToBeClickable(btnVerify)).click();
	}
	
}
