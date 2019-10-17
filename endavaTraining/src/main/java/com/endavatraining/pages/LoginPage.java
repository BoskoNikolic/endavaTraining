package com.endavatraining.pages;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends BasePage {

	private static final String ENDAVATRAINING_URL = "http://172.17.167.71:9010";
	public static Logger log = Logger.getLogger(LoginPage.class);

	private By loginButton = By.xpath("//input[@value='Log In']");
	private By userName = By.id("username");
	private By password = By.id("password");
	private By errorLoginText = By.id("loginbox");
    private By upperRightLogInButton = By.xpath("//a[@href='/login']");
	private By createAccountButton = By.xpath("//a[@href='/register']");

    public LoginPage(WebDriver driver) {
		super(driver);
	}
	

	public void open() {
		log.debug("Open endava training site");
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
		log.debug("Log In user");
        open();
        insertTextInUsernameAndPasswordLogInTextFields(username, password);
        driver.findElement(this.loginButton).click();
    }

	public HomePage openAs(String username, String password) {
		log.debug("Log In as user and open Home Page");
		open();
		userLogin(username, password);
		return new HomePage(driver);
	}

	public boolean isErrorTextPresent() {
		log.debug("Is error text present?");
		return isElementPresent(errorLoginText);
	}

    /**
     *
     * This method finds username and password text fields, and inserts credentials.
     *
     * @author Jovan.Penic
     * @param username
     * @param password
     */
    public void insertTextInUsernameAndPasswordLogInTextFields(String username, String password) {
		log.debug("Insert text in user name and in password field");
        driver.findElement(this.userName).sendKeys(username);
        driver.findElement(this.password).sendKeys(password);
    }

    /**
     *
     * This method finds and clicks on upper right Log In button
     *
     * @author Jovan.Penic
     */
    public void clickRightUpperLoginButton() {
		log.debug("Click on upper right Log In button");
        driver.findElement(upperRightLogInButton).click();
    }

    /**
     *
     *
     * @author Jovan.Penic
     * @return RegisterNewAccountPage
     */
    public RegisterNewAccountPage openCreateAccount() {
		log.debug("Click create account on Log In page");
        open();
        driver.findElement(createAccountButton).click();
        return new RegisterNewAccountPage(driver);
    }



}