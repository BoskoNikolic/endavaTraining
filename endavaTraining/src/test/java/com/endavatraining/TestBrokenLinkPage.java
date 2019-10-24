package com.endavatraining;

import com.endavatraining.pages.BrokenLinkPage;
import com.endavatraining.pages.HomePage;
import com.endavatraining.pages.LoginPage;
import com.endavatraining.util.Utils;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.testng.annotations.*;

/*
 *
 * @author Srboljub.Todorovic
 *
 */

public class TestBrokenLinkPage extends TestBase {

    private LoginPage loginPage;
    private BrokenLinkPage brokenLinkPage;
    private By brokenLinkPageTab = By.linkText("Broken Link");
    private static final String EXPECTED_TITLE = "Alice in Wonderland";
    public static Logger log = Logger.getLogger(TestBrokenLinkPage.class);


    @BeforeTest
    @Parameters({"browser"})
    public void setUp(String browser) {
        loginPage = Utils.setUpWebBrowser(browser);
    }

    /*
     * Test validates that elements visible on other pages are invisible on
     * Broken Link page and that page title is shown
     * @author Srboljub.Todorovic
     */

    @Test
    public void testBrokenLinkPageIsOpened() {

        HomePage homePage = loginPage.openAs(ADMIN_USERNAME, ADMIN_PASSWORD);
        homePage.goToPage(brokenLinkPageTab);

        brokenLinkPage = new BrokenLinkPage(homePage.driver);

        for (By button : brokenLinkPage.listOfElements()) {
            Assert.assertFalse(brokenLinkPage.isElementPresentOnPage(button), "This is not Broken link page");
        }
        Assert.assertTrue(brokenLinkPage.isMainTitlePresent(), "The main title of the page isn't presented on the page");
        String mainTitle = brokenLinkPage.getMainTitleText();
        Assert.assertEquals(mainTitle, EXPECTED_TITLE, "Main title differs from expected");
    }


    @AfterClass
    public void tearDown() {
        if (brokenLinkPage != null)
            brokenLinkPage.quit();
    }
}