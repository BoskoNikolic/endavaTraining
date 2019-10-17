package com.endavatraining;

import com.endavatraining.pages.AdminPage;
import com.endavatraining.pages.HomePage;
import com.endavatraining.pages.LoginPage;
import com.endavatraining.util.Utils;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

/*
 *
 * @author Srboljub.Todorovic
 *
 */

public class TestAdminPage extends BaseTest {

    private LoginPage loginPage;
    private By adminPageButton = By.linkText("Admin");
    public static Logger log = Logger.getLogger(HomePage.class);


    @BeforeTest
    @Parameters({"browser"})
    public void setUp(String browser) {
        loginPage = Utils.setUpWebBrowser(browser);
    }

    /*
     * Test validates default state of checkbox on admin page
     * @author Srboljub.Todorovic
     *
     */
    @Test
    public void testAdminPageCheckbox() {
        log.info("This test checks if checkbox on admin page is ticked and changes its state");
        HomePage homePage = loginPage.openAs(BaseTest.adminUsername, BaseTest.adminPassword);
        homePage.goToPage(adminPageButton);

        AdminPage adminPage = new AdminPage(homePage.driver);

        Assert.assertTrue(adminPage.isCheckBoxSelected());
        adminPage.clickOnAllowUsersToShareRegCode();
        Assert.assertFalse(adminPage.isCheckBoxSelected());
        adminPage.clickOnAllowUsersToShareRegCode();
        Assert.assertTrue(adminPage.isCheckBoxSelected());
    }


    @AfterMethod
    public void tearDown() {
        loginPage.quit();
    }
}