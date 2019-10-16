package com.endavatraining;

import org.apache.log4j.Logger;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.*;

import com.endavatraining.util.Utils;
import com.endavatraining.pages.LoginPage;


public class TestLoginPage {

	private LoginPage loginPage;
	private static String falseUsername = "user1";
	private static String falsePassword = "password1";
	public static Logger log = Logger.getLogger(TestLoginPage.class);

	@BeforeTest
	@Parameters({"browser"})
	public void setUp(String browser) {
		loginPage = Utils.setUpWebBrowser(browser);
	}

	/*
	 * Test validates that login page is opened by checking if log in button is
	 * visible on the page
	 */
	@Test
	public void testLoginPageIsOpened() {
		log.info("Test login page is opened");
		loginPage.open();
		new WebDriverWait(loginPage.driver, 5)
				.until(ExpectedConditions.visibilityOfElementLocated(loginPage.getLoginButton()));
	}

	/*
	 * Test validates that attempt to login with false credentials is not possible
	 * by checking if log in error message is visible on the page
	 * @author Srboljub.Todorovic
	 */
	@Test
	public void testLoginWithFalseCredentials() {
		loginPage.userLogin(falseUsername, falsePassword);
		assert loginPage.isErrorTextPresent() : "Error message is not present";
	}


	@AfterTest
	public void tearDown() {
		if (loginPage != null)
			loginPage.quit();
	}

}
