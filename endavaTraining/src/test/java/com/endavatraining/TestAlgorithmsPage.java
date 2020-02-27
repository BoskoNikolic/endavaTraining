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
	private static String formControl = "6";
	private static String searchKey = "ana";
	private static String vgnKey = "FJv6Jb";
	private static String letter = "e";
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
	@Test
	public void testAlgorithmsPageIsOpened() {
		log.info("Test is Algorithms Page is opened");
		homePage = loginPage.openAs(USER_USERNAME, USER_PASSWORD);
		algorithmsPage = new AlgorithmsPage(homePage.driver);
		algorithmsPage.openArithmeticsPage();
		new WebDriverWait(algorithmsPage.driver, 5)
				.until(ExpectedConditions.visibilityOfElementLocated(algorithmsPage.getSubmitButton()));
	}
	/*
	 * Test validates is Log In page available by clicking upperRightLogInButton 
	 */
	@Test
	public void testIsLoginPageAvailable() {
		testAlgorithmsPageIsOpened();
        log.info("Test is is Log In page available by clicking upperRightLogInButton " );
        algorithmsPage.clickRightUpperLoginButton();
		new WebDriverWait(algorithmsPage.driver, 5)
				.until(ExpectedConditions.visibilityOfElementLocated(algorithmsPage.getLoginButton()));
	}
	/*
	 * Test validates is Login possible after logIn by clicking upperRightLogInButton 
	 */
	@Test
	public void testIsLogInPossible() {
		testAlgorithmsPageIsOpened();
		testIsLoginPageAvailable();
		algorithmsPage.insertTextInUsernameAndPasswordLogInTextFields(username, password);
        Assert.assertEquals( username, LoginPage.getAttributeOfAnyTextField(algorithmsPage.driver, userNameBy), "Entered text in username Log In field is NOT populated.");
        Assert.assertEquals( password, LoginPage.getAttributeOfAnyTextField(algorithmsPage.driver, passWordBy), "Entered text in password Log In field is NOT populated. ");
		log.info("Tested that username and password fields are populated with correct credentials");
		algorithmsPage.clickRightUpperLoginButton();
        Assert.assertTrue(LoginPage.getAttributeOfAnyTextField(algorithmsPage.driver, userNameBy).isEmpty(), "Username Log In field IS populated. Expected empty text field, but got: " + LoginPage.getAttributeOfAnyTextField(loginPage.driver, userNameBy));
        Assert.assertTrue(LoginPage.getAttributeOfAnyTextField(algorithmsPage.driver, passWordBy).isEmpty(), "Password Log In field IS populated. Expected empty text field, but got: " + LoginPage.getAttributeOfAnyTextField(loginPage.driver, passWordBy));
		log.info("Tested that username and password fields are NOT populated after clicking Log In");
	}
	/*
	 * 
	 * Test validates is Home page available after logIn by clicking upperRightLogInButton
	 */
	@Test
	public void testIsAlgorithmsPageAvailableAfterLogin() {
		log.info("Test is algorithms page availabe" );
		testIsLoginPageAvailable();
		algorithmsPage.insertTextInUsernameAndPasswordLogInTextFields(username, password);
		algorithmsPage.clickLoginButton();
		algorithmsPage.clickArithmeticsHomeTab();
		new WebDriverWait(algorithmsPage.driver, 5)
				.until(ExpectedConditions.visibilityOfElementLocated(algorithmsPage.getSubmitButton()));
	}
}