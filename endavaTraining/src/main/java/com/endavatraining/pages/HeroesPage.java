package com.endavatraining.pages;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

public class HeroesPage extends BasePage {

    public HeroesPage(WebDriver driver) {
        super(driver);
    }

    public static Logger log = Logger.getLogger(LoginPage.class);
    private By heroesButton = By.linkText("Heroes");
    private By dropDownOnHeroesPage = By.id("pageSizeSelect");


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
}}