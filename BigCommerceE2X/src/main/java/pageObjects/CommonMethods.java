package pageObjects;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import io.github.bonigarcia.wdm.WebDriverManager;

public class CommonMethods {
	public static ChromeDriver driver;

	//Method for launching the url and check if the correct webpage is displayed
	public static void launchMyBigCommerce() {
		//initiating ChromeDriver
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		//Launching MyBigCommerce site
		driver.get("https://cornerstone-light-demo.mybigcommerce.com/");
		//Verifying if MyBigCommerce site is launched
		boolean logo = driver.findElement(HomePage.page_header).isDisplayed();
		if (logo) {
			System.out.println("MyBigCommerce site is launched");
		}
		else {
			System.out.println("MyBigCommerce site is not launched");
		}
	}
	
	//Method for entering the search item and clicking Search button
		public static void searchItem(String itemName) {
			driver.findElement(HomePage.search_link).click();
			driver.findElement(HomePage.search_box).sendKeys(itemName);
			driver.findElement(HomePage.search_box).sendKeys(Keys.ENTER);
		}
	
	//Method for checking search results
	public static void checkResults(String itemName) {
		//validating if the search results are valid
		List<WebElement> title = driver.findElements(HomePage.results_title);
		for(int i = 0; i<=title.size()-1; i++) {		
			//Assert.assertEquals(title.get(i).getText(),itemName);
			Assert.assertTrue(title.get(i).getText().contains(itemName));
		}
	}
	
	//Method for adding item to the cart
	public static void addToCart() {
		WebElement add_cart=driver.findElement(HomePage.add_to_cart);
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		jse.executeScript("arguments[0].click()", add_cart);
	}
	
	//Method for checkout
	public static void checkOut() {
		driver.findElement(HomePage.cart_link).click();
		WebElement checkout=driver.findElement(HomePage.checkout_link);
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		jse.executeScript("arguments[0].click()", checkout);
	}
	
	//Method for entering customer email details
	public static void emailDetails(String mail){
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofMillis(5000));
		wait.until(ExpectedConditions.visibilityOfElementLocated(HomePage.email_textbox));
		driver.findElement(HomePage.email_textbox).sendKeys(mail);	
		WebElement policy=driver.findElement(HomePage.privacy_policy_checkbox);
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		jse.executeScript("arguments[0].click()", policy);
		driver.findElement(HomePage.email_continue).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(HomePage.continueAsGuest));
		boolean continueGuest = driver.findElement(HomePage.continueAsGuest).isDisplayed();
		if (continueGuest){
			driver.findElement(HomePage.continueAsGuest).click();
		}
	}
	
	//Method for entering customer details
	public static void shipping_details(String fname,String lname,String address,String city,String zip,String phnum){
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofMillis(10000));
		wait.until(ExpectedConditions.visibilityOfElementLocated(HomePage.first_name));
		driver.findElement(HomePage.first_name).sendKeys(fname);
		driver.findElement(HomePage.last_name).sendKeys(lname);
		driver.findElement(HomePage.address).sendKeys(address);
		driver.findElement(HomePage.city).sendKeys(city);
		driver.findElement(HomePage.zipCode).sendKeys(zip);
		driver.findElement(HomePage.phNum).sendKeys(phnum);
		wait.until(ExpectedConditions.visibilityOfElementLocated(HomePage.shipping_continue));
		WebElement cont=driver.findElement(HomePage.shipping_continue);
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		jse.executeScript("arguments[0].click()", cont);
	}
	
	//Method for entering credit card details
	public static void credit_details(String credit_num,String expirydt,String name,String cvv){
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofMillis(3000));
		wait.until(ExpectedConditions.visibilityOfElementLocated(HomePage.credit_number));
		driver.findElement(HomePage.credit_number).sendKeys(credit_num);
		driver.findElement(HomePage.credit_expiry).sendKeys(expirydt);
		driver.findElement(HomePage.credit_name).sendKeys(name);
		driver.findElement(HomePage.cvv).sendKeys(cvv);
		WebElement place_order=driver.findElement(HomePage.place_order);
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		jse.executeScript("arguments[0].click()", place_order);
	}
	
	//Method for verifying order confirmation message
	public static void order_confirmation(){
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofMillis(10000));
		wait.until(ExpectedConditions.visibilityOfElementLocated(HomePage.order_confirmation));
		if (driver.findElement(HomePage.order_confirmation).isEnabled()) {
			WebElement confirmation=driver.findElement(HomePage.order_confirmation);
			Assert.assertTrue(confirmation.getText().contains("Order Summary"));
		}
		
	}
	
	//Method to close the browser
	public static void browserClose() {
		driver.close();
	}
}