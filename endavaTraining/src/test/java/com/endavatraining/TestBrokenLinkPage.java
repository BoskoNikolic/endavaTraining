package com.endavatraining;

import com.endavatraining.pages.BrokenLinkPage;
import com.endavatraining.pages.LoginPage;
import com.endavatraining.util.Utils;
import org.openqa.selenium.By;
import org.testng.annotations.*;

public class TestBrokenLinkPage {

    private LoginPage loginPage;
    private String username = "admin";
    private String password = "password";

    @BeforeTest
    @Parameters({"browser"})
    public void setUp(String browser) {
        loginPage = Utils.setUpWebBrowser(browser);
    }

    /*
     * Test validates that elements visible on other pages are invisible on
     * Broken Link page and that page title is shown
     */
    @Test
    public void testBrokenLinkPageIsOpened() {
        loginPage.open();
        loginPage.userLogin(username, password);
        loginPage.driver.findElement(By.linkText("Broken Link")).click();
        BrokenLinkPage brokenLinkPage = new BrokenLinkPage(loginPage.driver);
        assert brokenLinkPage.isElementNotPresentOnPage() && brokenLinkPage.isMainTitlePresent() : "This is not Broken Link page";
    }


    @AfterMethod
    public void tearDown() {
        if (loginPage != null)
            loginPage.quit();
    }
}