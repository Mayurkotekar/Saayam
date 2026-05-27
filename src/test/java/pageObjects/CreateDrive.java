package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CreateDrive extends BasePage{
	
	public CreateDrive(WebDriver driver)
	{
		super(driver);
	}
	
	@FindBy(xpath="//button[@id='mysaayam-drive-tab-2']")
	WebElement linktabDrive;
	
	@FindBy(xpath="//button[@id='createcause-start-btn']")
	WebElement linkStart;
	
	@FindBy(xpath="//button[@id='select-acc-submit']")
	WebElement linkSubmit;
	
	@FindBy(xpath="//div[@id='dynamic-dropdown-drivetype']")
	WebElement drpDriveType;
	
	@FindBy(xpath="//li[text()='A seminar']")
	WebElement selectDriveType;
	
	@FindBy(xpath="//input[@placeholder='Drive Name']")
	WebElement txttDriveName;
	
	@FindBy(xpath="//input[@type='radio' and @value = 'Both']")
	WebElement rdobtnsuaitable;
	
	@FindBy(xpath="//div[contains(@id,'startdatetime')]//button")
	WebElement clickstartdate;
	
	@FindBy(xpath="//button[contains(text(),'OK')]")
	WebElement clickOk;
	
	@FindBy(xpath="//div[contains(@id,'enddatetime')]//button")
	WebElement clickEnddate;
	

	public void clictabDrive()
	{
		linktabDrive.click();
	}
	
	public void clickbtnStart()
	{
		linkStart.click();
	}

	public void clickbtnSubmit()
	{
		linkSubmit.click();
	}
	
	public void clickfldDriveType()
	{
		drpDriveType.click();
	}
	
	public void selectfldDriveType()
	{
		selectDriveType.click();
	}
	
	public void setdDriveName(String drvname)
	{
		txttDriveName.sendKeys(drvname);
	}

	public void setdRadioSuitable()
	{
		rdobtnsuaitable.click();
	}
	public void setstartdate(){
		
		clickstartdate.click();
		
	}
	
	public void clickOK(){
		
		clickOk.click();
		
	}

	public void setEnddate(){
		
		clickEnddate.click();
		
	}


}