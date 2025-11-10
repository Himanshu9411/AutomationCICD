package rahulshettyacademy.stepDefination;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.testng.Assert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import rahulshettyacademy.TestComponents.BaseTest;
import rahulshettyacademy.pageobjects.CartPage;
import rahulshettyacademy.pageobjects.CheckoutPage;
import rahulshettyacademy.pageobjects.ConfirmationPage;
import rahulshettyacademy.pageobjects.LandingPage;
import rahulshettyacademy.pageobjects.ProductCatalogue;

public class StepDefinationIMPL extends BaseTest {
	public LandingPage landingPage;
	public ProductCatalogue productCatalogue;
	public ConfirmationPage confirmPage;

	@Given("I Landed on E-Commerce Page")
	public void I_landed_on_Ecommerce_Page() throws IOException {

		landingPage = launchApplication();
	}

	@Given("^Logged in with (.+) and (.+)$")
	public void logged_in_with_Usename_Password(String userName, String password) {
		productCatalogue = landingPage.loginApplication(userName, password);

	}

	@When("^I add (.+) to Cart$")
	public void I_add_prduct_to_Cart(String productName) {

		List<WebElement> products = productCatalogue.getProductList();
		// Total Items in Dashboard and adding to cart
		productCatalogue.addProductToCart(productName);
	}

	@When("^Checkout (.+) and submit the order$")
	public void checkout_productName_and_Submit_The_Order(String productName)

	{
		CartPage cartPage = productCatalogue.goToCartPage();

		Boolean match = cartPage.VerifyProductDisplay(productName);
		Assert.assertTrue(match);

		CheckoutPage checkoutPage = cartPage.goToCheckout();

		checkoutPage.SelectCountry("india");
		confirmPage = checkoutPage.SubmitOrder();

	}
	
	@Then("{string} message is displayed on ConfirmationPage")
	public void message_is_displayed_on_ConfirmationPage(String string) {
		
		String confirmMessage = confirmPage.getConfirmMessage();
		Assert.assertTrue( confirmMessage.equalsIgnoreCase(string));
		driver.close();
		
	}
	@Then("{string} message is displayed")
	public void message_is_displayed(String string) {
		
		Assert.assertEquals(string, landingPage.getErrorMessage());
		driver.close();
		
	}

}
