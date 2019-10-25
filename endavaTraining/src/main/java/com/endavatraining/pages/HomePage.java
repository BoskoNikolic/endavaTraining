package com.endavatraining.pages;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


public class HomePage extends BasePage {

	private By homePageWelcomeMessage = By.xpath("//div[@class='panel-title text-center'][contains(.,'Hello, and welcome to our gamers page!')]");
	private By logOutButton = By.xpath("//*[@id=\"headContainer\"]/nav/div/ul[2]/li[2]/a");
	private By homeButton = By.linkText("Home");
	private By usersButton = By.linkText("Users");
	private By heroesButton = By.linkText("Heroes");
	private By galleryButton = By.linkText("Gallery");
	private By apiButton = By.linkText("API");
	private By brokenLinkButton = By.linkText("Broken Link");
	private By profileButton = By.linkText("Profile");
	private By logOutTitle = By.xpath("//div[@class='alert alert-success']");
	private By shareWithFriends= By.xpath("//*[text()='Share with friends!']");
	private By title= By.className("panel-title text-center");
	private By samsara= By.cssSelector("a.navbar-brand");
	private By body = By.cssSelector("body");
	private By adminButton = By.linkText("Admin");
    public static Logger log = Logger.getLogger(HomePage.class);

	public HomePage(WebDriver driver) {
		super(driver);
	}



	public boolean isWelcomeTextPresent() {
		return isElementPresent(homePageWelcomeMessage);
	}

	public By getLogOutButton() {
		return logOutButton;
	}

	public By getHomeButton() {
		return homeButton;
	}

	public By getUsersButton() {
		return usersButton;
	}

	public By getHeroesButton() {
		return heroesButton;
	}

	public By getGalleryButton() {
		return galleryButton;
	}

	public By getApiButton() {
		return apiButton;
	}

	public By getBrokenLinkButton() {
		return brokenLinkButton;
	}

	public By getProfileButton() {
		return profileButton;
	}

	public By getLogOutTitle() {
		return logOutTitle;
	}

	public By getTitle() {
		return title;
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

	/**
	 * This method clicks on samsara button
	 * @author Danko.Lojanica
	 */
	public void clickOnSamsaraButton(){
		driver.findElement(samsara).click();
	}

	/**
	 * This method clicks on share with friends button
	 * @author Danko.Lojanica
	 */
	public void clickOnShareWithFriendsButton(){
		driver.findElement(shareWithFriends).click();
	}

	/**
	 * This method clicks on users button button
	 * @author Danko.Lojanica
	 */
	public void clickOnUsersButton(){
		driver.findElement(usersButton).click();
	}
	public WebElement findUsersPage() { return driver.findElement(this.usersButton);  }

	public boolean isAdminTabPresent(){ return isElementPresent(adminButton); }

	public boolean isProfileButtonDisplayed() {
		return isElementPresent(profileButton);
	}
	public void clickOnHeroesButton(){
		driver.findElement(heroesButton).click();
	}
}
