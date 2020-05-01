package com.endavatraining.pages;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.util.List;

public class UsersPage extends BasePage {

	private List<WebElement> rows;
	public static By usersPageTab = By.linkText("Users");
	public static By userDetails = By.id("userModal");
	public static By addNewUserButton = By.xpath("//div[@class='panel-body']/div[@class='row']/div[@class='text-right col-sm-6']/a[@href='#']/span[1]");
	public static By adminHomeTab = By.linkText("Admin");
	private By userDetailsFirstname = By
			.xpath("/html/body/div[1]/div/div/div[3]/div/div/div/div[2]/div/div[2]/p/span[4]");
	private By userDetailsLastname = By
			.xpath("/html/body/div[1]/div/div/div[3]/div/div/div/div[2]/div/div[2]/p/span[6]");
	private By userDetailsAbout = By.xpath("/html/body/div[1]/div/div/div[3]/div/div/div/div[2]/div/div[2]/span[2]");
	private By getUserDetailsCreationTime = By
			.xpath("/html/body/div[1]/div/div/div[3]/div/div/div/div[2]/div/div[2]/p/span[8]");
	private By closeUserDetailsButton = By.xpath("/html/body/div[1]/div/div/div[3]/div/div/div/div[3]/button");
	private By logOutButton = By.xpath("//*[@id=\"headContainer\"]/nav/div/ul[2]/li[2]/a");
	public static By userHeroesWindowBody = By.xpath("//*[@id=\"heroesModal\"]/div/div/div[2]/div/table/tbody/tr");
	public static By closeUserHeroesPopUpWindow = By.xpath("//*[@id=\"heroesModal\"]/div/div/div[3]/button");
	public static By adminHeroCountUsersTable = By.xpath("//*[@id=\"users-table\"]/tbody/tr[1]/td[3]/a/b/span");
	private By search = By.id("search");
	public static Logger log = Logger.getLogger(UsersPage.class);
	private By dropDownOnUsersPage = By.id("pageSizeSelect");
	private By searchIcon = By.cssSelector("button[class='btn btn-info btn-sm']");
	private By heroCountField = By.xpath("//*[@id=\"users-table\"]/tbody/tr[1]/td[3]");
	
	private By userTableBody = By.xpath("//table");
	private By deleteUserButton = By.xpath("//div[@class='container']/div[1]/div[1]/div[@id='deleteUserModalHolder']/div[@id='deleteUserModal']");
	public static By deleteExistingUser = By.xpath("//div[@class = 'panel panel-default']/div[@id='deleteUserModalHolder']/div[@id='deleteUserModal']/div[@class='modal-dialog']/div[@class='modal-content']/div[@class='modal-footer']/form[@method='post']/button[@type='submit']");

	
	public static By addUserSave = By.xpath("//div[@class='modal-footer']/button[2]");
	public static By addNewUserrepasword = By.xpath("//div[@class='container']/div[@class='mainbox col-md-8 col-md-offset-2 col-sm-8 col-sm-offset-2']/div[@class='panel panel-default']/div[@id='addUserModalHolder']/div[@id='addUserModal']/div[@class='modal-dialog']/div[@class='modal-content']/form[@id='add-user-form']/div[@class='modal-body']/div[@class='form-group'][8]/input[@id='repassword']");
	public static By addNewUserpasword = By.xpath("//div[@class='container']/div[@class='mainbox col-md-8 col-md-offset-2 col-sm-8 col-sm-offset-2']/div[@class='panel panel-default']/div[@id='addUserModalHolder']/div[@id='addUserModal']/div[@class='modal-dialog']/div[@class='modal-content']/form[@id='add-user-form']/div[@class='modal-body']/div[@class='form-group'][7]/input[@id='password']']");    
	public static By addUserName = By.xpath("//input[@id='username']");
    public static By addUserFirstName = By.xpath("//input[@id='firstName']");
    public static By addUserLastName = By.xpath("//input[@id='lastName']");
    public static By addUserAbout = By.xpath("//input[@id='about']");
    public static By addUserSecretQuestion = By.xpath("//input[@id='secretQuestion']");
    public static By addUserSecretAnswer = By.xpath("//input[@id='secretAnswer']");



    
	
	private WebDriverWait wait = new WebDriverWait(driver, 15);

	public UsersPage(WebDriver driver) {
		super(driver);
	}

	/**
	 * This method clicks on search icon on Users page
	 * 
	 * @author Danko.Lojanica
	 */
	public void clickOnSearchIcon() {
		driver.findElement(searchIcon).click();
	}

