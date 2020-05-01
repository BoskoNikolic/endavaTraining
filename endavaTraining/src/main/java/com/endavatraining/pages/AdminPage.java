package com.endavatraining.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AdminPage extends BasePage {

	private By allowUsersToShareRegCodeCheckBox = By.id("usersAllowed");
	private By regCodeField = By.xpath("/html/body/div[1]/div/div/div[2]/code");
	public static By generateRegCodeButton = By.xpath("/html/body/div[1]/div/div/div[2]/a[1]");
	public static By logoutButton = By.xpath("//*[@id=\"headContainer\"]/nav/div/ul[2]/li[2]/a");

	public static By adminPageButton = By.linkText("Admin");

	public AdminPage(WebDriver driver) {
		super(driver);
	}

	public boolean isCheckBoxSelected() {
		return driver.findElement(allowUsersToShareRegCodeCheckBox).isSelected();
	}

	public void clickOnAllowUsersToShareRegCode() {
		driver.findElement(allowUsersToShareRegCodeCheckBox).click();
	}

	public String getRegCodeBoxText() {
		return driver.findElement(regCodeField).getText();
	}

	public void generateNewRegCode() {
		clickOnButton(generateRegCodeButton);
	}

	public void logout() {
		clickOnButton(logoutButton);
	}
}
