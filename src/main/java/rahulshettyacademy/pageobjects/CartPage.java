package rahulshettyacademy.pageobjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import rahulshettyacademy.AbstractComponents.AbstractComponents;

public class CartPage extends AbstractComponents {
	
	WebDriver driver;
	
	public CartPage(WebDriver driver) {
		
		super(driver);
		this.driver =driver;
		PageFactory.initElements(driver, this);
	}

	//WebElement userEmails = driver.findElement(By.id("userEmail"));
	
	// Page factory
	@FindBy(css = ".totalRow button")
	private WebElement checkout;
	
	@FindBy(xpath = "//*[@Class = 'cartSection']/h3")
	private List<WebElement> productList;
	 
	public Boolean VerifyProductDisplay(String productName) {
		 
			Boolean match = productList.stream().anyMatch(cartProduct ->cartProduct.getText().equalsIgnoreCase(productName));
			return match;
	 }
	


	public CheckoutPage goToCheckout() {
		
		checkout.click();
		return new CheckoutPage(driver);
		
	}
}
	

