package com.endavatraining;

import com.endavatraining.pages.AdminPage;
import com.endavatraining.pages.AlgorithmsPage;
import com.endavatraining.pages.HeroesPage;
import com.endavatraining.pages.HomePage;
import com.endavatraining.pages.LoginPage;
import com.endavatraining.util.Utils;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.*;

public class TestAlgorithmsPage extends TestBase {

    private LoginPage loginPage;
    private HomePage homePage;
    private AlgorithmsPage algorithmsPage;
    private By algorithmsPageButton = By.linkText("Algorithms");
    public static Logger log = Logger.getLogger(TestAlgorithmsPage.class);
    
	private static String username = "user";
	private static String password = "password";
	private static String formControlValue = "8";
	private static String searchKeyValue = "ana";
	private static String vgnKeyValue = "FJv6Jb";
	private static String letterValue = "e";
	private By userNameBy = By.id("username");
	private By passWordBy = By.id("password");
    
    @BeforeSuite
    public void setup() {
        System.out.println("Running testAlgorithmsPage Test.");
    }
    
    @BeforeTest
	@Parameters({"browser"})
	public void setUp(String browser) {
		loginPage = Utils.setUpWebBrowser(browser);
	}

    @AfterTest
    public void tearDown() {
        if (algorithmsPage != null)
        	algorithmsPage.quit();
    }
	/*
	 * Test validates that algorithms page is opened by checking if Submit button is
	 * visible on the page
	 */
	@Parameters("browser")
	@Test
	public void testAlgorithmsPageIsOpened() {
		algorithmsPage = new AlgorithmsPage(homePage.driver);
		
		//1. User is logged and home page is present
		log.info("Test is Algorithms Page is opened");
		homePage = loginPage.openAs(USER_USERNAME, USER_PASSWORD);
		//2. Click to Algorithms Tab to open Algorithms Page
		algorithmsPage.openArithmeticsPage();
		//3. Verify that Algorithms Page is presented
		new WebDriverWait(algorithmsPage.driver, 5)
				.until(ExpectedConditions.visibilityOfElementLocated(algorithmsPage.getSubmitButton()));
	}
	/*
	 * Test validates is Log In page available by clicking upperRightLogInButton under Algorithms Page
	 */
	@Parameters("browser")
	@Test
	public void testIsLoginPageAvailable() {
		//1. Verify that Algorithms Page is presented
		testAlgorithmsPageIsOpened();
		//2. Click to the RightUpperLoginButton
        log.info("Test is LogIn page available by clicking upperRightLogInButton " );
        algorithmsPage.clickRightUpperLoginButton();
        //3. Verify that RightUpperLoginButton open login Page
		new WebDriverWait(algorithmsPage.driver, 5)
				.until(ExpectedConditions.visibilityOfElementLocated(algorithmsPage.getLoginButton()));
	}
	/*
	 * Test validates is Log In page available by clicking upperRightLogInButton 
	 */
	@Parameters("browser")
	@Test
	public void testSubmitButtonFunctionality() {
		//1. Verify that Algorithms Page is presented
		testAlgorithmsPageIsOpened();
		//2. Click to the RightUpperLoginButton
        log.info("Clear and enter text into the formControl field" );
        algorithmsPage.submitNewValue(formControlValue, searchKeyValue, vgnKeyValue, letterValue);
        //3. Verify that RightUpperLoginButton open login Page
		new WebDriverWait(algorithmsPage.driver, 5)
				.until(ExpectedConditions.visibilityOfElementLocated(algorithmsPage.getLoginButton()));
	}
	/*
	 * *Test validates are prime numbers generated appropriate related to entered formControl number
	 */
	@Parameters("browser")
	@Test
	public void testGeneratedPrimeNumbers() {
		//1. precondition for generated prime numbers verification: enter and submit appropriate field value
		testSubmitButtonFunctionality();
		//2. Get generated prime numbers and verify them
		algorithmsPage.generatedPrimeNumbersVerification(formControlValue);
	}
	/*
	 * *Test validates are Fibonacci numbers generated appropriate related to entered formControl number
	 */
	@Parameters("browser")
	@Test
	public void testGeneratedFibonacciNumbers() {
		//1. precondition for generated prime numbers verification: enter and submit appropriate field value
		testSubmitButtonFunctionality();
		//2. Get generated Fibonacci numbers and verify them
		algorithmsPage.generatedFibonacciNumbersVerification(formControlValue);
	}
	/*
	 * *Test validates are factoriel calculated valid
	 */
	@Parameters("browser")
	@Test
	public void testCalculateFactorial() {
		//1. precondition for generated prime numbers verification: enter and submit appropriate field value
		testSubmitButtonFunctionality();
		//2. Get calculate factorial 
		algorithmsPage.calculatedFactorial(formControlValue);
		//3. Verify that Factorial has expected value.
		algorithmsPage.compareFatorial(algorithmsPage.getApplicationFactorialValue(), algorithmsPage.calculatedFactorial(formControlValue));
	}
	
}