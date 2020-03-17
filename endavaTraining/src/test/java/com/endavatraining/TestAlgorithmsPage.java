package com.endavatraining;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.endavatraining.pages.AlgorithmsPage;
import com.endavatraining.pages.HomePage;
import com.endavatraining.pages.LoginPage;
import com.endavatraining.util.Utils;

public class TestAlgorithmsPage extends BaseTest {

	private LoginPage loginPage;
	private HomePage homePage;
	private AlgorithmsPage algorithmsPage;
	private By algorithmsPageButton = By.linkText("algorithms");
	public static Logger log = Logger.getLogger(TestAlgorithmsPage.class);

	private String username = "user";
	private String password = "password";
	private String formControlValue = "8";
	private String searchKeyValue = "ana";
	private String vgnKeyValue = "FJv6Jb";
	private String letterValue = "e";
	private By userNameBy = By.id("username");
	private By passWordBy = By.id("password");

	@BeforeTest
	@Parameters({ "browser" })
	public void setUp(String browser) {
		loginPage = Utils.setUpWebBrowser(browser);
	}

	/*
	 * Test validates that algorithms page is opened by checking if Submit button is
	 * visible on the page
	 */
	@Test
	public void testAlgorithmsPageIsOpened() {
		algorithmsPage = new AlgorithmsPage(homePage.driver);

		// 1. User is logged and home page is present
		log.info("Test is algorithms Page is opened");
		homePage = loginPage.openAs(USER_USERNAME, USER_PASSWORD);
		// 2. Click to algorithms Tab to open algorithms Page
		algorithmsPage.openArithmeticsPage();
		// 3. Verify that algorithms Page is presented
		new WebDriverWait(algorithmsPage.driver, 5)
				.until(ExpectedConditions.visibilityOfElementLocated(algorithmsPage.getSubmitButton()));
	}

	/*
	 * Test validates submitted values which will be used in the next test
	 */
	@Test
	public void testSubmitButtonFunctionality() {
		// 1. Verify that algorithms Page is presented
		testAlgorithmsPageIsOpened();
		// 2. Click to the RightUpperLoginButton
		log.info("Clear and enter text into the formControl field");
		algorithmsPage.submitNewValue(formControlValue, searchKeyValue, vgnKeyValue, letterValue);
		// 3. Verify that RightUpperLoginButton open login Page
		new WebDriverWait(algorithmsPage.driver, 5)
				.until(ExpectedConditions.visibilityOfElementLocated(algorithmsPage.getLoginButton()));
	}

	/*
	 * *Test validates is random string expected
	 */
	@Test
	public void testRandomString() throws Exception {
		// 1. precondition for generated prime numbers verification: enter and submit
		// appropriate field value
		testSubmitButtonFunctionality();
		// 2. Random string verification
		algorithmsPage.randomStringVerification();
	}

	/*
	 * *Test validates is Letters field expected
	 */
	@Test
	public void testLettersFieldverification() throws Exception {
		// 1. precondition for generated prime numbers verification: enter and submit
		// appropriate field value
		testSubmitButtonFunctionality();
		// 2. Letters field verification
		algorithmsPage.randomLettersVerification();
	}

	/*
	 * *Test validates is Digits field expected
	 */
	@Test
	public void testDigitsFieldverification() throws Exception {
		// 1. precondition for generated prime numbers verification: enter and submit
		// appropriate field value
		testSubmitButtonFunctionality();
		// 2. Digit field verification
		algorithmsPage.randomDigitsVerification();
	}

	@AfterClass
	public void tearDown() {
		if (algorithmsPage != null)
			algorithmsPage.quit();
	}

}