	/**
	 * This method select value from drop down on Users page, depending on passed
	 * index
	 * 
	 * @param index
	 * @author Danko.Lojanica
	 */
	public void selectValueFromDropDownOnUsersPage(int index) {
		Select dropdown = new Select(driver.findElement(dropDownOnUsersPage));
		dropdown.selectByIndex(index);
	}

	/**
	 * This method enters passed string on search field
	 * 
	 * @author Danko.Lojanica
	 */
	public void searchUser(String searchParameter) {
		driver.findElement(search).sendKeys(searchParameter);
	}

	/**
	 * This method returns hero count for admin user on Users page
	 * 
	 * @return heroCount
	 * @author Danko.Lojanica
	 */
	public int heroCountForAdminUserOnUserPage() {
		int heroCount;
		return heroCount = Integer.parseInt(driver.findElement(heroCountField).getText());
	}

	/**
	 * Method check if User Details displayed
	 *
	 * @author: luka.ivancic
	 * @return: true if displayed / false if not displayed
	 *
	 */
	public boolean isUserDetailsVisible() {
		wait.until(ExpectedConditions.visibilityOfElementLocated(userDetails));
		String style = driver.findElement(this.userDetails).getAttribute("style");
		if (style.contains("display: block")) {

			return true;
		}
		if (style.contains("misplay: none;")) {

			return false;
		}

		return false;

	}

	/**
	 * Method finds the index of the User in the Users table
	 *
	 * @author: luka.ivancic
	 * @param: displayName
	 * @return: i
	 *
	 */
	public int findUserIndexByDisplayName(String displayName) {

		int userCount;
		List<WebElement> users = driver
				.findElements(By.xpath("/html/body/div[1]/div/div/div[2]/div[2]/table/tbody/tr"));
		userCount = users.size();
		String name;
		for (int i = 0; i < userCount; i++) {
			name = driver
					.findElement(
							By.xpath("/html/body/div[1]/div/div/div[2]/div[2]/table/tbody/tr[" + (i + 1) + "]/td[2]"))
					.getText();
			if (name.equals(displayName)) {
				return i + 1;
			}
		}

		return 0;
	}

	/**
	 * Method locates the Details button of a located user and clicks on it
	 *
	 * @author: luka.ivancic
	 * @param: index
	 *
	 *
	 */
	public void clickUserDetails(int index) {

		driver.findElement(By.xpath("/html/body/div[1]/div/div/div[2]/div[2]/table/tbody/tr[" + index + "]/td[4]/a"))
				.click();

	}

	/**
	 * Method gets the firs name of a user from the Users table
	 * 
	 * @author: luka.ivancic
	 * @param: index
	 * @return firstName
	 *
	 */
	public String getFirstNameFromUserList(int index) {
		String fullName;

		fullName = driver
				.findElement(By.xpath("/html/body/div[1]/div/div/div[2]/div[2]/table/tbody/tr[" + index + "]/td[2]"))
				.getText();
		String[] stringArray = fullName.split(" ");
		String firstName = stringArray[0];
		return firstName;

	}

	/**
	 * Method gets the last name of a user from the Users table
	 * 
	 * @author: luka.ivancic
	 * @param: index
	 * @return lastName
	 *
	 */
	public String getLastNameFromUserList(int index) {
		String fullName;
		fullName = driver
				.findElement(By.xpath("/html/body/div[1]/div/div/div[2]/div[2]/table/tbody/tr[" + index + "]/td[2]"))
				.getText();
		String[] stringArray = fullName.split(" ");
		String lastName = stringArray[1];
		return lastName;

	}
	
	public void insertUserName(String userName) {
		typeTextOnElement(addUserName, userName);
	}
	
	public void insertUserFirstName(String firstName) {
		typeTextOnElement(addUserFirstName, firstName);
	}

	public void insertUserLastName(String lastName) {
		typeTextOnElement(addUserLastName, lastName);
	}

	public void insertUserAbout(String about) {
		typeTextOnElement(addUserAbout, about);
	}

	public void insertUserSecretQuestion(String secretQuestion) {
		typeTextOnElement(addUserSecretQuestion, secretQuestion);
	}

	public void insertUserSecretAnswer(String secretAnswer) {
		typeTextOnElement(addUserSecretAnswer, secretAnswer);
	}

	public void insertUserPassword(String password) {
		typeTextOnElement(addNewUserpasword, password);
	}

