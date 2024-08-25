package testts;

import static org.testng.Assert.assertTrue;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import Abstractcomponents.Basictest;
import Abstractcomponents.Retry;
import junit.framework.Assert;
import pageobjects.Checkout;
import pageobjects.Landingpage;
import pageobjects.Productcatalogue;
import pageobjects.Submitorder;

import java.util.HashMap;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.By.ByCssSelector;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
public class Errorvalidation extends Basictest{
	

	//public WebDriver driver;
	
	
@Test(groups= {"error"},dataProvider="getdata")
	public void execute(HashMap<String,String> input) throws IOException {
		// TODO Auto-generated method stub
		String Productname=input.get("product");
		landing.log(input.get("email"),input.get("password"));
		System.out.println(landing.geterrormessage());
		System.out.println(input.get("email")+input.get("password")+"   "+Productname);
		
	}
@Test(dataProvider="getdata")
public void secondassert(HashMap<String,String> input)
{
	String Productname=input.get("product");		
	Productcatalogue productcatalogue=landing.log(input.get("email"),input.get("password"));
	List<WebElement> items=productcatalogue.getproductlist();	
	WebElement dhu=productcatalogue.getproduct(Productname);	
	Submitorder submit=productcatalogue.addtoCart(Productname);
	Boolean check=submit.productmatching("ZARA COAT 3");
	Assert.assertTrue(check);
	System.out.println(input.get("email")+input.get("password")+"  "+Productname);
}

@Test(retryAnalyzer = Retry.class)
public void failtest()
{	
driver.get("https://www.google.com");

Assert.assertTrue(true);
}





@DataProvider
public Object[][] getdata() throws IOException
{
	List<HashMap<String,String>> data=getJsonDataToMap(System.getProperty("user.dir")+"//src//test//java//data//PurchaseOrder.json");
	
	return new Object[][] {{data.get(0)},{data.get(1)}};
}

//@DataProvider
//public Object[][] getdata()
//{
//	return new Object[][] {{"kuttanpilla@aaro.com","Open@123"},{"kuttanpilla@aaro.com","mm@123"}};
//}





//@DataProvider
//public Object[][] getdata()
//{
//	HashMap<Object,Object> map=new HashMap<Object,Object>();
//	map.put("email", "kuttanpilla@aaro.com");
//	map.put("password", "Open@123");
//	map.put("product", "ZARA COAT 3");
//	
//	HashMap<Object,Object> map1=new HashMap<Object,Object>();
//	map1.put("email", "kuttanpilla2@aaro.com");
//	map1.put("password", "Open@123");
//	map1.put("product", "ADIDAS ORIGINAL");
//	
//	return new Object[][] {{map},{map1}};
//}


}





