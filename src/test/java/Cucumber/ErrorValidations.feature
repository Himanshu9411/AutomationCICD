@tag
Feature: Error Validation



@ErrorValidation
Scenario Outline: Negative Test for Submitting the order
	Given I Landed on E-Commerce Page
	When Logged in with <userName> and <password>
	Then "Incorrect email or password." message is displayed
		
	Examples:
	
	| userName          | password | 
	| rana1@gmail.com 	| P@s56468d | 