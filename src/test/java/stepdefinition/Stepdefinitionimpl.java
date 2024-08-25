package stepdefinition;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.WebElement;

import Abstractcomponents.AbstractComponent;
import Abstractcomponents.Basictest;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import junit.framework.Assert;
import pageobjects.Checkout;
import pageobjects.Landingpage;
import pageobjects.Productcatalogue;
import pageobjects.Submitorder;

public class Stepdefinitionimpl extends Basictest{
	
	public Landingpage landing;
	public Productcatalogue productcatalogue;
	public 	Submitorder submit;
	public String message;
	
	@Given("I landed on Ecommerce Page")
	public void I_landed_on_Ecommerce_Page() throws IOException
	{
		landing=launchapplication();
	}
	
	@Given("^Logged in with username (.+) and password (.+)$")
	public void Logged_in_with_username_and_password(String username, String pw)
	{
		productcatalogue=landing.log(username,pw);
	}
	
	@When("^I add product (.+) to Cart$")
	public void I_add_product_to_Cart(String productname)
	{
		List<WebElement> items=productcatalogue.getproductlist();	
		submit=productcatalogue.addtoCart(productname);
	}
	
	@When("^Checkout (.+) and submit the order$")
		public void Checkout_and_submit_the_order(String productname)
		{
			
		Boolean check=submit.productmatching(productname);
		Assert.assertTrue(check);
		Checkout checkout=submit.buttonclick();
		message=checkout.filling("India");
	}
	
	@Then("{string} message is displayed on ConfirmationPage")
	public void THANKYOU_FOR_THE_ORDER_message_is_displayed_on_ConfirmationPage(String string)
	{
		Assert.assertTrue(message.equalsIgnoreCase(string));
		System.out.println(message);
	}
	
	
	
	@Then("{string} message is displayed")
	public void Incorrect_email_or_password_message_is_displayed(String shu)
	{
		System.out.println(landing.geterrormessage());
		Assert.assertEquals(shu, landing.geterrormessage());
	}
}
