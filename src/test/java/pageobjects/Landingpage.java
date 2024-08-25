package pageobjects;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import Abstractcomponents.AbstractComponent;


public class Landingpage extends Abstractcomponents.AbstractComponent {

	WebDriver driver;
	
	public Landingpage(WebDriver driver)
	{
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
		
	}
	@FindBy(id="userEmail")
	WebElement id;
	@FindBy(id="userPassword")
	WebElement pwd;
	@FindBy(id="login")
	WebElement button;
	@FindBy(css=".ng-trigger-flyInOut")
	WebElement error;
	
	
	public Productcatalogue log(String email, String pw)
	{
		//WebElement id=driver.findElement(By.id("userEmail"));
		//WebElement pwd=driver.findElement(By.id("userPassword"));
		//WebElement button=driver.findElement(By.id("login"));
		id.sendKeys(email);
		pwd.sendKeys(pw);
		button.click();
		Productcatalogue productcatalogue=new Productcatalogue(driver);
		return productcatalogue;
	}
	
	
	public void gotos()
	{
		driver.get("https://rahulshettyacademy.com/client");
	}
	

	
	public String geterrormessage()
	{
		return error.getText();
		
		
	}


}
