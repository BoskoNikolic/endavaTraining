package com.endavatraining;

import com.endavatraining.pages.LoginPage;
import com.endavatraining.util.Utils;
import org.openqa.selenium.By;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

/*
 *
 * @author Srboljub.Todorovic
 *
 */

public class TestAdminPage {

    private LoginPage loginPage;
    private String username = "admin";
    private String password = "password";

    @BeforeTest
    @Parameters({"browser"})
    public void setUp(String browser) {
        loginPage = Utils.setUpWebBrowser(browser);
    }

    /*
     * Test validates default state of checkbox on admin page
     * @author Srboljub.Todorovic
     */
    @Test
    public void testAdminPageCheckbox() {
        loginPage.open();
        loginPage.userLogin(username, password);
        loginPage.driver.findElement(By.linkText("Admin")).click();
        boolean checkBoxTicked = loginPage.driver.findElement(By.id("usersAllowed")).isSelected();
        if (checkBoxTicked) {
            loginPage.driver.findElement(By.id("usersAllowed")).click();
            checkBoxTicked = loginPage.driver.findElement(By.id("usersAllowed")).isSelected();
            if (!checkBoxTicked) {
                loginPage.driver.findElement(By.id("usersAllowed")).click();
                checkBoxTicked = loginPage.driver.findElement(By.id("usersAllowed")).isSelected();
            }
        }
        assert checkBoxTicked : "Checkbox on admin page is not ticked";
    }


    @AfterMethod
    public void tearDown() {
        loginPage.quit();
    }
}