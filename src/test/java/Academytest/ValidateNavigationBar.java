package Academytest;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import resources.Base;
import pageObjects.LandingPage;
import pageObjects.LoginPage;

public class ValidateNavigationBar extends Base  {
	
	public WebDriver driver;
	public static Logger log =LogManager.getLogger(Base.class.getName());
	
	@BeforeTest
	public void initialization() throws IOException {
		
		driver=initializeDriver();
		log.info("drive is initialized");
		driver.get(prop.getProperty("url"));
		log.info("Navigated to home page");
		driver.manage().window().maximize();
		
	}
	
	
	
	@Test
	public void basePageNavigation() throws IOException
	{
		
		
		
		LandingPage l = new LandingPage(driver);
		Assert.assertTrue(l.getNavbar().isDisplayed());
		
		//*[@id="homepage"]/header/div[2]/div/nav
		
		log.info("Succssfully validated");
		
	}
	
	@AfterTest
	public void tearDown()
	{
		driver.quit();
		
	}

	
	
	

}
