package com.endavatraining.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class LoginPage extends BasePage {

	private static final String ENDAVATRAINING_URL = "http://172.17.167.71:9010";

    private By loginButton = By.xpath("//input[@value='Log In']");
    private By userName = By.id("username");
    private By password = By.id("password");
    private By errorLoginText = By.id("loginbox");
	private  By upperRightLogInButton = By.xpath("//a[@href='/login']");

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

	/**
	 *
	 * This method finds username and password text fields, and inserts credentials.
	 *
	 * @author Jovan.Penic
	 * @param username
	 * @param password
	 */
	public void insertTextInTextField(String username, String password) {
		driver.findElement(this.userName).sendKeys(username);
		driver.findElement(this.password).sendKeys(password);
	}

	/**
	 *
	 * This method checks if values entered in username and password text fields are visible.
	 *
	 * @author Jovan.Penic
	 * @param username
	 * @param password
	 * @return boolean
	 */
	public boolean areValuesEnteredInTextFields(String username, String password){
		insertTextInTextField(username, password);
		return (driver.findElement(this.userName).getAttribute("value").equals("admin") &&
				driver.findElement(this.password).getAttribute("value").equals("password"));
	}

	/**
	 *
	 * This method checks if values entered in username and password text fields are visible after clicking on upper Log In button.
	 *
	 * @author Jovan.Penic
	 * @return boolean
	 */
	public boolean isUserPasswordTextFieldEmpty(){
		driver.findElement(upperRightLogInButton).click();
		String userNameText = driver.findElement(this.userName).getAttribute("value");
		String passWordText = driver.findElement(this.password).getAttribute("value");
		return (userNameText.isEmpty() && passWordText.isEmpty());
	}


}
