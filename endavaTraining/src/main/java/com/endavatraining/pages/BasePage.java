package com.endavatraining.pages;

import org.apache.log4j.Logger;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage {

	public static WebDriver driver;
	public static Logger log = Logger.getLogger(BasePage.class);
	public static final String LOG_OUT_MESSAGE = "You have been logged out.";

	private Select dropClass;

    protected BasePage(WebDriver driver) {
		this.driver = driver;
	}

	protected boolean isElementPresent(By by){
	        try{
	            driver.findElement(by);
	            return true;
	        }
	        catch(NoSuchElementException e){
	            return false;
	        }
	    }

	public void quit() {
		log.debug("Quitting browser");
		if (this.driver != null) {
			driver.quit();
		}
	}

	/**
	 *
	 * This method returns value of attributes of any text field
	 *
	 * @author Jovan.Penic
	 * @param driver
	 * @param anyTextField
	 * @return
	 */
	public static String getAttributeOfAnyTextField(WebDriver driver, By anyTextField){
		return driver.findElement(anyTextField).getAttribute("value");
	}

    /**
     * This method clicks on button that is passed
     * @author Danko.Lojanica
     * @param button
     */
     public void clickOnButton(By button){
        driver.findElement(button).click();
    }

    /**
     * This method returns text of any passed element
     * @author Danko.Lojanica
     * @param element
     * @return
     */
    public String getTextOfElement(By element) {
        return driver.findElement(element).getText();
    }

	/**
	 * This method send keys on passed element
	 * @author Danko.Lojanica
	 */
	public void sendKeys(By by, String text){
		driver.findElement(by).sendKeys(text);
	}

	/**
	 * This method accepts alert end returns text from it
	 * @author Danko.Lojanica
	 * @return alertMessage
	 */
	public String alertMethod(){
		Alert alert = driver.switchTo().alert();
		String alertMessage = alert.getText();
		alert.accept();
		return alertMessage;
	}
	/*
	 *This method sends text into chosen text field
	 * @author Srboljub.Todorovic
	 * @param By, String
	 */
	public void typeTextOnElement(By field, String keys) {
		WebDriverWait wait = new WebDriverWait(driver, 3);
		wait.until(ExpectedConditions.elementToBeClickable(field));
		driver.findElement(field).sendKeys(keys);
	}

	/*
	 *This method selects desirable option from drop down menu options
	 * @author Srboljub.Todorovic
	 * @param By, String
	 */
	public void dropDownMenuSelect(By dropMenu, String dropText) {
		WebDriverWait wait = new WebDriverWait(driver, 3);
		wait.until(ExpectedConditions.elementToBeClickable(dropMenu));
		dropClass = new Select(driver.findElement(dropMenu));
		dropClass.selectByVisibleText(dropText);
	}


    /**
     * This method clears text of selected element
     *
     * @author Jovan.Penic
     * @param field
     */
	public void clearTextOnElement(By field) {
		WebDriverWait wait = new WebDriverWait(driver, 3);
		wait.until(ExpectedConditions.elementToBeClickable(field));
		driver.findElement(field).clear();
	}

}
