package Academytest;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import resources.Base;
import pageObjects.LandingPage;
import pageObjects.LoginPage;

public class HomePage extends Base  {
	public static Logger log =LogManager.getLogger(Base.class.getName());
	public WebDriver driver;
	@BeforeTest
	public void initialization() throws IOException {
		
		driver=initializeDriver();
		
		//driver.manage().window().maximize();
	//	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}
	
	//public WebDriver driver;
	@Test(dataProvider="getData")
	public void basePageNavigation(String username, String password) throws IOException
	{
		
		
		driver.get(prop.getProperty("url"));
		LandingPage l = new LandingPage(driver);
		l.getLogin().click();
		
		LoginPage lp = new LoginPage(driver);
		lp.getEmail().sendKeys(username);
		lp.getPassword().sendKeys(password);
		lp.getLogin().click();
		log.info("Home Page");
		//driver.close();
	}
	
	@AfterTest
	public void tearDown()
	{
		driver.quit();
		
	}
	
	@DataProvider
	public Object[][] getData()
	{
		//Row how many different data types should run
		// how many values per each test
		Object[][] data=new Object[2][2];
		data[0][0]= "nonrestricteduser@we.com";
		data[0][1]= "1234";
		
		data[1][0]="resticteduser@rr.com";
		data[1][1]="1246788";
				
		return data;
				
	}
	
	

}
