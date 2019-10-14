package com.endavatraining.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class HomePage extends BasePage {

	private By homePageWelcomeMessage = By.xpath("//div[@class='panel-title text-center'][contains(.,'Hello, and welcome to our gamers page!')]"); //<div class="panel-title text-center">Hello, and welcome to our gamers page!</div>
	private By adminTab = By.linkText("Admin");

	public HomePage(WebDriver driver) {
		super(driver);
	}
	

	public boolean isWelcomeTextPresent() {
		return isElementPresent(homePageWelcomeMessage);
	}

	public boolean isAdminTabPresent(){
		return isElementPresent(adminTab);
	}

}
