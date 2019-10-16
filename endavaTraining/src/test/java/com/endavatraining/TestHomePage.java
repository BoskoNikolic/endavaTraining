package com.endavatraining;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;


import com.endavatraining.util.Utils;
import com.endavatraining.pages.HomePage;
import com.endavatraining.pages.LoginPage;

import io.github.bonigarcia.wdm.WebDriverManager;

import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOfElementLocated;

public class TestHomePage {

	private HomePage homePage;
	private LoginPage loginPage;
	private String username = "user";
	private String password = "password";
	public static Logger logger = Logger.getLogger(TestHomePage.class);


		@BeforeTest
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
		loginPage = new LoginPage(new ChromeDriver());
		homePage = loginPage.openAs(username, password);
		assert homePage.isWelcomeTextPresent() : "Welcome text is not present";
	}

	/*
	 * Test validates that Log Out button works from every page
	 */
	@Test
	public void testIsLogOutWorks() {
		loginPage = new LoginPage(new ChromeDriver());
		homePage = loginPage.openAs(username, password);
        homePage.logOutButton("Home");
		new WebDriverWait(loginPage.driver, 5)
				.until(ExpectedConditions.visibilityOfElementLocated(loginPage.getLogOutMessage()));

		loginPage.userLogin(username,password);
		homePage.logOutButton("Users");
		new WebDriverWait(loginPage.driver, 5)
				.until(ExpectedConditions.visibilityOfElementLocated(loginPage.getLogOutMessage()));

		loginPage.userLogin(username,password);
		homePage.logOutButton("Heroes");
		new WebDriverWait(loginPage.driver, 5)
				.until(ExpectedConditions.visibilityOfElementLocated(loginPage.getLogOutMessage()));

		loginPage.userLogin(username,password);
		homePage.logOutButton("Gallery");
		new WebDriverWait(loginPage.driver, 5)
				.until(ExpectedConditions.visibilityOfElementLocated(loginPage.getLogOutMessage()));

		loginPage.userLogin(username,password);
		homePage.logOutButton("API");
		new WebDriverWait(loginPage.driver, 5)
				.until(ExpectedConditions.visibilityOfElementLocated(loginPage.getLogOutMessage()));

		loginPage.userLogin(username,password);
		homePage.logOutButton("Broken Link");
		new WebDriverWait(loginPage.driver, 5)
				.until(ExpectedConditions.visibilityOfElementLocated(loginPage.getLogOutMessage()));

		loginPage.userLogin(username,password);
		homePage.logOutButton("Profile");
		new WebDriverWait(loginPage.driver, 5)
				.until(ExpectedConditions.visibilityOfElementLocated(loginPage.getLogOutMessage()));
	}


	@AfterMethod
	public void tearDown() {
		loginPage.quit();
	}

}