	public void insertUserConfirmPassword(String confirmPassword) {
		typeTextOnElement(addNewUserrepasword, confirmPassword);
	}
	

	/**
	 * Method gets the first name of a user from the Details page
	 * 
	 * @author: luka.ivancic
	 * @return userDetailsFirstName
	 *
	 */
	public String getFirstNameFromDetailsPage() {
		String userDetailsFirstName = driver.findElement(userDetailsFirstname).getText();
		return userDetailsFirstName;
	}

	/**
	 * Method gets the last name of a user from the Details page
	 * 
	 * @author: luka.ivancic
	 * @return userDetailsLastName
	 *
	 */
	public String getLastNameFromDetailsPage() {
		String userDetailsLastName = driver.findElement(userDetailsLastname).getText();
		return userDetailsLastName;
	}

	/**
	 * Method gets the About message of a user from the Details page
	 * 
	 * @author: luka.ivancic
	 * @return aboutMessage
	 *
	 */
	public String getAboutMessageFromDetailsPage() {
		String aboutMessage = driver.findElement(userDetailsAbout).getText();
		return aboutMessage;
	}
	
	public void openUsersPage() {
		wait.until(ExpectedConditions.elementToBeClickable(usersPageTab));
		clickOnButton(usersPageTab);
	}

	/**
	 * Method gets the Creation time of a user from the Details page
	 * 
	 * @author: luka.ivancic
	 * @return creationTime
	 *
	 */
	public String getCreationTimeFromDetailsPage() {
		String creationTime = driver.findElement(getUserDetailsCreationTime).getText();
		return creationTime;
	}

	/**
	 * Method locates the Close button of a Details page, and clicks on it
	 * 
	 * @author: luka.ivancic
	 *
	 *
	 */
	public void clickUserDetailsCloseButton() {
		driver.findElement(closeUserDetailsButton).click();
	}

	/**
	 * This method counts the number of Admin heroes in User heroes Pop Up Window,
	 * by clicking on it and counting the number of rows
	 *
	 * @author Jovan.Penic
	 * @return int
	 */
	public int numberOfAdminHeroesInUserHeroesPopUp() {
		clickOnButton(UsersPage.adminHeroCountUsersTable);
		rows = driver.findElements(userHeroesWindowBody);
		return rows.size() - 1;
	}
	
	public void openAddNewUserWindow() {
		clickOnButton(addNewUserButton);
	}
	
	public void saveNewUser() {
		clickOnButton(addUserSave);
	}
	
	public void deleteUserInTable(String userName) {
		rows = driver.findElements(userTableBody);
		for (int i = 0; i < rows.size() - 1; i++) {
			if (userName.equals(
					getTextOfElement(By.xpath("//table/tbody/tr[" + (i + 1) + "]/td[1]")))) {
				clickOnButton(By.xpath("//table/tbody/tr[" + (i + 1) + "]/td[4]/a[3]"));
				wait.until(ExpectedConditions.elementToBeClickable(deleteUserButton));
				clickOnButton(deleteUserButton);
				wait.until(ExpectedConditions.elementToBeClickable(deleteExistingUser));
				clickOnButton(deleteExistingUser);
			}
		}
	}
	
	public boolean isUserInTable(String userName) {
		rows = driver.findElements(userTableBody);
		for (int i = 0; i < rows.size(); i++) {
			if (userName.equals(
					getTextOfElement(By.xpath("//table/tbody/tr[" + (i + 1) + "]/td[1]")))) {
				return true;
			}
		}
		return false;
	}

	public boolean openAdminPage() {
		driver.findElements(adminHomeTab);
		return false;
	}
	
	public void deleteUserifExists(String userName) {

		openUsersPage();

		if(isUserInTable(userName)) {
			deleteUserInTable(userName);
		}
	}

	/**
	 * This method clicks and closes the User Heroes Window
	 *
	 * @author Jovan.Penic
	 */
	public void closeUserHeroesWindow() {
		clickOnButton(closeUserHeroesPopUpWindow);
	}

	/**
	 * This method counts the number of Admin heroes in Users table, by getting the
	 * text from Hero Count element and parsing it to integer
	 *
	 * @author Jovan.Penic
	 * @return int
	 */
	public int getNumberOfAdminHeroesInUsersList() {
		return Integer.parseInt(getTextOfElement(adminHeroCountUsersTable));
	}

	/**
	 * Method locates the Log Out button and clicks on it
	 *
	 * @author: Jovan.Penic
	 */
	public void clickLogOutButton() {
		clickOnButton(logOutButton);
	}

}
