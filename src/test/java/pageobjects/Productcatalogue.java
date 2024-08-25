package pageobjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class Productcatalogue extends Abstractcomponents.AbstractComponent {

	WebDriver driver;
	
	
	public Productcatalogue(WebDriver driver)
	{
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
		
	}
	
	@FindBy(css=".mb-3")
	List<WebElement> items;
	
	
	By products=By.cssSelector(".mb-3");
	By addtocartt=By.cssSelector(".card-body button:last-of-type");
	By toast=By.cssSelector("#toast-container");
	By animatingg=By.cssSelector(".ngl-animating");
	public List<WebElement> getproductlist()
	{
		waittoappear(products);
		//List<WebElement> items=driver.findElements(By.cssSelector(".mb-3"));
		return items;
	}
	
	public WebElement getproduct(String Productname)
	{
		WebElement productt=getproductlist().stream().filter(s->s.findElement(By.cssSelector("b")).getText().equals(Productname)).findFirst().orElse(null);
		return productt;
	}
	
	public Submitorder addtoCart(String Productname)
	{
		WebElement dhu=getproduct(Productname);
		dhu.findElement(addtocartt).click();
		waittoappear(toast);
		waittodissapear(animatingg);
		//w.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#toast-container")));
		//w.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector(".ngl-animating")));
		cartbutton();
		
		

		
		Submitorder submit=new Submitorder(driver);
		return submit;
		
	}
	
}
