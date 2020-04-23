package com.endavatraining;

import com.endavatraining.pages.HomePage;
import com.endavatraining.pages.LoginPage;
import com.endavatraining.pages.ProfilePage;
import com.endavatraining.util.Utils;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class TestProfilePage extends BaseTest {

	private LoginPage loginPage;
	private HomePage homePage;
	private ProfilePage profilePage;

	@BeforeTest
	@Parameters({ "browser" })
	public void setUp(String browser) {
		loginPage = Utils.setUpWebBrowser(browser);
	}

	/*
	 * Test is checking functionality of profile button
	 * 
	 * @author Srboljub.Todorovic
	 */
	@Test
	public void testProfileButton() {

		homePage = loginPage.openAs(USER_USERNAME, USER_PASSWORD);
		Assert.assertTrue(homePage.isProfileButtonDisplayed(), "Profile button should be displayed on home page");

		profilePage = new ProfilePage(homePage.driver);
		profilePage.openProfilePage();

		Assert.assertTrue(profilePage.isProfileButtonDisplayed(), "Profile button should be displayed on profile page");
		Assert.assertTrue(profilePage.isPageTitleDisplayed(), "Profile page title isn't displayed");

		log.info(
				"Tested that profile page button is displayed when user is logged in and that it is possible to click on it and go to profile page");

	}

	@AfterTest
	public void tearDown() {
		profilePage.quit();
	}
}
