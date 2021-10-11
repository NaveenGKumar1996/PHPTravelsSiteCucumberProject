package com.pagebase;

import java.util.List;

import org.apache.log4j.Logger;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.qa.factory.DriverFactory;

public class BasePage extends DriverFactory {

	public WebDriver driver;
	private static final Logger logger = Logger.getLogger(BasePage.class);

	public BasePage() {
		this.driver = DriverFactory.getDriver();
	}

	public void isDisplayedThenGetText(WebElement locator, String expectedText) {
		try {
			locator.isDisplayed();
			String actualText = locator.getText();
			System.out.println(actualText);
		} catch (Exception ex) {
			logger.error(ex.getMessage());
		}
	}

	public void waitUntilElementDisplayed(final WebElement webElement) {

		WebDriverWait wait = new WebDriverWait(driver, 10);

		ExpectedCondition<Boolean> elementIsDisplayed = new ExpectedCondition<Boolean>() {
			public Boolean apply(WebDriver arg0) {
				try {
					webElement.isDisplayed();
					return true;
				} catch (NoSuchElementException e) {
					return false;
				} catch (StaleElementReferenceException f) {
					return false;
				}
			}
		};
		wait.until(elementIsDisplayed);

	}

	public void waitUntilElementClickable(WebElement locator, String message) {
		waitUntilElementDisplayed(locator);
		try {

			WebDriverWait wait = new WebDriverWait(driver, 30);
			wait.until(ExpectedConditions.elementToBeClickable(locator));
		} catch (Exception ex) {
			Assert.assertFalse(true, ex.getMessage());
		}
	}

	public void isDisplayedThenClick(final WebElement locator, final String message) {

		try {
			waitUntilElementClickable(locator, message);
			if (locator.isDisplayed()) {
				locator.click();
				Assert.assertTrue(true, message + " is Not Displayed");
			} else {

				Assert.assertFalse(true, message + " is Not Displayed");
			}
		} catch (Exception ex) {
			Assert.assertFalse(true, ex.getMessage());
		}
	}

	public void compareListOfText(List<String> actual, List<String> expected) {
		Assert.assertEquals(actual, expected);
	}
}
