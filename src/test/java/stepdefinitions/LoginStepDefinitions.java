package stepdefinitions;

import java.util.List;

import com.qa.factory.DriverFactory;
import com.qa.pages.HomePage;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LoginStepDefinitions {
	
	HomePage homePage = new HomePage(DriverFactory.getDriver());

	@Given("I want to load DemoQA page")
	public void i_want_to_load_demo_qa_page() {
		homePage.loadSiteURL();
	}

	@When("The page got loaded")
	public void the_page_got_loaded() {
		homePage.validateHeaderImage();
	}

	@Then("Validate the box present at first")
	public void validate_the_box_present_at_first(DataTable cardValues) {
		List<String> values = cardValues.asList();
		homePage.validatePageFields(values);
	}

}
