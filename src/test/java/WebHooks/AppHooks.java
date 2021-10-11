package WebHooks;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import com.qa.factory.DriverFactory;
import com.utils.PropUtils;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

public class AppHooks {

	private static DriverFactory driverFactory;
	private static WebDriver driver;

	
	
	@Before
	public void launchBrowser() {
		String url = "https://demoqa.com/";
		String browserName = "chrome";
		driverFactory = new DriverFactory();
		driver = driverFactory.initDriver(browserName, url);
	}

	@After(order = 1)
	public void quit() {
		driver.quit();
	}

	@After(order = 0)
	public void tearDown(Scenario scenario) {
		if (scenario.isFailed()) {
			String scenarioName = scenario.getName();
			byte[] failedScreenShot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
			scenario.attach(failedScreenShot, "image/jpeg", scenarioName);
		} 
	}
}
