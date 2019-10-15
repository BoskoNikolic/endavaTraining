package com.endavatraining.pages;

import com.endavatraining.util.Utils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class LoginPage extends BasePage {

	private static final String ENDAVATRAINING_URL = "http://172.17.167.71:9010";

	private By loginButton = By.xpath("//input[@value='Log In']");
	private By userName = By.id("username");
	private By password = By.id("password");
	private By upperRightLogInButton = By.xpath("//a[@href='/login']");
	private By createAccountButton = By.xpath("//a[@href='/register']");

	public LoginPage(WebDriver driver) {
		super(driver);
	}
	

	public void open() {
		driver.get(ENDAVATRAINING_URL);
	}

	public By getLoginButton() {
		return loginButton;
	}

	public HomePage openAs(String username, String password){
		open();
		insertTextInUsernameAndPasswordLogInTextFields(username, password);
		driver.findElement(this.loginButton).click();
		
		return new HomePage(driver);		
	}

	/**
	 *
	 *
	 * @author Jovan.Penic
	 * @return RegisterNewAccountPage
	 */
	public RegisterNewAccountPage openCreateAccount() {
		open();
		driver.findElement(createAccountButton).click();
		return new RegisterNewAccountPage(driver);
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
	}

	/**
	 *
	 * This method finds and clicks on upper right Log In button
	 *
	 * @author Jovan.Penic
	 */
	public void clickRightUpperLoginButton() {
		driver.findElement(upperRightLogInButton).click();
	}




}
