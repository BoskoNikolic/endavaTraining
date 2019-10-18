package com.endavatraining.pages;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;

public class BasePage {

    public static Logger logger = Logger.getLogger(BasePage.class);

    public WebDriver driver;
    public static Logger log = Logger.getLogger(BasePage.class);
    public static final String LOG_OUT_MESSAGE = "You have been logged out.";

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
     * This method clicks on button that is passed
     * @author Danko.Lojanica
     * @param button
     */
    public void clickOnButton(By button){
        driver.findElement(button).click();
    }

    public void quit() {
        if (this.driver != null) {
            driver.quit();
        }
    }

}
