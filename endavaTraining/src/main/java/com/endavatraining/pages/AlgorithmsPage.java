package com.endavatraining.pages;

import static org.testng.AssertJUnit.*;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Stream;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AlgorithmsPage extends BasePage {
	public static Logger log = Logger.getLogger(AlgorithmsPage.class);
	private List<WebElement> rows;
	private WebDriverWait wait = new WebDriverWait(driver, 3);
	public static By arithmeticsHomeTab = By.linkText("Algorithms");
    private  static By arithmeticsButton = By.linkText("Algorithms");
	private static By upperRightLogInButton = By.xpath("//a[@href='/login']");
	private static By formControl = By.id("length");
	private static By searchKey = By.id("plainText");
	private static By vgnKey = By.id("vgnKey");
	private static By letter = By.id("letter");
	private static By algorithmsPageWelcomeMessage = By.xpath("//div[@class='panel-title text-center'][contains(.,'Hello, and welcome to our gamers page!')]");
	public static By submitButton = By.linkText("Submit");
	private static By wonderlandPageWelcomeMessage = By.xpath("//div[@class='panel-title text-center'][contains(.,'Alice in Wonderland')]");
	private static By loginPageSamsaraWelcomeMessage = By.xpath("//div[@class='panel-title text-center'][contains(.,'Samsara')]");
	private static By loginButton = By.xpath("//input[@value='Log In']");
	private static By userName = By.id("username");
	private static By password = By.id("password");
	private static By errorLoginText = By.id("loginbox");
	private static By createAccountButton = By.xpath("//a[@href='/register']");
	private static By galleryButton = By.xpath("//a[@href='/gallery']");
	private static By profileButton = By.linkText("Profile");
	private static By resetPassword = By.xpath("//a[@href='/forgotpassword ']");
	private static By generatePrimeNumbers = By.id("primes");
	private static By generateFibonacciNumbers = By.id("fibonacci");
	private static By calculateFactorial = By.id("factorial");
	private static By generateRandomString = By.id("rand");
	private static By possiblePermutations = By.xpath("/html/body/div[1]/div/div/div[2]/div[4]/textarea");//xpath will be updated 


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
	public void clearTextOnElement(By field) {
		WebDriverWait wait = new WebDriverWait(driver, 3);
		driver.findElement(field).clear();
	}
    public void insertValueInFormControlFields(String formControlValue) {
		log.debug("Clear form control number field if there is any value");
    	clearTextOnElement(formControl);
		log.debug("Enter value into the control number field");
    	typeTextOnElement(formControl, formControlValue);
		log.debug("Inserted number in form control number field");
    }
    public void insertValueInSearchKeyFields(String searchKeyValue) {
		log.debug("Clear form searchKey field if there is any value");
    	clearTextOnElement(this.searchKey);
		log.debug("Enter value into the searchKey  field");
    	typeTextOnElement(this.searchKey, searchKeyValue);
		log.debug("Inserted number in searchKey  field");
    }
    public void clickArithmeticsHomeTab() {
        driver.findElement(arithmeticsHomeTab).click();
		log.debug("Clicked on Arithmetic Home Tab");
    }
    /*public void insertValueInSearchKeyFields(String searchKey) {
        driver.findElement(this.searchKey).sendKeys(searchKey);
		log.debug("Inserted searchKey in search key field");
    }*/
    public void insertValueInVigenereFields(String vgnKey) {
        driver.findElement(this.vgnKey).sendKeys(vgnKey);
		log.debug("Inserted FJv6Jb in Vigenere key field");
    }
    public void insertValueInLetterFields(String letter) {
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
    public void submitNewValue(String formControlValue, String searchKeyValue, String vgnKeyValue, String letterValue) {
    	insertValueInFormControlFields(formControlValue);
    	clearTextOnElement(this.searchKey);
    	typeTextOnElement(this.searchKey, searchKeyValue);
    	clearTextOnElement(vgnKey);
    	typeTextOnElement(vgnKey, vgnKeyValue);
    	clearTextOnElement(letter);
    	typeTextOnElement(letter, letterValue);
        clickSubmitButton();
    }
    public void insertTextInUsernameAndPasswordLogInTextFields(String username, String password) {
        driver.findElement(this.userName).sendKeys(username);
        driver.findElement(this.password).sendKeys(password);
		log.debug("Inserted text in user name and in password field");
    }
    public int[] getFieldValueArray(By field) {
        String str = driver.findElement(field).getText();
		int[] arr=Stream.of(str.replaceAll("[\\[\\]\\, ]", "").split("")).mapToInt(Integer::parseInt).toArray();
		return arr;
    }
    public long[] getLongFieldValueArray(By field) {
        String str = driver.findElement(field).getText();
        long[] arr=Stream.of(str.replaceAll("[\\[\\]\\, ]", "").split("")).mapToLong(Long::parseLong).toArray();
		return arr;
    }
    public int getIntFromString(By field) {
        String str = driver.findElement(field).getText();
        int i=Integer.parseInt(str);
		return i;
    }
    public long getLongFromString(By field) {
        String str = driver.findElement(field).getText();
        long arr=Long.parseLong(str);
		return arr;
    }
    public static String getStringFromString(By field) {
        String str = driver.findElement(field).getText();
		return str;
    }
    public static String getRandomString() {
    	//this random value generated by application
    	return getStringFromString(generateRandomString);
    }
    public static String getPlaintextRandomString() {
    	//get text from plainText 
    	String PlainText = "//p[@text()=" + "’" + getStringFromString(generateRandomString) + "’";
    	String randomString = driver.findElement(By.xpath(PlainText)).getText();
		return randomString;
    }
    public void randomStringVerification() throws Exception {
    	//verification will be based on verification that there is a class name such as random generated string
    	assertTrue(getRandomString().equals(getPlaintextRandomString()));
    }
    public static String convertStringInArayOfLetters() {
    	//convert string into an array of characters
    	String PlainText = "//p[@text()=" + "’" + getStringFromString(generateRandomString) + "’";
    	String randomString = driver.findElement(By.xpath(PlainText)).getText();
    	char[] charArray = randomString.toCharArray();
		return Arrays.toString(charArray);
    }
    //this method return letters reference for comparing 
    public static String parseLetters() {
    	//parse letters from string plaintext
    	String PlainText = "//p[@text()=" + "’" + getStringFromString(generateRandomString) + "’";
    	String randomString = driver.findElement(By.xpath(PlainText)).getText();	
		// eliminate leading and trailing spaces 
		randomString = randomString.trim(); 
        // split all non-alphabetic characters 
		// split any non word  ; this is result of parseLetters()
        String delims = "\\W+";
        String[] tokens = randomString.split(delims);
        // print the tokens 
        for (String item : tokens) { 
            return(item + " "); 
        }
		return null;
    }
    //this method return digit reference for comparing 
    public static String parseDigit() {
    	//parse digit from string plaintext
    	String PlainText = "//p[@text()=" + "’" + getStringFromString(generateRandomString) + "’";
    	String randomString = driver.findElement(By.xpath(PlainText)).getText();	
		// eliminate leading and trailing spaces 
		randomString = randomString.trim(); 
        // split all non-digit characters 
		// split any non digit  ; this is result of parseLetters()
        String digits = "\\d+";
        String[] tokens = randomString.split(digits);
        // print the tokens 
        for (String item : tokens) { 
            return(item + " "); 
        }
		return null;
    }
    public static String getpClassNameLettersField() {
    	//get text from plainText 
    	String Letters = "//p[@text()=" + "’" + getStringFromString(generateRandomString) + "’";
    	String className = driver.findElement(By.xpath(Letters)).getText();
		return className;
    }
    public void randomLettersVerification() throws Exception {
    	//verification will be based on verification that there is a class name such as Letters field
    	String PlainText = "//p[@text()=" + "’" + parseLetters() + "’";
    	String randomString = driver.findElement(By.xpath(PlainText)).getText();	
    	assertTrue(randomString.equals(parseLetters()));
    }
    public void randomDigitsVerification() throws Exception {
    	//verification will be based on verification that there is a class name such as Digits field
    	String PlainText = "//p[@text()=" + "’" + parseDigit() + "’";
    	String randomString = driver.findElement(By.xpath(PlainText)).getText();	
    	assertTrue(randomString.equals(parseDigit()));
    }
}