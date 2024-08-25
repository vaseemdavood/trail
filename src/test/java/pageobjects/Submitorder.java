package pageobjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Abstractcomponents.AbstractComponent;
import junit.framework.Assert;

public class Submitorder extends AbstractComponent {
	WebDriver driver;

	public Submitorder(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}

	
	  @FindBy(css=".cartSection h3")
	  List<WebElement> purchased;
	  
	  
	  @FindBy(css=".totalRow button")
	  WebElement butt;
//		WebElement butt=driver.findElement(By.cssSelector(".totalRow button"));
	 

	public Boolean productmatching(String Productname) {
		Boolean check = purchased.stream().anyMatch(s -> s.getText().equalsIgnoreCase(Productname));
		return check;
	}
	
	public Checkout buttonclick()
	{
	mousemove(butt);
	butt.click();	
	Checkout checkout=new Checkout(driver);
	return checkout;
	}

}
