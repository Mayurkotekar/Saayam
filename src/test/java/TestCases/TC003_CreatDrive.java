package TestCases;

import org.testng.annotations.Test;

import pageObjects.CreateDrive;
import pageObjects.HomePage;
import testBase.BaseClass;

public class TC003_CreatDrive extends BaseClass {
	
	@Test(groups="CreaDrive")
	public void Create_Drive() throws InterruptedException
	{
		
		
		HomePage hp=new HomePage(driver);
		hp.clickSignIn();
		hp.setPhoneNumber("9359483162");
		hp.clickNextSignin();
		hp.setOTP("123456");
		hp.clickMySaayamHeader();
		
		CreateDrive cdrive= new CreateDrive(driver);
		
		Thread.sleep(5000);
		cdrive.clictabDrive();
		Thread.sleep(5000);
		cdrive.clickbtnStart();
		cdrive.clickbtnSubmit();
		cdrive.clickfldDriveType();
		cdrive.selectfldDriveType();
		cdrive.setdDriveName("Drive"+randomeString().toUpperCase());
		cdrive.setdRadioSuitable();
		cdrive.setstartdate();
		DateSelection(CurrentDate(), CurrentMonth());
		cdrive.clickOK();
		Thread.sleep(5000);
		cdrive.setEnddate();
		DateSelection("17", "July");
		cdrive.clickOK();
		
	}
	

}
