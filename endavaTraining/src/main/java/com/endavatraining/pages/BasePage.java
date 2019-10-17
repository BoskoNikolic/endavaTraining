package com.endavatraining.pages;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;

public class BasePage {

	public WebDriver driver;
	public static Logger log = Logger.getLogger(BasePage.class);

	protected BasePage(WebDriver driver) {
		this.driver = driver;
	}
 
	protected boolean isElementPresent(By by){
		log.debug("Element found");
	        try{
	            driver.findElement(by);
	            return true;
	        }
	        catch(NoSuchElementException e){
	            return false;
	        }
	    }
	    	  
	public void quit() {
		log.debug("Quit browser");
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
		log.debug("Get attribute of any text field");
		return driver.findElement(anyTextField).getAttribute("value");
	}




}
