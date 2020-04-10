package com.endavatraining.pages;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class RegisterNewAccountPage extends BasePage {

	private By userNameField = By.xpath("//div[@id='registeruserinfo' and contains(@style,'display: block')]/div[1]");
	private By registrationCodeField = By.id("registrationCode");
	private By registrationCodeErrorMessage = By
			.xpath("//div[@id='regiCodeMessage'][contains(.,\"Bla bla incorect registration code format!\")]");
	public static Logger log = Logger.getLogger(RegisterNewAccountPage.class);
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
	 *
	 * This method enters registration code in Registration Code text field
	 *
	 * @author Jovan.Penic
	 * @param registrationCode
	 * @return boolean
	 */
	public void enterRegistrationCode(String registrationCode) {
		log.debug("Inserting registration code");
		driver.findElement(registrationCodeField).sendKeys(registrationCode);
	}

	/**
	 *
	 * This method enters text in Registration Code text field and checks is
	 * mentioned element visible
	 *
	 * @author Jovan.Penic
	 * @param randomRegistrationCode
	 * @return boolean
	 */
	public boolean isUserNameFieldPresent(String randomRegistrationCode) {
		enterRegistrationCode(randomRegistrationCode);
		return isElementPresent(userNameField);
	}

	/**
	 *
	 * This method checks if registration code error is visible
	 *
	 * @author Jovan.Penic
	 * @return boolean
	 */
	public boolean isRegistrationCodeErrorMessagePresent() {
		return isElementPresent(registrationCodeErrorMessage);
	}

	/**
	 * The method locates and returns the submit button
	 * 
	 * @author: luka.ivancic
	 * @return WebElement submit button
	 *
	 */
	public WebElement submitButton() {

		return driver.findElement(this.submitButton);

	}

	/**
	 * The method enters all Credentials for a new user,and submits the form
	 *
	 * @author luka.ivancic
	 */
	public void signUpNewUser(String registrationCode, String userName, String firstName, String lastName, String about,
			String secretQuestion, String secretAnswer, String password) {

		driver.findElement(this.registrationCode).sendKeys(registrationCode);
		driver.findElement(this.userName).sendKeys(userName);
		driver.findElement(this.firstName).sendKeys(firstName);
		driver.findElement(this.lastName).sendKeys(lastName);
		driver.findElement(this.about).sendKeys(about);
		driver.findElement(this.secretQuestion).sendKeys(secretQuestion);
		driver.findElement(this.secretAnswer).sendKeys(secretAnswer);
		driver.findElement(this.password).sendKeys(password);
		driver.findElement(this.repassword).sendKeys(password);

	}

	public void quit() {
		if (this.driver != null) {
			driver.quit();
		}

	}

}
