package com.endavatraining;

import org.apache.log4j.Logger;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.*;

import com.endavatraining.util.Utils;
import com.endavatraining.pages.HomePage;
import com.endavatraining.pages.LoginPage;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestHomePage {

	private HomePage homePage;
	private LoginPage loginPage;
	private String username = "user";
	private String password = "password";
	public static Logger log = Logger.getLogger(TestHomePage.class);



	@BeforeMethod
	@Parameters({ "browser" })
	public void setUp(String browser) {
		loginPage = Utils.setUpWebBrowser(browser);
	}
	
	/*
	 * Test validates that HomePage page is available
	 */
	@Test
	public void testIsHomePageAvailable() {
        log.info("Test is home page availabe" );
		homePage = loginPage.openAs(username, password);
		assert homePage.isWelcomeTextPresent() : "Welcome text is not present";
	}

	/**
	 * Test validates that the Admin Tab is not present when logged in as a regular User
	 *
	 * */
	@Test
	public void testIsAdminTabAvailable(){
		homePage = loginPage.openAs(username, password);
		Assert.assertFalse(homePage.isAdminTabPresent(), "Admin tab is present");

	}


	@AfterMethod
	public void tearDown() {
		loginPage.quit();
	}

}
