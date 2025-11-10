package rahulshettyacademy.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import rahulshettyacademy.AbstractComponents.AbstractComponents;

public class LandingPage extends AbstractComponents{
	
	WebDriver driver;
	
	public LandingPage(WebDriver driver) {
		
		super(driver);
		this.driver =driver;
		PageFactory.initElements(driver, this);
	}

	//WebElement userEmails = driver.findElement(By.id("userEmail"));
	
	// Page factory
	@FindBy(id = "userEmail")
	private WebElement userEmail;
	
//	driver.findElement(By.id("userPassword")).sendKeys("P@ssw0rd");
	@FindBy(id = "userPassword")
	private WebElement userPassword;
	
//	driver.findElement(By.id("login")).click();
	@FindBy(id = "login")
	private WebElement submit;
	
	@FindBy(xpath = "//div[@aria-label='Incorrect email or password.']")
	private WebElement errorMessage;
	
	
	
	public ProductCatalogue loginApplication(String email, String password) {
		
		
		userEmail.sendKeys(email);
		userPassword.sendKeys(password);
		submit.click();
		ProductCatalogue productCatalogue = new ProductCatalogue(driver);
		
		return productCatalogue;
		
	}
	
	public void goTo() {
		
		driver.get("https://rahulshettyacademy.com/client");
	}
	
	public String getErrorMessage()
	{
		waitForElementToAppear(errorMessage);
		return errorMessage.getText();
		
		
	}



	}


