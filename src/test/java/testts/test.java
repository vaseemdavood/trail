package testts;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import Abstractcomponents.Basictest;
import junit.framework.Assert;
import pageobjects.Checkout;
import pageobjects.Landingpage;
import pageobjects.Orderpage;
import pageobjects.Productcatalogue;
import pageobjects.Submitorder;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.By.ByCssSelector;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
public class test extends Basictest{
	String Productname="ZARA COAT 3";
@Test
	public void execute() throws IOException {
		// TODO Auto-generated method stub
				
		Productcatalogue productcatalogue=landing.log("kuttanpilla@aaro.com","Open@123");
		List<WebElement> items=productcatalogue.getproductlist();	
		//WebElement dhu=productcatalogue.getproduct(Productname);	
		Submitorder submit=productcatalogue.addtoCart(Productname);
		Boolean check=submit.productmatching(Productname);
		Assert.assertTrue(check);
		Checkout checkout=submit.buttonclick();
		String message=checkout.filling("India");
		Assert.assertTrue(message.equalsIgnoreCase("Thankyou for the order."));
		System.out.println(message);
		
	
	}
@Test(dependsOnMethods={"execute"})

public void verify()
{
	Productcatalogue productcatalogue=landing.log("kuttanpilla@aaro.com","Open@123");
	Orderpage ordr=productcatalogue.orderbutton();
	Assert.assertTrue(ordr.ordermatching(Productname));
}







}
