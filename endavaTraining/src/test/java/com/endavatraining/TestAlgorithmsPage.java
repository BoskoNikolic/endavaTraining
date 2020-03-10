package com.endavatraining;

import com.endavatraining.pages.AlgorithmsPage;
import com.endavatraining.pages.HomePage;
import com.endavatraining.pages.LoginPage;
import com.endavatraining.util.Utils;
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
    
	private  String username = "user";
	private  String password = "password";
	private  String formControlValue = "8";
	private  String searchKeyValue = "ana";
	private  String vgnKeyValue = "FJv6Jb";
	private  String letterValue = "e";
	private By userNameBy = By.id("username");
	private By passWordBy = By.id("password");


    @BeforeTest
    @Parameters({"browser"})
    public void setUp(String browser) {
        loginPage = Utils.setUpWebBrowser(browser);
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
	 * *Test validates is random string expected 
	 */
	@Parameters("browser")
	@Test
	public void testRandomString() throws Exception {
		//1. precondition for generated prime numbers verification: enter and submit appropriate field value
		testSubmitButtonFunctionality();
		//2. Random string verification
		algorithmsPage.randomStringVerification();
	}
	/*
	 * *Test validates is Letters field expected 
	 */
	@Parameters("browser")
	@Test
	public void testLettersFieldverification() throws Exception {
		//1. precondition for generated prime numbers verification: enter and submit appropriate field value
		testSubmitButtonFunctionality();
		//2. Letters field verification
		algorithmsPage.randomLettersVerification();
	}
	/*
	 * *Test validates is Digits field expected 
	 */
	@Parameters("browser")
	@Test
	public void testDigitsFieldverification() throws Exception {
		//1. precondition for generated prime numbers verification: enter and submit appropriate field value
		testSubmitButtonFunctionality();
		//2. Digit field verification
		algorithmsPage.randomDigitsVerification();
	}

    @AfterClass
    public void tearDown() {
        if (algorithmsPage != null)
        	algorithmsPage.quit();
    }
	
}