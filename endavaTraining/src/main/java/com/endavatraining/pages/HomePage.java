package com.endavatraining.pages;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class HomePage extends BasePage {

	private By homePageWelcomeMessage = By.xpath("//div[@class='panel-title text-center'][contains(.,'Hello, and welcome" +
			" to our gamers page!')]");
	public static Logger log = Logger.getLogger(HomePage.class);
	private By adminTab = By.linkText("Admin");

	public HomePage(WebDriver driver) {
		super(driver);
	}
	

	public boolean isWelcomeTextPresent() {
		return isElementPresent(homePageWelcomeMessage);
	}

	/**
	 * Method is checking if Admin Tab is present on the page
	 * @author Luka.Ivancic
	 * @return adminTab true/adminTab false
	 *
	 * */

	public boolean isAdminTabPresent(){
		return isElementPresent(adminTab);
	}
}


