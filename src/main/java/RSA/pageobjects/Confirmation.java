package RSA.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import RSA.AbstractComp.AbstractComp;
import rahulshettyacademy.AbstractComponents.AbstractComponent;

public class Confirmation extends AbstractComp{

	
	WebDriver driver;

	public Confirmation(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
		

	}
	
	@FindBy(css = ".hero-primary")
	WebElement confirmationMessage;
	
	public String getConfirmationMessage()
	{
		
		Checkout cp = new Checkout(driver);	
		return confirmationMessage.getText();
	}
	
	
}

