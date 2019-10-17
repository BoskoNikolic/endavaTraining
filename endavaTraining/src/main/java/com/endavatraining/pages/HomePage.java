package com.endavatraining.pages;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class HomePage extends BasePage {

	private By homePageWelcomeMessage = By.xpath("//div[@class='panel-title text-center'][contains(.,'Hello, and welcome to our gamers page!')]");


	public HomePage(WebDriver driver) {
		super(driver);
	}
	

	public boolean isWelcomeTextPresent() {
		return isElementPresent(homePageWelcomeMessage);
	}

}
