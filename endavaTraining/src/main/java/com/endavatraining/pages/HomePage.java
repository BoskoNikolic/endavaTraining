package com.endavatraining.pages;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


public class HomePage extends BasePage {


	private By homePageWelcomeMessage = By.xpath("//div[@class='panel-title text-center'][contains(.,'Hello, and welcome to our gamers page!')]");
	private By usersPage = By.linkText("Users");

	public static Logger log = Logger.getLogger(HomePage.class);

	public HomePage(WebDriver driver) {
		super(driver);
	}


	public boolean isWelcomeTextPresent() {
		return isElementPresent(homePageWelcomeMessage);
	}

	public WebElement findUsersPage(){

		return driver.findElement(this.usersPage);

	}

	/*
	 *
	 * This method is used to navigate from home page to another page
	 * @author Srboljub.Todorovic
	 * @param pageTab
	 */
	public void goToPage(By pageTab) {
		driver.findElement(pageTab).click();
	}

}