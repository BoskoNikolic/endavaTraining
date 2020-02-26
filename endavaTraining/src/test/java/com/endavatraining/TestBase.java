package com.endavatraining;

import com.endavatraining.pages.BasePage;
import com.endavatraining.util.Utils;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;

public class TestBase {

    protected static BasePage basePage;
    public static Logger log = Logger.getLogger(TestBase.class);
    public static final String ADMIN_USERNAME = "admin";
    public static final String ADMIN_PASSWORD = "password";
    public static final String USER_USERNAME = "user";
    
    public static WebDriver driver;
    protected void BasePage(WebDriver driver) {
		this.driver = driver;
	}

    /*
     * Before Test suite message
     * @author ana.acanski
     *
     */
    
    @BeforeSuite
    public void setup() {
        System.out.println("Running loginPage Test.");
    }
    public static final String USER_PASSWORD = "password";

    @BeforeClass
    @Parameters({"browser"})
    public void setUp(String browser) {
        basePage = Utils.setUpWebBrowser(browser);
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
            Utils.captureScreenshot(basePage.driver, result.getName());
            log.info("Screenshot of failure of test " + result.getName() +" is taken!");
        }
    }

    
    /*
     * After Test suite message
     * @author ana.acanski
     *
     */


    @AfterTest
    public void tearDown() {
        if (basePage != null)
            basePage.quit();
    }
    @AfterSuite
    public void teardownS() {
        System.out.println("TestBase Test Suite is finished");
        driver.quit(); 
    }


}
