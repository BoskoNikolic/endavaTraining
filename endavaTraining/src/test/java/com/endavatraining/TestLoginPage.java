package com.endavatraining;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.*;

import com.endavatraining.util.Utils;
import com.endavatraining.pages.LoginPage;


public class TestLoginPage {

    private LoginPage loginPage;

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
     */
    @Test
    public void testLoginWithFalseCredentials() {
        loginPage = loginPage.openWithFalseCedentials("user1", "password1");
        assert loginPage.isErrorTextPresent() : "Error message is not present";
    }


    @AfterTest
    public void tearDown() {
        if (loginPage != null)
            loginPage.quit();
    }

}
