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
import org.testng.annotations.DataProvider;
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
	
	@DataProvider(name = "data-provider")
    public Object[][] dataProviderMethod() {
        return new Object[][] { { "", "" }, { "", password }, { "", falsePassword }, { username, "" }, { falseUsername, "" }, { falseUsername, falsePassword }, { falseUsername, password }, {username, "1234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890"}};
    }
	
	@Test(dataProvider = "data-provider")
	public void testLoginWithFalseCredentials(String falseUsername, String falsePassword) {
		loginPage.userLogin(falseUsername, falsePassword);
		loginPage.invalidCredentialVerification();
	}

	@AfterTest
	public void tearDown() {
		if (loginPage != null)
			loginPage.quit();
	}
}
