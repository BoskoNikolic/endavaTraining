package com.endavatraining;

import com.endavatraining.pages.BasePage;
import com.endavatraining.pages.HeroesPage;
import com.endavatraining.pages.HomePage;
import com.endavatraining.pages.LoginPage;
import com.endavatraining.util.Utils;
import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.*;


public class TestHeroesPage {

    private LoginPage loginPage;
    private HeroesPage heroesPage;
    public static Logger log = Logger.getLogger(TestHeroesPage.class);


    @BeforeTest
    @Parameters({"browser"})
    public void setUp(String browser) {
        loginPage = Utils.setUpWebBrowser(browser);
    }

    /*
     *Test validates that it is possible to add multiple inputs into hero table with different
     * values from drop down menu option
     * @author Srboljub.Todorovic
     * @param dataProvider
     */
    @Test(dataProvider = "DataProvider")
    public void testAddingNewHero(String heroName, String heroLevel, String heroClass) {

        HomePage homePage = loginPage.openAs(BasePage.ADMIN_USERNAME, BasePage.ADMIN_PASSWORD);

        heroesPage = new HeroesPage(homePage.driver);
        heroesPage.clickOnButton(HeroesPage.heroesPageTab);

        Assert.assertFalse(heroesPage.isHeroInTable(heroName), "Hero with this username already exists in table!");

        heroesPage.clickOnButton(HeroesPage.addNewHeroButton);
        heroesPage.typeTextOnElement(HeroesPage.addHeroName, heroName);
        heroesPage.typeTextOnElement(HeroesPage.addHeroLevel, heroLevel);
        heroesPage.dropDownMenuSelect(HeroesPage.addHeroClass, heroClass);
        heroesPage.clickOnButton(HeroesPage.addHeroSave);

        Assert.assertTrue(heroesPage.isHeroInTable(heroName), "Hero with this username is not added!");
        log.info("Verifies that new hero is added (shown on table).");

        heroesPage.deleteHeroInTable(heroName);
        log.info("Deleting inserted values so the test could be performed multiple times with same set of data");

        heroesPage.clickOnButton(HeroesPage.logoutButton);
    }

    @DataProvider(name = "DataProvider")
    public Object[][] getDataFromDataprovider() {
        return new Object[][]
                {
                        {"Hero", "1", "Mesmer"},
                        {"Hero", "1", "Necromancer"},
                        {"Hero", "1", "Elementalist"},
                        {"Hero", "1", "Ranger"},
                        {"Hero", "1", "Thief"},
                        {"Hero", "1", "Engineer"},
                        {"Hero", "1", "Revenant"},
                        {"Hero", "1", "Guardian"},
                        {"Hero", "1", "Warrior"}
                };

    }

    @AfterTest
    public void tearDown() {
        heroesPage.quit();
    }

}