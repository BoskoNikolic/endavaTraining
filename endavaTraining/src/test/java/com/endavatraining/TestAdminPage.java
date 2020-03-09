package com.endavatraining;

import com.endavatraining.pages.AdminPage;
import com.endavatraining.pages.HomePage;
import com.endavatraining.pages.LoginPage;
import com.endavatraining.util.Utils;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.*;

/*
 *
 * @author Srboljub.Todorovic
 *
 */

public class TestAdminPage extends TestBase {

    private LoginPage loginPage;
    private HomePage homePage;
    private AdminPage adminPage;
    private By adminPageButton = By.linkText("Admin");
    public static Logger log = Logger.getLogger(TestAdminPage.class);
    
    @BeforeTest
    @Parameters({"browser"})
    public void setUp(String browser) {
        loginPage = Utils.setUpWebBrowser(browser);
    }
    
	@BeforeMethod
	@Parameters({ "browser" })
	public void openBrowser(String browser) {
		homePage = new HomePage(WebDriverWrapper.createDriver(browser));
		homePage.open();
	}

    /*
     * Test validates default state of checkbox on admin page
     * @author Srboljub.Todorovic
     *
     */
    @Test
    public void testAdminPageCheckbox() {
        HomePage homePage = loginPage.openAs(ADMIN_USERNAME, ADMIN_PASSWORD);
        homePage.goToPage(adminPageButton);

        adminPage = new AdminPage(homePage.driver);

        Assert.assertTrue(adminPage.isCheckBoxSelected(), "Checkbox is not ticked by default");
        adminPage.clickOnAllowUsersToShareRegCode();
        Assert.assertFalse(adminPage.isCheckBoxSelected());
        adminPage.clickOnAllowUsersToShareRegCode();
        Assert.assertTrue(adminPage.isCheckBoxSelected());

        adminPage.logout();
        log.info("Tested functionality of a 'Allow users to share Registration Code' checkbox on admin page");

    }

    /*
     * Test validates functionality of generate new code button on admin page
     * @author Srboljub.Todorovic
     *
     */
    @Test
    public void testGenerateNewRegCodeButton() {
        homePage = loginPage.openAs(ADMIN_USERNAME, ADMIN_PASSWORD);
        homePage.goToPage(AdminPage.adminPageButton);

        adminPage = new AdminPage(homePage.driver);

        String regCode = adminPage.getRegCodeBoxText();

        adminPage.generateNewRegCode();

        String newRegCode = adminPage.getRegCodeBoxText();

        Assert.assertNotEquals(regCode, newRegCode, "Registration button does not refreshes registration code");
        log.info("Tested functionality of 'Generate new code' button on admin page");

    }
    @AfterMethod
    public void tearDown() {
        if (adminPage != null)
            adminPage.quit();
    }
    @AfterTest
    public void tearDown() {
        System.out.println("TestAdminPage Test Suite is finished");
        if (this.driver != null)
            driver.quit();
    }
}