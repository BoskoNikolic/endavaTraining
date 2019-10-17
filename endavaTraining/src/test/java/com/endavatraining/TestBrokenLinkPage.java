package com.endavatraining;

import com.endavatraining.pages.BasePage;
import com.endavatraining.pages.BrokenLinkPage;
import com.endavatraining.pages.HomePage;
import com.endavatraining.pages.LoginPage;
import com.endavatraining.util.Utils;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.*;

/*
*
* @author Srboljub.Todorovic
*
 */

public class TestBrokenLinkPage extends BaseTest {

    private LoginPage loginPage;
    private By brokenLinkPageTab = By.linkText("Broken Link");
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
        log.info("Test to check if broken link page is visible" );
        HomePage homePage = loginPage.openAs(BaseTest.adminUsername, BaseTest.adminPassword);
        homePage.goToPage(brokenLinkPageTab);

        BrokenLinkPage brokenLinkPage = new BrokenLinkPage(homePage.driver);

        for (By button : brokenLinkPage.listOfElements()) {
            Assert.assertTrue(brokenLinkPage.isElementNotPresentOnPage(button));
            Assert.assertTrue(brokenLinkPage.isMainTitlePresent());
        }

    }


    @AfterMethod
    public void tearDown() {
        if (loginPage != null)
            loginPage.quit();
    }
}