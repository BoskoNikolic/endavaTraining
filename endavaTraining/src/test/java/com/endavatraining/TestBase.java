package com.endavatraining;

import com.endavatraining.pages.BasePage;
import com.endavatraining.util.Utils;
import org.apache.log4j.Logger;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

public class TestBase {

    protected static BasePage basePage;
    public static Logger log = Logger.getLogger(TestBase.class);
    public static final String ADMIN_USERNAME = "admin";
    public static final String ADMIN_PASSWORD = "password";
    public static final String USER_USERNAME = "user";
    public static final String USER_PASSWORD = "password";
    public static final String HERO_ALREADY_EXISTS = "Hero with this name already exists!";

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

    @AfterClass
    public void tearDown() {
        if (basePage != null)
            basePage.quit();
    }


}
