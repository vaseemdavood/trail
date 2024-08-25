package Abstractcomponents;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import pageobjects.Orderpage;

public class AbstractComponent {
	WebDriver driver;
	public  AbstractComponent(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	
	@FindBy(css="[routerlink*='cart']")
	WebElement cardtbutton;
	
	@FindBy(css="[routerlink*='order']")
	WebElement orderpageb;
	
	public void waittoappear(By findBy)
	{
		WebDriverWait w=new WebDriverWait(driver,Duration.ofSeconds(4));
		w.until(ExpectedConditions.visibilityOfElementLocated(findBy));
	
	}

	public void waittodissapear(By findBy)
	{
		WebDriverWait w=new WebDriverWait(driver,Duration.ofSeconds(4));
		w.until(ExpectedConditions.invisibilityOfElementLocated(findBy));
		
	
	}
	public void cartbutton()
	{
		cardtbutton.click();
	}
	public Orderpage orderbutton()
	{
		orderpageb.click();
		Orderpage orderpage=new Orderpage(driver);
		return orderpage;
	}
	
	
	
	public void mousemove(WebElement element)
	{

		Actions a=new Actions(driver);
		a.moveToElement(element).build().perform();
	}
	public void sendaction(WebElement element, String string)
	{

		Actions a=new Actions(driver);
		a.sendKeys(element, string).build().perform();
	}
}
