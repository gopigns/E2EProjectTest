package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import resources.Base;

public class LandingPage {

	
	public WebDriver driver;
	
	By signin = By.cssSelector("a[href*='sign_in']");
	By title = By.xpath("//h2[contains(text(),'Featured Courses')]");
	By navbar = By.xpath("//*[@id=\"homepage\"]/header/div[2]/div/nav");
	
	
	public LandingPage(WebDriver driver) {
		
		this.driver=driver;
	}

	public WebElement getLogin()
	{
		return driver.findElement(signin);
		
	}
	
	public WebElement getTitle()
	{
		return driver.findElement(title);
		
	}
	
	public WebElement getNavbar()
	{
		return driver.findElement(navbar);
		
	}
}
