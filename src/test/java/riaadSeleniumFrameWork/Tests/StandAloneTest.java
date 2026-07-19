package riaadSeleniumFrameWork.Tests;



import static org.testng.Assert.assertEquals;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.HashMap;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
import riaadSeleniumFrameWork.TestComponents.BaseTest;
import riaadSeleniumFrameWork.pageObject.CartPage;
import riaadSeleniumFrameWork.pageObject.CheckoutPage;
import riaadSeleniumFrameWork.pageObject.ConfirmationPage;
import riaadSeleniumFrameWork.pageObject.LandingPage;
import riaadSeleniumFrameWork.pageObject.OrderPage;
import riaadSeleniumFrameWork.pageObject.ProductCatalogue;


public class StandAloneTest extends BaseTest{

	String productName="ZARA COAT 3";
	
	@Test (dataProvider="getData",groups= {"Purchase"})
	public void standAloneTest(HashMap<String,String>input) throws InterruptedException, IOException {
		
	/*//System.setProperty("webdriver.chrome.driver", "C:\\Users\\riaad\\OneDrive\\Documents\\chromedriver.exe");
	WebDriverManager.chromedriver().setup();
	WebDriver driver= new ChromeDriver();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	driver.manage().window().maximize();
	//driver.get("https://rahulshettyacademy.com/client/#/dashboard/dash");

	LandingPage landingPage=new LandingPage(driver); //LandingPage class
	landingPage.goTo();
	*/
	//LandingPage landingPage=launchApplication();
	ProductCatalogue productCatalogue=landingPage.loginApplication(input.get("email"),input.get("password"));
	productCatalogue.waitforElementsToAppear(By.cssSelector(".mb-3"));
	//ProductCatalogue productCatalogue=new ProductCatalogue(driver); //ProductCatalogue Class
	List <WebElement>products= productCatalogue.getProductList();
	productCatalogue.addProductToCart(input.get("productName"));
	CartPage cartPage=productCatalogue.goToCartPage();
	//CartPage cartPage=new CartPage(driver);
	Boolean match=cartPage.verifyProductDisplay(input.get("productName"));
	Assert.assertTrue(match);
	CheckoutPage checkoutPage= cartPage.goToCheckOut();
	checkoutPage.selectCountry("india");
	ConfirmationPage confirmationPage= checkoutPage.submitOrder();
	String confirmMessage= confirmationPage.getConfirmationMessage();
	Assert.assertTrue(confirmMessage.equalsIgnoreCase("THANKYOU FOR THE ORDER."));
//	driver.quit();

	
//	LandingPage class
	/*driver.findElement(By.id("userEmail")).sendKeys("riaad001@gmail.com");
	driver.findElement(By.id("userPassword")).sendKeys("Ro#49014");
	driver.findElement(By.id("login")).click();
	*/
	
	//ProductCatalogue Class
//WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(10));
	//wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div.mb-3")));
//	List<WebElement> products= driver.findElements(By.cssSelector("div.mb-3"));
	
	//ProductCatalogue Class
//	WebElement prod= products.stream().filter(product-> 
	//product.findElement(By.cssSelector("b")).getText().equals(productName)).findFirst().orElse(null);
	
//	prod.findElement(By.cssSelector(".card-body button:last-of-type")).click();
	
//	waits in AbstractComponent Class added to ProductCatalogue Class methods
//	wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#toast-container")));
	
	//wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector(".ng-animating")));
//	wait.until(ExpectedConditions.invisibilityOf(driver.findElement(By.cssSelector(".ng-animating"))));
	//Thread.sleep(3000);
	
	
	//ProductCatalogue Class gotocartpage method
	//driver.findElement(By.cssSelector("[routerlink*='cart']")).click();
	
	//List<WebElement> cartProducts= driver.findElements(By.cssSelector(".cartSection h3"));
	//Boolean match= cartProducts.stream().anyMatch(cartProduct->cartProduct.getText().equalsIgnoreCase(productName));	
	//Assert.assertTrue(match);
	//driver.findElement(By.cssSelector(".totalRow button")).click();
	
//	Actions a= new Actions(driver);
	//a.sendKeys(driver.findElement(By.cssSelector("[placeholder='Select Country']")), "India").build().perform();
	//wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".ta-results")));

//	driver.findElement(By.xpath("(//button[contains(@class,'ta-item')])[2]")).click();
	//driver.findElement(By.cssSelector(".action__submit")).click();
	//	String confirmMessage= confirmationPage.getConfimationMessage();
	//String confirmMessage= driver.findElement(By.cssSelector(".hero-primary")).getText();
	//Assert.assertTrue(confirmMessage.equalsIgnoreCase("THANKYOU FOR THE ORDER."));
	//driver.quit();

	}

	@Test (dependsOnMethods= {"standAloneTest"})
	public void OrderHistoryTest()
	
	{
		String productName="ZARA COAT 3";
		ProductCatalogue productCatalogue=landingPage.loginApplication("riaad001@gmail.com", "Ro#49014");
		productCatalogue.waitforElementsToAppear(By.cssSelector(".mb-3"));
		OrderPage orderPage=productCatalogue.goToOrdersPage();
		Assert.assertTrue(orderPage.VerifyOrderDisplay(productName));
	}
	
	
	//Extent Reports
	
	@DataProvider
	public Object[][] getData() throws IOException
	{
/*		HashMap<String,String> map= new HashMap<String,String>();
		map.put("email", "anshika@gmail.com");//check email
		map.put("password", "Iamking@000");
		map.put("productName", "ADIDAS ORIGINAL");
		
		HashMap<String,String> map1= new HashMap<String,String>();
		map1.put("email", "riaad001@gmail.com");
		map1.put("password", "Ro#49014");
		map1.put("productName", "ZARA COAT 3");
	*/	
		List<HashMap<String,String>>data=getJsonDataToMap(System.getProperty("user.dir")+"\\src\\test\\java\\riaadSeleniumFrameWork\\data\\PurchaseOrder.json");	
		return new Object [] [] {{data.get(0)},{data.get(1)}};
	
	
	}
	
	
}
