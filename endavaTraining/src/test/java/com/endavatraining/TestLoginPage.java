package com.endavatraining;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.*;

import com.endavatraining.util.Utils;
import com.endavatraining.pages.LoginPage;


public class TestLoginPage {

    private LoginPage loginPage;
    private static String falseUsername = "user1";
    private static String falsePassword = "password1";
	private String username = "admin";
	private String password = "password";

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
	/**
	 *
	 * Test validates that username and password fields are populated with correct credentials,
	 * by checking if they are visible in username and password text boxes.
	 * Then test validates that username and password fields are NOT populated after clicking log In,
	 * by checking if username and password text boxes after clicking on Log In are empty.
	 *
	 *  @author Jovan.Penic
	 */
	@Test
	public void testLoginUsernameAndPasswordsArePopulated(){
		loginPage.open();
		assert loginPage.areValuesEnteredInTextFields(username, password) : "Username or password fields are NOT populated with correct credentials!";
		assert loginPage.isUserPasswordTextFieldEmpty() : "Text fields username and password are populated after clicking on Log In!";
	}


    @AfterTest
    public void tearDown() {
        if (loginPage != null)
            loginPage.quit();
    }

}
