package com.endavatraining.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;

import java.util.List;


public class HomePage extends BasePage {

	private By logOutButton = By.xpath("//*[@id=\"headContainer\"]/nav/div/ul[2]/li[2]/a");
	private By homePageWelcomeMessage = By.xpath("//div[@class='panel-title text-center'][contains(.,'Hello, and welcome to our gamers page!')]");
	private By homeButton = By.linkText("Home");
	private By usersButton = By.linkText("Users");
	private By heroesButton = By.linkText("Heroes");
	private By galleryButton = By.linkText("Gallery");
	private By apiButton = By.linkText("API");
	private By brokenLinkButton = By.linkText("Broken Link");
	private By profileButton = By.linkText("Profile");



	public HomePage(WebDriver driver) {
		super(driver);
	}
	

	public boolean isWelcomeTextPresent() {
		return isElementPresent(homePageWelcomeMessage);
	}

/**
    * This method clicks on every menu button depending on parameter is passed
    * @author danko lojanica
    * @param  button
 */
	public void logOutButton(String button){

		if(button.equals("Home")){
		driver.findElement(homeButton).click();}
		else if(button.equals("Users")) {
			driver.findElement(usersButton).click();
		}
		else if(button.equals("Heroes")) {
			driver.findElement(heroesButton).click();
		}
		else if(button.equals("Gallery")) {
			driver.findElement(galleryButton).click();
		}
		else if(button.equals("API")) {
			driver.findElement(apiButton).click();
		}
		else if(button.equals("Broken Link")) {
			driver.findElement(brokenLinkButton).click();
			driver.navigate().back();
		}
		else if(button.equals("Profile")) {
			driver.findElement(profileButton).click();
		}
		else  System.out.println("Parametar that is passed is not correct");

		driver.findElement(logOutButton).click();
	}


}
