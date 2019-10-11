package com.endavatraining;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.endavatraining.util.Utils;
import com.endavatraining.pages.HomePage;
import com.endavatraining.pages.LoginPage;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestHomePage {

	private HomePage homePage;
	private LoginPage loginPage;
	private String username = "user";
	private String password = "password";


	//@BeforeTest
	public void setUp() {
		WebDriverManager.chromedriver().setup();
	}

	@BeforeTest
	@Parameters({ "browser" })
	public void setUp(String browser) {
		loginPage = Utils.setUpWebBrowser(browser);
	}
	
	/*
	 * Test validates that HomePage page is available
	 */
	@Test
	public void testIsHomePageAvailable() {
//		loginPage = new LoginPage(new ChromeDriver());
		homePage = loginPage.openAs(username, password);
		assert homePage.isWelcomeTextPresent() : "Welcome text is not present";
	}


	@AfterMethod
	public void tearDown() {
		loginPage.quit();
	}

}
