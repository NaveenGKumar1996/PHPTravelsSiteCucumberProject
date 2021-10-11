package testrunner;

import org.testng.annotations.DataProvider;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features = { "src/test/resources/features" }, glue = { "stepdefinitions", "WebHooks" }, plugin = {
		"pretty", "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:" }, monochrome = true

)
public class ToolsQATest extends AbstractTestNGCucumberTests {

	@DataProvider(parallel = true)
	public Object[][] scenarios() {
		return super.scenarios();
	}
}
