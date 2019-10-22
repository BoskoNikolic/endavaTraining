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

    public static Logger log = Logger.getLogger(TestBase.class);
    protected static BasePage basePage;

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
