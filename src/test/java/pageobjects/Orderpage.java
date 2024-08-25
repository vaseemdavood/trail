package pageobjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Abstractcomponents.AbstractComponent;

public class Orderpage extends AbstractComponent {

	
	
	WebDriver driver;
	public  Orderpage(WebDriver driver)
	{
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(css="tr td:nth-child(3)")
	List<WebElement> orderlist;
		//List<WebElement> orderlist=driver.findElements(By.xpath("//tr //td[2]"));
	
	public Boolean ordermatching(String Productname) {
		Boolean check = orderlist.stream().anyMatch(s -> s.getText().equalsIgnoreCase(Productname));
		return check;
	}
	
	
	
}
