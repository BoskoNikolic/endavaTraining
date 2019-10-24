package com.endavatraining;

import com.endavatraining.pages.HomePage;
import com.endavatraining.pages.LoginPage;
import org.apache.log4j.Logger;
import org.testng.Assert;
import com.endavatraining.util.Utils;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;


public class TestHomePage extends TestBase {

	private HomePage homePage;
	private LoginPage loginPage;
	private String username = "user";
	private String password = "password";
	public static Logger log = Logger.getLogger(TestHomePage.class);



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
		log.info("Tested home page availability.");
		homePage.clickOnButton(homePage.getLogOutButton());
	}

	/**
	 * Test validates that log out button works properly from every page
	 * @author Danko.Lojanica
	 */
	@Test
	public void testIsLogOutWorks() {
		homePage = loginPage.openAs(username, password);
		homePage.clickOnButton(homePage.getHomeButton());
		homePage.clickOnButton(homePage.getLogOutButton());
		Assert.assertEquals(homePage.getTextOfElement(homePage.getLogOutTitle()),
				HomePage.LOG_OUT_MESSAGE, "Log out failed");

		loginPage.userLogin(username, password);
		homePage.clickOnButton(homePage.getUsersButton());
		homePage.clickOnButton(homePage.getLogOutButton());
		Assert.assertEquals(homePage.getTextOfElement(homePage.getLogOutTitle()),
				HomePage.LOG_OUT_MESSAGE, "Log out failed");

		loginPage.userLogin(username, password);
		homePage.clickOnButton(homePage.getHeroesButton());
		homePage.clickOnButton(homePage.getLogOutButton());
		Assert.assertEquals(homePage.getTextOfElement(homePage.getLogOutTitle()),
				HomePage.LOG_OUT_MESSAGE, "Log out failed");

		loginPage.userLogin(username, password);
		homePage.clickOnButton(homePage.getGalleryButton());
		homePage.clickOnButton(homePage.getLogOutButton());
		Assert.assertEquals(homePage.getTextOfElement(homePage.getLogOutTitle()),
				HomePage.LOG_OUT_MESSAGE, "Log out failed");



		loginPage.userLogin(username, password);
		homePage.clickOnButton(homePage.getApiButton());
		homePage.clickOnButton(homePage.getLogOutButton());
		Assert.assertEquals(homePage.getTextOfElement(homePage.getLogOutTitle()),
				HomePage.LOG_OUT_MESSAGE, "Log out failed");


		loginPage.userLogin(username, password);
		homePage.clickOnButton(homePage.getProfileButton());
		homePage.clickOnButton(homePage.getLogOutButton());
		Assert.assertEquals(homePage.getTextOfElement(homePage.getLogOutTitle()),
				HomePage.LOG_OUT_MESSAGE, "Log out failed");

	}

	/**
	 * Test validates that Share with friends button works properly
	 * @author Danko Lojanica
	 */
	@Test
	public void testShareWithFriends() {

		loginPage.open();
		homePage = loginPage.openAs(username, password);
		homePage.clickOnSamsaraButton();
		homePage.clickOnShareWithFriendsButton();
		String message = homePage.alertMethod();
		Assert.assertEquals(message, "http://172.17.167.71:9010", "Provided link is not correct");
		homePage.clickOnButton(homePage.getLogOutButton());

	}

	/**
	 * Test validates that the Admin Tab is not present when logged in as a regular User
	 *
	 * */
	@Test
	public void testIsAdminTabAvailable(){
		homePage = loginPage.openAs(username, password);
		Assert.assertFalse(homePage.isAdminTabPresent(), "Admin tab is present");
		homePage.clickOnButton(homePage.getLogOutButton());

	}

	/**
	 * Test validates that the Admin Tab is not present when logged in as a regular User
	 *
	 * */
	@Test
	public void testIsAdminTabAvailable(){
		homePage = loginPage.openAs(username, password);
		Assert.assertFalse(homePage.isAdminTabPresent(), "Admin tab is present");
		homePage.clickOnButton(homePage.getLogOutButton());
	}

	@AfterTest
	public void tearDown() {
		if (homePage != null)
			homePage.quit();
	}

}
