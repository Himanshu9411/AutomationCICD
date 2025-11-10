@tag
Feature: Purchase the order from E-commerce WebSite
Background:
Given I Landed on E-Commerce Page

@Regression
Scenario Outline: Positive Test for Submitting the order

	Given Logged in with <userName> and <password>
	When I add <productName> to Cart
	And  Checkout <productName> and submit the order
	Then "THANKYOU FOR THE ORDER." message is displayed on ConfirmationPage
	
	Examples:
	
	| userName          | password | productName |
	| rana1@gmail.com 	| P@ssw0rd | ZARA COAT 3 |