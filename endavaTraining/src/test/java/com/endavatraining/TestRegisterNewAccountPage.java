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
    private static String randomRegistrationCodeWithSpecCharacters = "+++123";
    private static String randomRegistrationCodeWithLettersAndNumbers = "abc123";

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
    public void test1IsUserFieldVisibleRegiCodeSpecialCharacters() {
        registerNewAccountPage = loginPage.openCreateAccount();
        Assert.assertFalse(registerNewAccountPage.isUserNameFieldPresentAfterSpecialCharacterEntryInRegistrationCodeField(randomRegistrationCodeWithSpecCharacters), "Username field IS present after special character entry in registration code field. ");
        Assert.assertTrue(registerNewAccountPage.isErrorMessagePresentAfterFalseEntryInRegistrationCodeField(), "Error message does NOT appear after special character entry in registration code field. ");
    }

    /**
     *
     * Test validates that username field IS visible after entering special characters in Registration Code text field of create.
     * Then test validates if registration code error is NOT visible.
     *
     *  @author Jovan.Penic
     */
    @Test (priority = 1)
    public void test2IsUserFieldVisibleRegiCodeLettersAndNumbers() {
        registerNewAccountPage = loginPage.openCreateAccount();
        Assert.assertTrue(registerNewAccountPage.isUserNameFieldPresentAfterSpecialCharacterEntryInRegistrationCodeField(randomRegistrationCodeWithLettersAndNumbers),"Username field is NOT present after random letters and numbers entry in registration code field. ");
        Assert.assertFalse(registerNewAccountPage.isErrorMessagePresentAfterFalseEntryInRegistrationCodeField(), "Error message DOES appear after random letters and numbers entry in registration code field. ");
    }

    @AfterTest
    public void tearDown() {
        if (loginPage != null)
            loginPage.quit();
        if (registerNewAccountPage != null)
            registerNewAccountPage.quit();
    }


}
