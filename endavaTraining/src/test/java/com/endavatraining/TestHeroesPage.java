package com.endavatraining;

import com.endavatraining.pages.HeroesPage;
import com.endavatraining.pages.HomePage;
import com.endavatraining.pages.LoginPage;
import com.endavatraining.util.Utils;
import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.testng.annotations.DataProvider;
import org.testng.annotations.AfterTest;


public class TestHeroesPage extends TestBase {

    private LoginPage loginPage;
    private HeroesPage heroesPage;
    private HomePage homePage;
    public static Logger log = Logger.getLogger(TestHeroesPage.class);


    @BeforeTest
    @Parameters({"browser"})
    public void setUp(String browser) {
        loginPage = Utils.setUpWebBrowser(browser);
    }

    /*
     * Test validates that it is possible to add multiple inputs into hero table with different
     * values from drop down menu option
     * @author Srboljub.Todorovic
     * @param  String heroName, String heroLevel, String heroClass
     */
    @Test(dataProvider = "DataProvider")
    public void testAddingNewHero(String heroName, String heroLevel, String heroClass) {

        homePage = loginPage.openAs(USER_USERNAME, USER_PASSWORD);

        heroesPage = new HeroesPage(homePage.driver);
        heroesPage.openHeroPage();

        Assert.assertFalse(heroesPage.isHeroInTable(heroName), "Hero with this username already exists in table!");

        heroesPage.openAddNewHero();
        heroesPage.insertHeroName(heroName);
        heroesPage.insertHeroLevel(heroLevel);
        heroesPage.insertHeroClass(heroClass);
        heroesPage.saveNewHero();

        Assert.assertTrue(heroesPage.isHeroInTable(heroName), "Hero with this username is not added!");
        log.info("Verifies that new hero is added (shown on table).");

        heroesPage.logout();
    }

    /*
     * Test erases inputs from previous test
     * @author Srboljub.Todorovic
     * @param  String heroName, String heroLevel, String heroClass
     */
    @Test(dataProvider = "DataProvider", dependsOnMethods = {"testAddingNewHero"})
    public void deleteAddedHeroes(String heroName, String heroLevel, String heroClass) {

        homePage = loginPage.openAs(USER_USERNAME, USER_PASSWORD);

        heroesPage = new HeroesPage(homePage.driver);
        heroesPage.openHeroPage();

        heroesPage.deleteHeroInTable(heroName);
        log.info("Erasing inserted values so the previous test could be performed multiple times with same set of data");

        heroesPage.logout();
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

    /**
     *
     * Test validates that user can't create new hero, when hero level is beyond limit, by logging in as user,
     * clicking on Heroes tab and on Add New Hero button, entering level beyond limit and checking if error message is visible.
     *
     *  @author Jovan.Penic
     */
    @Test (priority = 0)
    public void testUserCanNotCreateNewHeroBeyondHeroLevel() {
        loginPage.userLogin(USER_USERNAME, USER_PASSWORD);
        heroesPage = new HeroesPage(loginPage.driver);
        heroesPage.openHeroPage();
        heroesPage.openAddNewHero();
        heroesPage.insertHeroLevel(heroLevelBeyondLimit);
        Assert.assertTrue(heroesPage.isHeroLevelErrorMessagePresent(), "User can add new hero with level beyond limit. ");
    }


    @AfterTest
    public void tearDown() {
        if(heroesPage != null)
        heroesPage.quit();
    }

}