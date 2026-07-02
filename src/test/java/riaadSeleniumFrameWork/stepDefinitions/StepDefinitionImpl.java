package riaadSeleniumFrameWork.stepDefinitions;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.testng.Assert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import riaadSeleniumFrameWork.TestComponents.BaseTest;
import riaadSeleniumFrameWork.pageObject.CartPage;
import riaadSeleniumFrameWork.pageObject.CheckoutPage;
import riaadSeleniumFrameWork.pageObject.ConfirmationPage;
import riaadSeleniumFrameWork.pageObject.LandingPage;
import riaadSeleniumFrameWork.pageObject.ProductCatalogue;

public class StepDefinitionImpl extends BaseTest {
	public ProductCatalogue productCatalogue;
	public LandingPage landingPage;
	public ConfirmationPage confirmationPage;
	@Given ("I landed on Ecommerce Page")
	public void I_landed_on_Ecommerce_Page() throws IOException
	{
		landingPage=launchApplication();
	}
	
	
	@Given("^Logged in with username (.+) and password (.+)$")
	public void logged_in_username_and_password(String username, String password)
	{
		productCatalogue=landingPage.loginApplication(username, password);
	}
	
	@When("^i add product (.+) to Cart$")
	public void i_add_product_to_cart(String productName) 
	
	{
		List <WebElement>products= productCatalogue.getProductList();
		productCatalogue.addProductToCart(productName);
	}
	
	@When ("^Checkout (.+) and submit order$")
	public void checkout_and_submit_order(String productName)
	{
		
		CartPage cartPage=productCatalogue.goToCartPage();
		
		Boolean match=cartPage.VerifyPoductDisplay(productName);
		Assert.assertTrue(match);
		CheckoutPage checkoutPage= cartPage.goToCheckOut();
		checkoutPage.selectCountry("india");
		confirmationPage= checkoutPage.submitOrder();
		
	}
	
	
	@Then ("{string} message is displayed on ConfimationPage")
	public void message_displayed_confimationPage (String string)
	
	{
		String confirmMessage= confirmationPage.getConfimationMessage();
		Assert.assertTrue(confirmMessage.equalsIgnoreCase(string));
		driver.close();
	}
	
	@Then ("^\"([^\"]*)\" message is displayed$")
	public void something_message_is_displayed(String strArg1)  {
	
		Assert.assertEquals(strArg1 , landingPage.getErrorMessage());
		driver.close();
	}
	

}

	


