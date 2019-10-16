package com.endavatraining.pages;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class LoginPage extends BasePage {

	public static Logger logger = Logger.getLogger(LoginPage.class);

	private static final String ENDAVATRAINING_URL = "http://172.17.167.71:9010";

	private By loginButton = By.xpath("//input[@value='Log In']");
	private By userName = By.xpath("//input[@name='username']");
	private By password = By.xpath("//input[@name='password']");
	private By logOutMessage = By.xpath("//div[@class='alert alert-success']");

	public LoginPage(WebDriver driver) {
		super(driver);
	}

	public void userLogin(String username, String password) {
		open();
		driver.findElement(this.userName).sendKeys(username);
		driver.findElement(this.password).sendKeys(password);
		driver.findElement(this.loginButton).click();
	}


	public void open() {
		driver.get(ENDAVATRAINING_URL);
		driver.manage().window().maximize();
	}

	public By getLoginButton() {
		return loginButton;

	}

	public By getLogOutMessage() {
		return logOutMessage;

	}

	public HomePage openAs(String username, String password){
		open();
		driver.findElement(this.userName).sendKeys(username);
		driver.findElement(this.password).sendKeys(password);

		driver.findElement(this.loginButton).click();
		
		return new HomePage(driver);		
	}
}
