package com.endavatraining;

import com.endavatraining.pages.LoginPage;
import com.endavatraining.pages.RegisterNewAccountPage;
import com.endavatraining.util.Utils;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.*;

public class TestRegisterNewAccountPage {

    private LoginPage loginPage;
    private RegisterNewAccountPage registerNewAccountPage;

    private static final String REGISTRATION_CODE = "kFVVSfsKyBGBXvBySBvxM8j2oohutQLJ";
    private String USER_NAME = "johndoe123";
    private String FIRST_NAME = "John";
    private String LAST_NAME = "Doe";
    private String ABOUT = "Something about Joe";
    private String SECRET_QUESTION = "The Ultimate Question";
    private String SECRET_ANSWER = "42";
    private String PASSWORD = "Johndoerules123";

    private By submitButton = By.id("submitButton");

    @BeforeClass
    @Parameters({"browser"})
    public void setUp(String browser) {
        loginPage = Utils.setUpWebBrowser(browser);
    }

    /**
     * The test opens the Create Account page, enters the correct credentials, and submits the form
     * @author: luka.ivancic
     * */
    @Test
    public void testCreateNewAccount(){
        registerNewAccountPage = loginPage.openCreateAccount();
        registerNewAccountPage.signUpNewUser(REGISTRATION_CODE,USER_NAME,FIRST_NAME,LAST_NAME, ABOUT, SECRET_QUESTION, SECRET_ANSWER, PASSWORD);
        if(registerNewAccountPage.submitButton().isEnabled()){
            registerNewAccountPage.submitButton().click();
        }else{
            Assert.assertTrue(registerNewAccountPage.submitButton().isEnabled(), "Sign Up button is disabled");

    }

}
    @AfterMethod
    public void tearDown(){
        if (registerNewAccountPage != null)
            registerNewAccountPage.quit();
    }

}
