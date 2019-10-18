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
	private By galleryButton = By.xpath("//a[@href='/gallery']");
	public static final String USERNAME_LOGIN_VALUE = "user";
	public static final String PASSWORD_LOGIN_VALUE = "password";




	public LoginPage(WebDriver driver) {
		super(driver);
	}


	public void open() {
		log.debug("Opening endava training site");
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
		log.debug("Logging In user");
        open();
        insertTextInUsernameAndPasswordLogInTextFields(username, password);
        driver.findElement(this.loginButton).click();
    }

	public HomePage openAs(String username, String password) {
		log.debug("Logging In as user and opening Home Page");
		open();
		userLogin(username, password);
		return new HomePage(driver);
	}

	public boolean isErrorTextPresent() {
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
        driver.findElement(this.userName).sendKeys(username);
        driver.findElement(this.password).sendKeys(password);
		log.debug("Inserted text in user name and in password field");
    }

    /**
     *
     * This method finds and clicks on upper right Log In button
     *
     * @author Jovan.Penic
     */
    public void clickRightUpperLoginButton() {
        driver.findElement(upperRightLogInButton).click();
		log.debug("Clicked on upper right Log In button");
    }

    /**
     *
     *
     * @author Jovan.Penic
     * @return RegisterNewAccountPage
     */
    public RegisterNewAccountPage openCreateAccount() {
		log.debug("Clicking on create account on Log In page");
        open();
        driver.findElement(createAccountButton).click();
        return new RegisterNewAccountPage(driver);
    }

    /**
     *
     * This method clicks on and opens Gallery Page
     *
     * @author Jovan.Penic
     * @return GalleryPage
     */
    public GalleryPage openGalleryPage() {
        log.debug("Open gallery");
        driver.findElement(galleryButton).click();
        return new GalleryPage(driver);
    }


}