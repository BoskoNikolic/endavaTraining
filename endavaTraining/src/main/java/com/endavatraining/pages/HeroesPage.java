package com.endavatraining.pages;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class HeroesPage extends BasePage {


    public static Logger log = Logger.getLogger(HeroesPage.class);
    private List<WebElement> rows;
    private WebDriverWait wait = new WebDriverWait(driver, 3);
    private By heroesButton = By.linkText("Heroes");
    private By dropDownOnHeroesPage = By.id("pageSizeSelect");
    private By heroTableBody = By.xpath("//table[@id=\"heroes-table\"]/tbody/tr");
    private By deleteHeroButton = By.xpath("//*[@id=\"deleteHeroModal\"]/div/div/div[3]/form/button[2]");
    public static By heroesPageTab = By.linkText("Heroes");
    public static By addNewHeroButton = By.linkText("Add New Hero");
    public static By addHeroName = By.xpath("//*[@id=\"name\"]");
    public static By addHeroLevel = By.id("level");
    public static By addHeroClass = By.id("type");
    public static By addHeroSave = By.id("submitButton");
    public static By logoutButton = By.xpath("//*[@id=\"headContainer\"]/nav/div/ul[2]/li[2]/a");
    public static By heroLevelErrorMessage = By.xpath("//div[@id='levelMessage'][contains(.,\"Level is a number between 0 and 80\")]");
    public static By cancelAddHero = By.xpath("//*[@id=\"add-hero-form\"]/div[2]/button[1]");
    public static By addHeroModal = By.xpath("//*[@id=\"addHeroModal\"]");

    public HeroesPage(WebDriver driver) {
        super(driver);
    }

    /**
     * This method clicks on heroesButton button
     * @author Danko.Lojanica
     */
    public void clickOnHeroesButton() {
        driver.findElement(heroesButton).click();
    }

    /**
     * This method select value from drop down on heroes page, depending on passed index
     * @param index
     * @author Danko.Lojanica
     */
    public void selectValueFromDropDownOnHeroesPage(int index) {
        Select dropdown = new Select(driver.findElement(dropDownOnHeroesPage));
        dropdown.selectByIndex(index);
    }

    /**
     * This method returns hero count for admin user on heroes page
     * @return heroCount
     * @author Danko.Lojanica
     */
    public int heroCountForAdminUserOnHeroesPage(){
        int rowNumber;
        int heroCount = 0;
        rowNumber= driver.findElements(By.xpath("//*[@id=\"heroes-table\"]/tbody/tr")).size();
        for(int i =1; i<rowNumber; i++){
            if(driver.findElement(By.xpath("//*[@id=\"heroes-table\"]/tbody/tr[" + i + "]/td[4]")).getText().equals("admin")){
            heroCount++;
        }
    } return  heroCount;
}
    /*
     * This method checks if the hero with given name already exists in table
     * @author Srboljub.Todorovic
     * @param String
     * @return boolean
     */
    public boolean isHeroInTable(String heroName) {
        rows = driver.findElements(heroTableBody);
        for (int i = 0; i < rows.size(); i++) {
            if (heroName.equals(getTextOfElement(By.xpath("//table[@id=\"heroes-table\"]/tbody/tr[" + (i + 1) + "]/td[1]")))) {
                return true;
            }
        }
        return false;
    }

    /*
     * This method deletes hero with given name from a table
     * @author Srboljub.Todorovic
     * @param String
     */
    public void deleteHeroInTable(String heroName) {
        rows = driver.findElements(heroTableBody);
        for (int i = 0; i < rows.size() - 1; i++) {
            if (heroName.equals(getTextOfElement(By.xpath("//table[@id=\"heroes-table\"]/tbody/tr[" + (i + 1) + "]/td[1]")))) {
                clickOnButton(By.xpath("//table[@id=\"heroes-table\"]/tbody/tr[" + (i + 1) + "]/td[5]/a[3]"));
                wait.until(ExpectedConditions.elementToBeClickable(deleteHeroButton));
                clickOnButton(deleteHeroButton);
            }
        }
    }

    /*
     * This method opens hero page
     * @author Srboljub.Todorovic
     */
    public void openHeroPage() {
        wait.until(ExpectedConditions.elementToBeClickable(heroesPageTab));
        clickOnButton(heroesPageTab);
    }

    /*
     * This method opens add new hero window
     * @author Srboljub.Todorovic
     */
    public void openAddNewHeroWindow() {
        clickOnButton(addNewHeroButton);
    }

    /*
     * This method types text into hero name field
     * @author Srboljub.Todorovic
     * @param String
     */
    public void insertHeroName(String heroName) {
        typeTextOnElement(addHeroName,heroName);
    }

    /*
     * This method types text into hero level field
     * @author Srboljub.Todorovic
     * @param String
     */
    public void insertHeroLevel(String heroLevel) {
        typeTextOnElement(addHeroLevel, heroLevel);
    }

    /*
     * This method selects provided hero class from drop down menu
     * @author Srboljub.Todorovic
     * @param String
     */
    public void insertHeroClass(String heroClass) {
        dropDownMenuSelect(addHeroClass, heroClass);
    }

    /*
     * This method saves hero with provided attributes
     * @author Srboljub.Todorovic
     */
    public void saveNewHero() {
        clickOnButton(addHeroSave);
    }

    /*
     * This method does logout function
     * @author Srboljub.Todorovic
     */
    public void logout() {
        wait.until(ExpectedConditions.elementToBeClickable(logoutButton));
        clickOnButton(logoutButton);
    }

    /**
     *
     * This method checks if hero level code error is visible
     *
     * @author Jovan.Penic
     * @return boolean
     */
    public boolean isHeroLevelErrorMessagePresent() {
        return isElementPresent(heroLevelErrorMessage);
    }

    /**
     * This method clicks on Cancel Add Hero button
     *
     * @author Jovan.Penic
     */
    public void clickOnCancel() {
        wait.until(ExpectedConditions.elementToBeClickable(cancelAddHero));
        clickOnButton(cancelAddHero);
    }

    /**
     * This method clears Hero level in Add Hero window
     *
     * @author Jovan.Penic
     */
    public void clearHeroLevel() {
        clearTextOnElement(addHeroLevel);
    }

    /**
     * This method logs out user from Add New Hero window
     *
     * @author Jovan.Penic
     */
    public void logoutFromAddNewHeroModal() {
        wait.until(ExpectedConditions.invisibilityOfElementLocated(addHeroModal));
        clickOnButton(logoutButton);
    }

}
