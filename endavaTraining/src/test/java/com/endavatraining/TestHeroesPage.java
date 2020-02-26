package com.endavatraining;

import com.endavatraining.pages.HeroesPage;
import com.endavatraining.pages.HomePage;
import com.endavatraining.pages.LoginPage;
import com.endavatraining.pages.UsersPage;
import com.endavatraining.util.Utils;
import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.*;





public class TestHeroesPage extends TestBase {

    private LoginPage loginPage;
    private HeroesPage heroesPage;
    private HomePage homePage;
    private UsersPage usersPage;
    public static Logger log = Logger.getLogger(TestHeroesPage.class);

    private String userName = "user";

    /*
     * Before Test suite message
     * @author ana.acanski
     *
     */
    
    @BeforeSuite
    public void setup() {
        System.out.println("Running TestHeroesPage Test.");
    }

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
    @Test(priority = 0, dataProvider = "DataProvider")
    public void testAddingNewHero(String heroName, String heroLevel, String heroClass) {

        homePage = loginPage.openAs(USER_USERNAME, USER_PASSWORD);

        heroesPage = new HeroesPage(homePage.driver);
        heroesPage.openHeroPage();

        Assert.assertFalse(heroesPage.isHeroInTable(heroName), "Hero with this username already exists in table!");

        heroesPage.openAddNewHeroWindow();
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
    @Test(priority = 1, dataProvider = "DataProvider", dependsOnMethods = {"testAddingNewHero"})
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
    @Test(priority = 2, dataProvider = "NewHeroLevelBeyondLimits")
    public void testUserCanNotCreateNewHeroBeyondHeroLevel(String heroLevel) {
        loginPage.userLogin(USER_USERNAME, USER_PASSWORD);
        heroesPage = new HeroesPage(loginPage.driver);
        heroesPage.openHeroPage();
        heroesPage.openAddNewHeroWindow();
        heroesPage.insertHeroLevel(heroLevel);
        Assert.assertTrue(heroesPage.isHeroLevelErrorMessagePresent(), "User can add new hero with level beyond limit. ");
        log.info("Verified that new hero beyond level limit can not be added.");
        heroesPage.clearHeroLevel();
        heroesPage.clickOnCancel();
        heroesPage.logoutFromAddNewHeroModal();
    }

    @DataProvider(name = "NewHeroLevelBeyondLimits")
    public Object[][] getDataFromNewHeroLevelBeyondLimitsDataProvider() {
        return new Object[][]
                {
                        { "85" },
                        { "0" },
                        { "-10"},
                };

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
        log.info("Search for admin user");
        usersPage.clickOnSearchIcon();
        int heroCountForAdminOnUserPage = usersPage.heroCountForAdminUserOnUserPage();
        log.info("Count the number of heroes for admin user on User page");
        heroesPage = new HeroesPage(homePage.driver);
        heroesPage.clickOnHeroesButton();
        heroesPage.selectValueFromDropDownOnHeroesPage(3);
        int heroCountForAdminOnHeroesPage = heroesPage.heroCountForAdminUserOnHeroesPage();
        log.info("Count the number of heroes for admin user on Heroes page");
        Assert.assertEquals(heroCountForAdminOnUserPage,heroCountForAdminOnHeroesPage, " Hero count for admin user is not the same on Users page (list of users) and Hero Page(heroes list)");
        heroesPage.logout();

    }


    /**
     * Test check all the heroes from the Heroes page, and compares that list with the one took from My Heroes page
     * @author luka.ivancic
     *
     *
     * */
    @Test(priority = 2)
    public void testUsersHeroesNumber(){
        homePage = loginPage.openAs(USER_USERNAME, USER_PASSWORD);
        heroesPage = new HeroesPage(homePage.driver);
        heroesPage.openHeroPage();
        int allUsersHeroes = heroesPage.numberOfUsersHeroes(userName);
        heroesPage.clickOnMyHeroesButton();
        int myHeroesHeroes = heroesPage.numberOfMyHeroes(userName);
        System.out.println("Number of all Users heroes: " + allUsersHeroes + "\nNumber of Users Heroes on My Heroes page: " + myHeroesHeroes);
        Assert.assertEquals(allUsersHeroes, myHeroesHeroes, "Number of all Users heroes is not the same as on the My Heroes page");
        log.info("Checking the number of users heroes on the Heroes list, and the number of users heroes on the My Heroes page.");
    }

    @AfterTest
    public void tearDown() {
        if (heroesPage != null)
        	heroesPage.quit();
    }
    
    /*
     * After Test suite message
     * @author ana.acanski
     *
     */
    @AfterSuite
    public void teardownS() {
        System.out.println("LogTestHeroesPageinPage Test Suite is finished");
        driver.quit(); 
    }

}