package com.endavatraining;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.endavatraining.util.Utils;
import com.endavatraining.pages.LoginPage;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestLoginPage {

	private LoginPage loginPage;

//	@BeforeTest
	public void setUp() {
		WebDriverManager.chromedriver().setup();
	}

	@BeforeTest
	@Parameters({ "browser" })
	public void setUp(String browser) {
		loginPage = Utils.setUpWebBrowser(browser);
	}
	
	/*
	 * Test validates that login page is opened by checking if log in button is
	 * visible on the page
	 */
	@Test
	public void testLoginPageIsOpened() {
		loginPage = new LoginPage(new ChromeDriver());
		loginPage.open();
		new WebDriverWait(loginPage.driver, 5)
				.until(ExpectedConditions.visibilityOfElementLocated(loginPage.getLoginButton()));
	}


	@AfterMethod
	public void tearDown() {
		if (loginPage != null)
			loginPage.quit();
	}

}
