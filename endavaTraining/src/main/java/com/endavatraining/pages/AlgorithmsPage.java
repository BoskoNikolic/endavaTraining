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
	public static Logger log = Logger.getLogger(AlgorithmsPage.class);
	private List<WebElement> rows;
	private WebDriverWait wait = new WebDriverWait(driver, 3);
	public static By arithmeticsHomeTab = By.linkText("Algorithms");
	private static By arithmeticsButton = By.linkText("Algorithms");
	private static By upperRightLogInButton = By.xpath("//a[@href='/login']");
	private static By formControl = By.xpath("//form//input[@class='form-control']['length'][@name='n']");
	private static By searchKey = By.xpath("//form//input[@class='form-control']['plainText'][@name='searchKey']");
	private static By vgnKey = By.xpath("//form//input[@class='form-control']['vgnKey'][@name='vgnKey']");
	private static By letter = By.xpath("//form//input[@class='form-control']['letter'][@name='letter']");
	private static By algorithmsPageWelcomeMessage = By
			.xpath("//div[@class='panel-title text-center'][contains(.,'Hello, and welcome to our gamers page!')]");
	public static By submitButton = By.xpath("//form//button[@type='submit']");
	private static By wonderlandPageWelcomeMessage = By
			.xpath("//div[@class='panel-title text-center'][contains(.,'Alice in Wonderland')]");
	private static By loginPageSamsaraWelcomeMessage = By
			.xpath("//div[@class='panel-title text-center'][contains(.,'Samsara')]");
	private static By loginButton = By.xpath("//input[@value='Log In']");
	private static By userName = By.id("username");
	private static By password = By.id("password");
	private static By errorLoginText = By.id("loginbox");
	private static By createAccountButton = By.xpath("//a[@href='/register']");
	private static By galleryButton = By.xpath("//a[@href='/gallery']");
	private static By profileButton = By.linkText("Profile");
	private static By resetPassword = By.xpath("//a[@href='/forgotpassword ']");
	private static By generatePrimeNumbers = By.xpath("//input[@class='form-control'][@id='primes]");
	private static By generateFibonacciNumbers = By.xpath("//input[@class='form-control'][@id='fibonacci]");
	private static By calculateFactorial = By.xpath("//input[@class='form-control'][@id='factorial']");
	private static By generateRandomString = By.xpath("//input[@class='form-control'][@id='rand']");
	private static By possiblePermutations = By.xpath("//textarea");

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
		int[] arr = Stream.of(str.replaceAll("[\\[\\]\\, ]", "").split("")).mapToInt(Integer::parseInt).toArray();
		return arr;
	}

	public long[] getLongFieldValueArray(By field) {
		String str = driver.findElement(field).getText();
		long[] arr = Stream.of(str.replaceAll("[\\[\\]\\, ]", "").split("")).mapToLong(Long::parseLong).toArray();
		return arr;
	}

	public int getIntFromString(By field) {
		String str = driver.findElement(field).getText();
		int i = Integer.parseInt(str);
		return i;
	}

	public long getLongFromString(By field) {
		String str = driver.findElement(field).getText();
		long arr = Long.parseLong(str);
		return arr;
	}

	public static String getStringFromString(By field) {
		String str = driver.findElement(field).getText();
		return str;
	}

	public void generatedPrimeNumbersVerification(String formControlValue) {
		// expected array based on entered limit(formControlValue)
		insertValueInFormControlFields(formControlValue);
		int formControlInt = Integer.parseInt(formControlValue);
		int[] array = new int[formControlInt];
		// create expected array, loop through the number one by one
		for (int i = 1; i < array.length; i++) {
			boolean isPrime = true;
			// check to see if the number is prime
			for (int j = 2; j < i; j++) {
				if (i % j == 0) {
					isPrime = false;
					break;
				}
				if (isPrime)
					System.out.print(array[i] + "");
			}
		}
		// this is array generated by application
		int[] generatedPrimeNumber = getFieldValueArray(generatePrimeNumbers);
		// compare generated array and expected array - message part is added to get
		// message
		assertArrayEquals(array, generatedPrimeNumber);
		if (array == generatedPrimeNumber)
			System.out.println("Test PASS, we got the expected results.");
		else
			System.out.println("Test FAIL, we didnot get expected results.");
	}

	// This method is not a part of ArrayAsserts class. Added for
	// generatedFibonacciNumbersVerification method
	public static void assertArrayEqualsLongInt(long[] expecteds, long[] generatedFibonacciNumbers) {
		assertArrayEqualsLongInt(expecteds, generatedFibonacciNumbers);
	}

	public void generatedFibonacciNumbersVerification(String formControlValue) {
		// expected array based on entered limit(formControlValue)
		insertValueInFormControlFields(formControlValue);
		long formControlLong = Long.parseLong(formControlValue);
		long[] series = new long[(int) formControlLong];
		// create expected series, loop through the number one by one
		// create first 2 series elements
		series[0] = 0;
		series[1] = 1;

		// create Fibonacci series and store it in an array
		for (int i = 2; i < formControlLong; i++) {
			series[i] = series[i - 1] + series[i - 2];
		}
		// print the Fibonacci series numbers
		for (int i = 2; i < formControlLong; i++) {
			System.out.print(series[i] + "");
		}
		// this is array generated by application
		long[] generatedFibonacciNumbers = getLongFieldValueArray(generateFibonacciNumbers);
		// compare generated array and expected series - message part is added to get
		// message
		assertArrayEqualsLongInt(series, generatedFibonacciNumbers);
		if (series == generatedFibonacciNumbers)
			System.out.println("Test PASS, we got the expected results.");
		else
			System.out.println("Test FAIL, we didnot get expected results.");
	}

	public int getApplicationFactorialValue() {
		// this is factorial value generated by application
		return getIntFromString(calculateFactorial);
	}

	public int calculatedFactorial(String formControlValue) {
		// expected array based on entered limit(formControlValue)
		insertValueInFormControlFields(formControlValue);
		int formControlInt = Integer.parseInt(formControlValue);
		int fact = 1;

		// factorial algorithm using a for loop
		for (int i = 2; i < formControlInt; i++) {
			fact = fact * i;
		}
		return fact;
	}

	public static boolean compareFactorial(Integer int1, Integer int2) {
		if (int1 != null) {
			return int1.equals(int2);
		} else {
			return int2 == null;
		}
	}

	public static String getRandomString() {
		// this random value is generated by application
		return getStringFromString(generateRandomString);
	}

	public static String getPlaintextRandomString() {
		// get text from plainText
		String PlainText = "//p[@text()=" + "’" + getStringFromString(generateRandomString) + "’";
		String randomString = driver.findElement(By.xpath(PlainText)).getText();
		return randomString;
	}

	public void randomStringVerification() throws Exception {
		// verification will be based on verification that there is a class name such as
		// random generated string
		assertTrue(getRandomString().equals(getPlaintextRandomString()));
	}
}