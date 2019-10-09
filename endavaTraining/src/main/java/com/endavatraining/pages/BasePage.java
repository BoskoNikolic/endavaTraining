package com.endavatraining.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;

public class BasePage {

	public WebDriver driver;

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
		if (this.driver != null) {
			driver.quit();
		}
	}
}
