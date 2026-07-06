package riaadSeleniumFrameWork.Tests;



import static org.testng.Assert.assertEquals;

import java.io.IOException;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
import riaadSeleniumFrameWork.TestComponents.BaseTest;
import riaadSeleniumFrameWork.TestComponents.Retry;
import riaadSeleniumFrameWork.pageObject.CartPage;
import riaadSeleniumFrameWork.pageObject.CheckoutPage;
import riaadSeleniumFrameWork.pageObject.ConfirmationPage;
import riaadSeleniumFrameWork.pageObject.LandingPage;
import riaadSeleniumFrameWork.pageObject.ProductCatalogue;


public class ErrorValidationsTest extends BaseTest{
	@Test (groups={"ErrorHandling"},retryAnalyzer=Retry.class)
	public void LoginErrorValidation() throws InterruptedException, IOException {
		// TODO Auto-generated method stub

//	String productName="ZARA COAT 3";
	//Changes made to code, user have to update it
	
	landingPage.loginApplication("riaad001@gmail.com", "Ro#49015");
	Assert.assertEquals("Incorrect email or password.", landingPage.getErrorMessage());
	
	}
	
	
	@Test
	public void ProductErrorValidation() throws InterruptedException, IOException {
	// TODO Auto-generated method stub

	String productName="ZARA COAT 3";
	ProductCatalogue productCatalogue=landingPage.loginApplication("riaad001@gmail.com", "Ro#49014");
	//ProductCatalogue productCatalogue=new ProductCatalogue(driver); //ProductCatalogue Class
	List <WebElement>products= productCatalogue.getProductList();
	productCatalogue.addProductToCart(productName);
	CartPage cartPage=productCatalogue.goToCartPage();
	//CartPage cartPage=new CartPage(driver);
	Boolean match=cartPage.VerifyPoductDisplay("ZARA COAT 33");
	Assert.assertFalse(match);
	
	}

}
