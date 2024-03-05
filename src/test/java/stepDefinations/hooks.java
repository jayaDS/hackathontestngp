package stepDefinations;

import java.io.IOException;
import java.util.Properties;

//import org.openqa.selenium.OutputType;
//import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;
import org.testng.annotations.Parameters;

import basepackage.basic;
//import io.cucumber.java.*;

public class hooks {

	WebDriver driver;
	Properties p;
	
	@BeforeTest
	@Parameters({"browser"})
	public void setup(String br)throws IOException
	{
		p=basic.getProperties();
					basic.initilizeBrowser(br);
					driver=basic.getDriver();
			
			
	 
		
		
		driver.get(p.getProperty("appURL"));
		driver.manage().window().maximize();
	}
	
	@AfterTest
	public void close()
	{
		driver.quit();
	}
	
//	@AfterStep
//	public void addScreenshot(Scenario scenario)
//	{
//		if(scenario.isFailed())
//		{
//			TakesScreenshot ts=(TakesScreenshot)driver;
//			byte[] screenshot=ts.getScreenshotAs(OutputType.BYTES);
//			scenario.attach(screenshot, "image/png", scenario.getName());
//		}
//		
//		
//	}
	
	
	
}
