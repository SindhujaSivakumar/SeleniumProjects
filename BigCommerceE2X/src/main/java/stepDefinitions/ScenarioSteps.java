package stepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.CommonMethods;

public class ScenarioSteps extends CommonMethods {
	@Given("I have a product in my cart")
	public void addItemToCart() {
		launchMyBigCommerce();
		searchItem("Kettle");
		checkResults("Kettle");
		addToCart();
		checkOut();
	}
	
	@When("I complete the checkout process")
	public void checkout() {
		emailDetails("aa5@a.com");
		shipping_details("aaa","bbb","high road","London","IG11ZG","1234554321");
		credit_details("4111 1111 1111 1111","02/27","aaa bbb","123");
	}
	
	@Then("I am presented with a purchase confirmation page for my order")
	public void orderConfirmation(){
		order_confirmation();
	}
}