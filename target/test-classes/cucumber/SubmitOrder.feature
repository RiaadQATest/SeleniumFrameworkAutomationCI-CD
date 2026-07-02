
@tag
Feature: Purchase the order from the Ecommerce Website
I want to use this template for my feature file

	Background:
	Given I landed on Ecommerce Page 

	@Regression
	Scenario Outline: Positive test of Submitting the order
		
		Given Logged in with username <name> and password <password>
		When I add product <productName> to Cart
		And Checkout <productName> and submit the order
		Then "THANKYOU FOR THE ORDER." message is displayed on ConfimationPage
		
		Examples:
			| name               | password | productName |
			| Riaad001@gmail.com | Ro#49014 | ZARA COAT 3 |