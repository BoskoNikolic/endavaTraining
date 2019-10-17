package com.endavatraining;

import com.endavatraining.pages.LoginPage;
import com.endavatraining.pages.RegisterNewAccountPage;
import com.endavatraining.util.Utils;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class TestRegisterNewAccountPage {

    private RegisterNewAccountPage registerNewAccountPage;
    private LoginPage loginPage;
    private static final String randomRegistrationCodeWithSpecCharacters = "+++123";
    private static final String randomRegistrationCodeWithLettersAndNumbers = "abc123";

    @BeforeTest
    @Parameters({"browser"})
    public void setUp(String browser) {
        loginPage = Utils.setUpWebBrowser(browser);
    }

    /**
     *
     * Test validates that username field is NOT visible after entering special characters in Registration Code text field.
     * Then test validates if registration code error IS visible.
     *
     *  @author Jovan.Penic
     */
    @Test (priority = 0)
    public void testUserFieldVisibilityFalseRegCodeSpecChar() {
        registerNewAccountPage = loginPage.openCreateAccount();
        Assert.assertFalse(registerNewAccountPage.isUserNameFieldPresent(randomRegistrationCodeWithSpecCharacters), "Username field IS present after special character entry in registration code field. ");
        Assert.assertTrue(registerNewAccountPage.isRegistrationCodeErrorMessagePresent(), "Error message does NOT appear after special character entry in registration code field. ");
    }

    /**
     *
     * Test validates that username field is NOT visible after entering random code without special characters in Registration Code text field.
     * Then test validates if registration code error IS visible.
     *
     *  @author Jovan.Penic
     */
    @Test (priority = 1)
    public void testUserFieldVisibilityFalseRegCode() {
        registerNewAccountPage = loginPage.openCreateAccount();
        Assert.assertFalse(registerNewAccountPage.isUserNameFieldPresent(randomRegistrationCodeWithLettersAndNumbers),"Username field IS present after random letters and numbers entry in registration code field. ");
        Assert.assertTrue(registerNewAccountPage.isRegistrationCodeErrorMessagePresent(), "Error message DOES appear after random letters and numbers entry in registration code field. ");
    }

    @AfterTest
    public void tearDown() {
        if (registerNewAccountPage != null)
            registerNewAccountPage.quit();
    }


}
