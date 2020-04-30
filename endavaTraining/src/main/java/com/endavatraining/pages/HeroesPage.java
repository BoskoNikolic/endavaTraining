package com.endavatraining.pages;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class HeroesPage extends BasePage {

	public static Logger log = Logger.getLogger(HeroesPage.class);
	private List<WebElement> rows;
	private WebDriverWait wait = new WebDriverWait(driver, 3);
	private By heroesButton = By.linkText("Heroes");
	private By dropDownOnHeroesPage = By.id("pageSizeSelect");
	private By heroTableBody = By.xpath("//table[@id='heroes-table']/tbody/tr");
	private By deleteHeroButton = By.xpath("//div[@class='container']/div[1]/div[1]/div[@id='deleteHeroModalHolder']/div[@id='deleteHeroModal']");
	private By editHeroButton = By.xpath("//div[@class='container']/div[1]/div[1]/div[@id='editHeroModalHolder']/div[@id='editHeroModal']");

	public static By heroesPageTab = By.linkText("Heroes");
	public static By addNewHeroButton = By.xpath("//div[@class='panel-body']/div[@class='row']/div[@class='text-right col-sm-6']/a[@href='#']/span[1]");
	public static By addHeroName = By.xpath("//div[@class = 'panel panel-default']/div[@id='addHeroModalHolder']/div[@id='addHeroModal']/div[@class='modal-dialog']/div[@class='modal-content']/form[@id='add-hero-form']/div[@class='modal-body']/div[@class='form-group']/input[@name='name']");
	public static By addHeroLevel = By.xpath("//div[@class = 'panel panel-default']/div[@id='addHeroModalHolder']/div[@id='addHeroModal']/div[@class='modal-dialog']/div[@class='modal-content']/form[@id='add-hero-form']/div[@class='modal-body']/div[@class='form-group']/input[@name='level']");
	public static By addHeroClass = By.xpath("//div[@class = 'panel panel-default']/div[@id='addHeroModalHolder']/div[@id='addHeroModal']/div[@class='modal-dialog']/div[@class='modal-content']/form[@id='add-hero-form']/div[@class='modal-body']/div[@class='form-group']/select[@id='type']");
	public static By addHeroSave = By.xpath("//div[@class = 'panel panel-default']/div[@id='addHeroModalHolder']/div[@id='addHeroModal']/div[@class='modal-dialog']/div[@class='modal-content']/form[@id='add-hero-form']/div[@class='modal-footer']/button[@type='submit']");
	public static By editHeroName = By.xpath("//div[@class = 'panel panel-default']/div[@id='editHeroModalHolder']/div[@id='editHeroModal']/div[@class='modal-dialog']/div[@class='modal-content']/form[@id='edit-hero-form']/div[@class='modal-body']/div[@class='form-group']/input[@name='name']");
	public static By editHeroLevel = By.xpath("//div[@class = 'panel panel-default']/div[@id='editHeroModalHolder']/div[@id='editHeroModal']/div[@class='modal-dialog']/div[@class='modal-content']/form[@id='edit-hero-form']/div[@class='modal-body']/div[@class='form-group']/input[@name='level']");
	public static By editHeroClass = By.xpath("//div[@class = 'panel panel-default']/div[@id='editHeroModalHolder']/div[@id='editHeroModal']/div[@class='modal-dialog']/div[@class='modal-content']/form[@id='edit-hero-form']/div[@class='modal-body']/div[@class='form-group']/select[@id='type']");
	public static By editHeroSave = By.xpath("//div[@class = 'panel panel-default']/div[@id='editHeroModalHolder']/div[@id='editHeroModal']/div[@class='modal-dialog']/div[@class='modal-content']/form[@id='edit-hero-form']/div[@class='modal-footer']/button[@type='submit']");
	public static By deleteExistingHero = By.xpath("//div[@class = 'panel panel-default']/div[@id='deleteHeroModalHolder']/div[@id='deleteHeroModal']/div[@class='modal-dialog']/div[@class='modal-content']/div[@class='modal-footer']/form[@method='post']/button[@type='submit']");
	
	public static By logoutButton = By.xpath("//header/nav/div/ul[2]/li[2]/a");
	public static By heroLevelErrorMessage = By
			.xpath("//div[@id='levelMessage'][contains(.,\"Level is a number between 0 and 80\")]");
	public static By cancelAddHero = By.xpath("//*[@id=\"add-hero-form\"]/div[2]/button[1]");
	public static By addHeroModal = By.xpath("//*[@id=\"addHeroModal\"]");
	private By heroesNextButton = By.linkText("→");
	private By heroesTableRows = By.xpath("/html/body/div[1]/div/div/div[2]/div[2]/table/tbody/tr");
	private By myHeroesButton = By.xpath("/html/body/div[1]/div/div/div[2]/div[2]/table/thead/tr/th[5]/div/a/span");
	private By heroPagePaginate = By.xpath("/html/body/div[1]/div/div/div[2]/div[3]/div[2]/ul/li");

	public HeroesPage(WebDriver driver) {
		super(driver);
	}

	/**
	 * This method clicks on heroesButton button
	 * 
	 * @author Danko.Lojanica
	 */
	public void clickOnHeroesButton() {
		driver.findElement(heroesButton).click();
	}

	/**
	 * This method select value from drop down on heroes page, depending on passed
	 * index
	 * 
	 * @param index
	 * @author Danko.Lojanica
	 */
	public void selectValueFromDropDownOnHeroesPage(int index) {
		Select dropdown = new Select(driver.findElement(dropDownOnHeroesPage));
		dropdown.selectByIndex(index);
	}

	/**
	 * This method returns hero count for admin user on heroes page
	 * 
	 * @return heroCount
	 * @author Danko.Lojanica
	 */
	public int heroCountForAdminUserOnHeroesPage() {
		int rowNumber;
		int heroCount = 0;
		rowNumber = driver.findElements(By.xpath("//*[@id=\"heroes-table\"]/tbody/tr")).size();
		for (int i = 1; i < rowNumber; i++) {
			if (driver.findElement(By.xpath("//*[@id=\"heroes-table\"]/tbody/tr[" + i + "]/td[4]")).getText()
					.equals("admin")) {
				heroCount++;
			}
		}
		return heroCount;
	}

	/*
	 * This method checks if the hero with given name already exists in table
	 * 
	 * @author Srboljub.Todorovic
	 * 
	 * @param String
	 * 
	 * @return boolean
	 */
	public boolean isHeroInTable(String heroName) {
		rows = driver.findElements(heroTableBody);
		for (int i = 0; i < rows.size(); i++) {
			if (heroName.equals(
					getTextOfElement(By.xpath("//table[@id=\"heroes-table\"]/tbody/tr[" + (i + 1) + "]/td[1]")))) {
				return true;
			}
		}
		return false;
	}

	/*
	 * This method checks if the hero with given name already exists in table
	 */
	public void editExistingHero(String heroName) {
		isHeroInTable(heroName);
		rows = driver.findElements(heroTableBody);
		for (int i = 0; i < rows.size(); i++) {
			if (heroName.equals(
					getTextOfElement(By.xpath("//table[@id=\"heroes-table\"]/tbody/tr[" + (i + 1) + "]/td[1]")))) {
				clickOnButton(By.xpath("//table[@id=\"heroes-table\"]/tbody/tr[" + (i + 1) + "]/td[5]/a[2]"));
				wait.until(ExpectedConditions.elementToBeClickable(editHeroButton));
				clickOnButton(editHeroButton);
			}
		}
	}

	/*
	 * This method deletes hero with given name from a table
	 * 
	 * @author Srboljub.Todorovic
	 * 
	 * @param String
	 */
	public void deleteHeroInTable(String heroName) {
		rows = driver.findElements(heroTableBody);
		for (int i = 0; i < rows.size() - 1; i++) {
			if (heroName.equals(
					getTextOfElement(By.xpath("//table[@id=\"heroes-table\"]/tbody/tr[" + (i + 1) + "]/td[1]")))) {
				clickOnButton(By.xpath("//table[@id=\"heroes-table\"]/tbody/tr[" + (i + 1) + "]/td[5]/a[3]"));
				wait.until(ExpectedConditions.elementToBeClickable(deleteHeroButton));
				clickOnButton(deleteHeroButton);
				wait.until(ExpectedConditions.elementToBeClickable(deleteExistingHero));
				clickOnButton(deleteExistingHero);
			}
		}
	}

	/*
	 * This method opens hero page
	 * 
	 * @author Srboljub.Todorovic
	 */
	public void openHeroPage() {
		wait.until(ExpectedConditions.elementToBeClickable(heroesPageTab));
		clickOnButton(heroesPageTab);
	}

	/*
	 * This method opens add new hero window
	 * 
	 * @author Srboljub.Todorovic
	 */
	public void openAddNewHeroWindow() {
		clickOnButton(addNewHeroButton);
	}

	/*
	 * This method types text into hero name field
	 * 
	 * @author Srboljub.Todorovic
	 * 
	 * @param String
	 */
	public void insertHeroName(String heroName) {
		typeTextOnElement(addHeroName, heroName);
	}

	/*
	 * This method types text into hero level field
	 * 
	 * @author Srboljub.Todorovic
	 * 
	 * @param String
	 */
	public void insertHeroLevel(String heroLevel) {
		typeTextOnElement(addHeroLevel, heroLevel);
	}

	/*
	 * This method selects provided hero class from drop down menu
	 * 
	 * @author Srboljub.Todorovic
	 * 
	 * @param String
	 */
	public void insertHeroClass(String heroClass) {
		dropDownMenuSelect(addHeroClass, heroClass);
	}

	/*
	 * This method saves hero with provided attributes
	 * 
	 * @author Srboljub.Todorovic
	 */
	public void saveNewHero() {
		clickOnButton(addHeroSave);
	}

	public void editHeroName(String heroName) {
		typeTextOnElement(editHeroName, heroName);
	}
	
	public void editHeroLevel(String heroLevel) {
		typeTextOnElement(editHeroLevel, heroLevel);
	}
	
	public void editHeroClass(String heroClass) {
		dropDownMenuSelect(editHeroClass, heroClass);
	}
	
	public void saveEditedHero() {
		clickOnButton(editHeroSave);
	}

	/*
	 * This method does logout function
	 * 
	 * @author Srboljub.Todorovic
	 */	
	public void logout() {
		wait.until(ExpectedConditions.elementToBeClickable(logoutButton));
		clickOnButton(logoutButton);
	}

	/**
	 * This method checks if hero level code error is visible
	 *
	 * @return boolean
	 * @author Jovan.Penic
	 */
	public boolean isHeroLevelErrorMessagePresent() {
		return isElementPresent(heroLevelErrorMessage);
	}

	/**
	 * This method clicks on Cancel Add Hero button
	 *
	 * @author Jovan.Penic
	 */
	public void clickOnCancel() {
		wait.until(ExpectedConditions.elementToBeClickable(cancelAddHero));
		clickOnButton(cancelAddHero);
	}

	/**
	 * This method clears Hero level in Add Hero window
	 *
	 * @author Jovan.Penic
	 */
	public void clearHeroLevel() {
		clearTextOnElement(addHeroLevel);
	}

	/**
	 * This method logs out user from Add New Hero window
	 *
	 * @author Jovan.Penic
	 */
	public void logoutFromAddNewHeroModal() {
		wait.until(ExpectedConditions.invisibilityOfElementLocated(addHeroModal));
		clickOnButton(logoutButton);
	}

	/**
	 * Method finds the My Heroes button on the Heros page, and clicks on it
	 *
	 * @author luka.ivancic
	 */
	public void clickOnMyHeroesButton() {
		driver.findElement(myHeroesButton).click();

	}

	/**
	 * Method returns the number of Heroes pages
	 *
	 * @return heroPageNumber - 4
	 * @author luka.ivancic
	 */
	public int numberOfHeroPages() {

		int heroPageNumber;
		List<WebElement> pages = driver.findElements(heroPagePaginate);
		heroPageNumber = pages.size();
		log.debug("Checked the number of Heroes pages");
		if (heroPageNumber <= 4) {
			return 1;
		}
		return heroPageNumber - 4;
	}

	/**
	 * Mathod counts all the heroes of the certain user
	 *
	 * @param userName
	 * @return numberOfUsersHeroes
	 * @author luka.ivancic
	 */
	public int numberOfUsersHeroes(String userName) {
		int heroCount;
		int numberOfUsersHeroes = 0;

		for (int j = 0; j < numberOfHeroPages(); j++) {

			List<WebElement> allHeroes = driver.findElements(heroesTableRows);
			heroCount = allHeroes.size();
			for (int i = 0; i < heroCount; i++) {

				if (((driver.findElement(By.xpath(
						"/html/body/div[1]/div/div/div[2]/div[2]/table/tbody/tr[" + (i + 1) + "]/td[4]/a/b/span")))
								.getText()).equals(userName)) {
					numberOfUsersHeroes++;
				}
			}
			driver.findElement(heroesNextButton).click();

		}
		log.debug("Checked the number of users heroes on the Heroes page");
		return numberOfUsersHeroes;
	}

	/**
	 * Method counts the certain Users heroes on the My Heroes page
	 *
	 * @param userName
	 * @return numberOfMyHeroes
	 * @author luka.ivacnic
	 */
	public int numberOfMyHeroes(String userName) {
		int heroCount;
		int numberOfMyHeroes = 0;
		List<WebElement> myHeroes = driver.findElements(heroesTableRows);
		heroCount = myHeroes.size();
		for (int i = 0; i < heroCount; i++) {
			if (((driver.findElement(
					By.xpath("/html/body/div[1]/div/div/div[2]/div[2]/table/tbody/tr[" + (i + 1) + "]/td[4]/a/b/span")))
							.getText()).equals(userName)) {
				numberOfMyHeroes++;
			}
		}
		log.debug("Checked the number of users heroes on the My Heroes page");
		return numberOfMyHeroes;
	}

	/**
	 * This method check if hero already exists in table and delete him
	 **/
	public void deleteHeroifExists(String heroName) {

		openHeroPage();

		if(isHeroInTable(heroName)) {
			deleteHeroInTable(heroName);
		}
	}

	/**
	 * This method check if hero already exists in table and edits him
	 **/
	public void editHeroifExists(String heroName) {

		openHeroPage();

		if(isHeroInTable(heroName)) {
			deleteHeroInTable(heroName);
		}
	}

}
