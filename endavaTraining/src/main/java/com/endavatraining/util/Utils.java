package com.endavatraining.util;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import com.endavatraining.pages.LoginPage;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Utils {

	/**
	 * 
	 * @param browser
	 * @return LoginPage
	 */
	public static LoginPage setUpWebBrowser(String browser) {
		LoginPage loginPage;

		if (browser.equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver().setup();
			ChromeOptions options = new ChromeOptions();
			options.setExperimentalOption("excludeSwitches", new String[]{"enable-automation"});
			loginPage = new LoginPage(new ChromeDriver(options));
		} else {
			throw new RuntimeException();
		}
		return loginPage;
	}


	/**
	 * @param driver
	 * @param locator
	 */
	public static void webDriverWait(WebDriver driver, By locator) {
		new WebDriverWait(driver, 5).until(ExpectedConditions.visibilityOfElementLocated(locator));
	}

}