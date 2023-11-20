package RSA.pageobjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import RSA.AbstractComp.AbstractComp;

public class RemoveOrder extends AbstractComp{

	WebDriver driver;
	//constructor
	public RemoveOrder(WebDriver driver)
	{
		super(driver);
		//initialization
		this.driver=driver;
		PageFactory.initElements(driver, this);
		
	}
	
	@FindBy(className = "btn btn-custom")
	WebElement Orders;
	
	@FindBy(xpath = "//tbody/tr[1]/td[1]")
	WebElement Product;
	
		
	
		
	
	public void RemoveOrder() {
		
		
			Orders.click();
			Product.clear();				
		
		
		
	}



}
