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
    private HomePage homePage;
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

        homePage = loginPage.openAs(BasePage.ADMIN_USERNAME, BasePage.ADMIN_PASSWORD);

        heroesPage = new HeroesPage(homePage.driver);
        heroesPage.clickOnElement(HeroesPage.heroesPageTab);

        Assert.assertFalse(heroesPage.isHeroInTable(heroName), "Hero with this username already exists in table!");

        heroesPage.clickOnElement(HeroesPage.addNewHeroButton);
        heroesPage.sendKeysToElement(HeroesPage.addHeroName, heroName);
        heroesPage.sendKeysToElement(HeroesPage.addHeroLevel, heroLevel);
        heroesPage.dropDownMenuSelect(HeroesPage.addHeroClass, heroClass);
        heroesPage.clickOnElement(HeroesPage.addHeroSave);

        Assert.assertTrue(heroesPage.isHeroInTable(heroName), "Hero with this username is not added!");
        log.info("Verifies that new hero is added (shown on table).");

        heroesPage.deleteHeroInTable(heroName);

        heroesPage.clickOnElement(HeroesPage.logoutButton);
    }

    @DataProvider(name = "DataProvider")
    public Object[][] getDataFromDataprovider() {
        return new Object[][]
                {
                        {"0Hero", "1", "Mesmer"},
                        {"1Hero", "1", "Necromancer"},
                        {"2Hero", "1", "Elementalist"},
                        {"3Hero", "1", "Ranger"},
                        {"4Hero", "1", "Thief"},
                        {"5Hero", "1", "Engineer"},
                        {"6Hero", "1", "Revenant"},
                        {"7Hero", "1", "Guardian"},
                        {"8Hero", "1", "Warrior"}
                };

    }

    @AfterTest
    public void tearDown() {
        heroesPage.quit();
    }

}