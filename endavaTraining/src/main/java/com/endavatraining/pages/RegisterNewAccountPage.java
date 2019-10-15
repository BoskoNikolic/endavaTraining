package com.endavatraining.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class RegisterNewAccountPage extends  BasePage {


    private By registrationCode = By.id("registrationCode");
    private By userName = By.id("username");
    private By firstName = By.id("firstName");
    private By lastName = By.id("lastName");
    private By about = By.id("about");
    private By secretQuestion = By.id("secretQuestion");
    private By secretAnswer = By.id("secretAnswer");
    private By password = By.id("password");
    private By repassword = By.id("repassword");
    private By submitButton = By.id("submitButton");

    public RegisterNewAccountPage(WebDriver driver) {
        super(driver);
    }
    /**
     * The method enters all Credentials for a new user,and submits the form
     * @author luka.ivancic
     *
     * */


    public void signUpNewUser(String registrationCode, String userName, String firstName, String lastName, String about, String secretQuestion, String secretAnswer, String password){

        driver.findElement(this.registrationCode).sendKeys(registrationCode);
        driver.findElement(this.userName).sendKeys(userName);
        driver.findElement(this.firstName).sendKeys(firstName);
        driver.findElement(this.lastName).sendKeys(lastName);
        driver.findElement(this.about).sendKeys(about);
        driver.findElement(this.secretQuestion).sendKeys(secretQuestion);
        driver.findElement(this.secretAnswer).sendKeys(secretAnswer);
        driver.findElement(this.password).sendKeys(password);
        driver.findElement(this.repassword).sendKeys(password);

        if(driver.findElement(this.submitButton).isEnabled()){
            driver.findElement(this.submitButton).click();
        }else{
            Assert.assertTrue(driver.findElement(this.submitButton).isEnabled(), "Sign Up button is disabled");
        }

    }


}
