package com.endavatraining.pages;

import static org.testng.AssertJUnit.*;

import java.util.List;
import java.util.Optional;
import java.util.Random;
import java.util.StringJoiner;
import java.util.stream.Stream;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import com.google.common.primitives.Ints;
import com.google.common.primitives.Longs;

public class AlgorithmsPage extends BasePage {
	public static Logger log = Logger.getLogger(AlgorithmsPage.class);
	private List<WebElement> rows;
	private WebDriverWait wait = new WebDriverWait(driver, 3);
	public static By arithmeticsHomeTab = By.linkText("Algorithms");
	private static By arithmeticsButton = By.linkText("Algorithms");
	private static By upperRightLogInButton = By.xpath("//a[@href=\"javascript: document.logoutForm.submit()\"]");
	private static By formControl = By.xpath("//input[@class='form-control']['length'][@name='n']");
	private static By searchKey = By.xpath("//input[@class='form-control']['plainText'][@name='searchKey']");
	private static By vgnKey = By.xpath("//input[@class='form-control']['vgnKey'][@name='vgnKey']");
	private static By letter = By.xpath("//input[@class='form-control']['letter'][@name='letter']");
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
	private static By generatePrimeNumbers = By.xpath("//div[@class='col-md-6'][1]/input[@class='form-control'][@id='primes']");
	private static By generateFibonacciNumbers = By.xpath("//div[@class='col-md-6'][1]/input[@class='form-control'][@id='fibonacci']");
	private static By calculateFactorial = By.xpath("//div[@class='col-md-6'][1]/input[@class='form-control'][@id='factorial']");
	private static By generateRandomString = By.xpath("//div[@class='col-md-6'][1]/input[@class='form-control'][@id='rand']");
	private static By possiblePermutations = By.xpath("//div[4][@class='col-md-12']/textarea[@rows='4'][@cols='80']");
	private static By plainText = By.xpath("//div[@class='col-md-4'][1]/p[1]");
	//XOR: *******************
	private static By xorValue = By.xpath("//div[@class='col-md-4'][1]/p[2]");
	//ROT13:******************
	private static By rot13Value = By.xpath("//div[@class='col-md-4'][1]/p[4]");
	//Vigenere:***************
	private static By vigenereValue = By.xpath("//div[@class='col-md-4'][1]/p[7]");
	//Reverse:
	private static By reverseValue = By.xpath("//div[@class='col-md-4'][1]/p[7]");
	//Letters:
	private static By lettersValue = By.xpath("//div[@class='col-md-4'][2]/p[1]");
	//Digits:
	private static By digitsValue = By.xpath("//div[@class='col-md-4'][2]/p[2]");
	//Is palindrome:
	private static By isPalindromeValue = By.xpath("//div[@class='col-md-4'][2]/p[3]");
	//Contains key:	
	private static By containsKey = By.xpath("//div[@class='col-md-4'][2]/p[4]");
	//Contains letters:
	private static By containsLettersValue = By.xpath("//div[@class='col-md-4'][2]/p[5]");
	//Time to search:
	private static By timeToSearch = By.xpath("//div[@class='col-md-4'][2]/p[6]");
	//Sort asc:
	private static By sortAsc = By.xpath("//div[@class='col-md-4'][3]/p[1]");


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

	public void insertRandomValueInFormControlFields() {
		log.debug("Clear form control number field if there is any value");
		clearTextOnElement(formControl);
		Random rand = new Random();
		//Generate random integer in range 0 to 50
		int number = rand.nextInt(50);
		String formControlStr = Integer.toString(number);
		typeTextOnElement(formControl, formControlStr);
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
		int i = Optional.ofNullable(str)
				 .map(Ints::tryParse)
				 .orElse(0);
		int[] arr = new int[i];
		//int[] arr = Stream.of(str.replaceAll("[\\[\\]\\, ]", "").split("")).mapToInt(Integer::parseInt).toArray();
		return arr;
	}

	public long[] getLongFieldValueArray(By field) {
		String str = driver.findElement(field).getText();
		long i = Optional.ofNullable(str)
				 .map(Longs::tryParse)
				 .orElse((long) 0);
		long[] arr = new long[(int) i];
		//long[] arr = Stream.of(str.replaceAll("[\\[\\]\\, ]", "").split("")).mapToLong(Long::parseLong).toArray();
		return arr;
	}

	public int getIntFromString(By field) {
		String str = driver.findElement(field).getText();
		int i = Optional.ofNullable(str)
				 .map(Ints::tryParse)
				 .orElse(0);
		return i;
	}

	public long getLongFromString(By field) {
		String str = driver.findElement(field).getText();
		Long arr = Optional.ofNullable(str)
				 .map(Longs::tryParse)
				 .orElse((long) 0);
		//long arr = Long.parseLong(str);
		return arr;
	}

	public static String getStringFromString(By field) {
		String str = driver.findElement(field).getText();
		return str;
	}

