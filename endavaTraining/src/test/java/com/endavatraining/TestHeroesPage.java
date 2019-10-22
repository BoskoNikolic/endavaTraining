package com.endavatraining;

import com.endavatraining.pages.HeroesPage;
import com.endavatraining.pages.HomePage;
import com.endavatraining.pages.LoginPage;
import com.endavatraining.pages.UsersPage;
import com.endavatraining.util.Utils;
import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class TestHeroesPage {

    private LoginPage loginPage;
    private HeroesPage heroesPage;
    private HomePage homePage;
    private UsersPage usersPage;
    public static Logger log = Logger.getLogger(TestHeroesPage.class);



    @BeforeTest
    @Parameters({ "browser" })
    public void setUp(String browser) {
        loginPage = Utils.setUpWebBrowser(browser);
    }

    /**
     * Test validates that hero count for admin user is the same on Users page (list of users) and Hero Page(heroes list)
     * @author Danko.Lojanica
     */
    @Test
    public void isHeroCountCorrect2(){

        homePage = loginPage.openAs(TestBase.USER_USERNAME, TestBase.USER_PASSWORD);
        homePage.clickOnUsersButton();
        usersPage = new UsersPage(homePage.driver);
        usersPage.selectValueFromDropDownOnUsersPage(3);
        usersPage.searchUser("admin");
        usersPage.clickOnSearchIcon();
        int heroCountForAdminOnUserPage = usersPage.heroCountForAdminUserOnUserPage();
        heroesPage = new HeroesPage(homePage.driver);
        heroesPage.clickOnHeroesButton();
        heroesPage.selectValueFromDropDownOnHeroesPage(3);
        int heroCountForAdminOnHeroesPage = heroesPage.heroCountForAdminUserOnHeroesPage();
        Assert.assertEquals(heroCountForAdminOnUserPage,heroCountForAdminOnHeroesPage, " Hero count for admin user is not the same on Users page (list of users) and Hero Page(heroes list)");


    }


    @AfterTest
    public void tearDown() {
        if (usersPage != null)
            usersPage.quit();
    }
}
