package com.endavatraining.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class LoginPage extends BasePage {

    private static final String ENDAVATRAINING_URL = "http://172.17.167.71:9010";

    private By loginButton = By.id("form");
    private By userName = By.id("username");
    private By password = By.id("password");
    private By errorLoginText = By.id("loginbox");

    public LoginPage(WebDriver driver) {
        super(driver);
    }


    public void open() {
        driver.get(ENDAVATRAINING_URL);
    }

    public By getLoginButton() {

        return loginButton;

    }

    /*
    * This method is used for user login
    *
    * @author Srboljub.Todorovic
    * @param username
    * @param password
    *
     */
    public void userLogin(String username, String password) {
        open();
        driver.findElement(this.userName).sendKeys(username);
        driver.findElement(this.password).sendKeys(password);
        driver.findElement(this.loginButton).click();
    }

    public HomePage openAs(String username, String password) {
        open();
        userLogin(username, password);
        return new HomePage(driver);
    }

    public boolean isErrorTextPresent() {
        return isElementPresent(errorLoginText);
    }
}
