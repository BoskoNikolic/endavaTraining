package com.endavatraining;

import com.endavatraining.pages.HomePage;
import com.endavatraining.pages.LoginPage;
import com.endavatraining.util.Utils;

import static org.testng.AssertJUnit.assertTrue;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class TestLoginPage extends BaseTest {

	private LoginPage loginPage;
	private static String falseUsername = "user1";
	private static String falsePassword = "password1";
	public static Logger log = Logger.getLogger(TestLoginPage.class);
	private static String username = "admin";
	private static String password = "password";
	private By userNameBy = By.id("username");
	private By passWordBy = By.id("password");

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
		log.info("Test is log in page opened");
		loginPage.open();
		new WebDriverWait(loginPage.driver, 5)
				.until(ExpectedConditions.visibilityOfElementLocated(loginPage.getLoginButton()));
	}
	
	@Test
	public void testLoginWithFalseCredentials() {
		loginPage.userLogin(falseUsername, falsePassword);
		loginPage.invalidCredentialVerification();
	}

	/**
	 *
	 * Test validates that username and password fields are populated with correct
	 * credentials, by checking if they are visible in username and password text
	 * boxes. Then test validates that username and password fields are NOT
	 * populated after clicking log In, by checking if username and password text
	 * boxes after clicking on Log In are empty.
	 *
	 * @author Jovan.Penic
	 */
	@Test
	public void testRightUpperLoginButtonClearsCredentialsTextFields() {
		loginPage.open();
		loginPage.insertTextInUsernameAndPasswordLogInTextFields(username, password);
		Assert.assertEquals(username, LoginPage.getAttributeOfAnyTextField(loginPage.driver, userNameBy),
				"Entered text in username Log In field is NOT populated.");
		Assert.assertEquals(password, LoginPage.getAttributeOfAnyTextField(loginPage.driver, passWordBy),
				"Entered text in password Log In field is NOT populated. ");
		log.info("Tested that username and password fields are populated with correct credentials");
		loginPage.clickRightUpperLoginButton();
		Assert.assertTrue(LoginPage.getAttributeOfAnyTextField(loginPage.driver, userNameBy).isEmpty(),
				"Username Log In field IS populated. Expected empty text field, but got: "
						+ LoginPage.getAttributeOfAnyTextField(loginPage.driver, userNameBy));
		Assert.assertTrue(LoginPage.getAttributeOfAnyTextField(loginPage.driver, passWordBy).isEmpty(),
				"Password Log In field IS populated. Expected empty text field, but got: "
						+ LoginPage.getAttributeOfAnyTextField(loginPage.driver, passWordBy));
		log.info("Tested that username and password fields are NOT populated after clicking Log In");
	}

	@AfterTest
	public void tearDown() {
		if (loginPage != null)
			loginPage.quit();
	}
}
