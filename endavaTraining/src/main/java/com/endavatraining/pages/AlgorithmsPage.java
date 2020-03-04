package com.endavatraining.pages;

import static org.testng.AssertJUnit.*;

import java.util.List;
import java.util.stream.Stream;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AlgorithmsPage extends BasePage {
	public static Logger log = Logger.getLogger(HeroesPage.class);
	private List<WebElement> rows;
	private WebDriverWait wait = new WebDriverWait(driver, 3);
	public static By arithmeticsHomeTab = By.linkText("Algorithms");
    private By arithmeticsButton = By.linkText("Algorithms");
	private By upperRightLogInButton = By.xpath("//a[@href='/login']");
	private By formControl = By.id("length");
	private By searchKey = By.id("plainText");
	private By vgnKey = By.id("vgnKey");
	private By letter = By.id("letter");
	private By algorithmsPageWelcomeMessage = By.xpath("//div[@class='panel-title text-center'][contains(.,'Hello, and welcome to our gamers page!')]");
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
	private By generatePrimeNumbers = By.id("primes");
	private By generateFibonacciNumbers = By.id("fibonacci");

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
    public void generatedPrimeNumbersVerification(String formControlValue) {
    	//expected array based on entered limit(formControlValue)
    	insertValueInFormControlFields(formControlValue);
    	int formControlInt = Integer.parseInt(formControlValue);
    	int[] array = new int[formControlInt];
    	//create expected array, loop through the number one by one
    	for (int i=1; i<array.length; i++) {
    		boolean isPrime = true;
    		//check to see if the number is prime
    		for(int j=2; j<i;j++) {
    			if(i%j==0) {
    				isPrime=false;
    				break;
    			}
    			if(isPrime)
    			System.out.print(array[i] + "");
    		}	
    	}
    	//this is array generated by application
    	int[] generatedPrimeNumber = getFieldValueArray(generatePrimeNumbers);
    	//compare generated array and expected array - message part is added to get message
    	assertArrayEquals(array, generatedPrimeNumber);
    	if(array == generatedPrimeNumber)
    		System.out.println("Test PASS, we got the expected results.");
    	else
			System.out.println("Test FAIL, we didnot get expected results.");
    }
    //This method is not a part of ArrayAsserts class. Added for generatedFibonacciNumbersVerification method
    public static void assertArrayEqualsLongInt(long[] expecteds, long[] generatedFibonacciNumbers) {
    	assertArrayEqualsLongInt(expecteds, generatedFibonacciNumbers);
    }
    public void generatedFibonacciNumbersVerification(String formControlValue) {
    	//expected array based on entered limit(formControlValue)
    	insertValueInFormControlFields(formControlValue);
    	long formControlLong = Long.parseLong(formControlValue);
    	long[] series = new long[(int) formControlLong];
    	//create expected series, loop through the number one by one
    	//create first 2 series elements
    	series[0]=0;
    	series[1]=1;
    	
    	//create Fibonacci series and store it in an array
    	for(int i=2; i<formControlLong; i++) {
    		series[i]=series[i-1]+series[i-2];
    	}
    	//print the Fibonacci series numbers
    	for(int i=2; i< formControlLong; i++){
        	System.out.print(series[i] + "");	
    	}
    	//this is array generated by application
    	long[] generatedFibonacciNumbers = getLongFieldValueArray(generateFibonacciNumbers);
    	//compare generated array and expected series - message part is added to get message
    	assertArrayEqualsLongInt(series, generatedFibonacciNumbers);
    	if(series == generatedFibonacciNumbers)
    		System.out.println("Test PASS, we got the expected results.");
    	else
			System.out.println("Test FAIL, we didnot get expected results.");
    }
}