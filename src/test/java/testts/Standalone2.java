package testts;

import java.time.Duration;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import junit.framework.Assert;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.By.ByCssSelector;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
public class Standalone2 {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		String need="ZARA COAT 3";
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.get("https://rahulshettyacademy.com/client");
		driver.findElement(By.id("userEmail")).sendKeys("kuttanpilla@aaro.com");
		driver.findElement(By.id("userPassword")).sendKeys("Open@123");
		driver.findElement(By.id("login")).click();

		WebDriverWait w=new WebDriverWait(driver,Duration.ofSeconds(4));
		w.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".mb-3")));
		List<WebElement> items=driver.findElements(By.cssSelector(".mb-3"));
		
		
		WebElement dhu=items.stream().filter(s->s.findElement(By.cssSelector("b")).getText().equals(need)).findFirst().orElse(null);
		dhu.findElement(By.cssSelector(".card-body button:last-of-type")).click();
		
		
		//WebDriverWait w=new WebDriverWait(driver,Duration.ofSeconds(4));
		w.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#toast-container")));
		w.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector(".ngl-animating")));
		driver.findElement(By.cssSelector("[routerlink*='cart']")).click();	
		List<WebElement> purchased=driver.findElements(By.xpath("//*[@class='cartSection']/h3"));		
		Boolean check=purchased.stream().anyMatch(s->s.getText().equalsIgnoreCase(need));
		Assert.assertTrue(check);
		
		Actions a=new Actions(driver);
		WebElement butt=driver.findElement(By.cssSelector(".totalRow button"));
		a.moveToElement(butt).build().perform();
		butt.click();
		
		
		WebElement form=driver.findElement(By.cssSelector(".form-group input"));
		
		a.sendKeys(form, "India").build().perform();
		w.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".ta-results")));
		driver.findElement(By.cssSelector(".ta-item:nth-of-type(2)")).click();
		a.moveToElement(driver.findElement(By.cssSelector(".action__submit"))).build().perform();
		driver.findElement(By.cssSelector(".action__submit")).click();
		String message=driver.findElement(By.cssSelector(".hero-primary")).getText();
		Assert.assertTrue(message.equalsIgnoreCase("Thankyou for the order."));
		
		
		
		
		driver.quit();
		
		
		
		
		
		
		
		
		
		
		//driver.close();
	}

}
