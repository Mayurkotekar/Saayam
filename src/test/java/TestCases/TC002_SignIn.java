package TestCases;

import org.testng.annotations.Test;

import pageObjects.HomePage;
import testBase.BaseClass;

public class TC002_SignIn extends BaseClass{
	
	@Test(groups={"Sanity","Master"})
	public void verify_SignInTest()
	{
		logger.info("***** Starting TC002_ SignIn****");
	
	HomePage hp=new HomePage(driver);
	hp.clickSignIn();
	hp.setPhoneNumber(p.getProperty("phone"));
	hp.clickNextSignin();
	hp.setOTP(p.getProperty("otp"));
	hp.checkSuccesmsg("Logged in successfully!");
	
	logger.info("***** Finished TC002_ SignIn****");

}
	
}
