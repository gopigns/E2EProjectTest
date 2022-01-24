package Academytest;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;


import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;


import resources.Base;
import pageObjects.LandingPage;
import pageObjects.LoginPage;

public class ValidateTitle extends Base  {
	
	public WebDriver driver;
	public static Logger log =LogManager.getLogger(Base.class.getName());
	@BeforeTest
	public void initialization() throws IOException {
		
		driver=initializeDriver();
		driver.get(prop.getProperty("url"));
		driver.manage().window().maximize();
		
	}
	@Test
	public void validateAppTitle() throws IOException
	{
		
		
		
		LandingPage l = new LandingPage(driver);
		Assert.assertEquals(l.getTitle().getText(), "FEATURED COURSE123S");
		log.info("Validate title page");
		
		
	}
	@AfterTest
	public void tearDown()
	{
		driver.quit();
		
	}
	
	

}
