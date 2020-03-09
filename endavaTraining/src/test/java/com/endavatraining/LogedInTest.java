package com.endavatraining;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import com.endavatraining.pages.BasePage;
import com.endavatraining.pages.HomePage;
import com.endavatraining.pages.LogedInPage;
import com.endavatraining.pages.LoginPage;
import com.endavatraining.util.Utils;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

public class LogedInTest extends TestBase  {

    protected LogedInPage logedInPage;
    protected BasePage basePage;
    protected HomePage homePage;
    protected LoginPage loginPage;

    public static Logger log = Logger.getLogger(LogedInTest.class);
    public static final String ADMIN_USERNAME = "admin";
    public static final String ADMIN_PASSWORD = "password";
    public static final String USER_USERNAME = "user";
    public static final String USER_PASSWORD = "password";
    
	public By Samsara = By.linkText("Samsara");
	public By Algorithms = By.linkText("Algorithms");

    @BeforeMethod
	@BeforeClass
    @Parameters({"browser"})
    public void setUp(String browser) {
        basePage = Utils.setUpWebBrowser(browser);
    }
    @AfterMethod
    public void testFailScreenshot(ITestResult result){
        if (ITestResult.FAILURE == result.getStatus()){
            Utils.captureScreenshot(basePage.driver, result.getName());
            log.info("Screenshot of failure of test " + result.getName() +" is taken!");
        }
    }

    @AfterMethod
	@AfterClass
    public void tearDown() {
        if (basePage != null)
            basePage.quit();
    }
    
    /*
     * Test validates that Samsara Page is opened
     */
    @Test
    public void testSamsaraPageIsOpened(By pageTab) {
       
        //1. User is logged and home page is present
        log.info("Test is Samsara Page present after login");
        homePage = loginPage.openAs(USER_USERNAME, USER_PASSWORD);
        //2. Click to Samsara Tab to open Samsara Page
        logedInPage.goToPage(Samsara);
    }


}
