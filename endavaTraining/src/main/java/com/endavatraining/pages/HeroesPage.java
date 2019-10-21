package com.endavatraining.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class HeroesPage extends BasePage {


    private List<WebElement> rows;
    private WebDriverWait wait = new WebDriverWait(driver, 3);
    private Select drpClass;

    private By heroTableBody = By.xpath("//table[@id=\"heroes-table\"]/tbody/tr");
    public static By heroesPageTab = By.linkText("Heroes");
    public static By addNewHeroButton = By.linkText("Add New Hero");
    public static By addHeroName = By.xpath("//*[@id=\"name\"]");
    public static By addHeroLevel = By.id("level");
    public static By addHeroClass = By.id("type");
    public static By addHeroSave = By.id("submitButton");
    public static By logoutButton = By.xpath("//*[@id=\"headContainer\"]/nav/div/ul[2]/li[2]/a");

    public HeroesPage(WebDriver driver) {
        super(driver);
    }

    /*
     *This method returns element from the page
     * @author Srboljub.Todorovic
     * @param By
     * @return WebElement
     */

    public WebElement getElement(By locator) {
        return driver.findElement(locator);
    }

    /*
     *This method clicks onto chosen element
     * @author Srboljub.Todorovic
     * @param By
     */
    public void clickOnElement(By button) {
        wait.until(ExpectedConditions.elementToBeClickable(button));
        getElement(button).click();
    }

    /*
     *This method sends text into chosen text field
     * @author Srboljub.Todorovic
     * @param By, String
     */
    public void sendKeysToElement(By field, String keys) {
        wait.until(ExpectedConditions.elementToBeClickable(field));
        getElement(field).sendKeys(keys);
    }

    /*
     *This method selects desirable option from drop down menu options
     * @author Srboljub.Todorovic
     * @param By, String
     */
    public void dropDownMenuSelect(By dropMenu, String drpText) {
        wait.until(ExpectedConditions.elementToBeClickable(dropMenu));
        drpClass = new Select(getElement(dropMenu));
        drpClass.selectByVisibleText(drpText);
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
            if (heroName.equals(driver.findElement(By.xpath("//table[@id=\"heroes-table\"]/tbody/tr[" + (i + 1) + "]/td[1]")).getText())) {
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
            if (heroName.equals(driver.findElement(By.xpath("//table[@id=\"heroes-table\"]/tbody/tr[" + (i + 1) + "]/td[1]")).getText())) {
                driver.findElement(By.xpath("//table[@id=\"heroes-table\"]/tbody/tr[" + (i + 1) + "]/td[5]/a[3]")).click();
                wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"deleteHeroModal\"]/div/div/div[3]/form/button[2]")));
                driver.findElement(By.xpath("//*[@id=\"deleteHeroModal\"]/div/div/div[3]/form/button[2]")).click();
            }
        }
    }

}
