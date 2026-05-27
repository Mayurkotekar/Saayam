package testBase;

import java.io.FileReader;
import java.io.IOException;
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.Month;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.logging.log4j.LogManager; //log4j
import org.apache.logging.log4j.Logger;     //log4j
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.chromium.ChromiumDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;



public class BaseClass {

public WebDriver driver;
public Logger logger; // Log4j
public Properties p;

LocalDateTime now = LocalDateTime.now();


	
	@BeforeClass(groups= {"Sanity","Regression","Master"})
	@Parameters({"os","browser"})
	public void setup(String os, String br) throws IOException	
	{
		// Loading config.properties file
		FileReader file=new FileReader("./src//test//resources//config.properties");
		p=new Properties();
		p.load(file);
		
		logger=LogManager.getLogger(this.getClass()); // Log4j
		
		 ChromeOptions options = new ChromeOptions();

		    Map<String, Object> prefs = new HashMap<>();

		    // ❌ Block Notifications
		    prefs.put("profile.default_content_setting_values.notifications", 1);

		    // ✅ Allow Location
		    prefs.put("profile.default_content_setting_values.geolocation", 1);

		    // (Optional) Allow mic if needed
		    prefs.put("profile.default_content_setting_values.media_stream_mic", 1);

		    options.setExperimentalOption("prefs", prefs);

		    switch(br.toLowerCase())
		    {
		    case "chrome" :  driver = new ChromeDriver(options); break;
		    case "edge"   :  driver = new EdgeDriver(); break;
		    case "firefox"   :  driver = new FirefoxDriver(); break;
		    default : System.out.println("Invalid browser name..."); return;
		    }
		    
		    
		    //driver = new ChromeDriver(options);
		    
		 // ✅ Grant permission
		    Map<String, Object> permissionParams = new HashMap<>();
		    permissionParams.put("origin", "https://staging.saayam.com");
		    permissionParams.put("permissions", Arrays.asList("geolocation"));

		    ((ChromiumDriver) driver).executeCdpCommand("Browser.grantPermissions", permissionParams);

		    // ✅ Set fake location (Hyderabad)
		    Map<String, Object> coordinates = new HashMap<>();
		    coordinates.put("latitude", 17.3850);
		    coordinates.put("longitude", 78.4867);
		    coordinates.put("accuracy", 100);

		    ((ChromiumDriver) driver).executeCdpCommand("Emulation.setGeolocationOverride", coordinates);
		    
		    driver.manage().deleteAllCookies();
		    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		    //driver.get("https://staging.saayam.com/");
		    driver.get(p.getProperty("appURL")); // Reading url from perperties file
		    driver.manage().window().maximize();
	}
	
	@AfterClass(groups= {"Sanity","Regression","Master"})
	public void teardown()
	{
		driver.close();
	}
	
	public String randomeString()
	{
		String generatedstring=RandomStringUtils.randomAlphabetic(7);
		return generatedstring;
	}
	
	public String randomeNumber()
	{
		String generatednumber=RandomStringUtils.randomNumeric(7);
		return generatednumber;
	}
	
	public String randomeAlphaNumbric()
	{
		String generatedstring=RandomStringUtils.randomAlphabetic(5); // we use this method when string and number combination need pass on any field like pass.f
		String generatednumber=RandomStringUtils.randomNumeric(3);
		return (generatedstring+"@"+generatednumber);
	}
	
	public String CurrentDate() {
		
		int Current_Date = now.getDayOfMonth();
		
		String TodayDate = String.valueOf(Current_Date);
		return TodayDate;
				
	}
	
	public String CurrentMonth() {
		
		Month Current_Month = now.getMonth();
		
		String ThisMonth = Current_Month.toString();
		
		return ThisMonth;
	}
	
	public void DateSelection(String Date, String Month) {
		
		String CurrentDateandYear =  driver.findElement(By.xpath("//div[contains(@id,'grid-label')]")).getText();
		
		String NextMonth = "//button[contains(@title,'Next month')]";
		
		String DateXpath = "//button[contains(text(),'"+ Date +"')]";
		
		String[] CurrentDateandYearArray = CurrentDateandYear.split(" ");
		
		String CurrentMonth = CurrentDateandYearArray[0];
		
		while(!(CurrentMonth.equalsIgnoreCase(Month))) {
			
			driver.findElement(By.xpath(NextMonth)).click();
			
			CurrentDateandYear = driver.findElement(By.xpath("//div[contains(@id,'grid-label')]")).getText();
			
			 CurrentDateandYearArray = CurrentDateandYear.split(" ");
			
			 CurrentMonth = CurrentDateandYearArray[0];
		}
		
		driver.findElement(By.xpath(DateXpath)).click();		
	}
	
	
}
