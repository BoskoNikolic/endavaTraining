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

public class TestBrokenLinkPage {

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

        HomePage homePage = loginPage.openAs(BasePage.ADMIN_USERNAME, BasePage.ADMIN_PASSWORD);
        homePage.goToPage(brokenLinkPageTab);

        brokenLinkPage = new BrokenLinkPage(homePage.driver);

        for (By button : brokenLinkPage.listOfElements()) {
            Assert.assertTrue(brokenLinkPage.isElementNotPresentOnPage(button));
        }
        Assert.assertTrue(brokenLinkPage.isMainTitlePresent());
        String mainTitle = brokenLinkPage.driver.findElement(brokenLinkPage.getMainTitle()).getText();
        Assert.assertEquals(mainTitle, EXPECTED_TITLE, "Main title differs from expected");
    }


    @AfterMethod
    public void tearDown() {
        if (brokenLinkPage != null)
            brokenLinkPage.quit();
    }
}