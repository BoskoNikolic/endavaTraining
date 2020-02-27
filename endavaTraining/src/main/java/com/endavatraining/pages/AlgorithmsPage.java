package com.endavatraining.pages;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class AlgorithmsPage extends BasePage {
	//private static final String ENDALGORITHMS_URL = "http://localhost:8080/algorithms";
	private WebDriverWait wait = new WebDriverWait(driver, 3);
	public static Logger log = Logger.getLogger(AlgorithmsPage.class);
	//private By arithmeticsHomeTab = By.xpath("//a[@href='/Algorithms']");
	public static By arithmeticsHomeTab = By.linkText("Algorithms");
    private By arithmeticsButton = By.linkText("Algorithms");
	private By upperRightLogInButton = By.xpath("//a[@href='/login']");
	private By formControl = By.id("length");
	private By searchKey = By.id("plainText");
	private By vgnKey = By.id("vgnKey");
	private By letter = By.id("letter");
	private By algorithmsPageWelcomeMessage = By.xpath("//div[@class='panel-title text-center'][contains(.,'Hello, and welcome to our gamers page!')]");
    //private By submitButton = By.xpath("/html/body/div[1]/div/div/div[2]/div[1]/form/div/div[5]/button");
	//private By submitButton = By.xpath("//input[@value='Submit']");
	public static By submitButton = By.linkText("Submit");
	private By wonderlandPageWelcomeMessage = By.xpath("//div[@class='panel-title text-center'][contains(.,'Alice in Wonderland')]");
	private By loginPageSamsaraWelcomeMessage = By.xpath("//div[@class='panel-title text-center'][contains(.,'Samsara')]");
	private By loginButton = By.xpath("//input[@value='Log In']");
	private By userName = By.id("username");
	private By password = By.id("password");
	private By errorLoginText = By.id("loginbox");
	private By createAccountButton = By.xpath("//a[@href='/register']");
	private By galleryButton = By.xpath("//a[@href='/gallery']");
	private By profileButton = By.linkText("Profile");
	private By resetPassword = By.xpath("//a[@href='/forgotpassword ']");

	public AlgorithmsPage(WebDriver driver) {
		super(driver);
	}
	public void goToPage(By pageTab) {
		driver.findElement(pageTab).click();
	}
	public void openArithmeticsPage() {
        wait.until(ExpectedConditions.elementToBeClickable(arithmeticsHomeTab));
        clickOnButton(arithmeticsHomeTab);
    }
    public void clickOnAlgorithmsButton() {
        driver.findElement(arithmeticsButton).click();
    }
	public By getSubmitButton() {
		return submitButton;
	}
	public By getLoginButton() {
		return loginButton;
	}
    public void insertValueInFormControlFields(CharSequence[] formControl) {
        driver.findElement(this.formControl).sendKeys(formControl);
		log.debug("Inserted number in form control number field");
    }
    public void clickArithmeticsHomeTab() {
        driver.findElement(arithmeticsHomeTab).click();
		log.debug("Clicked on Arithmetic Home Tab");
    }
    public void insertValueInSearchKeyFields(String searchKey) {
        driver.findElement(this.searchKey).sendKeys(searchKey);
		log.debug("Inserted searchKey in search key field");
    }
    public void insertValueInVigenereFields(String vgnKey) {
        driver.findElement(this.vgnKey).sendKeys(vgnKey);
		log.debug("Inserted FJv6Jb in Vigenere key field");
    }
    public void insertValueInLetterFields(CharSequence[] letter) {
        driver.findElement(this.letter).sendKeys(letter);
		log.debug("Inserted letter in Vigenere key field");
    }
    public void clickRightUpperLoginButton() {
        driver.findElement(upperRightLogInButton).click();
		log.debug("Clicked on upper right Log In button");
    }
    public void clickLoginButton() {
        driver.findElement(loginButton).click();
		log.debug("Clicked on Login button");
    }
    public void clickSubmitButton() {
        driver.findElement(submitButton).click();
		log.debug("Clicked on Submit button");
    }
    public void submitNewValue(CharSequence[] formControl, String searchKey, String vgnKey, CharSequence[] letter) {
        driver.findElement(this.formControl).sendKeys(formControl);
        driver.findElement(this.searchKey).sendKeys(searchKey);
        driver.findElement(this.vgnKey).sendKeys(vgnKey);
        driver.findElement(this.letter).sendKeys(letter);
        clickSubmitButton();
    }
    public void insertTextInUsernameAndPasswordLogInTextFields(String username, String password) {
        driver.findElement(this.userName).sendKeys(username);
        driver.findElement(this.password).sendKeys(password);
		log.debug("Inserted text in user name and in password field");
    }

}
