package pageObjects;

import org.openqa.selenium.By;

public class HomePage {	
	
		public static By page_header=By.xpath("//a//span[@class='header-logo-text']");
		//search item
		public static By search_link=By.id("quick-search-expand");
		public static By search_box=By.id("nav-quick-search");
		public static By search_results=By.xpath("//a//div[@class='card-img-container']//img");
		public static By results_title=By.xpath("//div//h3[@class='card-title']//a");
		public static By select_item=By.xpath("//div//h3[@class='card-title']//a");
		
		//cart related elements
		public static By add_to_cart=By.xpath("//div//a[@class='button button--small card-figcaption-button']");
		public static By cart_link=By.xpath("//a//span[@class='navUser-item-cartLabel']");
		public static By checkout_link=By.xpath("//div//a[@class='button button--primary']");
		
		//checkout page
		public static By email_textbox=By.xpath("//div//input[@class='form-input optimizedCheckout-form-input']");
		public static By email_continue=By.xpath("//div//button[@class='button customerEmail-button button--primary optimizedCheckout-buttonPrimary']");
		public static By continueAsGuest=By.xpath("//div//a[@class='button optimizedCheckout-buttonSecondary']");
		public static By privacy_policy_checkbox=By.xpath("//div//input[@class='form-checkbox optimizedCheckout-form-checkbox']");
		public static By first_name=By.xpath("//div//input[@name='shippingAddress.firstName']");
		public static By last_name=By.xpath("//div//input[@name='shippingAddress.lastName']");
		public static By address=By.xpath("//div//input[@name='shippingAddress.address1']");
		public static By city=By.xpath("//div//input[@name='shippingAddress.city']");
		public static By zipCode=By.xpath("//div//input[@name='shippingAddress.postalCode']");
		public static By phNum=By.xpath("//div//input[@name='shippingAddress.phone']");
		public static By shipping_continue=By.xpath("//div//button[@class='button button--primary optimizedCheckout-buttonPrimary']");
		public static By credit_number=By.xpath("//div//input[@name='ccNumber']");
		public static By cvv=By.xpath("//div//input[@name='ccCvv']");
		public static By credit_name=By.xpath("//div//input[@name='ccName']");
		public static By credit_expiry=By.xpath("//div//input[@name='ccExpiry']");
		public static By place_order=By.xpath("//div//button[@class='button button--action button--large button--slab optimizedCheckout-buttonPrimary']");
		
		//order confirmation
		//public static By order_confirmation=By.xpath("//section[@class='orderConfirmation-section']//p//span");
		//public static By order_confirmation=By.xpath("//div[@class='orderConfirmation']//h1[@class='optimizedCheckout-headingPrimary']");
		public static By order_confirmation=By.xpath("//article//header//h3[@class='cart-title optimizedCheckout-headingSecondary']");
}
