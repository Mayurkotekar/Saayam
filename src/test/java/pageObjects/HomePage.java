package pageObjects;

import java.time.Duration;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class HomePage extends BasePage {
	
	public HomePage(WebDriver driver)
	{
		super(driver);
	}
	
	@FindBy(xpath="(//button[@id=\"header-signout-btn\"])[2]")
	WebElement linkGetStarted;
	
	@FindBy(xpath="//div[@id='signup-role-donor']")
	WebElement linkDonor;
	
	@FindBy(xpath="//button[@id='signup-role-next']")
	WebElement linkbtnNext;

	@FindBy(xpath="//div[@id='signup-user-fundraiser']")
	WebElement linkSelectOther;
	
	@FindBy(xpath="//button[@id='signup-user-submit-cause']")
	WebElement linkbtnNext2;
	
	@FindBy(xpath="(//button[contains(text(), 'Sign In')])[2]")
	WebElement linkbtnSignIn;
	
	@FindBy(xpath="//div[@id='signin-phone']//input[@placeholder='Enter your number']")
	WebElement txtPhoneNumber;
	
	@FindBy(xpath="//button[@id='signin-next-btn']")
	WebElement linkbtnNextSignin;
	
	@FindBy(xpath="//input[@aria-label='Please enter OTP character 1']")
	WebElement txtOTPSignin;
	
	@FindBy(xpath="(//a[@id='header-tab-my-saayam'])[1]")
	WebElement linkbtnMySaayam;
	
	@FindBy(xpath="//div[text()='Logged in successfully!']")
	WebElement successmsglogin;
	
	
	public void clickGetStarted()
	{
		linkGetStarted.click();
	}
	
	public void clickDonor()
	{
		linkDonor.click();
	}
	
	public void clickNext1()
	{
		linkbtnNext.click();
	}
	
	public void clickOther()
	{
		linkSelectOther.click();
	}
	
	public void clickNext2()
	{
		linkbtnNext2.click();
	}
	
	public void clickSignIn()
	{
		linkbtnSignIn.click();
	}
	
	public void setPhoneNumber(String phn)
	{
		txtPhoneNumber.sendKeys(phn);
	}
	
	public void clickNextSignin()
	{
		linkbtnNextSignin.click();
	}
	
	public void setOTP(String otp)
	{
		txtOTPSignin.sendKeys(otp);
	
	}
	
	public void checkSuccesmsg(String msg)
	{
		String actualmsg=successmsglogin.getText();
		Assert.assertEquals(actualmsg.trim(), msg.trim(),"Logged in successfully!");
	
	}
	
	public void clickMySaayamHeader() {

	    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

	    wait.until(ExpectedConditions.elementToBeClickable(linkbtnMySaayam));

	    ((JavascriptExecutor) driver).executeScript(
	        "arguments[0].click();", linkbtnMySaayam);
	}
}

