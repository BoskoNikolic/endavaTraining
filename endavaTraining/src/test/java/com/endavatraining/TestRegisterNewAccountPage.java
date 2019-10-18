package com.endavatraining;

import com.endavatraining.pages.LoginPage;
import com.endavatraining.pages.RegisterNewAccountPage;
import com.endavatraining.util.Utils;
import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.*;

public class TestRegisterNewAccountPage {

    private RegisterNewAccountPage registerNewAccountPage;
    private LoginPage loginPage;
    private static final String randomRegistrationCodeWithSpecCharacters = "+++123";
    private static final String randomRegistrationCodeWithLettersAndNumbers = "abc123";
    public static Logger log = Logger.getLogger(TestRegisterNewAccountPage.class);
    private static final String REGISTRATION_CODE = "kFVVSfsKyBGBXvBySBvxM8j2oohutQLJ";
    private String USER_NAME = "johndoe123";
    private String FIRST_NAME = "John";
    private String LAST_NAME = "Doe";
    private String ABOUT = "Something about Joe";
    private String SECRET_QUESTION = "The Ultimate Question";
    private String SECRET_ANSWER = "42";
    private String PASSWORD = "Johndoerules123";

    @BeforeTest
    @Parameters({"browser"})
    public void setUp(String browser) {
        loginPage = Utils.setUpWebBrowser(browser);
    }

    /**

     *
     * Test validates that username field is NOT visible after entering wrong code with special characters in Registration Code text field.
     * Then test validates if registration code error IS visible.
     *
     *  @author Jovan.Penic
     */
    @Test (priority = 0)
    public void testUserFieldVisibilityFalseRegCodeSpecChar() {
        registerNewAccountPage = loginPage.openCreateAccount();
        Assert.assertFalse(registerNewAccountPage.isUserNameFieldPresent(randomRegistrationCodeWithSpecCharacters), "Username field IS present after special character entry in registration code field. ");
        Assert.assertTrue(registerNewAccountPage.isRegistrationCodeErrorMessagePresent(), "Error message does NOT appear after special character entry in registration code field. ");
        log.info("Tested visibility of user name field after entering wrong code with special characters" );
    }

    /**
     *
     * Test validates that username field is NOT visible after entering wrong code without special characters in Registration Code text field.
     * Then test validates if registration code error IS visible.
     *
     *  @author Jovan.Penic
     */
    @Test (priority = 1)
    public void testUserFieldVisibilityFalseRegCode() {
        registerNewAccountPage = loginPage.openCreateAccount();
        Assert.assertFalse(registerNewAccountPage.isUserNameFieldPresent(randomRegistrationCodeWithLettersAndNumbers),"Username field IS present after random letters and numbers entry in registration code field. ");
        Assert.assertTrue(registerNewAccountPage.isRegistrationCodeErrorMessagePresent(), "Error message does NOT appear after random letters and numbers entry in registration code field. ");
        log.info("Tested visibility of user name field after entering wrong code without special characters" );
    }

     /** The test opens the Create Account page, enters the correct credentials, and submits the form
     * @author: luka.ivancic
     * */
    @Test (priority = 2)
    public void testCreateNewAccount(){
        registerNewAccountPage = loginPage.openCreateAccount();
        registerNewAccountPage.signUpNewUser(REGISTRATION_CODE,USER_NAME,FIRST_NAME,LAST_NAME, ABOUT, SECRET_QUESTION, SECRET_ANSWER, PASSWORD);
        if(registerNewAccountPage.submitButton().isEnabled()){
            registerNewAccountPage.submitButton().click();
        }else{
            Assert.assertTrue(registerNewAccountPage.submitButton().isEnabled(), "Sign Up button is disabled");

    }

}

    /**
     * This method runs after every test and takes screen shot if test fails
     *
     * @author Jovan.Penic
     * @param result
     */
    @AfterMethod
    public void testFailScreenshot(ITestResult result){
        if (ITestResult.FAILURE == result.getStatus()){
            Utils.captureScreenshot(registerNewAccountPage.driver, result.getName());
            log.info("Screenshot of failure of test " + result.getName() +" is taken!");
        }
    }


    @AfterTest
    public void tearDown() {
        if (registerNewAccountPage != null)
            registerNewAccountPage.quit();
    }

}
