package com.qa.factory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DriverFactory {

	public static ThreadLocal<WebDriver> threadLocal = new ThreadLocal<>();

	public WebDriver initDriver(String browserName, String url) {

		System.out.println("Browser Value ::: " + browserName);

		switch (browserName) {
		case "chrome":
			WebDriverManager.chromedriver().setup();
			threadLocal.set(new ChromeDriver());
			break;
		case "firefox":
			WebDriverManager.firefoxdriver().setup();
			threadLocal.set(new FirefoxDriver());
			break;
		case "edge":
			WebDriverManager.edgedriver().setup();
			threadLocal.set(new EdgeDriver());
			break;
		default:
			System.out.println("Sorry no browser available");
		}

		getDriver().manage().deleteAllCookies();
		getDriver().manage().window().maximize();
		return getDriver();

	}

	public static synchronized WebDriver getDriver() {
		return threadLocal.get();
	}

}
