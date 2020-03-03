package com.endavatraining.pages;

import org.apache.log4j.Logger;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class LogedInPage extends BasePage {
	public By Samsara = By.linkText("Samsara");
	public By homeButton = By.linkText("Home");
	public By usersButton = By.linkText("Users");
	public By heroesButton = By.linkText("Heroes");
	public By galleryButton = By.linkText("Gallery");
	public By apiButton = By.linkText("API");
	public By brokenLinkButton = By.linkText("Broken Link");
	//public By Algorithms = By.linkText("Algorithms");
	public By Algorithms = By.xpath("//*[@id=\"headContainer\"]/nav/div/ul[1]/li[7]/a");

    private AlgorithmsPage algorithmsPage;
    private HomePage homePage;
	
	protected LogedInPage(WebDriver driver) {
		super(driver);
	}

	public static WebDriver driver;
	public static final String LOG_OUT_MESSAGE = "You have been logged in.";

	public void quit() {
		log.debug("Quitting browser");
		if (this.driver != null) {
			driver.quit();
		}
	}

	public By getAlgorithms() {
		return Algorithms;
	}

	//This method is used to navigate from home page to another page
	public void goToPage(By pageTab) {
		driver.findElement(pageTab).click();
	}


    public static void verificationByURL(String content) {
    	String url = driver.getCurrentUrl();
        Assert.assertTrue(url.contains("content"));
		log.debug("URL used for this test verification contains expected content!");
    }
}
