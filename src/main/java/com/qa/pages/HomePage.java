package com.qa.pages;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.pagebase.BasePage;
import com.qa.objectrepository.ObjectRepos;


public class HomePage extends BasePage {

	@FindBy(how = How.XPATH, using = ObjectRepos.TITLE_IMAGE)
	private WebElement toolsQAImgIcon;

	public HomePage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
		
	public void loadSiteURL() {
		driver.get("https://demoqa.com/");
	}
	
	public void validateHeaderImage() {
		String toolsQAImgSrc = toolsQAImgIcon.getAttribute("src");
		Assert.assertEquals(toolsQAImgSrc, "https://demoqa.com/images/Toolsqa.jpg");
	}
	
	public void pageLoad() {
		((JavascriptExecutor) driver).executeScript("args[0].return document.readyState == complete");
	}
	
	public void validateToolsQATitle() {
		driver.getCurrentUrl();
	}
	
	public void validatePageFields(List<String> values) {
		List<String> actualValues = new ArrayList<String>();
		List<String> expectedValues = Arrays.asList("element", "Forms", "Alerts, Frame & Windows", "Widgets", "Interactions", "Book Store Application");
		Iterator<String> itr = values.iterator();
		
		while(itr.hasNext()) {
			actualValues.add(itr.next());
		}
		compareListOfText(actualValues, expectedValues);
	}

}
