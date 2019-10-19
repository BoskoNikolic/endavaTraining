package com.endavatraining;

import com.endavatraining.pages.BasePage;
import com.endavatraining.pages.HeroesPage;
import com.endavatraining.pages.HomePage;
import com.endavatraining.pages.LoginPage;
import com.endavatraining.util.Utils;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.*;


public class TestHeroesPage {

    private LoginPage loginPage;
    private HomePage homePage;
    private By heroesPageTab = By.linkText("Heroes");
    private HeroesPage heroesPage;
    private By addNewHeroButton = By.linkText("Add New Hero");
    private By addHeroName = By.xpath("//*[@id=\"name\"]");
    private By addHeroLevel = By.id("level");
    private By addHeroClass = By.id("type");
    private Select drpClass;
    private By addHeroSave = By.id("submitButton");
    private boolean condition = true;


    @BeforeTest
    @Parameters({"browser"})
    public void setUp(String browser) {
        loginPage = Utils.setUpWebBrowser(browser);
    }

    /*
     *
     */
    @Test(dataProvider = "DataProvider")
    public void testAddingNewHero(String heroName, String heroLevel, String heroClass) {

        while (condition){
            homePage = loginPage.openAs(BasePage.ADMIN_USERNAME, BasePage.ADMIN_PASSWORD);
            homePage.goToPage(heroesPageTab);

            heroesPage = new HeroesPage(homePage.driver);
            condition = false;

        }
        Assert.assertFalse(heroesPage.isHeroInTable(heroName), "Hero with this username already exists ");

        WebDriverWait wait = new WebDriverWait(heroesPage.driver, 3);
        heroesPage.getElement(addNewHeroButton).click();


        wait.until(ExpectedConditions.elementToBeClickable(addHeroName));
        heroesPage.getElement(addHeroName).sendKeys(heroName);

        wait.until(ExpectedConditions.elementToBeClickable(addHeroLevel));
        heroesPage.getElement(addHeroLevel).sendKeys(heroLevel);

        wait.until(ExpectedConditions.elementToBeClickable(addHeroClass));
        drpClass = new Select(heroesPage.getElement(addHeroClass));
        drpClass.selectByVisibleText(heroClass);

        wait.until(ExpectedConditions.elementToBeClickable(addHeroSave));
        heroesPage.getElement(addHeroSave).click();

        Assert.assertTrue(heroesPage.isHeroInTable(heroName), "New hero isn't added to the list ");


    }

    @DataProvider(name = "DataProvider")
    public Object[][] getDataFromDataprovider() {
        return new Object[][]
                {
                        {"0Hero", "11", "Mesmer"},
                        {"1Hero", "12", "Necromancer"},
                        {"2Hero", "13", "Elementalist"},
                        {"3Hero", "14", "Ranger"},
                        {"4Hero", "15", "Thief"},
                        {"5Hero", "16", "Engineer"},
                        {"6Hero", "17", "Revenant"},
                        {"7Hero", "18", "Guardian"},
                        {"8Hero", "19", "Warrior"}
                };

    }

    @AfterTest
    public void tearDown() {
        heroesPage.quit();
    }
}
