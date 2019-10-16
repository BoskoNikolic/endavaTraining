package com.endavatraining;

import com.endavatraining.pages.LoginPage;
import com.endavatraining.pages.RegisterNewAccountPage;
import com.endavatraining.util.Utils;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

/**
 * Test currently not working because of a bug: B001
 * https://github.com/BoskoNikolic/endavaTraining/wiki/BUG_001
 *
 *
 *
 * */

public class TestRegisterNewAccountPage {

    private LoginPage loginPage;
    private RegisterNewAccountPage registerNewAccountPage;

    private String registrationCode = "kFVVSfsKyBGBXvBySBvxM8j2oohutQLJ";
    private String userName = "johndoe123";
    private String firstName = "John";
    private String lastName = "Doe";
    private String about = "Something about Joe";
    private String secretQuestion = "The Ultimate Question";
    private String secretAnswer = "42";
    private String password = "Johndoerules123";

    @BeforeMethod
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
        registerNewAccountPage.signUpNewUser(registrationCode,userName,firstName,lastName, about, secretQuestion, secretAnswer, password);

     }

    @AfterMethod
    public void tearDown() {
        if (loginPage != null)
            loginPage.quit();
    }





}
