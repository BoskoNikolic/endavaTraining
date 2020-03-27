package com.endavatraining;

import com.endavatraining.pages.AlgorithmsPage;
import com.endavatraining.pages.BrokenLinkPage;
import com.endavatraining.pages.HomePage;
import com.endavatraining.pages.LoginPage;
import com.endavatraining.util.Utils;
import org.openqa.selenium.WebDriver;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.*;

public class TestAlgorithmsPage extends BaseTest {

	private LoginPage loginPage;
	private HomePage homePage;
	private AlgorithmsPage algorithmsPage;
	private By algorithmsPageButton = By.linkText("Algorithms");
	public static Logger log = Logger.getLogger(TestAlgorithmsPage.class);

	private String username = "user";
	private String password = "password";
	private String formControlValue = "8";
	public String formControlValueChecking;
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
		log.info("Test is Algorithms Page is opened");
		homePage = loginPage.openAs(USER_USERNAME, USER_PASSWORD);
		// 2. Click to Algorithms Tab to open Algorithms Page
		algorithmsPage.openArithmeticsPage();
	}

	/*
	 * Test validates is Log In page available by clicking upperRightLogInButton
	 * under Algorithms Page
	 */
	@Test
	public void testIsLoginPageAvailable() {
		// 1. Verify that Algorithms Page is presented
		testAlgorithmsPageIsOpened();
		// 2. Click to the RightUpperLoginButton
		log.info("Test is LogIn page available by clicking upperRightLogInButton ");
		algorithmsPage.clickRightUpperLoginButton();	
	}

	/*
	 * Test validates is Log In page available by clicking upperRightLogInButton
	 */
	@Test
	public void testSubmitButtonFunctionality() {
		// 1. Verify that Algorithms Page is presented
		testAlgorithmsPageIsOpened();
		// 2. Click to the RightUpperLoginButton
		log.info("Clear and enter text into the formControl field");
		algorithmsPage.submitNewValue(formControlValue, searchKeyValue, vgnKeyValue, letterValue);
	}

	/*
	 * Test validates are formControlValue appropriated 
	 */
	@Test
	public void testDifferentFormControlValue() {
		// 1. Verify that Algorithms Page is presented
		testAlgorithmsPageIsOpened();
		// 2. Click to the RightUpperLoginButton
		log.info("Clear and enter text into the formControl field");
		algorithmsPage.submitFormControlValueLoop(searchKeyValue, vgnKeyValue, letterValue);
	}

	/*
	 * *Test validates are prime numbers generated appropriate related to entered
	 * formControl number
	 */
	@Test
	public void testGeneratedPrimeNumbers() {
		// 1. precondition for generated prime numbers verification: enter and submit
		// appropriate field value
		testSubmitButtonFunctionality();
		// 2. Get generated prime numbers and verify them
		algorithmsPage.generatedPrimeNumbersVerification(formControlValue);
	}

	/*
	 * *Test validates are Fibonacci numbers generated appropriate related to
	 * entered formControl number
	 */
	@Test
	public void testGeneratedFibonacciNumbers() {
		// 1. precondition for generated prime numbers verification: enter and submit
		// appropriate field value
		testSubmitButtonFunctionality();
		// 2. Get generated Fibonacci numbers and verify them
		algorithmsPage.generatedFibonacciNumbersVerification(formControlValue);
	}

	/*
	 * *Test validates is factorial valid
	 */
	@Test
	public void testCalculateFactorial() {
		// 1. precondition for generated prime numbers verification: enter and submit
		// appropriate field value
		testSubmitButtonFunctionality();
		// 2. Get calculate factorial
		algorithmsPage.calculatedFactorial(formControlValue);
		// 3. Verify that Factorial has expected value.
		algorithmsPage.compareFactorial(algorithmsPage.getApplicationFactorialValue(),
				algorithmsPage.calculatedFactorial(formControlValue));
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
	 * *Test validates is random string expected
	 */
	@Test
	public void vigenereTest() {
		// 1. precondition for generated prime numbers verification: enter and submit
		// appropriate field value
		testSubmitButtonFunctionality();
		// 2. Random string verification
		algorithmsPage.vigenereVerification();
	}

	/*
	 * *Test validates is XOR: string expected
	 */
	@Test
	public void XOR() {
		// 1. precondition for generated prime numbers verification: enter and submit
		// appropriate field value
		testSubmitButtonFunctionality();
		// 2. Random string verification
		algorithmsPage.verificationXOR();
	}

	/*
	 * *Test validates is ROT13: expected
	 */
	@Test
	public void ROT13() {
		// 1. precondition for generated prime numbers verification: enter and submit
		// appropriate field value
		testSubmitButtonFunctionality();
		// 2. Random string verification
		algorithmsPage.verificationROT();
	}

	/*
	 * *Test validates is Reverse: expected
	 */
	@Test
	public void reverseVerification() {
		// 1. precondition for generated prime numbers verification: enter and submit
		// appropriate field value
		testSubmitButtonFunctionality();
		// 2. Random string verification
		algorithmsPage.revVerification();
	}
	
	/*
	 * *Test validates is Palindrom: expected
	 */
	@Test
	public void palindromeVerification() {
		// 1. precondition for generated prime numbers verification: enter and submit
		// appropriate field value
		testSubmitButtonFunctionality();
		// 2. Random string verification
		algorithmsPage.paVerification();
	}
	
	/*
	 * *Test validates is containsKey: expected
	 */
	@Test
	public void containsKeyVerification() {
		// 1. precondition for generated prime numbers verification: enter and submit
		// appropriate field value
		testSubmitButtonFunctionality();
		// 2. Random string verification
		algorithmsPage.containsKeyVerification();
	}

	
	/*
	 * *Test validates is containsKey: expected
	 */
	@Test
	public void containsLetters() {
		// 1. precondition for generated prime numbers verification: enter and submit
		// appropriate field value
		testSubmitButtonFunctionality();
		// 2. Random string verification
		algorithmsPage.containsLettersVerification();
	}

	@AfterClass
	
	public void tearDown() {
		if (algorithmsPage != null)
			algorithmsPage.quit();
	}
}
