package riaadSeleniumFrameWork.pageObject;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import riaadSeleniumFrameWork.AbstractComponent.AbstractComponent;

public class ProductCatalogue extends AbstractComponent  {
	WebDriver driver;
	
	public ProductCatalogue(WebDriver driver)
	{
		super (driver);
		this.driver=driver;
	//	PageFactory.initElements(driver, this);
			}
	//List<WebElement> products= driver.findElements(By.cssSelector("div.mb-3"));
	//PageFactory
	@FindBy (css=".ng-animating")
	WebElement spinner;
	
	//wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#toast-container")));
By productsBy = By.cssSelector("div.mb-3");
By productNameBy = By.cssSelector("h5 b");
By addToCart=	By.cssSelector(".card-body button.btn.w-10");
By toastMessage= 	By.cssSelector("#toast-container");
//By productVisibility= By.cssSelector("h5.card-title");

	public List<WebElement> getProductList() throws InterruptedException
	{
		waitForElementToAppear(productsBy);
		return driver.findElements(By.cssSelector("div.mb-3"));
		}
	
	public WebElement getProductByName (String productName) throws InterruptedException
	
	{
	//	waitForvisibilityElementLocated (productVisibility);
		
		return getProductList().stream().filter(product-> 
		product.findElement(productNameBy).getText().equalsIgnoreCase(productName)).findFirst().orElse(null);
	//return prod;
	}
	
	public void addProductToCart(String productName) throws InterruptedException
	
	{
		WebElement prod=getProductByName(productName);
		prod.findElement(addToCart).click();	
		waitForElementToAppear(toastMessage);
		waitForElementToDisappear(spinner);
	}
}
