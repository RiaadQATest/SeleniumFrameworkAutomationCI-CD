package riaadSeleniumFrameWork.AbstractComponent;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import riaadSeleniumFrameWork.pageObject.CartPage;
import riaadSeleniumFrameWork.pageObject.OrderPage;

public class AbstractComponent {

	WebDriver driver;
	WebDriverWait wait;
	
	
	public AbstractComponent(WebDriver driver) {
		this.driver=driver;
		this.wait= new WebDriverWait (driver, Duration.ofSeconds(30));
		PageFactory.initElements(driver, this);
	}
@FindBy (css="[routerlink*='cart']")
WebElement cartHeader;

@FindBy (css="[routerlink*='myorders']")
WebElement orderHeader;

public void waitForElementToAppear (By locator)
	
	{
	//WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(15));// this code is repeated need to handle it better
	wait.until(ExpectedConditions.visibilityOfElementLocated(locator));

	
	}

public void waitForWebElementToAppear (WebElement element)
	
	{
	//WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(15));
	wait.until(ExpectedConditions.visibilityOf(element));

	
	}
public void waitforElementsToAppear (By locator)
{

//WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(15));
wait.until(ExpectedConditions.visibilityOfElementLocated(locator));

}
	
	public CartPage goToCartPage ()
	{
		
		waitForWebElementToAppear(cartHeader);
		
		cartHeader.click();
		return new CartPage(driver);
		
	}
	
	public OrderPage goToOrdersPage ()
	{
		waitForWebElementToAppear(orderHeader);
		orderHeader.click();
		return new OrderPage(driver);
		
	
	}
	
	public void waitForElementToDisappear (WebElement element)

	
	{
	//WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(15));
	wait.until(ExpectedConditions.invisibilityOf(element));
	
	}

	
	
}
