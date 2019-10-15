package com.endavatraining;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.*;

import com.endavatraining.util.Utils;
import com.endavatraining.pages.HomePage;
import com.endavatraining.pages.LoginPage;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestHomePage {

    private HomePage homePage;
    private LoginPage loginPage;
    private String username = "user";
    private String password = "password";


    //	@BeforeTest
    public void setUp() {
        WebDriverManager.chromedriver().setup();
    }

    @BeforeMethod

    @Parameters({"browser"})
    public void setUp(String browser) {
        loginPage = Utils.setUpWebBrowser(browser);
    }

    /*
     * Test validates that HomePage page is available
     */
    @Test
    public void testIsHomePageAvailable() {

        homePage = loginPage.openAs(username, password);
        assert homePage.isWelcomeTextPresent() : "Welcome text is not present";
    }


    @AfterMethod
    public void tearDown() {
        loginPage.quit();
    }

}

