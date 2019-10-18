package com.endavatraining;

import com.endavatraining.pages.BasePage;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
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
	private By logOutButton = By.xpath("//*[@id=\"headContainer\"]/nav/div/ul[2]/li[2]/a");
	private By homeButton = By.linkText("Home");
	private By usersButton = By.linkText("Users");
	private By heroesButton = By.linkText("Heroes");
	private By galleryButton = By.linkText("Gallery");
	private By apiButton = By.linkText("API");
	private By brokenLinkButton = By.linkText("Broken Link");
	private By profileButton = By.linkText("Profile");
	private By logOutMessage = By.xpath("//div[@class='alert alert-success']");




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
	 * Test validates that log out button works properly from every page
	 * @author Danko.Lojanica
	 */

	@Test
	public void testIsLogOutWorks() {
		loginPage.open();
		homePage = loginPage.openAs(username, password);
		homePage.clickOnButton(homeButton);
		homePage.clickOnButton(logOutButton);
		Assert.assertEquals(homePage.driver.findElement(logOutMessage).getText(), BasePage.LOG_OUT_MESSAGE, "Log out failed");

		loginPage.userLogin(username,password);
		homePage.clickOnButton(usersButton);
		homePage.clickOnButton(logOutButton);
		Assert.assertEquals(homePage.driver.findElement(logOutMessage).getText(),  BasePage.LOG_OUT_MESSAGE, "Log out failed");

		loginPage.userLogin(username,password);
		homePage.clickOnButton(heroesButton);
		homePage.clickOnButton(logOutButton);
		Assert.assertEquals(homePage.driver.findElement(logOutMessage).getText(),  BasePage.LOG_OUT_MESSAGE, "Log out failed");

		loginPage.userLogin(username,password);
		homePage.clickOnButton(galleryButton);
		homePage.clickOnButton(logOutButton);
		Assert.assertEquals(homePage.driver.findElement(logOutMessage).getText(),  BasePage.LOG_OUT_MESSAGE, "Log out failed");

		loginPage.userLogin(username,password);
		homePage.clickOnButton(apiButton);
		homePage.clickOnButton(logOutButton);
		Assert.assertEquals(homePage.driver.findElement(logOutMessage).getText(),  BasePage.LOG_OUT_MESSAGE, "Log out failed");


		loginPage.userLogin(username,password);
		homePage.clickOnButton(profileButton);
		homePage.clickOnButton(logOutButton);
		Assert.assertEquals(homePage.driver.findElement(logOutMessage).getText(),  BasePage.LOG_OUT_MESSAGE, "Log out failed");
	}


	@AfterMethod
	public void tearDown() {
		homePage.quit();
	}

}
