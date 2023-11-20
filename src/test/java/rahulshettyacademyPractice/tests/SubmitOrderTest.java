package rahulshettyacademyPractice.tests;

import java.io.IOException;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import RSA.AbstractComp.AbstractComp;
import RSA.TestComponents.BaseTest;
import RSA.pageobjects.Cart;
import RSA.pageobjects.Checkout;
import RSA.pageobjects.Confirmation;
import RSA.pageobjects.LaunchPage;
import RSA.pageobjects.ProductCat;
import RSA.pageobjects.RemoveOrder;
import RSA.pageobjects.Reselect;
import io.cucumber.messages.types.Product;
import io.github.bonigarcia.wdm.WebDriverManager;
import rahulshettyacademy.pageobjects.CartPage;
import rahulshettyacademy.pageobjects.ConfirmationPage;
import rahulshettyacademy.pageobjects.LandingPage;
import rahulshettyacademy.pageobjects.OrderPage;
import rahulshettyacademy.pageobjects.ProductCatalogue;

public class SubmitOrderTest extends BaseTest{

	
	
	public static void main(String[] args) throws InterruptedException, IOException
	{
		
		String productName = "ZARA COAT 3";
		String productName2 = "ADIDAS ORIGINAL";
		
		
		//Launch the browser  POM model
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		 
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.get("https://rahulshettyacademy.com/client");
		LaunchPage launchpage = new LaunchPage(driver);
		launchpage.goTo();
		ProductCat productCat =  launchpage.loginApplication("g.haritha.k@gmail.com", "Yash@2114");
		driver.manage().window().maximize();
		List<WebElement>products = productCat.getProductList();
		productCat.addProductToCart(productName);
		Thread.sleep(5000);

		Cart cart = productCat.goToCart();
		Thread.sleep(5000);
		Boolean match = cart.VerifyProductDisplay(productName);
		//Assert.assertTrue(match);
		Checkout checkout = cart.goToCheckout();
		checkout.selectCountry("india");
		Confirmation confirmation = checkout.submitOrder();
		String confirmMessage = confirmation.getConfirmationMessage();
		Assert.assertTrue(confirmMessage.equalsIgnoreCase("THANKYOU FOR THE ORDER."));		 
		//driver.close();
		
		
		Reselect reselect = new Reselect(driver);
		List<WebElement>Items = reselect.getProductList();
		reselect.addProduct2toCart(productName2);

		
		
		
		
		
		
		
		
		
		
		
		
		Thread.sleep(5000);
		
		
	
		
		/* //Chcek the ordder hisptiry details 
				
		@Test(dependsOnMethods= {"submitOrder"})
		public void OrderHistoryTest()
		{
			//"ZARA COAT 3";
			ProductCatalogue productCatalogue = landingPage.loginApplication("anshika@gmail.com", "Iamking@000");
			OrderPage ordersPage = productCatalogue.goToOrdersPage();
			Assert.assertTrue(ordersPage.VerifyOrderDisplay(productName));
			
	}
		*/


		 
		
		
		
		//product1.goToCartPage();
		//CartPage cartpage = new CartPage(driver);
		//Boolean match = cartpage.VerifyProductDisplay(productName);
		//Assert.assertTrue(match);
		//cartpage.goToCheckout();
		//checkoutPage.selectcountry("india");
		
		
		
		/* driver.findElement(By.id("userEmail")).sendKeys("g.haritha.k@gmail.com");
		driver.findElement(By.id("userPassword")).sendKeys("Yash@2114");
		driver.findElement(By.id("login")).click(); */
		 
		//Select class name as css selector and search in console/Selectors hub 
		
//WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));

		//driver.manage().window().maximize();
		
		
		//Wait until element is loaded is a common step for all elements
				//wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".mb-3")));
		
		//List<WebElement> products = driver.findElements(By.cssSelector(".mb-3"));
		
		
		//The below is can be written in FORLOOP and if else condition also
		/* WebElement Prod = products.stream().filter(product-> 
		product.findElement(By.cssSelector("b")).getText().equals("ZARA COAT 3")).findFirst().orElse(null);		
		Prod.findElement(By.cssSelector(".card-body button:last-of-type")).click();
		
		
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#toast-container")));
		
		wait.until(ExpectedConditions.invisibilityOf(driver.findElement(By.cssSelector(".ng-animating")))); */
		
		/*driver.findElement(By.cssSelector("[routerlink*='cart']")).click();
		
		List <WebElement> Cartproducts = driver.findElements(By.cssSelector(".cartSelection h3"));		
		//Boolean match = Cartproducts.stream().anyMatch(cartProduct-> 
		//cartProduct.getText().equalsIgnoreCase(ProductName);	
		//Assert.assertTrue(match);
		
		driver.findElement(By.cssSelector(".totalRow button")).click();
				 
		Actions a = new Actions(driver);
		a.sendKeys(driver.findElement(By.cssSelector("[placeholder = 'Select Country']")), "India").build().perform();
		
		//wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".ta-results")));
		
		/*driver.findElement(By.xpath("(//button[contains(@class,'ta-item')])[2]")).click();
		driver.findElement(By.cssSelector(".action__submit")).click();
		
		String confirmMessage = driver.findElement(By.cssSelector(".hero-primary")).getText();
		Assert.assertTrue(confirmMessage.equalsIgnoreCase("THANKYOU FOR THE ORDER."));
	 
		driver.close();*/
		
		
		
		
		
	}

} 
