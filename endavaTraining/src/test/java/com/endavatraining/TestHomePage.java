package com.endavatraining;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
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
	public static Logger log = Logger.getLogger(TestHomePage.class);
	private By logOutMessage = By.xpath("//div[@class='alert alert-success']");




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
        log.info("Test is home page availabe" );
		homePage = loginPage.openAs(username, password);
		assert homePage.isWelcomeTextPresent() : "Welcome text is not present";
	}

	/**
	 * Test validates that log out button works properly from every page
	 * @author Danko.Lojanica
	 */

	@Test
	public void testIsLogOutWorks() {
		loginPage = new LoginPage(new ChromeDriver());
		homePage = loginPage.openAs(username, password);
		homePage.logOutButton("Home");
		new WebDriverWait(loginPage.driver, 5)
				.until(ExpectedConditions.visibilityOfElementLocated(logOutMessage));

		loginPage.userLogin(username,password);
		homePage.logOutButton("Users");
		new WebDriverWait(loginPage.driver, 5)
				.until(ExpectedConditions.visibilityOfElementLocated(logOutMessage));

		loginPage.userLogin(username,password);
		homePage.logOutButton("Heroes");
		new WebDriverWait(loginPage.driver, 5)
				.until(ExpectedConditions.visibilityOfElementLocated(logOutMessage));

		loginPage.userLogin(username,password);
		homePage.logOutButton("Gallery");
		new WebDriverWait(loginPage.driver, 5)
				.until(ExpectedConditions.visibilityOfElementLocated(logOutMessage));

		loginPage.userLogin(username,password);
		homePage.logOutButton("API");
		new WebDriverWait(loginPage.driver, 5)
				.until(ExpectedConditions.visibilityOfElementLocated(logOutMessage));

		loginPage.userLogin(username,password);
		homePage.logOutButton("Broken Link");
		new WebDriverWait(loginPage.driver, 5)
				.until(ExpectedConditions.visibilityOfElementLocated(logOutMessage));

		loginPage.userLogin(username,password);
		homePage.logOutButton("Profile");
		new WebDriverWait(loginPage.driver, 5)
				.until(ExpectedConditions.visibilityOfElementLocated(logOutMessage));
	}


	@AfterMethod
	public void tearDown() {
		loginPage.quit();
	}

}
