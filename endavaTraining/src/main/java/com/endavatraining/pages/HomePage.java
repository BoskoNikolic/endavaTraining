package com.endavatraining.pages;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


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

	public By getShareWithFriends() {
		return shareWithFriends;
	}

	public By getTitle() {
		return title;
	}

	public By getSamsara() {
		return samsara;
	}

	public By getBody() {
		return body;
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
