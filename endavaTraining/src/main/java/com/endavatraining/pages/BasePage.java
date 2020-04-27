package com.endavatraining.pages;

import java.util.List;

import org.apache.log4j.Logger;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
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

	protected boolean isElementPresent(By by) {
		new WebDriverWait(driver,5).until(ExpectedConditions.visibilityOfElementLocated(by));
		return false;
	}

	public void quit() {
		log.debug("Quitting browser");
		if (this.driver != null) {
			driver.quit();
		}
	}
	
	public static String getAttributeOfAnyTextField(WebDriver driver, By anyTextField) {
		return driver.findElement(anyTextField).getAttribute("value");
	}

	public void clickOnButton(By button) {
		driver.findElement(button).click();
	}

	public static String getTextOfElement(By element) {
		return driver.findElement(element).getText();
	}

	public void sendKeys(By by, String text) {
		driver.findElement(by).sendKeys(text);
	}
	
	public String alertMethod() {
		Alert alert = driver.switchTo().alert();
		String alertMessage = alert.getText();
		alert.accept();
		return alertMessage;
	}
	
	public void typeTextOnElement(By field, String keys) {
		WebDriverWait wait = new WebDriverWait(driver, 3);
		wait.until(ExpectedConditions.elementToBeClickable(field));
		driver.findElement(field).sendKeys(keys);
	}

	public void dropDownMenuSelect(By dropMenu, String dropText) {
		WebDriverWait wait = new WebDriverWait(driver, 3);
		wait.until(ExpectedConditions.elementToBeClickable(dropMenu));
		dropClass = new Select(driver.findElement(dropMenu));
		dropClass.selectByVisibleText(dropText);
	}
	
	public void clearTextOnElement(By field) {
		WebDriverWait wait = new WebDriverWait(driver, 3);
		wait.until(ExpectedConditions.elementToBeClickable(field));
		driver.findElement(field).clear();
	}

	public void waitInvisibilityOfElement(By invisibilityOfElement) {
		WebDriverWait wait = new WebDriverWait(driver, 3);
		wait.until(ExpectedConditions.invisibilityOfElementLocated(invisibilityOfElement));
	}

	public void waitForElementToBeClickable(By clickableElement) {
		WebDriverWait wait = new WebDriverWait(driver, 3);
		wait.until(ExpectedConditions.elementToBeClickable(clickableElement));
	}

}
