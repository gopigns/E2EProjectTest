package resources;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.sun.jna.platform.FileUtils;

public class Base {
	
	public WebDriver driver;
	public Properties prop;
	public WebDriver initializeDriver() throws IOException
	{
		
		prop = new Properties();	
		FileInputStream fis = new FileInputStream("E:\\Work\\E2EProjectTest\\src\\test\\java\\data.properties");
		prop.load(fis);
		String browsername = prop.getProperty("browser");
		
		if(browsername.equals("chrome"))	
		{
			System.setProperty("webdriver.chrome.driver", "E:\\softwares\\chromedriver_win32 (3)\\chromedriver.exe");
			driver = new ChromeDriver();
			
			
		}
		else if(browsername.equals("firefox"))
		{
			
		}
		else if(browsername.equals("IE"))
		{
			
		}
		
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		return driver;
	}
	
	public void getScreenShotPath(String testCaseName, WebDriver driver) throws IOException
	{
		TakesScreenshot ts = (TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		String destination = System.getProperty("user.dir")+"\\reports\\" +testCaseName+".png" ;
		org.apache.commons.io.FileUtils.copyFile(source,new File(destination));
		
	}

}


