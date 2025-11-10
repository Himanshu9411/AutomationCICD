package rahulshettyacademy.tests;

import java.time.Duration;
import java.util.*;

import org.openqa.selenium.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import rahulshettyacademy.pageobjects.LandingPage;


public class StandAloneTest {

	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
		driver.get("https://rahulshettyacademy.com/client");
		LandingPage landinfpage = new LandingPage(driver);
		//Login user
		
		
//		driver.findElement(By.id("userEmail")).sendKeys("rana1@gmail.com");
//		driver.findElement(By.id("userPassword")).sendKeys("P@ssw0rd");
//		driver.findElement(By.id("login")).click();
		
		//Total Items in Dashboard and adding to cart
		
		List<WebElement> products = driver.findElements(By.cssSelector(".card-body"));
		WebElement prod = products.stream().filter(product->
		product.findElement(By.cssSelector("b")).getText().equals("ZARA COAT 3")).findFirst().orElse(null);
		
		prod.findElement(By.cssSelector(".card-body button:last-of-type")).click();
		
		//
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(5));
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("toast-container")));
		
		driver.findElement(By.xpath("//button[@routerlink = '/dashboard/cart']")).click();
		
		//get item list from cart
	    
		List<WebElement> productList = driver.findElements(By.xpath("//*[@Class = 'cartSection']/h3"));
		Boolean match = productList.stream().anyMatch(cartProduct ->cartProduct.getText().equalsIgnoreCase("ZARA COAT 3"));
		Assert.assertTrue(match);
		
		//Checkout
		driver.findElement(By.cssSelector(".totalRow button")).click();
		
		Actions a = new Actions(driver);
		a.sendKeys(driver.findElement(By.xpath("//input[@placeholder='Select Country']")), "india").build().perform();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".ta-results")));
		
	driver.findElement(By.xpath("//button[contains(@class,'ta-item')][2]")).click();
	driver.findElement(By.cssSelector(".action__submit")).click();
	
	String confirmMessage = driver.findElement(By.cssSelector(".hero-primary")).getText();	
	Assert.assertTrue(confirmMessage.equalsIgnoreCase("THANKYOU FOR THE ORDER."));
	driver.close();
				
				
				
		
	
		
		
	}

}
