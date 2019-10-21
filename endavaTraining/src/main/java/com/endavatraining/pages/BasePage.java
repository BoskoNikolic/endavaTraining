package com.endavatraining.pages;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;

public class BasePage {

    public static Logger logger = Logger.getLogger(BasePage.class);

    public WebDriver driver;
    public static Logger log = Logger.getLogger(BasePage.class);
    public static final String ADMIN_USERNAME = "admin";
    public static final String ADMIN_PASSWORD = "password";
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

    /**
     *
     * This method returns value of attributes of any text field
     *
     * @author Jovan.Penic
     * @param driver
     * @param anyTextField
     * @return
     */
    public static String getAttributeOfAnyTextField(WebDriver driver, By anyTextField){
        return driver.findElement(anyTextField).getAttribute("value");
    }

    /**
     * This method returns text of any passed element
     * @author Danko.Lojanica
     * @param element
     * @return
     */
    public String getTextOfElement(By element) {
        return driver.findElement(element).getText();

    }

}
