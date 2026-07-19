package riaadSeleniumFrameWork.StepDefinitions;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import io.cucumber.java.en.And;
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
	public ConfirmationPage confirmationPage;
	
	@Given ("I landed on Ecommerce Page")
	public void I_landed_on_ecommerce_Page() throws IOException
	{
		// Driver and LandingPage already initialized by Hooks @Before
		// Just verify we're on the landing page
		if (landingPage == null) {
			landingPage = launchApplication();
		}
	}
	
	@Given ("Logged in with username {word}@{word}.{word} and password {word}#{int}")
	public void logged_in_with_username_and_password(String username1, String username2, String domain, String password, Integer num)
	{
		String fullUsername = (username1 + "@" + username2 + "." + domain).toLowerCase();
		String fullPassword = password + "#" + num;
		productCatalogue=landingPage.loginApplication(fullUsername, fullPassword);
	}
	
	
	@When ("I add product {word} {word} {int} to Cart")
	public void i_add_product_zara_coat_to_cart(String product1, String product2, Integer num) throws InterruptedException, IOException
	
	{
		String productName = product1 + " " + product2 + " " + num;
		try {
			productCatalogue.waitforElementsToAppear(By.cssSelector("div.mb-3"));
		} catch (Exception e) {
			String screenshot = getScreenShot("product_page_after_login", driver);
			System.out.println("Screenshot saved to: " + screenshot);
			System.out.println("Page URL: " + driver.getCurrentUrl());
			System.out.println("Page Title: " + driver.getTitle());
			throw e;
		}
		productCatalogue.addProductToCart(productName);
		
	}
	
	
	@And ("Checkout {word} {word} {int} and submit the order")
	public void checkout_zara_coat_and_submit_the_order (String product1, String product2, Integer num)
	{
		String productName = product1 + " " + product2 + " " + num;
		CartPage cartPage=productCatalogue.goToCartPage();
		
		Boolean match=cartPage.verifyProductDisplay(productName);
		Assert.assertTrue(match);
		CheckoutPage checkoutPage= cartPage.goToCheckOut();
		checkoutPage.selectCountry("india");
		confirmationPage= checkoutPage.submitOrder();
		
	}
	
	
	@Then ("\"(.+)\" message is displayed on ConfirmationPage")
	public void message_displayed_confirmationPage (String string)

	{
		String confirmMessage= confirmationPage.getConfirmationMessage();
		Assert.assertTrue(confirmMessage.equalsIgnoreCase(string));
		//driver.quit();
	}

	// Cucumber expression equivalent (some runners prefer {string})
	@Then("{string} message is displayed on ConfirmationPage")
	public void message_is_displayed_on_confirmation_page(String expected) {
		String confirmMessage = confirmationPage.getConfirmationMessage();
		Assert.assertTrue(confirmMessage.equalsIgnoreCase(expected));
	}

	@Then ("\"(.+)\" message is displayed")
	
	public void something_message_is_displayed(String strArg1)  {
	
		Assert.assertEquals(strArg1 , landingPage.getErrorMessage());
	//	driver.quit();
	}
	
	
	

}

	