	public void generatedPrimeNumbersVerification() {
		// expected array based on entered limit(formControlValue)
		int formControlInt = getIntFromString(formControl);
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
				if (isPrime) {
				    String test = String.valueOf(array[i]);
				    String str = String.join(", ", test);

					int i1 = Optional.ofNullable(str)
							 .map(Ints::tryParse)
							 .orElse(0);
					int[] arr = new int[i1];
					array = arr;
				    }
			}
		}
		
		
		// this is array generated by application
		int[] generatedPrimeNumber = getFieldValueArray(generatePrimeNumbers);
		// compare generated array and expected array - message part is added to get
		// message
		assertArrayEquals(array, generatedPrimeNumber);
	}

	// This method is not a part of ArrayAsserts class. Added for
	// generatedFibonacciNumbersVerification method
	public static void assertArrayEqualsLongInt(long[] expecteds, long[] generatedFibonacciNumbers) {
		assertArrayEqualsLongInt(expecteds, generatedFibonacciNumbers);
	}

	public void generatedFibonacciNumbersVerification() {
		// expected array based on entered limit(formControlValue)
		//insertValueInFormControlFields(formControlValue);
		int formControlInt = getIntFromString(formControl);
		long[] series = new long[formControlInt];
		

		// create expected array, loop through the number one by one
	    for (int j = 2; j < series.length; j++) {
			series[j] = series[j - 1] + series[j - 2];
		    String test = String.valueOf(series[j]);
		    String str = String.join(", ", test);
		    String str1 = String.join("0, 1, ", test);

		    long i1 = Optional.ofNullable(str)
					 .map(Longs::tryParse)
					 .orElse((long) 0);
			long[] arr = new long[(int) i1];
			series = arr;
		    }
		
		
		// this is array generated by application
	    long[] generatedFibonacciNumbers = getLongFieldValueArray(generateFibonacciNumbers);
		// compare generated array and expected array - message part is added to get
		// message
		assertArrayEquals(series, generatedFibonacciNumbers);
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

	public void randomStringVerification(){
		// verification will be based on verification that there is a class name such as
		// random generated string
		getStringFromString(generateRandomString).equals(getStringFromString(plainText));
	}
	
	public void repeatRandomFormControlValue(String searchKeyValue, String vgnKeyValue, String letterValue) {

		clearTextOnElement(formControl);
		insertRandomValueInFormControlFields();	
		clearTextOnElement(this.searchKey);
		typeTextOnElement(this.searchKey, searchKeyValue);
		clearTextOnElement(vgnKey);
		typeTextOnElement(vgnKey, vgnKeyValue);
		clearTextOnElement(letter);
		typeTextOnElement(letter, letterValue);
		clickSubmitButton();
	}

	public void submitFormControlValueLoop(String searchKeyValue, String vgnKeyValue, String letterValue) {
		repeatRandomFormControlValue(searchKeyValue, vgnKeyValue, letterValue);
		
		if ((getIntFromString(formControl)<6)&&(getIntFromString(formControl)>25)){
			repeatRandomFormControlValue(searchKeyValue, vgnKeyValue, letterValue);
		}
		else {
			clearTextOnElement(this.searchKey);
			typeTextOnElement(this.searchKey, searchKeyValue);
			clearTextOnElement(vgnKey);
			typeTextOnElement(vgnKey, vgnKeyValue);
			clearTextOnElement(letter);
			typeTextOnElement(letter, letterValue);
		}
		clickSubmitButton();
	}
	
	//for key I will use https://reverseengineering.stackexchange.com/questions/16163/help-me-understand-how-to-actually-break-an-xor-vigen%C3%A8re-cipher 
	//XOR: field and  Contains key: field to find content of Vigenere:  for input string for the code bellow
	//https://www.geeksforgeeks.org/vigenere-cipher/  I have used this url for help:  this part will be updated 
	
	
	// This function generates the key in 
	// a cyclic manner until it's length isi'nt 
	// equal to the length of original text 
	static String generateKey(String str, String key) 
	{ 
		str = getTextOfElement(generateRandomString);
	    int x = str.length(); 
	  
	    for (int i = 0; ; i++) 
	    { 
	        if (x == i) 
	            i = 0; 
	        if (key.length() == str.length()) 
	            break; 
	        key+=(key.charAt(i)); 
	    } 
	    return key; 
	} 

	public static String getValue(By field) {
		String str = driver.findElement(field).getText();
		return str;
	} 

	public static char getLetterValue(By field) {
		String str = driver.findElement(field).getText();
		char ch = str.charAt(0);  
		return ch;
	}
	  
	// This function returns the encrypted text 
	// generated with the help of the key 
	static String cipherText() 
	{ 
		String str = getValue(plainText);
		String key = getValue(searchKey);
	    String cipher_text=""; 
	  
	    for (int i = 0; i < str.length(); i++) 
	    { 
	        // converting in range 0-25 
	        int x = (str.charAt(i) + key.charAt(i)) %26; 
	  
	        // convert into alphabets(ASCII) 
	        x += 'A'; 
	  
	        cipher_text+=(char)(x); 
	    } 
	    return cipher_text; 
	} 
	  
	// This function decrypts the encrypted text 
	// and returns the original text 
	static String originalText() 
	{ 
		String cipher_text = cipherText();
		String key = getValue(searchKey);
		
	    String orig_text=""; 
	  
	    for (int i = 0 ; i < cipher_text.length() &&  
	                            i < key.length(); i++) 
	    { 
	        // converting in range 0-25 
	        int x = (cipher_text.charAt(i) -  
	                    key.charAt(i) + 26) %26; 
	  
	        // convert into alphabets(ASCII) 
	        x += 'A'; 
	        orig_text+=(char)(x);
	    } 
	    return orig_text; 
	}
	////*********** For caesar cipher Technique I will modify  https://www.geeksforgeeks.org/caesar-cipher-in-cryptography/
	//A Java Program to illustrate Caesar Cipher Technique 
	// Encrypts text using a shift  for ROT13
    public static StringBuffer encryptCaesar13() { 
    	String text = getValue(plainText);
    	StringBuffer result= new StringBuffer(); 
  
        for (int i=0; i<text.length(); i++) { 
            if (Character.isUpperCase(text.charAt(i))) 
            { 
                char ch = (char)(((int)text.charAt(i) + 13 - 65) % 26 + 65); 
                result.append(ch); 
            } 
            else
            { 
                char ch = (char)(((int)text.charAt(i) + 
                                  13 - 97) % 26 + 97); 
                result.append(ch); 
            } 
        }
		return result;
    }
    
    public String xorVerification(){
    	String plainTextValue = getValue(plainText);
    	String vigenereValueText = getValue(vigenereValue);
    	
        StringBuilder sb = new StringBuilder();
        for(int k=0; k < plainTextValue.length(); k++)
           sb.append((plainTextValue.charAt(k) ^ vigenereValueText.charAt(k + (Math.abs(plainTextValue.length() - vigenereValueText.length()))))) ;
           return sb.toString();
    }
    
    //// Java program to Reverse a String using swapping 
 // of variables

    public String reverseVerification(){
    	String plainTextValue = getValue(plainText);
    	  
        // getBytes() method to convert string  
        // into bytes[]. 
        byte [] strAsByteArray = plainTextValue.getBytes(); 
  
        byte [] result =  
                   new byte [strAsByteArray.length]; 
  
        // Store result in reverse order into the 
        // result byte[] 
        for (int i = 0; i<strAsByteArray.length; i++) 
            result[i] =  
             strAsByteArray[strAsByteArray.length-i-1]; 
  
        return(new String(result));
    }
        
	public void vigenereVerification(){
		assertTrue(xorVerification().equals(getStringFromString(rot13Value)));
	}
	
	public void verificationXOR(){
		assertTrue(xorVerification().equals(getTextOfElement(xorValue)));
	}
	
	public void verificationROT(){
		assertTrue(originalText().equals(getStringFromString(vigenereValue)));
	}
	
	public void revVerification(){
		String str = getValue(plainText);
		assertTrue(reverseVerification().equals(getStringFromString(reverseValue)));
	}
	
	public void paVerification(){
		String str = getValue(plainText);
		assertTrue(getStringFromString(plainText).equals(getStringFromString(reverseValue)));
	}
	
	public void containsKeyVerification(){
		String str = getValue(plainText);
		assertTrue(getStringFromString(plainText).equals(getStringFromString(reverseValue)));
	}
	
	public boolean containsLetters() {
		String s = getValue(plainText);
		char search = getLetterValue(letter);
		
	    if (s.length() == 0)
	        return false;
	    else
	        return s.charAt(0) == search || containsLetters();
	}
	
	public void containsLettersVerification(){
		String data = getStringFromString(lettersValue); 
		String str = String.valueOf(containsLetters());

		assertTrue(str.equals(getStringFromString(containsLettersValue)));
	}
	
	public String printPermutn(){
		// I have used https://www.geeksforgeeks.org/print-all-permutations-of-a-string-in-java/
		String str = getValue(plainText); 
		String ans = getValue(calculateFactorial);
    
  
		if (str.length() == 0) { 
            System.out.print(ans + " "); 
            ans = ans + "";
            return ans; 
        } 
  
        for (int i = 0; i < str.length(); i++) { 
  
            // ith character of str 
            char ch = str.charAt(i); 
  
            // Rest of the string after excluding  
            // the ith character 
            String ros = str.substring(0, i) +  
                         str.substring(i + 1); 
            ans = ans + ch;
  
            // Recurvise call 
            printPermutn(); 
        }
        ans = "";
        printPermutn();
        return ans;
     
    }

	public void printPermutnVerification(){
		String str = getValue(plainText);
		assertTrue(printPermutn().equals(getStringFromString(possiblePermutations)));
	}
	
}