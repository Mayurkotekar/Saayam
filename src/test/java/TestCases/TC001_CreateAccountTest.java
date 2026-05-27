package TestCases;
import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.CreateAccount;
import pageObjects.HomePage;
import testBase.BaseClass;

public class TC001_CreateAccountTest extends BaseClass {

	@Test(groups={"Regression","Master"})
	public void verify_CreateAccount() throws InterruptedException
	{
		logger.info("******* Starting TC001_CreateAccountTest  *******");
	
		try
		{
		
		HomePage hp=new HomePage(driver);
		hp.clickGetStarted();
		hp.clickDonor();
		hp.clickNext1();
		hp.clickOther();
		hp.clickNext2();
		
		CreateAccount crtacco=new CreateAccount(driver);
		
		logger.info("Providing customer details...");
		crtacco.setDisplayName(randomeString().toUpperCase());
		crtacco.setFirstName(randomeString().toUpperCase());
		crtacco.setLastName(randomeString().toUpperCase());
		crtacco.setEmail(randomeString().toLowerCase()+"@gmail.com");
		crtacco.setPhoneNumber("732"+randomeNumber());
		crtacco.setlocation("hyd");
		crtacco.txtlocation();
		crtacco.clickcitiz();
		crtacco.selectcitiz();
		crtacco.clickSave();
		Thread.sleep(5000);
		crtacco.enterOTP("123456");
		crtacco.setEmailOTP("123456");
		crtacco.clickVerify();
		logger.info("Onboarded Successfully");
		}
		catch(Exception e)
		{
			logger.error("Test Failed....");
			logger.debug("Debug logs...");
			Assert.fail();
		}
		
		logger.info("*****Finish TC001_CreateAccountTest  *******");
			
	}
	
}
