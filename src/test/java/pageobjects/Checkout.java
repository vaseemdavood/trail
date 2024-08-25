package pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import Abstractcomponents.AbstractComponent;

public class Checkout extends AbstractComponent {

	
	WebDriver driver;
	public  Checkout(WebDriver driver)
	{
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(css=".form-group input")
	WebElement form;
	By results=By.cssSelector(".ta-results");
	@FindBy(css=".ta-item:nth-of-type(2)")
	WebElement option;
	@FindBy(css=".action__submit")
	WebElement submitbutton;
	@FindBy(css=".hero-primary")
	WebElement message;
	
	
	
	public String filling(String string)
	{
		sendaction(form,string);
		waittoappear(results);
		option.click();
		mousemove(submitbutton);
		submitbutton.click();
		return message.getText();
//		
//		a.moveToElement(driver.findElement(By.cssSelector(".action__submit"))).build().perform();
//		driver.findElement(By.cssSelector(".action__submit")).click();
	}
	
	
	
}
