package RSA.pageobjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import RSA.AbstractComp.AbstractComp;

public class Reselect extends AbstractComp{

	WebDriver driver;
	//constructor
	public Reselect(WebDriver driver)
	{
		super(driver);
		//initialization
		this.driver=driver;
		PageFactory.initElements(driver, this);
		
	}
	
	@FindBy(css = ".fa-home")
	WebElement Home;
	
	@FindBy(css = ".mb-3")
	List<WebElement> Items;
	
	
		
	
	By productsBy = By.cssSelector(".mb-3");
	By addToCart = By.cssSelector(".card-body button:last-of-type");

	public List<WebElement> getProductList() {
		waitForElementToAppear(productsBy);
		return Items;
	}
	
	
	public WebElement getNewProduct(String productName2)
	
	{		
					Home.click();
					
					WebElement ele = getProductList().stream().filter(Item->
					Item.findElement(By.cssSelector("b")).getText().equals(productName2)).findAny().orElse(null);
					return ele;

		}


	public void addProduct2toCart(String productName2) throws InterruptedException

	{
	WebElement ele = getNewProduct(productName2);
	ele.findElement(addToCart).click();
	
	

	}
	
	
	public void RemoveOrder() {
		
		
		driver.findElement(By.className("btn btn-custom")).click();
		 driver.findElement(By.xpath("//tbody/tr[1]/td[1]")).clear();				
		
		
		
	}



}
