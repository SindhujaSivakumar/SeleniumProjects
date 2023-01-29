package runner;

import org.testng.annotations.AfterMethod;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import pageObjects.CommonMethods;

	@CucumberOptions(features = "src/main/java/features", 
					 glue = "stepDefinitions",
					 monochrome = true,
					 publish = true)
	public class Runner extends AbstractTestNGCucumberTests {
		@AfterMethod
		public void postCondition() {
		CommonMethods.browserClose();
		}
	}