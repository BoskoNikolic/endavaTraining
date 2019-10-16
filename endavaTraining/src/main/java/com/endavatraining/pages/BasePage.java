package com.endavatraining.pages;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;

public class BasePage {

    public static Logger logger = Logger.getLogger(BasePage.class);

    public WebDriver driver;
    public static Logger log = Logger.getLogger(BasePage.class);
    private By logOutButton = By.xpath("//*[@id=\"headContainer\"]/nav/div/ul[2]/li[2]/a");
    private By homeButton = By.linkText("Home");
    private By usersButton = By.linkText("Users");
    private By heroesButton = By.linkText("Heroes");
    private By galleryButton = By.linkText("Gallery");
    private By apiButton = By.linkText("API");
    private By brokenLinkButton = By.linkText("Broken Link");
    private By profileButton = By.linkText("Profile");

    protected BasePage(WebDriver driver) {
        this.driver = driver;
    }

    protected boolean isElementPresent(By by){
        try{
            driver.findElement(by);
            return true;
        }
        catch(NoSuchElementException e){
            return false;
        }
    }

    /**
     * This method clicks on every menu button and than on log out button depending on what parameter is passed
     * @author Danko.Lojanica
     * @param button
     */
    public void logOutButton(String button){
        if(button.equals("Home")){
            driver.findElement(homeButton).click();}
        else if(button.equals("Users")) {
            driver.findElement(usersButton).click();
        }
        else if(button.equals("Heroes")) {
            driver.findElement(heroesButton).click();
        }
        else if(button.equals("Gallery")) {
            driver.findElement(galleryButton).click();
        }
        else if(button.equals("API")) {
            driver.findElement(apiButton).click();
        }
        else if(button.equals("Broken Link")) {
            driver.findElement(brokenLinkButton).click();
            driver.navigate().back();
        }
        else if(button.equals("Profile")) {
            driver.findElement(profileButton).click();
        }
        driver.findElement(logOutButton).click();
    }

    public void quit() {
        if (this.driver != null) {
            driver.quit();
        }
    }

}
