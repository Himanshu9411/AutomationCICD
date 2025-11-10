package rahulshettyacademy.tests;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import rahulshettyacademy.TestComponents.BaseTest;
import rahulshettyacademy.TestComponents.Retry;
import rahulshettyacademy.pageobjects.CartPage;
import rahulshettyacademy.pageobjects.ProductCatalogue;

public class ErrorValidation extends BaseTest {

	@Test(groups = {"ErrorHandling"})
	public void LoginErrorValidation() throws IOException {
		// Login user
		landingPage.loginApplication("rana1@gmail.com", "P@styrd");
		Assert.assertEquals("Incorrect email or password.", landingPage.getErrorMessage());

		// aria-label="Incorrect email or password."

	}
	
	@Test(retryAnalyzer = Retry.class)
	public void ProductErrorValidation() throws IOException
	{
	String productName = "ZARA COAT 3";
	ProductCatalogue productCatalogue = landingPage.loginApplication("rana1@gmail.com", "P@ssw0rd");
	List<WebElement> products = productCatalogue.getProductList();
	productCatalogue.addProductToCart(productName);
	CartPage cartPage = productCatalogue.goToCartPage();
	Boolean match = cartPage.VerifyProductDisplay(productName);
	Assert.assertTrue(match);
	
}

}
