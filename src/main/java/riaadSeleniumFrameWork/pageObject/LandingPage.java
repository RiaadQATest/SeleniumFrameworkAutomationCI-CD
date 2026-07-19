package riaadSeleniumFrameWork.pageObject;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import riaadSeleniumFrameWork.AbstractComponent.AbstractComponent;

public class LandingPage extends AbstractComponent {
	WebDriver driver;
	
	public LandingPage(WebDriver driver)
	{
		super (driver);
		//initialization
		this.driver=driver;
		PageFactory.initElements(driver, this);	
	}
	//WebElement userEmail= driver.findElement(By.id("userEmail"));
	//PageFactory
	@FindBy (id="userEmail")
	WebElement userEmail;
	
	@FindBy (id="userPassword")
	WebElement passwordEle;
	
	@FindBy (id="login")
	WebElement submit;

	@FindBy (css=".toast-message")
	WebElement errorMessage;
	
	public ProductCatalogue loginApplication (String email,String password)
	{
		userEmail.clear();
		userEmail.sendKeys(email);
		passwordEle.clear();
		passwordEle.sendKeys(password);
		submit.click();
		
		// Wait for product list to appear (successful login) or URL to change away from login
		try {
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
			wait.until(org.openqa.selenium.support.ui.ExpectedConditions.or(
					ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div.mb-3")),
					ExpectedConditions.not(ExpectedConditions.urlContains("login"))
					));
		} catch (Exception e) {
			// Check if there's an error message
			try {
				String errorMsg = getErrorMessage();
				System.out.println("Login failed with error: " + errorMsg);
			} catch (Exception e2) {
				System.out.println("Login failed but no error message found");
			}
			throw e;
		}
		
		ProductCatalogue productCatalogue=new ProductCatalogue(driver); //ProductCatalogue Class
		return productCatalogue;
		}
	
	public  String getErrorMessage ()
	{
		// Try a few common toast/container locators to be robust against UI changes
		By[] locators = new By[] { By.cssSelector(".toast-message"), By.cssSelector("#toast-container"), By.cssSelector("#toast-container .toast-message") };
		for (By loc : locators) {
			try {
				waitForElementToAppear(loc);
				WebElement ele = driver.findElement(loc);
				String txt = ele.getText();
				if (txt != null && !txt.isEmpty()) return txt;
			} catch (Exception ignored) {
				// try next locator
			}
		}
		// fallback: try the field previously wired via PageFactory
		try {
			waitForWebElementToAppear(errorMessage);
			return errorMessage.getText();
		} catch (Exception e) {
			throw new RuntimeException("Error message not found on page", e);
		}
	}
	
	public void goTo ()
	
	{
		
		driver.get("https://rahulshettyacademy.com/client/#/dashboard/dash");
		
	}
	
	
	
	

}
